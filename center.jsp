<%@page import="cn.itcast.pojo.Cust"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="${pageContext.request.contextPath}/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="${pageContext.request.contextPath}/css/Common.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/Index2.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
</head>
<script type="text/javascript">
/* '<option  value="' + data[i].uid + '">' + data[i].nickname + '</option>' */
	$(function(){
		$.post("${pageContext.request.contextPath}/getUserNickname",function(data){
			for(var i = 0 ;i<data.length ;i++){
				if (data != null) {
					$("#custLinkUser").append("<option value='"+data[i].uid+"' >"+data[i].nickname+"</option>")
				}
			}
		})
	})

 	function updateCustomer(){
 		$("#add").submit();
	}
 
</script>

<body>
    <div class="container-fluid">
        <div class="row-fluid">
            <h4>数据列表</h4>
            <div>
            	<form action="${pageContext.request.contextPath}/center">
            		 <div class="uinArea" id="uinArea">
						客户名称：
                	 <input type="text" id="custName" value="${custName}" name="custName" class="inputstyle"/>
                		客户类型：
               		<!-- <input type="text" id="custType" name="custType" class="inputstyle"/> -->
               		<select class="form-control" name="custType" >
               			<option value="" >请选择:</option>
               			<c:forEach items="${types}" var="type" >
               				<option value="${type }" <c:if test="${custType == type }">selected</c:if> >
               				${type}
               				</option>
               			</c:forEach>
               		</select>
               		
               		<input type="submit" value="查询" style="width:60px;" class="button_blue"/>
                </div>
            	</form>
            </div>
            <div class="add"><a class="btn btn-success" onclick="openadd()">新增</a></div>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab">
                        <thead>
                            <tr>
                                <th>客户名称</th>
                                <th>客户类型</th>
                                <th>客户电话</th>
                                <th>客户地址</th>
                                <th>所属用户角色</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        
                        <tbody id="tbody">
                        <c:forEach items="${custList}" var="cust">
                        	<tr>
                        		<td>${cust.custName}</td>
                        		<td>${cust.custType}</td>
                        		<td>${cust.custPhone}</td>
                        		<td>${cust.custAddress}</td>
                        		<td>${cust.nickname}</td>
                        		<th><a href="#">删除</a></th>
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    
                    <div id="page" class="tr"></div>
                </div>
            </div>

            <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">添加客户</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/save" method="post" id="add" >
                        <div class="control-group">
                            <label class="control-label" for="userName">客户名称</label>
                            <div class="controls">
                                <input type="text" id="custName" name="custName" placeholder="客户名称">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">客户类型</label>
                            <div class="controls">
                                <!-- <input type="text" id="custType" name="custType" placeholder="客户类型"> -->
                             	<select class="form-control" name="custType" id="custType">
                             		<option value="" >请选择:</option>
                             		<c:forEach items="${types}" var="type" >
               							<option value="${type }" <c:if test="${custType == type }">selected</c:if> >
               								${type}
               							</option>
               						</c:forEach>
                             	</select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Math">客户电话</label>
                            <div class="controls">
                                <input type="text" id="custPhone" name="custPhone" placeholder="客户电话">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="English">客户地址</label>
                            <div class="controls">
                                <input type="text" id="custAddress" name="custAddress" placeholder="客户地址">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">所属用户角色</label>
                            <div class="controls">
                               <!--  <input type="text" id="custLinkUser" name="custLinkUser" placeholder="所属用户角色"> -->
                            	<select id="custLinkUser" name="custLinkUser" >
                            		<option value="" >请选择:</option>
                             		<%-- <c:forEach items="${nicknames}" var="nick" >
               							<option value="${nick }" <c:if test="${nick.nickname == nick }">selected</c:if> >
               								${nick.nickname }
               							</option> 
               						</c:forEach> --%>
                            	</select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                    <button class="btn btn-primary" id="add" onclick="updateCustomer()">保存</button>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/Index2.js"></script>
</body>
</html>