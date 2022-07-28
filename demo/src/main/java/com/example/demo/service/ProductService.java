package com.example.demo.service;


import com.example.demo.model.Coffee;
import com.example.demo.repo.CoffeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private CoffeeRepo coffeeRepo;

    public void saveProduct(MultipartFile file,
                            String name,
                            String description,
                            String type){
        Coffee c = new Coffee();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")){
            System.out.println("file is not valid");
        }

        try {
            c.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        c.setDescription(description);
        c.setName(name);
        c.setType(type);
        coffeeRepo.save(c);
    }
    public Iterable<Coffee> getAll(){
        return coffeeRepo.findAll();
    }
    public void deletecof (Long id){
        coffeeRepo.deleteById(id);
    }
    public void editor (Long id, MultipartFile multipartFile, String name, String desc, String type){
        Coffee coffee = new Coffee();
        coffee = coffeeRepo.findById(id).get();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName.contains("..")){
            System.out.println("file is not valid");
        }

        try {
            coffee.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        coffee.setName(name);
        coffee.setDescription(desc);
        coffee.setType(type);
        System.out.println(type);
        coffeeRepo.save(coffee);
    }
    public List<Coffee> coffeeInZerno(){
        Iterable<Coffee> all = coffeeRepo.findAll();
        ArrayList<Coffee> zerno = new ArrayList<>();
        for (Coffee coffee : all){

            if (coffee.getType().toString().equals("В зернах")){

                zerno.add(coffee);
            }

        }
        return zerno;
    }
    public List<Coffee> groundCoffee() {
        Iterable<Coffee> all = coffeeRepo.findAll();
        ArrayList<Coffee> ground = new ArrayList<>();
        for (Coffee coffee:all){
            if (coffee.getType().toString().equals("Мелена")){
                ground.add(coffee);
            }
        }
        return ground;
    }
    public List<Coffee> coffeeInCapsules (){
        Iterable<Coffee> all = coffeeRepo.findAll();
        ArrayList<Coffee> capsules = new ArrayList<>();
        for (Coffee coffee:all){
            if (coffee.getType().toString().equals("В капсулах")){
                capsules.add(coffee);
            }
        }
        return capsules;
    }
}
