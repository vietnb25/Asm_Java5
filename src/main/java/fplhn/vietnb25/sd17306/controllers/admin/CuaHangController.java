package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.entities.CuaHang;
import fplhn.vietnb25.sd17306.repositories.CuaHangRepository;
import fplhn.vietnb25.sd17306.request.CuaHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {
    @Autowired
    @Qualifier("cuaHangVM1")
    private CuaHangVM vm;

    @Autowired
    private CuaHangRepository cuaHangRepo;

    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/cua-hang/store");
        return "admin/cua_hang/create";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") CuaHang cuaHang, Model model)
    {
        vm.loadFromDomain(cuaHang);
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/cua-hang/update/" + cuaHang.getId());
        return "admin/cua_hang/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") CuaHang domainModel,
            @Valid @ModelAttribute("vm") CuaHangVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/cua_hang/create";
        } else {
            domainModel.loadFromVM(vm);
            this.cuaHangRepo.save(domainModel);
        }
        return "redirect:/cua-hang/index";
    }

    @PostMapping("store")
    public String store(
        @Valid @ModelAttribute("vm") CuaHangVM vm,
        BindingResult result
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            System.out.println(vm.getTen());
            return "admin/cua_hang/create";
        } else {
            CuaHang ch = new CuaHang();
            ch.setTen(vm.getTen());
            ch.setMa(vm.getMa());
            ch.setDiaChi(vm.getDiaChi());
            ch.setThanhPho(vm.getThanhPho());
            ch.setQuocGia(vm.getQuocGia());
            this.cuaHangRepo.save(ch);
        }
        return "redirect:/cua-hang/index";
    }

    @GetMapping("index")
    public String index(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Pageable pageable = PageRequest.of(number, 2);
        Page<CuaHang> ds = cuaHangRepo.findAll(pageable);
        model.addAttribute("data", ds);
        return "admin/cua_hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang)
    {
        this.cuaHangRepo.delete(cuaHang);
        return "redirect:/cua-hang/index";
    }
}
