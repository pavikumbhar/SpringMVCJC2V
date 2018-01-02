/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author pavikumbhar
 */
public class City {

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    @Id
    @GeneratedValue
    @JsonProperty("value")
    private Long id;

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public City() {

    }

    @JsonProperty("label")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
