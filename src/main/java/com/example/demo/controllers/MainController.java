package com.example.demo.controllers;

import com.example.demo.entities.Client;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Order;
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

    @GetMapping("/allOrders")
    public String allOrders(Model model) {
        Order order = new Order();
        List<Employee> employees = employeeService.findAll();
        List<Client> clients = clientService.findAll();

        model.addAttribute("order", order);

        Employee employee = Employee
                .builder()
                .surname("clienName")
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

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/main/allClients";
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



