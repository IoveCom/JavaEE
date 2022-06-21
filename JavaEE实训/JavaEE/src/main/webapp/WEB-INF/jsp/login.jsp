<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">
    
    <head>
      <meta charset="UTF-8">
      <script src="${pageContext.request.contextPath }/js/jquery/jquery-3.6.0.js">
      </script>
      <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap/css/bootstrap.css">
      <script src="${pageContext.request.contextPath }/css/bootstrap/js/bootstrap.js">
      </script>
      <style>input, label { font-size: 16px; } .wlecome { font-family: -apple-system, "Helvetica Neue", Arial, "PingFang SC", "Hiragino Sans GB", STHeiti, "Microsoft YaHei", "Microsoft JhengHei", "Source Han Sans SC", "Noto Sans CJK SC", "Source Han Sans CN", "Noto Sans SC", "Source Han Sans TC", "Noto Sans CJK TC", "WenQuanYi Micro Hei", SimSun, sans-serif; margin: 0; padding: 0; border: none; transition: all .2s; font-size: 44px; margin-bottom: 20px; } .header { font-family: -apple-system, "Helvetica Neue", Arial, "PingFang SC", "Hiragino Sans GB", STHeiti, "Microsoft YaHei", "Microsoft JhengHei", "Source Han Sans SC", "Noto Sans CJK SC", "Source Han Sans CN", "Noto Sans SC", "Source Han Sans TC", "Noto Sans CJK TC", "WenQuanYi Micro Hei", SimSun, sans-serif; margin: 0; padding: 0; border: none; transition: all .2s; font-size: 28px; margin-bottom: 64px; line-height: 1.2; color: #333; }</style>
      <title>在线观影平台--登录</title>
    </head>
    
    <body>
      <div class="container" style="width: 100%;">
        <div class="row">
          <div class="col-md-12 column">
            <div class="row clearfix">
              <div class="col-md-6 column">
                <div class="container col-lg-8 col-md-6 col-sm-4">
                  <div class="row clearfix">
                    <div class="col-md-12 column">
                      <div class="carousel slide" id="carousel-425961">
                        <ol class="carousel-indicators">
                          <li class="active" data-slide-to="0" data-target="#carousel-425961">
                          </li>
                          <li data-slide-to="1" data-target="#carousel-425961">
                          </li>
                          <li data-slide-to="2" data-target="#carousel-425961">
                          </li>
                        </ol>
                        <div class="carousel-inner">
                          <div class="item active">
                            <img alt="" src="${pageContext.request.contextPath }/img/01-1.jpg" />
                            <div class="carousel-caption">
                              <h4>美好生活</h4>
                              <p>从这里开始~~</p>
                            </div>
                          </div>
                          <div class="item">
                            <img alt="" src="${pageContext.request.contextPath }/img/01-4.jpg" />
                            <div class="carousel-caption">
                              <h4>享受生活</h4>
                              <p>从这里开始~~</p>
                            </div>
                          </div>
                          <div class="item">
                            <img alt="" src="${pageContext.request.contextPath }/img/01-3.jpg" />
                            <div class="carousel-caption">
                              <h4>享受快乐</h4>
                              <p>从这里开始~~</p>
                            </div>
                          </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-425961" data-slide="prev">
                          <span class="glyphicon glyphicon-chevron-left">
                          </span>
                        </a>
                        <a class="right carousel-control" href="#carousel-425961" data-slide="next">
                          <span class="glyphicon glyphicon-chevron-right">
                          </span>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 column" style="margin-top: 70px;">
                <div class="wlecome">欢迎登录</div>
                <div class="header">美好生活，从这里开始。</div>
                <form id="myForm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/userlogin" method="POST">
                  <div class="form-group">
                    <label for="name" style="font-size:18px;" class="col-lg-2 control-label">真实姓名:</label>
                    <div class="col-lg-5">
                      <input type="text" class="form-control" id="name" name="id" placeholder="请输入真实姓名">
                    </div>
                  </div>
                  <div class="form-group" style="margin-top: 30px;">
                    <label for="passwd" style="font-size:18px;" class="col-sm-2 control-label">密码：</label>
                    <div class="col-lg-5">
                      <input type="password" class="form-control " id="passwd" name="passwd" placeholder="请输入密码">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-10 col-lg-offset-2">
                      <button type="submit" class=" btn btn-default" style="width: 47%; background-color: #3588ff;color: whitesmoke;">登录</button>
                    </div>
                  </div>${msg}</form>
                <div class="col-sm-10 col-lg-offset-1 col-lg-6" style="text-align: center;">
                  <a href="${pageContext.request.contextPath }/gotoregister">→→→去注册←←←</a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <script>$("form :input.required").each(function() {
          var $required = $("<strong class='high'>*</strong>");
          $(this).parent().append($required)
        });
        $("form :input").blur(function() {
          var $parent = $(this).parent().parent();
          $parent.find(".formtips").remove();
          if ($(this).is("#name")) {
            var pattern = /[\u4E00-\u9FA5]{2,7}/;
            if (!pattern.test(this.value)) {
              var errorMsg = "输入错误，用户名由2-7个中文汉字组成";
              $parent.append('<label class="formtips onError control-label"
											   style="padding-left:0px">' + errorMsg + '</label>')
            } else {
              var okMsg = "输入正确";
              $parent.append('<label class="formtips onSuccess control-label"
											   style="padding-left:0px">' + okMsg + '</label>')
            }
          }
          if ($(this).is("#passwd")) {
            var pattern = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/;
            if (!pattern.test(this.value)) {

              var errorMsg = "输入错误，密码为6-18位且包含数字和字母";
              $parent.append('<label class="formtips onError control-label"
											   style="padding-left:0px">' + errorMsg + '</label>')
            } else {
              var okMsg = "输入正确";
              $parent.append('<label class="formtips onSuccess control-label"
											   style="padding-left:0px">' + okMsg + '</label>')
            }
          }

        });
        $("[type=checkbox]").click(function() {
          var number = 0;
          $("[type=checkbox]").each(function() {
            if ($(this).is(":checked")) {
              number = number + 1
            }
          });
          if (number != 0) {
            $("#count").hide()
          } else $("#count").show()
        });
        $(function() {
          $("#birthday").datepicker()
        });

        $(function() {
          $("#myForm").submit(function() {
            if ($(".onError").length == 0 && $(".onSuccess").length == 2) {
              return true;
            } else return false;
            return false;
          });
        })</script>
    </body>
  
  </html>