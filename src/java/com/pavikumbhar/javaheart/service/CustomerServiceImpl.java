/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.service;

import com.pavikumbhar.javaheart.common.service.GenericServiceImpl;
import com.pavikumbhar.javaheart.dao.CustomerDao;
import com.pavikumbhar.javaheart.datatable.DataTablesRequest;
import com.pavikumbhar.javaheart.datatable.DataTablesResponse;
import com.pavikumbhar.javaheart.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pavikumbhar
 */
@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public DataTablesResponse<Customer> getDataTable(DataTablesRequest dataTablesRequest) {

        return customerDao.getDataTable(dataTablesRequest);
    }

}
