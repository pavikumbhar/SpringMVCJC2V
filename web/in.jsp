
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC pagination using DataTables</title>

<link href="${pageContext.request.contextPath}/datatable/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>

 <script src=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>


<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>

<script src="https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>



<script src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.bootstrap.min.js"></script>


<script src="https://cdn.datatables.net/select/1.2.1/js/dataTables.select.min.js"></script>
<script src="resources/datatableEditor/js/dataTables.editor.min.js" type="text/javascript"></script>
<script src="https://editor.datatables.net/extensions/Editor/js/editor.bootstrap.min.js"></script>



<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<link href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>

<link href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>

<link href="https://cdn.datatables.net/select/1.2.1/css/select.bootstrap.min.css" rel="stylesheet" type="text/css"/>


<link href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap.min.css" rel="stylesheet" type="text/css"/>



<!--<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>

<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>

<link href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css" rel="stylesheet" type="text/css"/>

<link href="https://cdn.datatables.net/select/1.2.1/css/select.dataTables.min.css" rel="stylesheet" type="text/css"/>

<link href="https://cdn.datatables.net/select/1.2.1/css/select.dataTables.min.css" rel="stylesheet" type="text/css"/>

<link href="https://editor.datatables.net/extensions/Editor/css/editor.dataTables.min.css" rel="stylesheet" type="text/css"/>-->



<link href="${pageContext.request.contextPath}/datatable/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/datatable/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>

<script src="${pageContext.request.contextPath}/datatable/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/datatable/js/dataTables.responsive.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/datatable/js/responsive.bootstrap.min.js" type="text/javascript"></script>

<link href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap.min.css" rel="stylesheet" type="text/css"/>

<link href="datatable/css/xyz.css" rel="stylesheet" type="text/css"/>
 
        
        
        <script type="text/javascript">
var editor; // use a global for the submit and return data rendering in the examples
 
$(document).ready(function() {
    editor = new $.fn.dataTable.Editor( {
//       ajax: {
//            url: "datapost",
//            type: "POST",
//           "contentType": 'application/json; charset=utf-8',
//                'data': function (data) { return JSON.stringify(data);  }
//        },
//        
//          ajax: {
//            create: {
//                type: 'POST',
//                url:  '../php/rest/create.php',
//               
//            },
//            edit: {
//                type: 'PUT',
//                url:  '../php/rest/edit.php?id=_id_'
//               
//            },
//            remove: {
//                type: 'DELETE',
//                url:  '../php/rest/remove.php?id=_id_'
//            }
//        },
//        
        ajax: {
			create: {
				type: 'POST',
				url:  'api/rest/create',
                                 contentType: 'application/json; charset=utf-8',
                               
                              'data': function (data) { return JSON.stringify(data);  }
			},
			edit: {
				type: 'PUT',
				url:  'api/rest/edit',
                                 contentType: 'application/json; charset=utf-8',
                               
                              'data': function (data) { return JSON.stringify(data);  }
                                
			},
			remove: {
				type: 'DELETE',
				url:  'api/rest/remove',
                                 contentType: 'application/json; charset=utf-8',
                              'data': function (data) { return JSON.stringify(data);  }
			}
		},
        table: "#example",
        "idSrc": "id",
         template: '#customForm',
        fields: [ {
                label: "First name:",
                name: "id"
            }, {
            label: "First name:",
                name: "first_name"
            },{
                label: "Last name:",
                name: "last_name"
            }, {
                label: "Position:",
                name: "position"
            }, {
                label: "Office:",
                name: "office"
            }, {
                label: "Extension:",
                name: "extn"
            }, {
                label: "Start date:",
                name: "start_date",
                type: "datetime"
            }, {
                label: "Salary:",
                name: "salary"
            } , {
                label: "city",
                name: "city",
                type: "select",
                placeholder: "Select a location"
            }
        ]
    } );
 
 
 
 
 
 // New record
    $('a.editor_create').on('click', function (e) {
        e.preventDefault();
 
        editor.create( {
            title: 'Create new record',
            buttons: 'Add'
        } );
    } );
 
    // Edit record
    $('#example').on('click', 'a.editor_edit', function (e) {
        e.preventDefault();
 
        editor.edit( $(this).closest('tr'), {
            title: 'Edit record',
            buttons: 'Update'
        } );
    } );
 
    // Delete a record
    $('#example').on('click', 'a.editor_remove', function (e) {
        e.preventDefault();
 
        editor.remove( $(this).closest('tr'), {
            title: 'Delete record',
            message: 'Are you sure you wish to remove this record?',
            buttons: 'Delete'
        } );
    } );
 
 
 //  $("#customers_filter").css("display","none");  // hiding global search box
 
    $('.search-input').on( 'keyup click change', function () {
        var i =$(this).attr('id');  // getting column index
        var v =$(this).val();  // getting search input value
        editor.columns(i).search(v).draw();
    } );
 
 
  editor.on( 'preSubmit', function ( e, o, action ) {
        if ( action !== 'remove' ) {
            var firstName = editor.field( 'first_name' );
 
            // Only validate user input values - different values indicate that
            // the end user has not entered a value
            if ( ! firstName.isMultiValue() ) {
                if ( ! firstName.val() ) {
                    firstName.error( 'A first name must be given' );
                }
                 
                if ( firstName.val().length >= 20 ) {
                    firstName.error( 'The first name length must be less that 20 characters' );
                }
            }
 
            var lastName = editor.field( 'last_name' );
         
              if ( ! lastName.isMultiValue() ) {
                if ( ! lastName.val() ) {
                    lastName.error( 'A last Name must be given' );
                }
                 
                if ( lastName.val().length >= 20 ) {
                    lastName.error( 'The last Name length must be less that 20 characters' );
                }
            }
 
            // ... additional validation rules
 
            // If any error was reported, cancel the submission so it can be corrected
            if ( this.inError() ) {
                return false;
            }
        }
    } );
    
    $('#example').DataTable( {
       // dom: "Bfrtip",
        ajax: {
            url: "datapost",
            type: "POST",
           "contentType": 'application/json; charset=utf-8',
                'data': function (data) { return JSON.stringify(data);  }
        },
         serverSide: true,
        columns: [
             { data: "id" },
            { data: null, render: function ( data, type, row ) {
                // Combine the first and last names into a single table field
                return data.first_name+' '+data.last_name;
            } },
            { data: "position" },
            
            { data: "office" },
            { data: "extn" },
            { data: "start_date" },
            { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) },
            { data: "city" },
             
             {
                data: null,
                className: "center",
                defaultContent: '<a href="" class="editor_edit btn btn-warning btn-xs">Edit</a> / <a href="" class="editor_remove btn btn-danger btn-xs">Delete</a>'
            }
        ],
        select: true,
//        buttons: [
//            { extend: "create", editor: editor },
//            { extend: "edit",   editor: editor },
//            { extend: "remove", editor: editor }
//        ]
       buttons: [
            {
                extend: "create",
                editor: editor,
                formButtons: [
                    'Create',
                    { label: 'Cancel', fn: function () { this.close(); } }
                ]
            },
            {
                extend: "edit",
                editor: editor,
                formButtons: [
                    'Edit',
                    { label: 'Cancel', fn: function () { this.close(); } }
                ]
            },
            {
                extend: "remove",
                editor: editor,
                formButtons: [
                    'Delete',
                    { label: 'Cancel', fn: function () { this.close(); } }
                ]
            }
        ]
    } );
} );
            
        </script>
    </head>
    <body id="dt_example">
        
 
        <div id="container">
            
            
            
          
          <div id="customForm">
                        <fieldset class="name">
                            <legend>Name</legend>
                            <editor-field name="first_name"></editor-field>
                            <editor-field name="last_name"></editor-field>
                        </fieldset>
                        <fieldset class="office">
                            <legend>Office</legend>
                            <editor-field name="office"></editor-field>
                            <editor-field name="extn"></editor-field>
                        </fieldset>
                        <fieldset class="hr">
                            <legend>HR info</legend>
                            <editor-field name="position"></editor-field>
                            <editor-field name="salary"></editor-field>
                            <editor-field name="start_date"></editor-field>
                             <editor-field name="city"></editor-field>
                        </fieldset>
              
                    </div>  
            <a class="editor_create   btn btn-primary btn-xs"  ><i class="glyphicon glyphicon-eye"></i>Create new record</a>
<table id="example" class="table table-striped table-bordered" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Position</th>
                            <th>Office</th>
                            <th>Extn.</th>
                            <th>Start date</th>
                            <th>Salary</th>
                            <th>cities</th>
                            
                              <th>Edit / Delete</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                              <th>ID</th>
                            <th>Name</th>
                            <th>Position</th>
                            <th>Office</th>
                            <th>Extn.</th>
                            <th>Start date</th>
                            <th>Salary</th>
                              <th>Edit / Delete</th>
                        </tr>
                    </tfoot>
                </table> </div>
    </body>
</html>
