/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.controller;

import com.pavikumbhar.javaheart.dao.CustomerDao;
import com.pavikumbhar.javaheart.datatable.DataTablesColumn;
import com.pavikumbhar.javaheart.datatable.DataTablesRequest;
import com.pavikumbhar.javaheart.datatable.DataTablesResponse;
import com.pavikumbhar.javaheart.datatable.DataTablesSearch;
import com.pavikumbhar.javaheart.entity.City;
import com.pavikumbhar.javaheart.entity.Cust;
import com.pavikumbhar.javaheart.entity.Customer;
import com.pavikumbhar.javaheart.jtable.JTableJSONResponse;
import com.pavikumbhar.javaheart.service.CustomerService;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import newpackage.DataTablesEditorRequest;
import newpackage.DataTablesEditorResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author pavikumbhar
 */
@Controller
public class DataTableController {

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public DataTablesResponse<Customer> find(@RequestBody DataTablesRequest dataTablesRequest) {
        // The argument 'dtRequest' contains search and paging parameters.

        // Call the service responsible for retrieving your data here.
        DataTablesResponse<Customer> dataTablesResponse = customerService.getDataTable(dataTablesRequest);

        return dataTablesResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/datapost", method = RequestMethod.POST)
    public DataTablesEditorResponse<Cust> findget(@RequestBody DataTablesEditorRequest dataTablesEditorRequest, HttpServletRequest httpRequest) {
        // The argument 'dtRequest' contains search and paging parameters.
        // Call the service responsible for retrieving your data here.
        Map<String, String[]> parameterMap = httpRequest.getParameterMap();
        System.out.println("com..findget()" + parameterMap);

        System.out.println("dataTablesEditorRequest" + dataTablesEditorRequest.toString());

        //   DataTablesResponse<Customer> dataTablesResponse=customerService.getDataTable(dataTablesRequest);
        DataTablesEditorResponse<Cust> dataTablesResponse = new DataTablesEditorResponse<Cust>();
        Cust cust = new Cust(1L, "pp", "zsd", "xds", "xadas", "sdf", new Date(), 0);
        Cust cust2 = new Cust(2L, "Pravin", "Kumbhar", "xds", "xadas", "sdf", new Date(), 0);
        List<Cust> list = new ArrayList<Cust>();

        City city = new City(1L, "Kolhapur");
        City city1 = new City(2L, "Pune");
        City city2 = new City(3L, "Mumbai");

        List<City> listCity = new ArrayList<City>();
        listCity.add(city);
        listCity.add(city1);
        listCity.add(city2);

        list.add(cust);
        list.add(cust2);

        LinkedHashMap<String, Object> options = new LinkedHashMap<String, Object>();
        options.put("city", listCity);
        dataTablesResponse.setOptions(options);
        dataTablesResponse.setData(list);
        return dataTablesResponse;
    }

    @RequestMapping(value = "/jobSchedulerList")
    @ResponseBody
    public JTableJSONResponse<Customer> jobSchedulerList(@RequestParam int jtStartIndex, @RequestParam int jtPageSize, @RequestParam(required = false) String jtSorting) {
        System.out.println("jtSorting" + jtSorting);
        JTableJSONResponse<Customer> responseEntity = new JTableJSONResponse<Customer>();
        try {
            List<Customer> jobSchedulers = customerService.findRange(jtStartIndex, jtPageSize);
            int count = customerService.findRange(jtStartIndex, jtPageSize).size();

            responseEntity.setResult("OK");
            responseEntity.setRecords(jobSchedulers);
            responseEntity.setTotalRecordCount(count);

        } catch (Exception e) {
            responseEntity.setResult("ERROR");
            return responseEntity;

        }
        return responseEntity;

    }

    /**
     *
     * @param jobScheduler
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/saveJobScheduler", method = RequestMethod.POST)
    public @ResponseBody
    JTableJSONResponse saveJobScheduler(Customer customer, BindingResult bindingResult) {
        JTableJSONResponse jTableJSONResponse = new JTableJSONResponse();
        try {

            customerService.saveOrUpdate(customer);
            jTableJSONResponse.setResult("OK");
            return jTableJSONResponse;
        } catch (Exception e) {
            e.printStackTrace();
            jTableJSONResponse.setResult("Error");
            return jTableJSONResponse;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteJobScheduler", method = RequestMethod.POST)
    public @ResponseBody
    JTableJSONResponse deleteJobScheduler(Long id) {
        JTableJSONResponse jTableJSONResponse = new JTableJSONResponse();
        System.out.println("qwqw@@@@@@@@@@@@@@@");
        try {
            // shedulerService.updateJobScheduler(jobScheduler);
            jTableJSONResponse.setResult("OK");
            return jTableJSONResponse;
        } catch (Exception e) {
            e.printStackTrace();
            jTableJSONResponse.setResult("Error");
            return jTableJSONResponse;
        }
    }

    /**
     *
     * @param jobScheduler
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/updateJobScheduler", method = RequestMethod.POST)
    public @ResponseBody
    JTableJSONResponse updateJobScheduler(Customer customer, BindingResult bindingResult) {
        JTableJSONResponse jTableJSONResponse = new JTableJSONResponse();
        try {
            customerService.saveOrUpdate(customer);
            jTableJSONResponse.setResult("OK");
            return jTableJSONResponse;
        } catch (Exception e) {
            e.printStackTrace();
            jTableJSONResponse.setResult("Error");
            return jTableJSONResponse;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/api/rest/remove", method = RequestMethod.DELETE)
    public DataTablesEditorResponse<Cust> remove(@RequestBody DataTablesEditorRequest<Cust> dataTablesEditorRequest, HttpServletRequest httpRequest) {
        // The argument 'dtRequest' contains search and paging parameters.
        // Call the service responsible for retrieving your data here.
        Map<String, String[]> parameterMap = httpRequest.getParameterMap();
        System.out.println("com..remove()" + parameterMap);

        System.out.println("dataTablesEditorRequest" + dataTablesEditorRequest.toString());

        //   DataTablesResponse<Customer> dataTablesResponse=customerService.getDataTable(dataTablesRequest);
        Map<String, Cust> data = dataTablesEditorRequest.getData();
        System.out.println("com..remove() >>>>>>>" + dataTablesEditorRequest.getData().toString());
        DataTablesEditorResponse<Cust> dataTablesResponse = new DataTablesEditorResponse<Cust>();
        Cust cust = new Cust(1L, "pp", "zsd", "xds", "xadas", "sdf", new Date(), 0);
        List<Cust> list = new ArrayList<Cust>();
        list.add(cust);
        dataTablesResponse.setData(list);
        return dataTablesResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/api/rest/edit", method = RequestMethod.PUT)
    public DataTablesEditorResponse<Cust> edit(@RequestBody DataTablesEditorRequest<Cust> dataTablesEditorRequest, HttpServletRequest httpRequest) {
        // The argument 'dtRequest' contains search and paging parameters.
        // Call the service responsible for retrieving your data here.
        Map<String, String[]> parameterMap = httpRequest.getParameterMap();
        System.out.println("com..edit()" + parameterMap);

        System.out.println("dataTablesEditorRequest" + dataTablesEditorRequest.toString());

        //   DataTablesResponse<Customer> dataTablesResponse=customerService.getDataTable(dataTablesRequest);
        Map<String, Cust> data = dataTablesEditorRequest.getData();
        System.out.println("com..edit() >>>>>>>" + dataTablesEditorRequest.getData().toString());
        DataTablesEditorResponse<Cust> dataTablesResponse = new DataTablesEditorResponse<Cust>();
        Cust cust = new Cust(1L, "pp", "zsd", "xds", "xadas", "sdf", new Date(), 0);
        List<Cust> list = new ArrayList<Cust>();
        list.add(cust);
        dataTablesResponse.setData(list);
        return dataTablesResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/api/rest/create", method = RequestMethod.POST)
    public DataTablesEditorResponse<Cust> create(@RequestBody DataTablesEditorRequest<Cust> dataTablesEditorRequest, HttpServletRequest httpRequest) {
        // The argument 'dtRequest' contains search and paging parameters.
        // Call the service responsible for retrieving your data here.
        Map<String, String[]> parameterMap = httpRequest.getParameterMap();
        System.out.println("com..create()" + parameterMap);

        System.out.println("dataTablesEditorRequest" + dataTablesEditorRequest.toString());

        newpackage.FieldError fieldError = new newpackage.FieldError();
        fieldError.setName("salary");
        fieldError.setStatus("Pravin Kumbhar");

        System.out.println("com..create() >>>>>>>" + dataTablesEditorRequest.getData().toString());
        DataTablesEditorResponse<Cust> dataTablesResponse = new DataTablesEditorResponse<Cust>();

        List<newpackage.FieldError> fieldErrors = new ArrayList<newpackage.FieldError>();
        dataTablesResponse.setFieldErrors(fieldErrors);
        return dataTablesResponse;
    }

}
