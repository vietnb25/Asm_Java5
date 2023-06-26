package fplhn.vietnb25.sd17306.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("login")
public class LoginController {
    @GetMapping("login1")
    public String login(){
        return "admin/login";
    }

    @PostMapping("login2")
    public String login2(@RequestParam("taiKhoan") String taiKhoan, @RequestParam("matKhau") String matKhau){
        if (taiKhoan.equals("viet") && matKhau.equals("123")) {
           return "redirect:/home";
        }
        return "admin/login";
    }
}
