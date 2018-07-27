
// 加载列表
$('#modList').datagrid({    
    url:`${mod.url}getList.action`,    
    columns:mod.columns,
    pagination:true,    
    toolbar: [{
        text:"新增",
		iconCls: 'icon-add',
		handler: function(){
            $("#addDiv").dialog('open');
        }
	}],
});  

// 条件查询
$("#btnsearch").click(function(e){
    e.preventDefault();
    let formdata=$("#searchForm").serializeJSON();
    $("#modList").datagrid("load",formdata);
});

// 新增
$('#addDiv').dialog({    
    title: `新增${mod.name}`,    
    width: 300,    
    height: 200,    
    closed: true,    
    cache: false,       
    modal: true,
    fit:false,   
}); 
$('#editDiv').dialog({    
    title: `编辑${mod.name}`,    
    width: 300,    
    height: 200,    
    closed: true,    
    cache: false,       
    modal: true,
    fit:false,   
}); 

//添加
$("#btnadd").on("click",function(e){
    e.preventDefault();
    let data=$("#addform").serializeJSON();
    $.ajax({
        url:`${mod.url}save`,
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
            $("#addDiv").dialog("close");
            $("#modList").datagrid("reload");
            /*
            $.messager.alert("提示",res.message,"info",function(){
                $("#addDiv").dialog("close");
                $("#modList").datagrid("reload");
            })
            */
        },
    });
});

//编辑操作
$("#btnedit").on("click",function(e){
    e.preventDefault();
    let data=$("#editform").serializeJSON();
    $.post(`${mod.url}edit`,data,function(res){call3(res)},"json");
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
        $("#editDiv").dialog("close");
        $("#modList").datagrid("reload");
    }
});
//编辑界面
function edit(id){
    $("#editDiv").dialog("open");
    $("#editform").form("clear");
    $("#editform").form("load",`${mod.url}get?${mod.id}=${id}`);


}
//删除
function del(id){
    $.messager.confirm('确认', '您想删除此部门吗？', function(yes){
        if (yes){
            $.post(`${mod.url}delete`,{[mod.id]:id},function(res){call2(res)},"json");
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
                $("#modList").datagrid("reload");
            }
        }
    });
    
    
}

