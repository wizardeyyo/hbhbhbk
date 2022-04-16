package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.services.*;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final OrderedService orderedService;
    private final OrderService orderService;
    private final ProductService productService;
    private final SupplierService supplierService;
    private final TypeService typeService;

    @GetMapping
    public String adminMain() {
        return "admin/AdminPage";
    }


    @PostMapping("/addOrder")
    public String addGroup(@ModelAttribute("order") Order order) {
        orderService.save(order);
        return "redirect:/main/allOrders";
    }

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/main/allClients";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/main/allEmployees";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/main/allProducts";
    }

    @PostMapping("/addSupplier")
    public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/main/allSuppliers";
    }




    @GetMapping("/allOrders")
    public String allOrders(Model model) {
        Order order = new Order();
        List<Employee> employees = employeeService.findAll();
        List<Client> clients = clientService.findAll();

        model.addAttribute("order", order);

        Employee employee = Employee
                .builder()
                .surname("clientName")
                .build();

        employeeService.save(employee);

        Client client = Client
                .builder()
                .clientName("clientName")
                .build();

        clientService.save(client);

        Order order2 = Order
                .builder()
                .client(client)
                .employee(employee)
                .paymentDate(LocalDate.now())
                .receiverAddress("receiverAddress")
                .receiverName("receiverName")
                .shippingDate(LocalDate.now())
                .build();

        orderService.save(order2);


        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("clients", clients);
        model.addAttribute("employees", employees);
        return "admin/orders";
    }



    @GetMapping("/allClients")
    public String allClients(Model model) {
        Client client = new Client();

        model.addAttribute("client", client);

//        Employee employee = Employee
//                .builder()
//                .surname("clienName")
//                .build();
//
//        employeeService.save(employee);
//
//        Client client = Client
//                .builder()
//                .clientName("clientName")
//                .build();
//
//        clientService.save(client);
//
//        Order order = Order
//                .builder()
//                .client(client)
//                .employee(employee)
//                .paymentDate(LocalDate.now())
//                .receiverAddress("receiverAddress")
//                .receiverName("receiverName")
//                .shippingDate(LocalDate.now())
//                .build();
//        System.out.println(order);

        return "admin/clients";
    }


     @GetMapping("/allProducts")
     public String allProducts(Model model){
         Product product = new Product();
         List<Product> products = productService.findAll();
         List<Supplier> suppliers = supplierService.findAll();
         List<Type> types = typeService.findAll();

         model.addAttribute("product", product);
         model.addAttribute("products", products);
         model.addAttribute("suppliers", suppliers);
         model.addAttribute("types", types);

         Supplier supplier = Supplier
         .builder()
                 .brand("brand")
                 .build();

        supplierService.save(supplier);

        Type type = Type
                .builder()
                .category("category")
                .build();

        typeService.save(type);

        Product product1 = Product
                .builder()
                .name(product.getName())
                .supplier(supplier)
                .type(type)
                .unit("unit")
                .price(product.getPrice())
                .inStock(product.getInStock())
                .build();
        System.out.println(product1);

        return "admin/products";
     }

     @GetMapping("/allSuppliers")
     public String allSuppliers(Model model){
         Supplier supplier = new Supplier();
         List<Supplier> suppliers = supplierService.findAll();
         model.addAttribute("supplier", supplier);
         model.addAttribute("suppliers", suppliers);
         return "admin/suppliers";
     }
     @GetMapping("/allEmployees")
     public String allEmployees(Model model){
        Employee employee = new Employee();
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("employees", employees);
         return "admin/employees";
     }



    // удалялки
    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        clientService.deleteById(id);
        return "redirect:/main/allClients";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return "redirect:/main/allEmployees";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteById(id);
        return "redirect:/main/allOrders";
    }

    @GetMapping("/deleteOrdered/{id}")
    public String deleteOrdered(@PathVariable("id") Long id) {
        orderedService.deleteById(id);
        return "redirect:/main/allOrdereds";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/main/allProducts";
    }

    @GetMapping("/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable("id") Long id) {
        supplierService.deleteById(id);
        return "redirect:/main/allSuppliers";
    }

    @GetMapping("/deleteType/{id}")
    public String deleteType(@PathVariable("id") Long id) {
        typeService.deleteById(id);
        return "redirect:/main/allTypes";
    }
}



