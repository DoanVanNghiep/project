package vn.com.web.service.Web.Managermaterial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.web.service.Web.Managermaterial.Domain.Customer;
import vn.com.web.service.Web.Managermaterial.Repository.CustomerRepository;
import vn.com.web.service.Web.Managermaterial.Service.ReadData.ParamService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    ParamService paramService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("index")
    public String index(){
        return "layout/web";
    }
    @GetMapping("login")
    public String viewLogin(){
        return "account/login";
    }
    @GetMapping("profile")
    public String viewProfile(){
        return "account/profile";
    }


    // login
    @PostMapping("check-account")
    public String checkAccount(Model model,
                               @RequestParam("username") String username,
                               HttpSession session){
        String password = paramService.getString("password","");
        try {
            Customer customer = customerRepository.findByUsername(username);
            if (!customer.getPassword().equals(password)) model.addAttribute("message","Sai mật khẩu!");
            if (customer.getId() == 19){
                model.addAttribute("customer",customerRepository.findByUsername(username));
                session.setAttribute("customer",customer);
                return "/admin/indexAdmin";
            }
            else {
                model.addAttribute("customer",customerRepository.findByUsername(username));
                session.setAttribute("customer",customer);
                return "redirect:/account/index";
            }
        }catch (Exception e){
            model.addAttribute("message", "....");
        }
        return "redirect:/account/login";
    }

    // register



}
