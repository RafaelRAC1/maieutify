package com.rafael.maieutify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.Alternative;
import com.rafael.maieutify.repository.AlternativeRepository;

@Service
public class AlternativeService {
    @Autowired
    private AlternativeRepository alternativeRepository;

    public Alternative createAlternative(Alternative alternative){
        return alternativeRepository.save(alternative);
    }

    public Iterable<Alternative> createAlternatives(Iterable<Alternative> alternatives){
        return alternativeRepository.saveAll(alternatives);
    }

    public Alternative getAlternativeById(Long id){
        return alternativeRepository.findById(id).orElse(null);
    }
}
