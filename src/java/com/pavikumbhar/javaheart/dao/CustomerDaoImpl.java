package com.pavikumbhar.javaheart.dao;

import com.pavikumbhar.javaheart.common.dao.GenericDaoImpl;
import com.pavikumbhar.javaheart.datatable.DataTablesColumn;
import com.pavikumbhar.javaheart.datatable.DataTablesRequest;
import com.pavikumbhar.javaheart.datatable.DataTablesResponse;
import com.pavikumbhar.javaheart.entity.Customer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer, Long> implements CustomerDao {

    @Override
    public DataTablesResponse<Customer> getDataTable(DataTablesRequest dataTablesRequest) {

        DataTablesResponse<Customer> dataTablesResponse = new DataTablesResponse<Customer>();
        dataTablesResponse.setDraw(dataTablesRequest.getDraw());
        
        
        int start= dataTablesRequest.getStart();
        int lenth= dataTablesRequest.getLength();  

        List<DataTablesColumn> columns = dataTablesRequest.getColumns();

        String custId = dataTablesRequest.getColumns().get(0).getSearch().getValue();

        String custName = dataTablesRequest.getColumns().get(1).getSearch().getValue();

        String custContact = dataTablesRequest.getColumns().get(2).getSearch().getValue();

        String custCity = dataTablesRequest.getColumns().get(3).getSearch().getValue();

        String columnName = "";
        String dir = "";
        String searchTerm = "";   //globalserach
        
        
           if(dataTablesRequest.getSearch()!=null){
           searchTerm=dataTablesRequest.getSearch().getValue();
           }     
       int total = 0;
        List<String> sArray = new ArrayList<String>();

        if (!custId.equals("")) {
            String sId = " custId like '%" + custId + "%'";
            sArray.add(sId);
        }
        if (!custName.isEmpty()) {
            String sName = " custName like '%" + custName + "%'";
            sArray.add(sName);
        }
        if (!custContact.isEmpty()) {
            String sContact = " custContact like '%" + custContact + "%'";
            sArray.add(sContact);
        }
        if (!custCity.isEmpty()) {
            String sCity = " custCity like '%" + custCity + "%'";
            sArray.add(sCity);
        }

        String individualSearch = "";

        if (sArray.size() == 1) {
            individualSearch = sArray.get(0);
        } else if (sArray.size() > 1) {
            for (int i = 0; i < sArray.size() - 1; i++) {
                individualSearch += sArray.get(i) + " AND ";
            }
            individualSearch += sArray.get(sArray.size() - 1);
        }

        System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" );
        System.out.println("individualSearch " + individualSearch);
        
         System.out.println("searchTerm " + searchTerm);
  System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" );
        if (dataTablesRequest.getOrder().size() > 1) {
            columnName = columns.get(0).getData();
            dir = "asc";
        } else if (dataTablesRequest.getOrder().size() == 1) {

            int columindex = dataTablesRequest.getOrder().get(0).getColumn();

            columnName = columns.get(columindex).getData();

            dir = dataTablesRequest.getOrder().get(0).getDir().name();

        }

        total=this.findAll().size();
        int totalAfterFilter = total;
        String searchSQL = "";
        String sql = "SELECT * FROM Customer ";

        String globeSearch = " where (custId like '%" + searchTerm + "%'"
                + " or custName like '%" + searchTerm + "%'"
                + " or custContact like '%" + searchTerm + "%'"
                + " or custCity like '%" + searchTerm + "%')";
        if (searchTerm != "" && individualSearch != "") {
            searchSQL = globeSearch + " AND " + individualSearch;
        } else if (individualSearch != "") {
            searchSQL = " where " + individualSearch;
        } else if (searchTerm != "") {
            searchSQL = globeSearch;
        }
        sql += searchSQL;
        sql += " order by " + columnName + " " + dir;
        sql += " limit " + start + ", " + lenth;
        
        
        List<Customer> list = this.getCurrentSession().createSQLQuery(sql).addEntity(Customer.class).list();
          System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%searchSQL" +searchSQL );
        
        String sql2 = "SELECT count(*) FROM Customer";
			if (searchTerm != "") {
				sql2 += searchSQL;
				
           BigInteger bi1= (BigInteger)this.getCurrentSession().createSQLQuery(sql2).uniqueResult();
			  totalAfterFilter=bi1.intValue();
                        }

        dataTablesResponse.setData(list);
        dataTablesResponse.setRecordsTotal(total);
            dataTablesResponse.setRecordsFiltered(totalAfterFilter);// to populate the response with you data.
        return dataTablesResponse;

    }

}
