package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.entities.DongSP;
import fplhn.vietnb25.sd17306.repositories.DSPRepo;
import fplhn.vietnb25.sd17306.request.DongSPVM;
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
@RequestMapping("dsp")
public class DSPController {
    @Autowired
    @Qualifier("dspVM")
    private DongSPVM vm;

    @Autowired
    private DSPRepo dspRepo;

    @GetMapping("index")
    public String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<DongSP> ds = dspRepo.findAll(pageable);
        model.addAttribute("data", ds);
        return "admin/dsp/index";
    }

    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/dsp/store");
        return "admin/dsp/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") DongSPVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/dsp/create";
        } else {
            DongSP sp = new DongSP();
            sp.loadFromVM(vm);
            this.dspRepo.save(sp);
        }
        return "redirect:/dsp/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") DongSP dongSP)
    {
        this.dspRepo.delete(dongSP);
        return "redirect:/dsp/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") DongSP dongSP, Model model)
    {
        vm.loadFromDomain(dongSP);
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/dsp/update/" + dongSP.getId());
        return "admin/dsp/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") DongSP domainModel,
            @Valid @ModelAttribute("vm") DongSPVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/dsp/create";
        } else {
            domainModel.loadFromVM(vm);
            this.dspRepo.save(domainModel);
        }
        return "redirect:/dsp/index";
    }
}
