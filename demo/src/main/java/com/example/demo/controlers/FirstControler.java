package com.example.demo.controlers;

import com.example.demo.model.Coffee;
import com.example.demo.repo.CoffeeRepo;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class FirstControler {
    @Autowired
    private CoffeeRepo coffeeRepo;
    @Autowired
    private ProductService productService;

    @GetMapping("/coffee/all")
    public String allCoffee(Model model){
        Iterable<Coffee> kinds = productService.getAll();
        model.addAttribute("kinds",kinds);
        return "all";
    }
    @GetMapping("/coffee/zerno")
    public String beanCoffee(Model model){
        List<Coffee> kindsOfBean = productService.coffeeInZerno();
        model.addAttribute("kindsOfBean",kindsOfBean);
        return "zerno";
    }
    @GetMapping("/coffee")
    public  String showMain(Model model){
        return "newHomePage";
    }

    @GetMapping("/coffee/add")
    public String addCoffee(Model model) {
        return "addingForm";
    }

    @PostMapping("/coffee/add")
        public String addCoffee(@RequestParam("file") MultipartFile file,
                                @RequestParam String name,
                                @RequestParam String description,
                                @RequestParam String type,
                                Model model) {
        productService.saveProduct(file, name, description,type);
        return "redirect:all";
    }
    @GetMapping("/coffee/{id}/edit")
    public String editCoffee(@PathVariable(value = "id") long id, Model model){
        if (!coffeeRepo.existsById(id)){
      return "redirect:coffee/all";
    }
        Optional<Coffee> cof = coffeeRepo.findById(id);
        ArrayList<Coffee> cofe = new ArrayList<>();
        cof.ifPresent(cofe::add);
        model.addAttribute("cof",cofe);
        return "edit";
    }

    @PostMapping("/coffee/{id}/edit")
    public String editCoffee(@PathVariable(value = "id") long id,
                             @RequestParam("file")MultipartFile file,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam String type,
                             Model model){
        productService.editor(id,file,name,description,type );

        return "redirect:/coffee/all";
    }
    @GetMapping("/coffee/{id}/delete")
    public String deleteCoffee(@PathVariable(value = "id") long id, Model model) {
        productService.deletecof(id);
        return "redirect:/coffee/all";
    }
    @GetMapping("/coffee/ground")
    public String groundCoffee(Model model){
        List<Coffee> groundCoffee = productService.groundCoffee();
        model.addAttribute("groundCoffee",groundCoffee);
        return "ground";
    }
    @GetMapping("/coffee/capsules")
    public String coffeeInCapsules(Model model){
        List<Coffee> coffeeInCapsules = productService.coffeeInCapsules();
        model.addAttribute("coffeeInCapsules",coffeeInCapsules);
        return "capsules";
    }
@GetMapping("/login")
    public String showLogin(){
        return "login";
}


}
