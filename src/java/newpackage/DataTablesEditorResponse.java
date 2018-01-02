/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author pavikumbhar
 */
public class DataTablesEditorResponse<T> {
    /* Server-side processing parameters */

        /// <summary>
        /// Draw counter for server-side processing requests
        /// </summary>
        private int draw;

        /// <summary>
        /// Data to draw the table with, for both client-side and server-side processing
        /// </summary>
      //  private List<LinkedHashMap<String,Object>> data = new ArrayList<LinkedHashMap<String,Object>>();
        
          private List<T> data = Collections.emptyList();

  
        /// <summary>
        /// Total record count for server-side processing requests
        /// </summary>
        private int recordsTotal;

        /// <summary>
        /// Record count in the filtered data set for server-side processing requests
        /// </summary>
        private int recordsFiltered;


        /* Editor parameters */

        /// <summary>
        /// General error message if there is one
        /// </summary>
        private String error;

        /// <summary>
        /// List of field errors if one or more fields are in an error state
        /// when validated
        /// </summary>
        private List<FieldError> fieldErrors = new ArrayList<FieldError>();

        /// <summary>
        /// Id of the newly created row for the create action
        /// </summary>
        private int id;

        /// <summary>
        /// Information that can be processes in the Ajax callback handlers can
        /// be added here. It is not actively used by the libraries.
        /// </summary>
        private LinkedHashMap<String, Object> meta =
            new LinkedHashMap<String, Object>();

        /// <summary>
        /// List of options for Editor `select`, `radio` and `checkbox` field types
        /// </summary>
        private LinkedHashMap<String, Object> options =
            new LinkedHashMap<String, Object>();

        /// <summary>
        /// File information for the upload input types
        /// </summary>
        private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, Object>>> files =
            new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, Object>>>();

        /// <summary>
        /// Row data on update action
        /// </summary>
        private ResponseUpload upload =
            new ResponseUpload();

        /// <summary>
        /// If debug mode is enabled, this property will be populated with information
        /// about the SQL statements Editor has run.
        /// </summary>
    //    private List<DebugInfo> debugSql;

        /// <summary>
        /// List of ids for row that have had their processing cancelled by the `pre*` events
        /// </summary>
        private List<Object> cancelled  = new ArrayList<Object>();

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    /*
    public List<LinkedHashMap<String, Object>> getData() {
        return data;
    }

    public void setData(List<LinkedHashMap<String, Object>> data) {
        this.data = data;
    }
*/
    
     public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    
    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedHashMap<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(LinkedHashMap<String, Object> meta) {
        this.meta = meta;
    }

    public LinkedHashMap<String, Object> getOptions() {
        return options;
    }

    public void setOptions(LinkedHashMap<String, Object> options) {
        this.options = options;
    }

    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, Object>>> getFiles() {
        return files;
    }

    public void setFiles(LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, Object>>> files) {
        this.files = files;
    }

    public ResponseUpload getUpload() {
        return upload;
    }

    public void setUpload(ResponseUpload upload) {
        this.upload = upload;
    }

    public List<Object> getCancelled() {
        return cancelled;
    }

    public void setCancelled(List<Object> cancelled) {
        this.cancelled = cancelled;
    }
    
     


    
}

   

   class ResponseUpload
        {
  private int id ;
    public int getId() {
        return id;
    }

    /// <summary>
    /// Id of the newly uploaded file
    /// </summary>
    public void setId(int id) {
        this.id = id;
    }
          
        }