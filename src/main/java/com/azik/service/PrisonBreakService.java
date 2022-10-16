package com.azik.service;

import com.azik.exceptions.UserNotfoundException;
import com.azik.model.PrisonBreak;
import com.azik.repository.PrisonBreakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrisonBreakService {

    @Autowired
    private PrisonBreakRepository repository;

    public List<PrisonBreak> findAll() {
        return repository.findAll();
    }

    public Optional<PrisonBreak> findOne(Long id) throws UserNotfoundException {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new UserNotfoundException("User not found by given id")));
    }

    public PrisonBreak save(PrisonBreak prisonBreak) {
        return repository.save(prisonBreak);
    }

    public boolean findById(Long id) {
        return repository.findById(id).isPresent();
    }
    public PrisonBreak get(Long id)throws UserNotfoundException{
        Optional<PrisonBreak> result=repository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotfoundException("Could not find any user by given id");
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
