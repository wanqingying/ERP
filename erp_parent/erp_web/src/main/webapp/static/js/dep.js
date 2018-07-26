$('#depList').datagrid({    
    url:'dep_list.action',    
    columns:[[    
        {field:'uuid',title:'ID',width:100},    
        {field:'name',title:'Name',width:100},    
        {field:'tele',title:'Tele',width:100,align:'right'}    
    ]]    
});  