package vn.com.web.service.Web.Managermaterial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.web.service.Web.Managermaterial.Repository.CategoryRepository;
import vn.com.web.service.Web.Managermaterial.Repository.ProductRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/laptop")
    public String getAllLaptops(Model model){
        model.addAttribute("laptops",productRepository.findByLapTop());
        return "display/laptops";
    }

    @GetMapping("/smartphone")
    public String getAllSmartphone(Model model){
        model.addAttribute("smartphones",productRepository.findBySmartPhone());
        return "display/smartphones";
    }
    @GetMapping("/cameras")
    public String getAllCameras(Model model){
        model.addAttribute("cameras",productRepository.findByCameras());
        return "display/cameras";
    }
    @GetMapping("/accessories")
    public String getAllAccessories(Model model){
        model.addAttribute("accessories",productRepository.findByAccessories());
        return "display/accessories";
    }
    @GetMapping("/other")
    public String getAllOther(Model model){
        model.addAttribute("other",productRepository.findByRemaining());
        return "display/other";
    }



}
