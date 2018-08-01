//结束编辑行号
let lastIndex=-1;
let grid=$("#grid");

//初始化窗口表格
grid.datagrid({
    columns:[
        [
            {field:'goodsuuid',title:'商品编号',width:100,editor:{type:"numberbox",options:{
                    disabled:true,
                    }}},
            {field:'goodsname',title:'商品名称',width:100,editor:{type:"combobox",options:{
                        url:'goods_list',
                        valueField:'name',
                        textField:'name',
                        onSelect:function (goods) {
                            $(getEditor("goodsuuid").target).val(goods.goodstype.uuid);
                            $(getEditor("price").target).val(goods.inprice);
                            money("set");
                            bindkey();
                            $(getEditor("num").target).select()
                        }
                }}},
            {field:'price',title:'价格',width:100,editor:{type:"numberbox",options:{
                    precision:2,
                    }}},
            {field:'num',title:'数量',width:100,editor:"numberbox"},
            {field:'money',title:'金额',width:100,editor:{type:"numberbox",options:{
                        precision:2,prefix:"￥",disabled:true,
                    }}},
            {field:"-",title:"操作",width:100,formatter:function (v,r,i) {
                    if (r.num==="总计:") return ;
                    return `<a href="javascript:void(0)" onclick="delRow(${i})">删除</a>`;
                }}
        ]
    ],
    singleSelect:true,
    toolbar: [{
        text:"新增",
        iconCls: 'icon-add',
        handler: function(){
            grid.datagrid("appendRow",{
                price:0,
                num:"8",
            });
            if (lastIndex>-1){
                grid.datagrid("endEdit",lastIndex)
            }
            let len=grid.datagrid("getRows").length-1;
            lastIndex=len;
            grid.datagrid("beginEdit",len);
        },

        },'-',{
        text:"提交",
        iconCls: 'icon-save',
        handler: function(){
            if (lastIndex>-1) {
                grid.datagrid("endEdit",lastIndex);
            }
            let rows=grid.datagrid("getRows");
            if (rows.length===0) return;
            let formData=$("#orderForm").serializeJSON();
            formData.json=JSON.stringify(rows);
            $.post("orders_add",formData,function (res) {
                SMAR("提交",res)
            },"json")
        }
    }],
    rownumbers:true,
    showFooter:true,
});
//获取编辑器
function getEditor(field){
    return grid.datagrid("getEditor",{index:lastIndex,field:field})
}
//重复编辑点击的表格
grid.datagrid({
    onClickRow:function (index,row) {

        grid.datagrid("endEdit",lastIndex);
        lastIndex=index;
        grid.datagrid("beginEdit",lastIndex);
        bindkey();
    }
});
//获取，设置金额
function money(m){
    let num=$(getEditor("num").target).val();
    let price=$(getEditor("price").target).val();
    if (m==="set") {
        $(getEditor("money").target).val(num*price);
    }
    if (m==="get"){
        $(getEditor("money").target).val(num*price);
        return $(getEditor("money").target).val();
    }
}
//自动计算金额
function bindkey() {
    $(getEditor("num").target).on("keyup",function () {
        money("set");
        sum();
    });
    $(getEditor("price").target).on("keyup",function () {
        money("set");
        sum();
    });
    sum();
}
grid.datagrid('reloadFooter',[
    {num: "总计:", money:0}
]);

function sum() {
    let all=grid.datagrid("getRows");
    let ge=getEditor("money");
    if (ge) {
        all[lastIndex].money=$(ge.target).val();
    }

    let sum=all.reduce(function (x,y) {
        return x+(y.money-0);
    },0);
    grid.datagrid('reloadFooter',[
        {num: "总计:", money:sum.toFixed(2)}
    ]);
}
function delRow(i) {
    grid.datagrid("endEdit",lastIndex);
    grid.datagrid("deleteRow",i);
    let data=grid.datagrid("getData");
    grid.datagrid("loadData",data);
    sum();
}
$('#supplier').combogrid({
    panelWidth:600,
    idField:'uuid',
    textField:'name',
    url:'supplier_list?t1.type=1',
    columns:[[
        {field:'uuid',title:'编号',width:60},
        {field:'name',title:'名称',width:100},
        {field:'address',title:'地址',width:120},
        {field:'tele',title:'电话',width:100},
        {field:'email',title:'邮件',width:100}
    ]]
});
// ajax提交回调处理
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
    $("#supplier").combogrid("clear");
    grid.datagrid("loadData",{total:0,rows:[],footer:[{num:"总计",money:0}]});
}