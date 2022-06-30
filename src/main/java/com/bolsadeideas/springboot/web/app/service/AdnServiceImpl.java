package com.bolsadeideas.springboot.web.app.service;

import com.bolsadeideas.springboot.web.app.dao.IAdnDao;
import com.bolsadeideas.springboot.web.app.models.Adn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdnServiceImpl implements IadnService{

    @Autowired
    private IAdnDao adnDao;


    @Override
    public List<Adn> findAll() {
        return (List<Adn>) adnDao.findAll();
    }

    @Override
    public void save(Adn adn) {
       adnDao.save(adn);
    }

    @Override
    public Adn findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
