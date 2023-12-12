package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Adn;
import com.bolsadeideas.springboot.web.app.models.Candidate;
import com.bolsadeideas.springboot.web.app.models.Statistics;
import com.bolsadeideas.springboot.web.app.service.IadnService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.bolsadeideas.springboot.web.app.commos.Validation.isMutant;

@RestController
@RequestMapping("/api")
public class MagnetoController {

    @Autowired
    private IadnService adnService;

    @PostMapping("/mutant")
    public ResponseEntity<String> mutant(@RequestBody Candidate dna) {

        // logica en el controller no va , isMutant tiene que ser boolean
            if (Boolean.TRUE.equals(isMutant(dna.getDna()))) {
                adnService.save(new Adn(Arrays.toString(dna.getDna()), "YES"));
                return ResponseEntity.ok().build();
            }
            adnService.save(new Adn(Arrays.toString(dna.getDna()), "NO"));
            return new ResponseEntity(HttpStatus.FORBIDDEN);

        }



    @GetMapping("/stats")
    @JsonIgnore
    public ResponseEntity<Statistics> stats() {

        Statistics statistics = new Statistics(0, 0, (float) 0);

        int cantMuntante = 0;
        int cantHumano = 0;

        List<Adn> listAll = adnService.findAll();

        if (!listAll.isEmpty()) {
            for (int i = 0; i < listAll.size(); i++) {
                if (listAll.get(i).isMutante().equals("YES")) {
                    cantMuntante++;
                } else {
                    cantHumano++;
                }
            }

        }
        statistics.setCount_human_dna(cantHumano);
        statistics.setCount_mutant_dna(cantMuntante);

        if (cantHumano != 0) {
            statistics.setRatio((float) (cantMuntante / (float) cantHumano));
        }

        return new ResponseEntity<Statistics>(statistics, HttpStatus.OK);
    }

    @GetMapping("/allAdns")
    public ResponseEntity<List<Adn>> allAdns() {
        List<Adn> listAll = adnService.findAll();
        return new ResponseEntity<List<Adn>>(listAll, HttpStatus.OK);
    }

}
