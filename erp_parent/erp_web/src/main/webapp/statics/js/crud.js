// 初始化模型参数
if (!mod.hasOwnProperty("id")) {
    mod.id="id";
}
if (!mod.hasOwnProperty("height")) {
    mod.height=300;
}
if (!mod.hasOwnProperty("width")){
    mod.width=200;
}
if (!mod.hasOwnProperty("listParam")){
    mod.listParam='';
}
if (!mod.hasOwnProperty("saveParam")){
    mod.saveParam='';
}
// Show MessageAnd Reload
function SMAR(title,res) {
    $.messager.show({
        title:`${title}结果`,
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

//保存和编辑面板
let sa={};
function openEdit(method,pName,id) {
    sa.method=method;sa.pName=pName;
    let Form=$("#editForm").form("clear").removeAttr("hidden");
    if (!mod.hasOwnProperty("id")){
        mod.id="id"
    }
    $('#editDiv').dialog({
    	 title: `${pName+mod.name}`,
        width: mod.width,
        height: mod.height,
        closed: true,
        onClose:function () {
            $("#editForm").attr("hidden",'true')
        },
        cache: false,
        modal: true,
        fit:false,
    }).dialog("open");
    //编辑
    if (method==="update") {
        Form.form("load",`${mod.url}get?${mod.id}=${id}`);
        $("#uuid").removeAttr("disable");
    }
    if(method==="add"){
        $("#uuid").attr("disable","true");
    }
}

$("#btnSave").on("click",function(e){
    let Form=$("#editForm");
    if (!Form.form("validate")) return;
    let data=Form.serializeJSON();
    $.post(`${mod.url+sa.method+mod.saveParam}`,data,function(res){call3(res)},"json");
    function call3(res){
        $("#editDiv").dialog("close");
        SMAR(sa.pName,res);
        Form.attr("hidden",'true');
    }
});
// 加载列表
$('#modList').datagrid({
    url:`${mod.url}listByPage.action`+mod.listParam,
    columns:mod.columns,
    pagination:true,    
    toolbar: [{
        text:"新增",
		iconCls: 'icon-add',
		handler: function(){
            openEdit("add",'新增');
        }
	}],
});  

// 条件查询
$("#btnSearch").click(function(e){
    e.preventDefault();
    let formdata=$("#searchForm").serializeJSON();
    $("#modList").datagrid("load",formdata);
});

//删除
function del(id){
    $.messager.confirm('确认', '您想删除此部门吗？', function(yes){
        if (yes){
            $.post(`${mod.url}delete`,{[mod.id]:id},function(res){call2(res)},"json");
            function call2(res){
                SMAR("删除",res);
            }
        }
    });
}

