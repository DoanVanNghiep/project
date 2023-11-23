package vn.com.web.service.Web.Managermaterial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.web.service.Web.Managermaterial.Domain.Product;
import vn.com.web.service.Web.Managermaterial.Dto.CartDto;
import vn.com.web.service.Web.Managermaterial.Repository.ProductRepository;
import vn.com.web.service.Web.Managermaterial.Service.CartService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("shopping-cart")
public class CartController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartService cartService;

    @GetMapping("viewCart")
    public String viewCart(Model model,HttpSession session){
        model.addAttribute("all_item",cartService.getAll());
        model.addAttribute("count",cartService.getCount());
        model.addAttribute("amount",cartService.getAmount());
        session.setAttribute("all_item",cartService.getAll());
        session.setAttribute("amount",cartService.getAmount());
        session.setAttribute("count",cartService.getCount());
        return "display/cart";
    }



    @GetMapping("/add/{id}")
    public String addCart(Model model, @PathVariable("id") Integer id){
        Product product = productRepository.findAllById(id);
        if (product != null){
            CartDto cartDto = new CartDto();
            cartDto.setQty(1);
            cartDto.setProduct(product);
            cartDto.setTotalPrice(product.getPrice());
            cartService.add(cartDto);
        }
        return "redirect:/shopping-cart/viewCart";
    }
    @GetMapping("/clear")
    public String clearCart(){
        cartService.clear();
        return "redirect:/shopping-cart/viewCart";
    }

    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable("id") Integer id){
        cartService.delete(id);
        return "redirect:/shopping-cart/viewCart";
    }
    @PostMapping("/update")
    public String update(@RequestParam("id")Integer id, @RequestParam("qty")Integer qty){
        cartService.edit(id,qty);
        return "redirect:/shopping-cart/viewCart";
    }
}
