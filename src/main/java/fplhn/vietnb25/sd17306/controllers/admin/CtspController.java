package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.entities.ChiTietSanPham;
import fplhn.vietnb25.sd17306.request.ChiTietSanPhamVM;
import fplhn.vietnb25.sd17306.repositories.CtspRepository;
import fplhn.vietnb25.sd17306.repositories.DSPRepo;
import fplhn.vietnb25.sd17306.repositories.MauSacRepository;
import fplhn.vietnb25.sd17306.repositories.NhaSanXuatRepository;
import fplhn.vietnb25.sd17306.repositories.SanPhamRepo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
@RequestMapping("chi-tiet-san-pham")
public class CtspController {
    @Autowired
    @Qualifier("ctspVM")
    private ChiTietSanPhamVM vm;

    @Autowired
    private CtspRepository ctspRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private DSPRepo dspRepo;

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @GetMapping("index")
    public String index(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Pageable pageable = PageRequest.of(number, 10);
        Page<ChiTietSanPham> ds = ctspRepository.findAll(pageable);
        model.addAttribute("data", ds);
        return "admin/ctsp/index";
    }

    @GetMapping("search")
    public String search(@Param("keyword") String keyword, Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Pageable pageable = PageRequest.of(number, 10);
        Page<ChiTietSanPham> ds = ctspRepository.findByName("%"+keyword+"%",pageable);
        model.addAttribute("data", ds);
        return "admin/ctsp/index";
    }

    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("listSP", this.sanPhamRepo.findAll());
        model.addAttribute("listDSP", this.dspRepo.findAll());
        model.addAttribute("listMS", this.mauSacRepository.findAll());
        model.addAttribute("listNSX", this.nhaSanXuatRepository.findAll());
        model.addAttribute("action", "/chi-tiet-san-pham/store");
        return "admin/ctsp/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") ChiTietSanPhamVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/ctsp/create";
        } else {
            ChiTietSanPham ctsp = new ChiTietSanPham();
            ctsp.loadFromVM(vm);
            this.ctspRepository.save(ctsp);
        }
        return "redirect:/chi-tiet-san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChiTietSanPham chiTietSanPham, Model model)
    {
        vm.loadFromDomain(chiTietSanPham);
        model.addAttribute("vm", vm);
        model.addAttribute("listSP", this.sanPhamRepo.findAll());
        model.addAttribute("listDSP", this.dspRepo.findAll());
        model.addAttribute("listMS", this.mauSacRepository.findAll());
        model.addAttribute("listNSX", this.nhaSanXuatRepository.findAll());
        model.addAttribute("action", "/chi-tiet-san-pham/update/" + chiTietSanPham.getId());
        return "admin/ctsp/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") ChiTietSanPham domainModel,
            @Valid @ModelAttribute("vm") ChiTietSanPhamVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/ctsp/create";
        }
        else {
            domainModel.loadFromVM(vm);
            this.ctspRepository.save(domainModel);
        }
        return "redirect:/chi-tiet-san-pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChiTietSanPham chiTietSanPham)
    {
        this.ctspRepository.delete(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/index";
    }
}
