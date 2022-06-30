package com.bolsadeideas.springboot.web.app.service;

import com.bolsadeideas.springboot.web.app.models.Adn;

import java.util.List;

public interface IadnService {


    public List<Adn> findAll();

    public void save(Adn adn);

    public Adn findOne(Long id);

    public void delete(Long id);
}
