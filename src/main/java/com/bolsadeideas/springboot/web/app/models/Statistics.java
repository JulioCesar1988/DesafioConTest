package com.bolsadeideas.springboot.web.app.models;
// Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
// verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}

import java.io.Serializable;

public class Statistics   implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer count_mutant_dna;
    private Integer count_human_dna;
    private Float ratio;


    public Statistics(Integer count_mutant_dna, Integer count_human_dna, Float ratio) {
        this.count_mutant_dna = count_mutant_dna;
        this.count_human_dna = count_human_dna;
        this.ratio = ratio;
    }

    public Integer getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Integer count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public Integer getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Integer count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }
}
