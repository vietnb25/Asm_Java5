package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.entities.NhanVien;
import fplhn.vietnb25.sd17306.repositories.ChucVuRepository;
import fplhn.vietnb25.sd17306.repositories.CuaHangRepository;
import fplhn.vietnb25.sd17306.repositories.NhanVienRepository;
import fplhn.vietnb25.sd17306.request.ChucVuVM;
import fplhn.vietnb25.sd17306.request.CuaHangVM;
import fplhn.vietnb25.sd17306.request.NhanVienVM;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    @Qualifier("nhanVienVM")
    private NhanVienVM vm;

    @Autowired
    @Qualifier("cuaHangVM1")
    private CuaHangVM chvm;

    @Autowired
    @Qualifier("chucVuVM")
    private ChucVuVM cvvm;


    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;



    @GetMapping("create")
    public String create( Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/nhan-vien/store");

        model.addAttribute("listCH", this.cuaHangRepository.findAll());
        model.addAttribute("listCV", this.chucVuRepository.findAll());
        return "admin/nhan_vien/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") NhanVienVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/nhan_vien/create";
        }
        else {
            NhanVien nv = new NhanVien();
             nv.loadFromVM(vm);


            this.nhanVienRepository.save(nv);

        }
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("index")
    public String index(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Pageable pageable = PageRequest.of(number, 3);
        Page<NhanVien> ds = nhanVienRepository.findAll(pageable);
        model.addAttribute("data", ds);
        return "admin/nhan_vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhanVien nhanVien)
    {
        this.nhanVienRepository.delete(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NhanVien nhanVien, Model model)
    {
        vm.loadFromDomain(nhanVien);
        model.addAttribute("listCH", this.cuaHangRepository.findAll());
        model.addAttribute("listCV", this.chucVuRepository.findAll());
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/nhan-vien/update/" + nhanVien.getId());
        return "admin/nhan_vien/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") NhanVien domainModel,
            @Valid @ModelAttribute("vm") NhanVienVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/nhan_vien/create";
        } else {
            domainModel.loadFromVM(vm);
            this.nhanVienRepository.save(domainModel);
        }
        return "redirect:/nhan-vien/index";
    }

}
