/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import com.pavikumbhar.javaheart.datatable.DataTablesColumn;
import com.pavikumbhar.javaheart.datatable.DataTablesOrder;
import com.pavikumbhar.javaheart.datatable.DataTablesSearch;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pavikumbhar
 */
public class DataTablesEditorRequest<T>{

    @Override
    public String toString() {
        return "DataTablesEditorRequest{" + "draw=" + draw + ", start=" + start + ", length=" + length + ", search=" + search + ", order=" + order + ", columns=" + columns + ", action=" + action + ", data=" + data + ", ids=" + ids + ", uploadField=" + uploadField + '}';
    }

    ///  <summary>
    ///  DataTables draw counter for server-side processing
    ///  </summary>
    private int draw;

    ///  <summary>
    ///  DataTables record start pointer for server-side processing
    ///  </summary>
    private int start;

    ///  <summary>
    ///  DataTables page length parameter for server-side processing
    ///  </summary>
    private int length;

    ///  <summary>
    ///  Search information for server-side processing
    ///  </summary>
    private DataTablesSearch search = new DataTablesSearch();

    ///  <summary>
    ///  Column ordering information for server-side processing
    ///  </summary>
    private List<DataTablesOrder> order = Collections.emptyList();

    ///  <summary>
    ///  Column information for server-side processing
    ///  </summary>
    private List<DataTablesColumn> columns = Collections.emptyList();

    ///  <summary>
    ///  Editor action request
    ///  </summary>
    private String action;

    ///  <summary>
    ///  Dictionary of data sent by Editor (may contain nested data)
    ///  </summary>
    private Map<String, T> data;

    ///  <summary>
    ///  List of ids for Editor to operate on
    ///  </summary>
    private List<String> ids = Collections.emptyList();

    ///  <summary>
    ///  Upload field name
    ///  </summary>
    private String uploadField;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DataTablesSearch getSearch() {
        return search;
    }

    public void setSearch(DataTablesSearch search) {
        this.search = search;
    }

    public List<DataTablesOrder> getOrder() {
        return order;
    }

    public void setOrder(List<DataTablesOrder> order) {
        this.order = order;
    }

    public List<DataTablesColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<DataTablesColumn> columns) {
        this.columns = columns;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Map<String, T> getData() {
        return data;
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getUploadField() {
        return uploadField;
    }

    public void setUploadField(String uploadField) {
        this.uploadField = uploadField;
    }

}
