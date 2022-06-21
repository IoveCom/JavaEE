<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">
      
      <head>
        <meta charset="UTF-8">
        <title>Title</title>
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
      </head>
      <meta charset="UTF-8">
      <title>在线观影平台--播放电影</title>
      <style>p a span { font-size: 21px !important; } p a:hover { text-decoration: none; ! important; } .navbar-nav li a:hover { color: #FF5C38 !important; } .navbar-mystyle { background-image: -webkit-linear-gradient(top, #ffffff 0%, #fff 100%) !important; background-image: -o-linear-gradient(top, #ffffff 0%, #fff 0%) !important; background-image: -webkit-gradient(linear, left top, left bottom, from(#ffffff), to(#fff)) !important; background-image: linear-gradient(to bottom, #ffffff 0%, #fff 0%) !important; filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#fff', GradientType=0); background-repeat: repeat-x; filter: progid:DXImageTransform.Microsoft.gradient(enabled=false); border-radius: 0px !important; -webkit-box-shadow: inset 0 0px 0 rgba(255, 255, 255, 0), 0 0px 0px rgba(255, 255, 255, 0.0) !important; box-shadow: inset 0 0px 0 rgba(255, 255, 255, 0), 0 0px 0px rgba(0, 0, 0, 0) !important; } a { color: #111 !important; }</style>
      </head>
      
      <body>
        <div class="container" style="width: 100%">
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
                    <a class="navbar-brand" href="#">在线电影</a>
                  </div>
                  <div class="collapse navbar-collapse" id="example-navbar-collapse">
                    <ul class="nav navbar-nav">
                      <li>
                        <a href="${pageContext.request.contextPath }/index">电影片库</a>
                      </li>
                      <li>
                        <a href="${pageContext.request.contextPath }/exit">退出登录</a>
                      </li>
                    </ul>
                    <a href="#">
                      <p type="button" class="navbar-text navbar-right btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-user" style="color: rgb(0, 0, 0); font-size: 12px;">${contextUsername}</span>
                      </p>
                    </a>
                    <a href="#">
                      <p type="button" id="historyBut" class="navbar-text navbar-right  navbar-text navbar-right btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-time" style="color: rgb(0, 0, 0); font-size: 12px;">历史</span>
                      </p>
                       <script type="text/javascript">$(function() {
                    $("#historyBut").click(function() {
                      window.location.href = "${pageContext.request.contextPath }/history"
                    })
                  })</script>
                    </a>
                  </div>
                </div>
              </nav>
            </div>
          </div>
          <h3 style="text-align: center;">模拟播放电影</h3>
          <div class="container" style="margin-top: 30px;">
            <div class="row clearfix">
              <div class="col-md-12 column">
                <div class="row clearfix">
                  <div class="col-md-12 column">
                    <video controls style="width: 100%">
                      <source src="vedio/vedio.mp4">
                    </video>
                  </div>
                </div>
                <div class="row clearfix">
                  <div class="col-md-12 column">
                    <c:forEach items="${filmInfos}" var="filmInfos">
                      <h2>${filmInfos.film_name} &nbsp;&nbsp;&nbsp;&nbsp;
                        <small>上映日期：${filmInfos.release_date}</small>
                      </h2>
                      <p>类型:
                        <c:forEach items="${filmthemes}" var="thisthemes">
                          <span>${thisthemes.theme_name} &nbsp;</span>
                        </c:forEach>
                      </p>
                      <p>
                        <span>
                          <em>简介:
                            <em>
                              <br />${filmInfos.film_intro}</span>
                      </p>
                    </c:forEach>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </body>
    
    </html>