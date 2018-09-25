<html>  
  <head>  
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">  
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>  
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>  
  </head>  
    
  <body>  
      
	<table id="dg" title="Tickets" style="width:700px;height:390px"  toolbar="#toolbar" pagination="false" idField="id" fitColumns="true" singleSelect="true">

		<thead>
			<tr>
				<th field="ticketId" width="100">Ticket Id</th>
				<th field="teamName" width="100">Team Name</th>
				<th field="amount"  width="50" editor="text">Amount</th>
				<th field="applyDate" formatter="formatDatebox" width="50" >Apply Date</th>
			</tr>

		</thead>

	</table>

	<div id="toolbar">
		<#if allowsEdit>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:alert('Work in progress')">New</a>
			<#if beforeDeadLine>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:edit()">Edit</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:save()">Save</a>
			</#if>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:alert('Work in progress')">Delete</a>
		</#if>
	</div>
	
	 <a href="/logout">logout</a>
  </body>  
  
<script type="text/javascript">

		$(function(){

			$('#dg').datagrid({

				url:'list',

				saveUrl:'save',

				updateUrl:'update',

				destroyUrl:'delete',
				
				

			});
			function updateActions(index){
					$('#dg').datagrid('updateRow',{
						index: index,
						row:{}
					});
				}

		});
		
		function edit(){
			var row = $('#dg').datagrid('getSelected');
    		if (row){
    			var index = $("#dg").datagrid('getRowIndex', row);
        		$('#dg').datagrid('beginEdit', index);
    		}
		}
		
		function save(){
			var row = $('#dg').datagrid('getSelected');
    		if (row){
    			var index = $("#dg").datagrid('getRowIndex', row);
        		$('#dg').datagrid('endEdit', index);
        		var json = "{\"ticketId\":\" " + row.ticketId + "\""+ ","  +  "\"amount\":\" " + row.amount + "\""+     "}"

        		$.messager.confirm('Confirm', 'Are you sure you want to update the amount?', function(r){ 
        			if (r){
        				$.ajax({
        					type: "post", 
        					url: "/update", 
        					data: json,
        					contentType: 'application/json',
        					dataType: 'json',
        					success: function (data, textStatus) { 
        						if(data) {
        							showRightBottomMsg("","Amount Updated",'slide',5000);
        							clearDatagridAndTree();  
        						} 
        					}, 
        						                
        				});  		            
        			}  		        
        		}); 
    		}
		}
		
		function formatDatebox(value) {    
			if (value == null || value == '') {
				return '';    
			}    
			var date;
			if (value instanceof Date) { 
				date = value;
				
			} else {        
				date = new Date(value);
			}     
			var year = date.getFullYear().toString();
            var month = (date.getMonth() + 1);
            var day = date.getDate().toString();
			return year+"-"+month+"-"+day;
		}
</script>

</html> 