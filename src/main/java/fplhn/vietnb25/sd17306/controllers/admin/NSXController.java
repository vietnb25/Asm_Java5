package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.repositories.NhaSanXuatRepository;
import fplhn.vietnb25.sd17306.entities.NhaSanXuat;
import fplhn.vietnb25.sd17306.request.NhaSanXuatVM;
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
@RequestMapping("nsx")
public class NSXController {

    @Autowired
    @Qualifier("nsxVM")
    private NhaSanXuatVM vm;

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @GetMapping("index")
    public String index(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<NhaSanXuat> ds = nhaSanXuatRepository.findAll(pageable);
        model.addAttribute("data", ds);
        return "admin/nsx/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhaSanXuat nhaSanXuat)
    {
        this.nhaSanXuatRepository.delete(nhaSanXuat);
        return "redirect:/nsx/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "store");
        return "admin/nsx/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm") NhaSanXuatVM vm, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/nsx/create";
        } else {
            NhaSanXuat nsx = new NhaSanXuat();
            nsx.setTen(vm.getTen());
            nsx.setMa(vm.getMa());
            this.nhaSanXuatRepository.save(nsx);
        }
        return "redirect:/nsx/index";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NhaSanXuat nhaSanXuat, Model model)
    {
        vm.loadFromDomain(nhaSanXuat);
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/nsx/update/" + nhaSanXuat.getId());
        return "admin/nsx/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") NhaSanXuat domainModel,
            @Valid @ModelAttribute("vm") NhaSanXuatVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/nsx/create";
        } else {
            domainModel.loadFromVM(vm);
            this.nhaSanXuatRepository.save(domainModel);
        }
        return "redirect:/nsx/index";
    }

}
