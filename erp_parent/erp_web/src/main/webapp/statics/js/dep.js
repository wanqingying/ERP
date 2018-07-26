// 加载部门列表
$('#depList').datagrid({    
    url:'dep_getList.action',    
    columns:[[    
        {field:'uuid',title:'部门编号',width:100},    
        {field:'name',title:'部门名称',width:100},    
        {field:'tele',title:'部门电话',width:100},
        {field:'-',title:'操作',width:100,
            formatter: function(value,row,index){
                return `<a href="javascript:void(0)" onclick="edit(${row.uuid})">编辑 </a>`+
                `  <a href="javascript:void(0)" onclick="del(${row.uuid})"> 删除</a>`;
            }
        },
    ]],
    pagination:true,    
    toolbar: [{
        text:"新增",
		iconCls: 'icon-add',
		handler: function(){
            $("#addDep").dialog('open');
        }
	}],
});  

// 条件查询
$("#btnsearch").click(function(e){
    e.preventDefault();
    console.log(55)
    let formdata=$("#searchForm").serializeJSON();
    $("#depList").datagrid("load",formdata);
    /*
    $.ajax({
        url:"dep_getList",
        data:formdata,
        dataType:"JSON",
        type:"post",
        success:function(res){
            console.log(res);
            $("#depList").datag rid("loadData",res);
        }
    });
    */
});

// 新增部门
$('#addDep').dialog({    
    title: '新增部门',    
    width: 300,    
    height: 200,    
    closed: true,    
    cache: false,       
    modal: true,
    fit:false,   
}); 
$('#editDep').dialog({    
    title: '编辑部门',    
    width: 300,    
    height: 200,    
    closed: true,    
    cache: false,       
    modal: true,
    fit:false,   
}); 

$("#btnadd").on("click",function(e){
    e.preventDefault();
    let data=$("#addform").serializeJSON();
    $.ajax({
        url:"dep_save",
        data:data,
        type:"post",
        dataType:"json",
        success:function(res){
            $.messager.show({
                title:'添加结果',
                msg:res.message+'   消息将在1.5秒后关闭。',
                timeout:1500,
                showType:'fade',
                style:{
                    right:'',
                    top:document.body.scrollTop+document.documentElement.scrollTop,
                    bottom:''
                }
            });
            $("#addDep").dialog("close");
            $("#depList").datagrid("reload");
            /*
            $.messager.alert("提示",res.message,"info",function(){
                $("#addDep").dialog("close");
                $("#depList").datagrid("reload");
            })
            */
        },
    });
});

$("#btnedit").on("click",function(e){
    e.preventDefault();
    let data=$("#editform").serializeJSON();
    $.post("dep_edit",data,function(res){call3(res)},"json");
    function call3(res){
        $.messager.show({
            title:'更新结果',
            msg:res.message+'   消息将在1.5秒后关闭。',
            timeout:1500,
            showType:'fade',
            style:{
                right:'',
                top:document.body.scrollTop+document.documentElement.scrollTop,
                bottom:''
            }
        });
        $("#editDep").dialog("close");
        $("#depList").datagrid("reload");
    }
});
//编辑/删除部门
function edit(uuid){
    $("#editDep").dialog("open");
    $("#editform").form("clear");
    $("#editform").form("load","dep_get?dep.uuid="+uuid);


}
function del(uuid){
    $.messager.confirm('确认', '您想删除此部门吗？', function(yes){
        if (yes){
            $.post("dep_delete",{"dep.uuid":uuid},function(res){call2(res)},"json");
            function call2(res){
                $.messager.show({
                    title:'删除结果',
                    msg:res.message+'   消息将在1.5秒后关闭。',
                    timeout:1500,
                    showType:'fade',
                    style:{
                        right:'',
                        top:document.body.scrollTop+document.documentElement.scrollTop,
                        bottom:''
                    }
                });
                $("#depList").datagrid("reload");
            }
        }
    });
    
    
}

