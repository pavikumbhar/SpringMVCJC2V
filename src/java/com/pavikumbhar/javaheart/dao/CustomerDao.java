/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.dao;

import com.pavikumbhar.javaheart.common.dao.GenericDao;
import com.pavikumbhar.javaheart.datatable.DataTablesRequest;
import com.pavikumbhar.javaheart.datatable.DataTablesResponse;
import com.pavikumbhar.javaheart.entity.Customer;

/**
 *
 * @author pavikumbhar
 */
public interface CustomerDao extends GenericDao<Customer, Long>{
    
     public  DataTablesResponse<Customer>  getDataTable(DataTablesRequest dataTablesRequest ) ;
    
}
