$(document).ready(function(){
	
	$('#accountTable').datagrid({
			url:'../account/selectAll',
	    	columns:[[
	    		{field:'id',title:'ID',width:200},
	    		{field:'accountNumber',title:'账号',width:250},
	    		{field:'name',title:'姓名',width:250},
	    		{field:'password',title:'密码',width:250},
	    		{field:'position',title:'职位',width:250}
	    	]]
	    });
	
		$('#searchButton').linkbutton({
		    iconCls: 'icon-search'
		});
		$('#add2Button').linkbutton({
		    iconCls: 'icon-add'
		});
		$('#editButton').linkbutton({
		    iconCls: 'icon-edit'
		});
		$('#removeButton').linkbutton({
		    iconCls: 'icon-remove'
		});
		
		 var url;
		$('#add2Button').on('click',function(){
			$('#dlg2').dialog('open').dialog('center').dialog('setTitle','提示');
		    $('#fm2').form('clear');
		    url="../account/insert";
		})
		
		$('#editButton').on('click',
        function (){  
            var row=$('#accountTable').datagrid('getSelected');  
            if(row){  
                $("#dlg2").dialog('open').dialog('setTitle','编辑用户');  
                $('#fm2').form('load',row);  
                url='../account/update?id='+row.id;  
            }else{
            	alert("请选中信息再修改!")
            }  
        } )
		
		$('#removeButton').on('click',function(){
            var row = $('#accountTable').datagrid('getSelected');
            if (row){
                $.messager.confirm('删除','确定要删除吗?',function(r){
                    if (r){
                        $.post('../account/delete',{id:row.id},function(result){
                            if (result.success){
                            	alert("删除成功");
                                $('#accountTable').datagrid('reload');    
                            } else {
                                $.messager.show({    
                                    title: '提示',
                                    msg: result.errorMsg
                                });
                            }
                        },'json');
                    }
                });
            }else{
            	alert("请选中信息再删除!")
            }
		})
        
		$('#toSubmit').on('click',function(){
	        $('#fm2').form('submit',{
	          url: url,
	            onSubmit: function(){
	             return $(this).form('validate');
	                },
	                success: function(result){
	                    var result = eval('('+result+')');
	                    if (result.errorMsg){
	                        $.messager.show({
	                            title: '提示',
	                            msg: result.errorMsg
	                        });
	                    } else {
	                        $('#dlg2').dialog('close');      
	                        $('#accountTable').datagrid('reload');   
	                    }
	                }
	        });
		})
});

