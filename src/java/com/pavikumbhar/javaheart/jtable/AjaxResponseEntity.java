/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.jtable;

/**
 *
 * @author pravinkumbhar
 */
public class AjaxResponseEntity<T> {

    private AjaxResponseStatus status;

    private T entity;

    public AjaxResponseEntity(AjaxResponseStatus status) {
        super();
        this.status = status;
    }

    public AjaxResponseEntity(AjaxResponseStatus status, T entity) {
        super();
        this.status = status;
        this.entity = entity;
    }

    public AjaxResponseStatus getStatus() {
        return status;
    }

    public void setStatus(AjaxResponseStatus status) {
        this.status = status;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

}
