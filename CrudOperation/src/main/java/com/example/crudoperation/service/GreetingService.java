package com.example.crudoperation.service;

import com.example.crudoperation.model.GreetingModel;
import com.example.crudoperation.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;

    //Post method Saved Single Object
    public GreetingModel save(GreetingModel greetingModel) {
        return greetingRepository.save(greetingModel);
    }

    //Post method Saved list of Objects
    public List<GreetingModel> saveGreet(List<GreetingModel> greetingModel) {
        return greetingRepository.saveAll(greetingModel);
    }

    //getmethod return all
    public List<GreetingModel> getGreet() {
        return greetingRepository.findAll();
    }

    //return by id
    public GreetingModel getGreetById(int id) {
        return greetingRepository.findById(id).orElse(null);
    }

    //return by name
    public GreetingModel getGreetByName(String name) {
        return greetingRepository.findByFirstName(name).get();
    }

    //delete
    public String deleteGreet(int id){
        greetingRepository.deleteById(id);
        return "Delete Succesfully";
    }

    //Update
    public GreetingModel updateGreet(GreetingModel greetingModel){
        GreetingModel existing = greetingRepository.findById(greetingModel.getId()).orElse(null);
        existing.setFirstName(greetingModel.getFirstName());
        existing.setLastName(greetingModel.getLastName());
        return greetingRepository.save(existing);
    }
}
