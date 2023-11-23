package vn.com.web.service.Web.Managermaterial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("")
    public String showView(){
        return "layout/web";
    }
}
