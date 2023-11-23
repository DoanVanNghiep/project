package vn.com.web.service.Web.Managermaterial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.web.service.Web.Managermaterial.Domain.*;
import vn.com.web.service.Web.Managermaterial.Repository.*;
import vn.com.web.service.Web.Managermaterial.Service.Crud.*;
import vn.com.web.service.Web.Managermaterial.Service.ReadData.ParamService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class AdminController {

    //view admin

    @GetMapping("indexAdmin")
    public String viewAdmin(){
        return "admin/indexAdmin";
    }

    // Customer
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerCrudService customerService;

    @GetMapping("/customer")
    public String viewCustomer(Model model){
        model.addAttribute("CUSTOMER",customerRepository.findAll());
        return "admin/dynamic/customer";
    }

    //xóa
    @GetMapping("/removeCustomer/{id}")
    public String removeCustomer(@PathVariable(name = "id")Integer id){
        customerService.deleteById(id);
        return "redirect:/admin/customer";
    }


    // Category
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ParamService paramService;

    @Autowired
    CategoryCrudService categoryService;

    @GetMapping("/category")
    public String viewCategory(Model model){
        model.addAttribute("CATEGORY",categoryRepository.findAll());
        return "admin/dynamic/category";
    }

    // thêm
    @PostMapping("/saveCategory")
    public String saveOrUpdate(@Validated @ModelAttribute(name = "category") Category category,
                               BindingResult result,
                               @RequestParam("icon") MultipartFile multipartFile,
                               Model model,
                               HttpSession session){
//        if(result.hasErrors()){
//            model.addAttribute("message","Có thông tin bạn chưa nhập");
//            return "/category/category";
//        }
        // thêm ảnh
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "uploads/";
        category.setIcon(fileName);
        paramService.save(multipartFile,uploadDir);
        // cập nhật tên người thêm
        String createBy = (String) session.getAttribute("saveNameCustomer");
        category.setCreatedBy("admin");
        //
        category.setCreatedDate(new Date().toInstant());

        session.setAttribute("saveFile",paramService.save(multipartFile,uploadDir));

        categoryService.save(category);
        model.addAttribute("category",new Category());

        return "redirect:/admin/category";
    }
    // sửa
    // lưu lại khi sửa
    @PostMapping("/updateCategory/{id}")
    public String saveOrUpdate(@Validated @ModelAttribute(name = "category") Category category,
                               BindingResult result,
                               Model model,
                               @RequestParam("icon") MultipartFile multipartFile,
                               @PathVariable(name = "id") Integer id,
                               HttpSession session){

        // cập nhật tên người sửa
        String updateBy = (String) session.getAttribute("saveNameCustomer");
        category.setUpdatedBy(updateBy);
        // cập nhật lên payment để sửa
        // cập nhật ảnh
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "uploads/";
        category.setIcon(fileName);
        paramService.save(multipartFile,uploadDir);
        //
        Optional<Category> category1= categoryService.findById(id);
        if(category1.isPresent()){
            model.addAttribute("category1",category1.get());
            categoryService.save(category);
            return "redirect:/admin/category";
        }else {
            model.addAttribute("category",new Category());
        }
        return "redirect:/admin/category";
    }
    // click vào để sửa
    @GetMapping("/category/{id}")
    public String edit(@ModelAttribute(name = "category") Category category,
                       @PathVariable(name = "id") Integer id,Model model,HttpSession session){
        String createBy = (String) session.getAttribute("saveNameCustomer");
        category.setCreatedBy(createBy);
        Optional<Category> category1= categoryService.findById(id);
        if(category1.isPresent()){
            model.addAttribute("category1",category1.get());
        }else {
            model.addAttribute("category",new Category());
        }
        return "/update/updateCategory";
    }
    // xóa
    @GetMapping("/removeCategory/{id}")
    public String removeCategory(@PathVariable(name = "id")Integer id){
        categoryService.deleteById(id);
        return "redirect:/admin/category";
    }


    // Product
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCrudService productService;

    @GetMapping("/product")
    public String viewProduct(Model model){
        model.addAttribute("PRODUCT",productRepository.findAll());
        return "admin/dynamic/product";
    }

    // thêm
    // lưu lại khi thêm mới
    @PostMapping("/saveProduct")
    public String saveProduct(@Validated @ModelAttribute(name = "product") Product product,
                               BindingResult result,
                               @RequestParam("image") MultipartFile file,
                               Model model,
                               HttpSession session){
//        if(result.hasErrors()){
//            model.addAttribute("message","Có thông tin bạn chưa nhập");
//            return "/category/category";
//        }
        // thêm ảnh
        String fileName1 = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "uploads/";
        product.setImage(fileName1);
        paramService.save(file,uploadDir);
        // cập nhật tên người thêm
        product.setCreatedBy("admin");
        // product.setIsDelete(1);
        //
//        session.setAttribute("saveFile",paramService.save(file,uploadDir));
        product.setCreatedDate(new Date().toInstant());

        productService.save(product);
        model.addAttribute("product",new Product());

        return "redirect:/admin/product";
    }

    // sửa
    // lưu lại khi sửa
    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@Validated @ModelAttribute(name = "product") Product product,
                               BindingResult result,
                               Model model,
                               @RequestParam("image") MultipartFile file,
                               @PathVariable(name = "id") Integer id,
                               HttpSession session){

        // cập nhật tên người sửa
        String updateBy = (String) session.getAttribute("saveNameCustomer");
        product.setUpdatedBy(updateBy);
        // cập nhật lên payment để sửa
        // cập nhật ảnh
        String fileName1 = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "uploads/";
        product.setImage(fileName1);
        paramService.save(file,uploadDir);
        //
        Optional<Product> product1= productService.findById(id);
        if(product1.isPresent()){
            model.addAttribute("product1",product1.get());
            productService.save(product);
            return "redirect:/admin/product";
        }else {
            model.addAttribute("product",new Product());
        }
        return "redirect:/admin/product";
    }
    // click vào để sửa
    @GetMapping("/product/{id}")
    public String edit(@ModelAttribute(name = "product") Product product,
                       @PathVariable(name = "id") Integer id,
                       Model model,HttpSession session){
        String updateBy = (String) session.getAttribute("saveNameCustomer");
        product.setUpdatedBy(updateBy);
        Optional<Product> product1= productService.findById(id);
        if(product1.isPresent()){
            model.addAttribute("product1",product1.get());
        }else {
            model.addAttribute("product",new Product());
        }
        return "/update/updateProduct";
    }
    // xóa
    @GetMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable(name = "id")Integer id){
        productService.deleteById(id);
        return "redirect:/admin/product";
    }


    //Order
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order")
    public String viewOrder(Model model){
        model.addAttribute("ORDER",orderRepository.findAll());
        return "admin/static/order";

    }

    //Product Image
    @Autowired
    ProductImageRepository productImageRepository;

    @Autowired
    ProductImageCrudService productImageService;
    @GetMapping("/productImage")
    public String viewProductImage(Model model){
        model.addAttribute("PRODUCT",productRepository.findAll());
        model.addAttribute("IMAGE",productImageRepository.findAll());
        return "admin/dynamic/productImage";
    }
    @PostMapping("/saveProductImage")
    public String saveOrUpdate(@Validated @ModelAttribute(name = "productImage") ProductImage productImage,
                               BindingResult result,
                               @RequestParam("url") MultipartFile file,
                               Model model,
                               HttpSession session){
        // thêm ảnh
        String fileName1 = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "uploads/";
        productImage.setUrl(fileName1);
        paramService.save(file,uploadDir);
        //
//        session.setAttribute("saveFile",paramService.save(file,uploadDir));

        productImageService.save(productImage);
        model.addAttribute("image",new ProductImage());

        return "redirect:/admin/productImage";
    }

    // lưu lại khi sửa
    @PostMapping("/updateProductImage/{id}")
    public String updateProductImage(@Validated @ModelAttribute(name = "productImage") ProductImage productImage,
                               BindingResult result,
                               Model model,
                               @RequestParam("url") MultipartFile file,
                               @PathVariable(name = "id") Integer id,
                               HttpSession session){

        // cập nhật lên để sửa
        // cập nhật ảnh
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "uploads/";
        productImage.setUrl(fileName);
        paramService.save(file,uploadDir);
        //
        Optional<ProductImage> image1= productImageService.findById(id);
        if(image1.isPresent()){
            model.addAttribute("image1",image1.get());
            productImageService.save(productImage);
            return "redirect:/admin/productImage";
        }else {
            model.addAttribute("image",new ProductImage());
        }
        return "redirect:/admin/productImage";
    }
    // click vào để sửa
    @GetMapping("/productImage/{id}")
    public String edit(@ModelAttribute(name = "image") ProductImage image,
                       @PathVariable(name = "id") Integer id,
                       Model model,HttpSession session){

        Optional<ProductImage> image1= productImageService.findById(id);
        if(image1.isPresent()){
            model.addAttribute("image1",image1.get());
        }else {
            model.addAttribute("image",new ProductImage());
        }
        return "/update/updateProductImage";
    }
    //xóa
    @GetMapping("/removeProductImage/{id}")
    public String remove(@PathVariable(name = "id")Integer id){
        productImageService.deleteById(id);
        return "redirect:/admin/productImage";
    }

    //Payment Method
    @Autowired
    PaymentMethodRepository paymentMethodRepository;
    @Autowired
    PaymentCrudService paymentService;

    @GetMapping("/paymentMethod")
    public String viewPaymentMethod(Model model){
        model.addAttribute("PAYMENT",paymentMethodRepository.findAll());
        return "admin/dynamic/paymentMethod";
    }
    // thêm
    @PostMapping("/savePayment")
    public String savePayment(@Validated @ModelAttribute(name = "payment") PaymentMethod paymentMethod,
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            model.addAttribute("message","Có thông tin bạn chưa nhập");
            return "admin/dynamic/paymentMethod";
        }
        paymentMethod.setCreatedDate(new Date().toInstant());
        paymentService.save(paymentMethod);
        model.addAttribute("payment",new PaymentMethod());

        return "redirect:/admin/paymentMethod";
    }

    // sửa
    @PostMapping("/updatePayment/{id}")
    public String updatePayment(@Validated @ModelAttribute(name = "payment") PaymentMethod paymentMethod,
                               BindingResult result,
                               Model model,
                               @PathVariable(name = "id") Integer id){

        // cập nhật lên payment để sửa
        Optional<PaymentMethod> paymentMethod1= paymentService.findById(id);
        if(paymentMethod1.isPresent()){
            model.addAttribute("paymentMethod1",paymentMethod1.get());
            paymentMethod.setUpdatedDate(new Date().toInstant());
            paymentService.save(paymentMethod);
            return "redirect:/admin/paymentMethod";
        }else {
            model.addAttribute("payment",new PaymentMethod());
        }
        return "redirect:/admin/paymentMethod";
    }
    @GetMapping("/payment/{id}")
    public String edit(@PathVariable(name = "id") Integer id,Model model){
        Optional<PaymentMethod> paymentMethod1= paymentService.findById(id);
        if(paymentMethod1.isPresent()){
            model.addAttribute("paymentMethod1",paymentMethod1.get());
        }else {
            model.addAttribute("payment",new PaymentMethod());
        }
        return "update/updatePayment";
    }

    //xóa
    @GetMapping("/removePayment/{id}")
    public String removePayment(@PathVariable(name = "id")Integer id){
        paymentService.deleteById(id);
        return "redirect:/admin/paymentMethod";
    }


    //Transport Method
    @Autowired
    TransportMethodRepository transportMethodRepository;

    @Autowired
    TransportCrudService transportService;
    @GetMapping("/transportMethod")
    public String viewTransportMethod(Model model){
        model.addAttribute("TRANSPORT",transportMethodRepository.findAll());
        return "admin/dynamic/transportMethod";
    }

    // thêm
    @PostMapping("/saveTransport")
    public String saveTransport(@Validated @ModelAttribute(name = "transport")TransportMethod transportMethod,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("message","Có thông tin bạn chưa nhập");
            return "admin/dynamic/transportMethod";
        }
        transportMethod.setCreatedDate(new Date().toInstant());
        transportService.save(transportMethod);
        model.addAttribute("transport",new TransportMethod());

        return "redirect:/admin/transportMethod";
    }

    // sửa
    @PostMapping("/updateTransport/{id}")
    public String updateTransport(@Validated @ModelAttribute(name = "transport") TransportMethod transportMethod,
                                BindingResult result,
                                Model model,
                                @PathVariable(name = "id") Integer id){

        // cập nhật lên payment để sửa
        Optional<TransportMethod> transportMethod1= transportService.findById(id);
        if(transportMethod1.isPresent()){
            model.addAttribute("transportMethod1",transportMethod1.get());
            transportMethod.setUpdatedDate(new Date().toInstant());
            transportService.save(transportMethod);
            return "redirect:/admin/transportMethod";
        }else {
            model.addAttribute("transport",new TransportMethod());
        }
        return "redirect:/admin/transportMethod";
    }
    @GetMapping("/transport/{id}")
    public String editTransport(@PathVariable(name = "id") Integer id,Model model){
        Optional<TransportMethod> transportMethod= transportService.findById(id);
        if(transportMethod.isPresent()){
            model.addAttribute("transportMethod1",transportMethod.get());
        }else {
            model.addAttribute("transport",new TransportMethod());
        }
        return "update/updateTransport";
    }



    //xóa
    @GetMapping("/removeTransport/{id}")
    public String removeTransport(@PathVariable(name = "id")Integer id){
        transportService.deleteById(id);
        return "redirect:/admin/transportMethod";
    }

}
