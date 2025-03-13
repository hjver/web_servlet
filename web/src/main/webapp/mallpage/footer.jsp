<%@page import="mallpage.corpinfo_dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	corpinfo_dto cpdata = (corpinfo_dto)request.getAttribute("cpdata");
%>
    <div class="footer">
      <a href="http://facebook.com">
        <img src="images/facebook.png"height="20">
      </a>
      <a href="http://instagram.com">
        <img src="images/instagram.png"height="20">
      </a>
      <a href="http://twitter.com">
        <img src="images/twitter.png"height="20">
      </a>
    </div>
    <section class="foot_section"></section>
    <aside class="aside_footer">
        <div class="div_footer">
        <ul>
        <li><img src="./images/foot_logo.png"></li>
        <li>
회사명 : <%=cpdata.getCorp_nm()%>
대표자 : <%=cpdata.getCeo_nm()%>
주소 : <%=cpdata.getCorp_addr()%>  <br>
고객센터 : <%=cpdata.getCorp_tel()%>
상담시간 : <%=cpdata.getCorp_time()%>
E-Mail : <%=cpdata.getCeo_email()%>
사업자등록번호 : <%=cpdata.getCorp_no()%> <br>
통신판매업신고번호 : <%=cpdata.getCorp_no2()%>
개인정보보호책임자 : <%=cpdata.getCorp_master()%>   <br>
Copyright © <%=cpdata.getCorp_domain()%> All Rights Reserved.
        </li>
        </ul>    
        </div>
    </aside>