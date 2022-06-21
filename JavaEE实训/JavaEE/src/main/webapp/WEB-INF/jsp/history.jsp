<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <!DOCTYPE html>
      <html lang="en">
        
        <head>
          <meta charset="UTF-8">
          <title>在线观影平台--历史记录</title>
          <script src="${pageContext.request.contextPath }/js/jquery/jquery-3.6.0.js">
          </script>
          <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap/css/bootstrap.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap/css/bootstrap-theme.css">
          <script src="${pageContext.request.contextPath }/css/bootstrap/js/bootstrap.js">
          </script>
          <script src="${pageContext.request.contextPath }/css/font_evdl71ma25j/iconfont.js">
          </script>
          <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font_evdl71ma25j/iconfont.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
          <style>p a span { font-size: 21px !important; } p a:hover { text-decoration: none; ! important; } .navbar-nav li a:hover { color: #FF5C38 !important; } .navbar-mystyle { background-image: -webkit-linear-gradient(top, #ffffff 0%, #fff 100%) !important; background-image: -o-linear-gradient(top, #ffffff 0%, #fff 0%) !important; background-image: -webkit-gradient(linear, left top, left bottom, from(#ffffff), to(#fff)) !important; background-image: linear-gradient(to bottom, #ffffff 0%, #fff 0%) !important; filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#fff', GradientType=0); background-repeat: repeat-x; filter: progid:DXImageTransform.Microsoft.gradient(enabled=false); border-radius: 0px !important; -webkit-box-shadow: inset 0 0px 0 rgba(255, 255, 255, 0), 0 0px 0px rgba(255, 255, 255, 0.0) !important; box-shadow: inset 0 0px 0 rgba(255, 255, 255, 0), 0 0px 0px rgba(0, 0, 0, 0) !important; } a { color: #111 !important; }</style>
        </head>
        
        <body>
          <div class="container" style="width: 100%;">
            <div class="row clearfix">
              <div class="col-md-12 column">
                <div class="row clearfix">
                  <div class="col-md-12 column">
                    <nav class="navbar navbar-default navbar-mystyle " role="navigation">
                      <div class="container-fluid col-lg-offset-2 col-lg-8">
                        <div class="navbar-header">
                          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                            <span class="icon-bar">
                            </span>
                            <span class="icon-bar">
                            </span>
                            <span class="icon-bar">
                            </span>
                          </button>
                          <a class="navbar-brand" href="#">在线观影</a>
                        </div>
                        <div class="collapse navbar-collapse" id="example-navbar-collapse">
                          <ul class="nav navbar-nav">
                            <li>
                              <a href="${pageContext.request.contextPath }/index">电影片库</a>
                            </li>${state }</ul>
                          <a href="#">
                            <p type="button" class="navbar-text navbar-right btn btn-default btn-sm">
                              <span class="glyphicon glyphicon-user" style="color: rgb(0, 0, 0); font-size: 12px;">${username}</span>
                            </p>
                          </a>
                          <a href="#">
                            <p type="button" class="navbar-text navbar-right  navbar-text navbar-right btn btn-default btn-sm">
                              <span class="glyphicon glyphicon-time" style="color: rgb(0, 0, 0); font-size: 12px;">历史</span>
                            </p>
                          </a>
                        </div>
                      </div>
                    </nav>
                  </div>
                </div>
              </div>
            </div>
            <div class="container col-lg-offset-1 row clearfix">
              <div class="col-md-12  column">
                <h3 class="text-warning" style="text-align: center;">最近浏览的电影历史记录</h3>
                <table class="table table-hover table-bordered">
                  <thead>
                    <tr>
                      <th>用户编号</th>
                      <th>姓名</th>
                      <th>影片名称</th> <th>上映时间</th>
                      <th>观看时间</th>
                      <th>用户邮箱</th>
                     
                    </tr>
                  </thead>
                  <tbody>
                    <% String[] arr={ "warning", "info", "success", "error", "warning", "error", "", "", "", "success"}; Random random=new Random(); %>
                  
                      <c:forEach items="${records }" var="row">
                           <tr class="<%=arr[random.nextInt(10)] %>">
                       <td>${row.userid }</td>
                          <td>${row.username }</td>
                          <td>《${row.filmInfos[0].film_name }》</td><td>${row.filmInfos[0].release_date }</td>
                          <td>
                          <fmt:formatDate value="${row.recordDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                          <td>${row.email }</td>
                          
                       </tr>
                      </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </body>
      
      </html>