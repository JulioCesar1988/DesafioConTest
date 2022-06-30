package com.bolsadeideas.springboot.web.app.models;

import java.io.Serializable;


public class Candidate implements Serializable {

    private String[] dna;


    public Candidate() {
    }

    public Candidate(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
