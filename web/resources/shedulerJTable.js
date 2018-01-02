/* 
 * Javascript to manage the JTable
 */

$(document).ready(function () {
    //setup the jtable that will display the results
    $('#jobSchedulerList').jtable({
        title: 'Job Scheduler List',
        selecting: true, //Enable selecting 
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        sorting: true, //Enable sorting
        actions: {
            listAction: 'jobSchedulerList',
            createAction: 'saveJobScheduler',
            updateAction: 'updateJobScheduler',
            deleteAction: 'deleteJobScheduler'
        },
        fields: {
            custId: {
                title: 'cust Id',
                key: true,
                list: true,
                create: false,
                edit: false,
                width: '5%'
            },
            custName: {
                title: 'cust Name ',
                width: '15%',
                input: function (data) {
                    if (data.record) {
                        return '<input type="text" name="custName" style="width:200px"  class="jtable-input-readonly" readonly value="' + data.record.custName + '" />';
                    } else {
                        return '<input type="text" name="custName" style="width:200px" value="" placeholder="custName Name" />';
                    }
                }


            },
            custContact: {
                title: 'cust Contact',
                width: '15%',
                input: function (data) {
                    if (data.record) {
                        return '<input type="text" name="custContact" style="width:200px" class="jtable-input-readonly"  readonly value="' + data.record.custContact + '" />';
                    } else {
                        return '<input type="text" name="custContact" style="width:200px" value="" placeholder="custContact" />';
                    }
                }

            },
            custCity: {
                title: 'cust City',
                width: '15%'
            }


        },
        //Register to selectionChanged event to hanlde events                                     
        recordAdded: function (event, data) {
            //after record insertion, reload the records
            $('#jobSchedulerList').jtable('load');
        },
        recordUpdated: function (event, data) {
            //after record updation, reload the records
            $('#jobSchedulerList').jtable('load');
        }
    });
    $('#jobSchedulerList').jtable('load');

});
