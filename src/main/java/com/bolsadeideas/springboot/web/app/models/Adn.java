package com.bolsadeideas.springboot.web.app.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "adns")
public class Adn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String adn;

    @NotEmpty
    private String isMutante;


    public Adn() {
    }

    public Adn(String adn, String isMutante) {
        this.adn = adn;
        this.isMutante = isMutante;
    }

    public String isMutante() {
        return isMutante;
    }

    public void setMutante(String mutante) {
        isMutante = mutante;
    }

    public Adn(String adn) {
        this.adn = adn;
    }

    public String getAdn() {
        return adn;
    }

    public void setAdn(String adn) {
        this.adn = adn;
    }
}
