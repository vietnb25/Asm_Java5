package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.entities.MauSac;
import fplhn.vietnb25.sd17306.repositories.MauSacRepository;
import fplhn.vietnb25.sd17306.request.MauSacVM;
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
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    @Qualifier("mauSacVM")
    private MauSacVM vm;

    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("index")
    public String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<MauSac> ds = mauSacRepository.findAll(pageable);
        model.addAttribute("data", ds);
        return "admin/mau_sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") MauSac mauSac)
    {
        this.mauSacRepository.delete(mauSac);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/mau-sac/store");
        return "admin/mau_sac/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") MauSacVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/mau_sac/create";
        } else {
            MauSac ms = new MauSac();
            ms.setTen(vm.getTen());
            ms.setMa(vm.getMa());
            this.mauSacRepository.save(ms);
        }
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") MauSac mauSac, Model model)
    {
        vm.loadFromDomain(mauSac);
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/mau-sac/update/" + mauSac.getId());
        return "admin/mau_sac/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") MauSac domainModel,
            @Valid @ModelAttribute("vm") MauSacVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/mau_sac/create";
        } else {
            domainModel.loadFromVM(vm);
            this.mauSacRepository.save(domainModel);
        }
        return "redirect:/mau-sac/index";
    }







}
