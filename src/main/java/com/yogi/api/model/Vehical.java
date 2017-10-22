package com.yogi.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Krishan Shukla on 18/09/2017.
 */

/*@Entity
@Table(name = "Vehical")*/
public class Vehical implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(nullable = true, length = 150)
    private String vehicalRegistrationNumber;

    @Column(nullable = true, length = 150)
    private String vehicalModel;

    @Column(nullable = true, length = 300)
    private String color;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicalRegistrationNumber() {
        return vehicalRegistrationNumber;
    }

    public void setVehicalRegistrationNumber(String vehicalRegistrationNumber) {
        this.vehicalRegistrationNumber = vehicalRegistrationNumber;
    }

    public String getVehicalModel() {
        return vehicalModel;
    }

    public void setVehicalModel(String vehicalModel) {
        this.vehicalModel = vehicalModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
