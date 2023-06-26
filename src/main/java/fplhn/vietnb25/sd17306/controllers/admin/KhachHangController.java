package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.entities.KhachHang;
import fplhn.vietnb25.sd17306.repositories.KhachHangRepository;
import fplhn.vietnb25.sd17306.request.KhachHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    @Qualifier("khVM")
    private KhachHangVM vm;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("index")
    public String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<KhachHang> ds = khachHangRepository.findAll(pageable);
        model.addAttribute("data", ds);
        return "admin/khach_hang/index";
    }

    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/khach-hang/store");
        return "admin/khach_hang/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") KhachHangVM vm, KhachHang domainModel,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/khach_hang/create";
        } else {
            domainModel.loadFromVM(vm);
            this.khachHangRepository.save(domainModel);
        }
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") KhachHang khachHang, Model model)
    {
        vm.loadFromDomain(khachHang);
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/khach-hang/update/" + khachHang.getId());
        return "admin/khach_hang/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") KhachHang domainModel,
            @Valid @ModelAttribute("vm") KhachHangVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/khach_hang/create";
        } else {
            domainModel.loadFromVM(vm);
            this.khachHangRepository.save(domainModel);
        }
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang)
    {
        this.khachHangRepository.delete(khachHang);
        return "redirect:/khach-hang/index";
    }
}
