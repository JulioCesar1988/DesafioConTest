package com.bolsadeideas.springboot.web.app.service;

import com.bolsadeideas.springboot.web.app.dao.IAdnDao;
import com.bolsadeideas.springboot.web.app.models.Adn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdnServiceImpl implements IadnService{



    private static final Logger logger = LoggerFactory.getLogger(AdnServiceImpl.class);


    @Autowired
    private IAdnDao adnDao;


    @Override
    public List<Adn> findAll() {
        logger.info("INFO OBTENIDA EN BD -> " + adnDao.findAll());
        return (List<Adn>) adnDao.findAll();
    }

    @Override
    public void save(Adn adn) {
        logger.info("INFO PARA REGISTRAR EN BD -> " + adn.toString());
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
