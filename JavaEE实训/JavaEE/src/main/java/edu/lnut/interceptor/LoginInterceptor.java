package edu.lnut.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import edu.lnut.po.User;
/*
 * 登录拦截器类
 * */
public class LoginInterceptor implements HandlerInterceptor
{
	@Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
    throws Exception
    {
        // TODO Auto-generated method stub
    }
	@Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
    throws Exception
    {
        // TODO Auto-generated method stub
    }
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        // TODO Auto-generated method stub
        // 获取Session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        // 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
        if(user != null)
        {
            return true;
        }
        // 不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg", "  <div class=\"col-md-6 col-lg-offset-1 alert alert-danger alert-dismissable\" style=\"text-align: center;\">\r\n" + "              <button type=\"button\" class=\"close\" data-dismiss=\"alert\"\r\n" + "                      aria-hidden=\"true\">\r\n" + "                &times;\r\n" + "              </button>\r\n" + "             您还没有登录,请登录！！\r\n" + "            </div>");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}