package vn.com.web.service.Web.Managermaterial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.web.service.Web.Managermaterial.Repository.PaymentMethodRepository;
import vn.com.web.service.Web.Managermaterial.Repository.TransportMethodRepository;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("checkout")
public class CheckOutController {
    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    TransportMethodRepository transportMethodRepository;

    @GetMapping("viewCheckOut")
    public String viewCheckout(Model model, HttpSession session){
        model.addAttribute("PaymentMethod",paymentMethodRepository.findAll());
        model.addAttribute("TransportMethod",transportMethodRepository.findAll());
        session.getAttribute("all_item");
        session.getAttribute("count");
        session.getAttribute("totalPrice");
        session.getAttribute("amount");
        return "display/checkout";
    }
    @GetMapping("viewCheckOutAccount")
    public String viewCheckOutController(Model model, HttpSession session){
        model.addAttribute("PaymentMethod",paymentMethodRepository.findAll());
        model.addAttribute("TransportMethod",transportMethodRepository.findAll());
        session.getAttribute("all_item");
        session.getAttribute("count");
        session.getAttribute("totalPrice");
        session.getAttribute("amount");
        return "account/checkoutAccount";
    }
}
