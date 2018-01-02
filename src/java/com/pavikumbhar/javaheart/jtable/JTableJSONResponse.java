/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.jtable;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author pravinkumbhar
 */
public class JTableJSONResponse<T> {
    @JsonProperty("Result")
    private String result;

    @JsonProperty("Records")
    private List<T> records;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("TotalRecordCount")
    private int totalRecordCount;

    public JTableJSONResponse(String result, List<T> records, int totalRecordCount) {
        super();
        this.result = result;
        this.records = records;
        this.totalRecordCount = totalRecordCount;
    }

    public JTableJSONResponse() {
     
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }
    
}
