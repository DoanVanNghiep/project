package vn.com.web.service.Web.Managermaterial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.web.service.Web.Managermaterial.Domain.ProductImage;
import vn.com.web.service.Web.Managermaterial.Repository.ProductImageRepository;
import vn.com.web.service.Web.Managermaterial.Repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/view")
public class StoreController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductImageRepository productImageRepository;

    // all product
    @GetMapping("/store")
    public String showStore(Model model){
        model.addAttribute("STORE",productRepository.findAll());
        return "display/store";
    }

    // tìm kiếm product theo id
    @GetMapping("/product/{id}")
    public String findByProduct(@PathVariable(name = "id") Integer id, Model model){
        model.addAttribute("product",productRepository.findAll());
        model.addAttribute("productId",productRepository.findAllById(id));
        List<ProductImage> productImages = productImageRepository.getProductImage(id);
        model.addAttribute("productImg",productImages);
        return "display/product";
    }


}
