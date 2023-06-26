package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.entities.SanPham;
import fplhn.vietnb25.sd17306.repositories.SanPhamRepo;
import fplhn.vietnb25.sd17306.request.SanPhamVM;
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
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    @Qualifier("spVM")
    private SanPhamVM vm;

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @GetMapping("index")
    public String index(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Pageable pageable = PageRequest.of(number, 3);
        Page<SanPham> ds = sanPhamRepo.findAll(pageable);
        model.addAttribute("data", ds);
        return "admin/san_pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPham sanPham){
        sanPhamRepo.delete(sanPham);
        return "redirect:/san-pham/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/san-pham/store");
        return "admin/san_pham/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm") SanPhamVM vm, BindingResult result){
        if(result.hasErrors()){
            return "admin/san_pham/create";
        }
        else{
            SanPham sp = new SanPham();
            sp.setTen(vm.getTen());
            sp.setMa("SP" + vm.getMa());
            this.sanPhamRepo.save(sp);
        }
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPham sanPham, Model model)
    {
        vm.loadFromDomain(sanPham);
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/san-pham/update/" + sanPham.getId());
        return "admin/san_pham/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") SanPham domainModel,
            @Valid @ModelAttribute("vm") SanPhamVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/san_pham/create";
        } else {
            domainModel.loadFromVM(vm);
            this.sanPhamRepo.save(domainModel);
        }
        return "redirect:/san-pham/index";
    }

}
