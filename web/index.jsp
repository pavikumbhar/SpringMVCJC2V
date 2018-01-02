
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC pagination using DataTables</title>
<%--<link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}css/responsive.bootstrap.css" rel="stylesheet" type="text/css"/>

<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.dataTables.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.responsive.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/responsive.bootstrap.js" type="text/javascript"></script>--%>

<link href="${pageContext.request.contextPath}/datatable/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/datatable/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/datatable/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>

<script src="${pageContext.request.contextPath}/datatable/js/jquery-1.12.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/datatable/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/datatable/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/datatable/js/dataTables.responsive.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/datatable/js/responsive.bootstrap.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/jquery.confirm.js" type="text/javascript"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        
      <script type="text/javascript">
//        $(document).ready(function () {
//            $("#customers").DataTable({
//                "responsive": true,
//                "serverSide": true,//"bServerSide": true,                          //Feature control DataTables' server-side processing mode
//                "ajax": "ajaxServer.action", //"sAjaxSource": "ajaxSearch.action", //Load data for the table's content from an Ajax source
//                "processing": true,// "bProcessing": true,                          //Feature control the processing indicator
//                "paginationType": "full_numbers",  //    "sPaginationType": "full_numbers",                                 //Pagination button display options
//                "jQueryUI": true,//"bJQueryUI": true,                                                //Use markup and classes for the table to be themed by jQuery UI ThemeRoller
//                "columns": [
//            { "data": "custId" },
//            { "data": "custName" },
//            { "data": "custCity" }
//           
//            
//        ]
//            });
//        });
//        
        
        
        
        
        
        </script>
        
        <script type="text/javascript">
    $('.confirmation').on('click', function () {
        return confirm('Are you sure?');
    });
    
    
  
</script>



        <script type="text/javascript">
       $(document).ready(function () {
    
     var dataTable = $('#customers').DataTable({
          "language": {
        "processing": "Pavi kumbhar...<i class='glyphicon glyphicon-refresh glyphicon-spin'></i>" //add a loading image,simply putting <img src="loader.gif" /> tag.
    },
        "serverSide": true,
        "ajax": {
            "type": "POST",
            "url": 'data',
            "contentType": 'application/json; charset=utf-8',
            'data': function (data) { return JSON.stringify(data);  }
        },
     
        "processing": true,
        "paging": true,
        "deferRender": true,
        "columns": [
       { "data": "custId" },
       { "data": "custName" },
       { "data": "custCity" },
       { "data": null , //its null here because 
         "render" : function ( data, type, row  ) { //'<a class=" btn btn-primary btn-xs " href="operations/display/'+data.custId+'">'+data.custName+'</a>'
                     return '<a class=" btn btn-primary btn-xs " href="operations/display/'+data.custId+'"><i class="glyphicon glyphicon-eye"></i>Show</a>'
                           + '    <a  class=" btn btn-warning btn-xs" href="operations/Delete/'+data.custId +'"><i class="glyphicon glyphicon-trash"></i>Delete</a>'
                           + '    <a class=" btn btn-danger btn-xs" href="operations/Edit/'+data.custId+'">'+ '<i class="glyphicon glyphicon-pencil"></i>Edit' +'</a>';
                   }
       }
       
     
        ],
      "order": [[0, "asc"],[1, "asc"],[2, "asc"]]
        
       
       

    });
    
    
    
   //  $("#customers_filter").css("display","none");  // hiding global search box
 
    $('.search-input').on( 'keyup click change', function () {
        var i =$(this).attr('id');  // getting column index
        var v =$(this).val();  // getting search input value
        dataTable.columns(i).search(v).draw();
    } );
 
     $( ".datepicker" ).datepicker({
        dateFormat: "yy-mm-dd",
        showOn: "button",
        showAnim: 'slideDown',
        showButtonPanel: true ,
        autoSize: true,
        buttonImage: "//jqueryui.com/resources/demos/datepicker/images/calendar.gif",
        buttonImageOnly: true,
        buttonText: "Select date",
        closeText: "Clear"
    });
    $(document).on("click", ".ui-datepicker-close", function(){
      var    val=  $('.datepicker').val("");
        dataTable.columns(2).search(val).draw();
    });
    
       });
            
            
        </script>
    </head>
    <body id="dt_example">
        <div id="container">
            
       
            <div id="demo_jui">
          <table id="customers" class="table  table-striped table-bordered dt-responsive nowrap">
                <thead>
                    <tr >
                     
                        <th class="all"> Id</th>
                         <th class="text-center" >Name</th>
                         <th class="text-center">City</th>
                         <th class="text-center all">Action</th>
                    </tr>
                    
                     </thead>
                     <thead>
                   <tr>
                    <td><input type="text" id="0" class="form-control search-input"></td>
                    <td><input type="text" id="1" class=" form-control search-input"></td>
                    <td  valign="middle"><input  readonly="readonly" type="text" id="2" class="form-control search-input datepicker" ></td>
                    <td><input type="text" id="3" class="form-control search-input" ></td>
                   </tr>
                     </thead>     
                <tbody>
                </tbody>
          </table>
         </div>
        </div>
    </body>
</html>
