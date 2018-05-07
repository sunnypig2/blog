<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>博客管理</title>
    <%@include file="./common/head.jspf" %>

    <script>
        function formatBlogType(val,row){
            return val.typeName;
        }

        function searchBlog(){
            $("#dg").datagrid("load", {
                "title":$("#s_title").val()
            });
        }

        /**
         * 删除博客信息
         * 可以多选
         */
        function deleteBlog() {
            var selectedRows = $("#dg").datagrid("getSelections");
            if(selectedRows.length == 0){
                $.messager.alert("系统提示","请选择要删除的数据");
                return;
            }
            var idsStr = [];
            for(var i = 0;i<selectedRows.length;i++){
                idsStr.push(selectedRows[i].id);
            }
            //将数组安装。链接成字符串
            var ids = idsStr.join(",");
            $.messager.confirm("系统提示", "<font color=red>您确定要删除选中的"+selectedRows.length+"条数据么？</font>", function(r) {
                if(r){
                    console.log("1")
                    $.post("${blog}/admin/blog/delete",
                        {ids:ids},function(result){
                        if(result.success){
                            $.messager.alert("系统提示","数据删除成功！");
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert("系统提示","数据删除失败！");
                        }
                        },"json");
                }
            });
        }

        /**
         *打开修改博客界面
         */
        function openBlogModifyTab() {
            var selectedRows =  $("#dg").datagrid("getSelections");
            if(selectedRows.length != 1){
                $.messager.alert("系统提示","请选择一个要修改的博客");
                return;
            }
            var row = selectedRows[0];
            window.parent.openTab("修改博客","modifyBlog.jsp?id=" + row.id ,"icon-writeblog")
        }
        /**
         * 重新载入数据
         */
        function reload() {
            $("#dg").datagrid("reload");
        }
    </script>
</head>
<body>
    <table id="dg" title="博客管理" class="easyui-datagrid"
           url="${blog}/admin/blog/listBlog"
           toolbar="#toolbar"
           rownumbers="true" fitColumns="true" pagination="true">
        <thead>
        <tr>
            <th field="cb" checkbox="true" align="center"></th>
            <th field="id" width="20" align="center">编号</th>
            <th field="title" width="200">标题</th>
            <th field="releaseDate" width="100" align="center">发布日期</th>
            <th field="blogType" width="100" align="center" formatter="formatBlogType">博客类型</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        标题 <input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()">
        <a href="javascript:searchBlog()" class="easyui-linkbutton" iconCls="icon-search" plain="true" >搜索</a>
        <a href="javascript:deleteBlog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除</a>
        <a href="javascript:openBlogModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true" >修改</a>
        <a href="javascript:reload()" class="easyui-linkbutton" iconCls="icon-reload" plain="true" >刷新</a>

    </div>
</body>