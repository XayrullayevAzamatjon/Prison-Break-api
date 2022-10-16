package com.azik.controller;

import com.azik.model.PrisonBreak;
import com.azik.service.PrisonBreakService;
import com.azik.exceptions.UserNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private PrisonBreakService service;

    @GetMapping("/characters")
    public List<PrisonBreak> getAllCharacters(){
        List<PrisonBreak> list=service.findAll();
        return list;
    }
    @GetMapping("/characters/{id}")
    public Optional<PrisonBreak> getOneCharacter(@PathVariable("id") Long id) throws UserNotfoundException {
        return service.findOne(id);
    }
    @PostMapping("/characters")
    public PrisonBreak add(@RequestBody PrisonBreak prisonBreak){
        return service.save(prisonBreak);
    }
    @PutMapping("/characters/{id}")
    public PrisonBreak edit(@PathVariable("id") Long id,@RequestBody PrisonBreak prisonBreak)
            throws UserNotfoundException {
        if (service.findById(id)){
            return service.save(prisonBreak);
        }
        else {
            throw new UserNotfoundException("User with given id is not found");
        }
    }
    @DeleteMapping("/characters/{id}")
    public  void delete(@PathVariable("id") Long id){
        service.delete(id);
    }


}
