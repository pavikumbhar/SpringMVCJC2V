/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;



/**
 *
 * @author pavikumbhar
 */
@Entity
public class Cust implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getExtn() {
        return extn;
    }

    public void setExtn(String extn) {
        this.extn = extn;
    }

  
    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
    public Cust(){}
    
    public Cust(Long id, String first_name, String last_name, String position, String office, String extn, Date start_date, long salary) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.office = office;
        this.extn = extn;
        this.start_date = start_date;
        this.salary = salary;
    }
	@Id
	@GeneratedValue
	private Long id;

    @Override
    public String toString() {
        return "Cust{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", position=" + position + ", office=" + office + ", extn=" + extn + ", start_date=" + start_date + ", salary=" + salary + '}';
    }
    
    private  String first_name;
    private  String last_name;
    
    private  String position;
    
    private  String office;
    
    private  String extn;

    
    
     private  Date start_date;
    
     private  long salary;

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }
    
     @Transient
    private int city;
    
    
}
