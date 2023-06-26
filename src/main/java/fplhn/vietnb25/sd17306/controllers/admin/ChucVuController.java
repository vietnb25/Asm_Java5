package fplhn.vietnb25.sd17306.controllers.admin;

import fplhn.vietnb25.sd17306.entities.ChucVu;
import fplhn.vietnb25.sd17306.repositories.ChucVuRepository;
import fplhn.vietnb25.sd17306.request.ChucVuVM;

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
@RequestMapping("chuc-vu")
public class ChucVuController {

    @Autowired
    @Qualifier("chucVuVM")

    private ChucVuVM vm;

    @Autowired
    private ChucVuRepository chucVuRepository;


//    @Autowired
//    private ChucVuService chucVuService;

//    @GetMapping("index")
//    public String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
//        Pageable pageable = PageRequest.of(number, 2);
//        Page<ChucVu> ds = chucVuRepository.findAll(pageable);
//        model.addAttribute("data", ds);
//        return "admin/chuc_vu/index";
//    }
    @GetMapping("search")
    public String search(@Param("keyword") String keyword, Model model,@RequestParam(defaultValue = "0", name = "page") Integer number)
    {
        Pageable pageable = PageRequest.of(number, 2);
        Page<ChucVu> cv = chucVuRepository.search("%"+keyword+"%", pageable);
        model.addAttribute("data", cv);
        model.addAttribute("keyword",keyword);

        return "admin/chuc_vu/index";
    }

    @GetMapping("index")
    public String index(@Param("keyword") String keyword, Model model,@RequestParam(defaultValue = "0", name = "page") Integer number)
    {
        Pageable pageable = PageRequest.of(number, 2);
        Page<ChucVu> ds = chucVuRepository.findAll(pageable);
        model.addAttribute("data", ds);

        return "admin/chuc_vu/index";
    }

    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/chuc-vu/store");
        return "admin/chuc_vu/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") ChucVuVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/chuc_vu/create";
        } else {
            ChucVu cv = new ChucVu();
            cv.setTen(vm.getTen());
            cv.setMa("CV"+ vm.getMa());

            this.chucVuRepository.save(cv);
        }
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChucVu chucVu)
    {
        this.chucVuRepository.delete(chucVu);
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChucVu chucVu, Model model)
    {
        vm.loadFromDomain(chucVu);
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/chuc-vu/update/" + chucVu.getId());
        return "admin/chuc_vu/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") ChucVu domainModel,
            @Valid @ModelAttribute("vm") ChucVuVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/chuc_vu/create";
        } else {
            domainModel.loadFromVM(vm);
            this.chucVuRepository.save(domainModel);
        }
        return "redirect:/chuc-vu/index";
    }

}
