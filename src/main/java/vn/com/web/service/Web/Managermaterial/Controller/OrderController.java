package vn.com.web.service.Web.Managermaterial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.web.service.Web.Managermaterial.Domain.*;
import vn.com.web.service.Web.Managermaterial.Dto.CartDto;
import vn.com.web.service.Web.Managermaterial.Repository.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    OrderPaymentRepository orderPaymentRepository;

    @Autowired
    TransportMethodRepository transportMethodRepository;

    @Autowired
    OrderTransportRepository orderTransportRepository;

    @PostMapping("/saveOrder/{username}")
    public String addOrder(Model model,
                           HttpSession session,
                           @PathVariable(name = "username") String username,
                           @RequestParam(required = false, name = "IDPayment") Integer IDPayment,
                           @RequestParam(required = false, name = "IDTransport") Integer IDTransport){

        Customer customer = customerRepository.findByUsername(username);

        Double totalMoney = (Double) session.getAttribute("amount");
        // đưa vào order
        Order order = new Order();
        String IDOrder = UUID.randomUUID().toString().substring(0,10);
        order.setOrdersDate(new Date().toInstant());
        order.setIdorders(IDOrder);
        order.setNotes("Có");
        order.setIdcustomer(customer);
        order.setTotalMoney(totalMoney);
        order.setNameReciver(customer.getName());
        order.setAddress(customer.getAddress());
        order.setPhone(customer.getPhone());
        orderRepository.save(order);

        // đưa vào order - details
        Collection<CartDto> cart = (Collection<CartDto>) session.getAttribute("all_item");
        List<OrdersDetail> ordersDetails = new ArrayList<>();
        for (CartDto cartDto : cart){
            OrdersDetail ordersDetail  = new OrdersDetail();
            ordersDetail.setIdord(order);
            ordersDetail.setQty(cartDto.getQty());
            ordersDetail.setIdproduct(cartDto.getProduct().getId());
            ordersDetail.setPrice(cartDto.getTotalPrice());
            //save
            orderDetailsRepository.save(ordersDetail);
            ordersDetails.add(ordersDetail);
        }


        // đưa vào order - payment
        OrdersPayment ordersPayment = new OrdersPayment();
        PaymentMethod paymentMethod = paymentMethodRepository.findAllById(IDPayment);
        ordersPayment.setIdord(order);
        ordersPayment.setIdpayment(paymentMethod);
        ordersPayment.setTotal(0);
        // save
        orderPaymentRepository.save(ordersPayment);


        // đưa vào order - transport
        OrdersTransport ordersTransport = new OrdersTransport();
        TransportMethod transportMethod = transportMethodRepository.findAllById(IDTransport);
        ordersTransport.setIdord(order);
        ordersTransport.setIdtransport(transportMethod);
        ordersTransport.setTotal(transportMethod.getPrice());
        ordersTransport.setNotes(1);
        // save
        orderTransportRepository.save(ordersTransport);



        return "display/success";
    }
}
