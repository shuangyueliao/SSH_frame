<%@ page language="java" import="java.util.*" pageEncoding="gbk" isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <base href="<%=basePath%>">
    <title>�����б�</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="/SSH5/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="/SSH5/css/index.css" type="text/css"></link>
   <link rel="stylesheet" href="/SSH5/css/foot.css" type="text/css"></link>
     <link rel="stylesheet" href="/SSH5/css/head.css" type="text/css"></link>

  </head>
  
  <body>
<jsp:include page="head.jsp" />
<div class="main1">
  <table class="list_tab" width="80%" align="center" cellspacing="1" bordercolor="#44AEDB"  cellpadding="1" border="1">

				  <tr>
				    <td colspan="2" align="center" bgcolor="#6A82DA"><span class="span3">�����б�</span></td>
			      </tr>
			    <s:iterator value="#request.newsList" var="news" status="s">  
				  <tr>
				    <td width="21%" align="right" bgcolor="#E4EDF9">���ű��⣺</td>
				    <td width="79%" bgcolor="#E4EDF9"><s:property value="#news.title"/></td>
			      </tr>
				  <tr>
				    <td align="right" bgcolor="#F1F3F5">�������ݣ�</td>
				    <td bgcolor="#F1F3F5"><s:property value="#news.content"/></td>
			      </tr>
				  <tr>
				    <td align="right" bgcolor="#E4EDF9">����ʱ�䣺</td>
				    <td bgcolor="#E4EDF9"><s:property value="#news.time"/></td>
			      </tr>
                   <tr>
				    <td colspan="2" align="left" bgcolor="#CAD7F7">&nbsp;</td>
			      </tr>
			      </s:iterator>
    </table>
   <center> 	 
 <%
 
 int  pageCount =(Integer) request.getAttribute("pageCount");

 int pageNow=(Integer) request.getAttribute("pageNow");
  int  totalCount=(Integer) request.getAttribute("totalCount");
   System.out.println("int  pageCount =(Integer) request.getAttribute(s_pageCount);"+pageCount+pageNow+totalCount);
 %>
 

<c:if test="${pageNow == 1}">
   		  <p style="font-size:18px font-weight:bold;margin-left:240px;margin-bottom:80px;" align="left"> ��ǰҳ��:[1/${pageCount}]&nbsp; 
   		 <a href="<%=basePath%>news!showList?s_pageNow=2">��һҳ&nbsp;&nbsp;</a> 
   		 <a href="<%=basePath%>news!showList?s_pageNow=${pageCount}">ĩҳ</a> </p>
  </c:if>
      	<c:if test="${pageNow == pageCount}">
      		<p style="font-size:18px font-weight:bold;margin-left:240px; margin-bottom:80px;" align="left"> ��ǰҳ��:[${pageNow }/${pageCount }]&nbsp;
      		 <a href="<%=basePath%>news!showList?s_pageNow=1">��ҳ</a>
      			<a href="<%=basePath%>news!showList?s_pageNow=${pageNow-1}">&nbsp;&nbsp;��һҳ</a></p>
      	</c:if>
      	<c:if test="${pageNow < pageCount && pageNow > 1}">
      		<p style="font-size:18px font-weight:bold;margin-left:240px; margin-bottom:80px;" align="left"> ��ǰҳ��:[${pageNow}/${pageCount }]&nbsp;&nbsp; 
      		<a href="<%=basePath%>news!showList?s_pageNow=1">��ҳ</a>
      			<a href="<%=basePath%>news!showList?s_pageNow=${pageNow-1}">&nbsp;&nbsp;��һҳ</a>
      		<a href="<%=basePath%>news!showList?s_pageNow=${pageNow+1}">&nbsp;&nbsp;��һҳ</a> 
      		<a href="<%=basePath%>news!showList?s_pageNow=${pageCount}">&nbsp;&nbsp;ĩҳ</a></p>
      	</c:if>	

</center>
</div>

<jsp:include page="foot.jsp" />
</body>