package com.example.crudoperation.controller;

import com.example.crudoperation.model.GreetingModel;
import com.example.crudoperation.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    //Rest Api
    //Post Api
    @PostMapping("/addGreet")
    public GreetingModel add(@RequestBody GreetingModel greetingModel) {
        return greetingService.save(greetingModel);
    }

    @PostMapping("/addGreets")
    public List<GreetingModel> add(@RequestBody List<GreetingModel> greetingModel) {
        return greetingService.saveGreet(greetingModel);
    }

    //Get Api
    @GetMapping("/getGreet")
    public List<GreetingModel> findAllGreet() {
        return greetingService.getGreet();
    }

    //get by id
    @GetMapping("/getById/{id}")
    public GreetingModel findProductById(@PathVariable int id) {
        return greetingService.getGreetById(id);
    }

    //getbyname
    @GetMapping("/getByName/{name}")
    public GreetingModel findProductByName(@PathVariable String name) {
        return greetingService.getGreetByName(name);
    }

    //put
    @PutMapping("/Update")
    public GreetingModel updateGreets(@RequestBody GreetingModel greetingModel) {
        return greetingService.updateGreet(greetingModel);
    }

    //delete
    @DeleteMapping("/Delete/{id}")
    public String deleteGreet(@PathVariable int id) {
        return greetingService.deleteGreet(id);
    }
}
