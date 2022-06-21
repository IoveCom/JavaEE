package edu.lnut.annotation;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import edu.lnut.po.User;
import edu.lnut.service.impl.UserServiceImpl;
@Aspect@Component
public class InsertAspect
{	@Autowired
    UserServiceImpl userServiceImpl;
	@Pointcut("execution(* edu.lnut.service.impl.InsertUserServiceImpl.insertUser(..))") // 所有返回值类型，edu.lnut.service.impl.InsertUserServiceImpl下的insertUser方法
    private void InsertPointCut(){}
	@Around("InsertPointCut()&&args(user)")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint, User user) throws Throwable
    {
        // 开始
        Object obj = null;
        User user2 = userServiceImpl.findUserInfo(user.getUsername());
        if(user2 != null)
        {
            if(user.getUsername().equals(user2.getUsername()))
            {
                RequestAttributes ra = RequestContextHolder.getRequestAttributes();
                ServletRequestAttributes sra = (ServletRequestAttributes) ra; // 获取ServletRequestAttributes对象
                HttpServletRequest request = sra.getRequest(); // 获取request对象
                request.setAttribute("msg", "  <div class=\"col-md-6 col-lg-offset-1 alert alert-danger alert-dismissable\" style=\"text-align: center;\"> <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\"> &times; </button> 用户名已经存在,请勿重复注册!!  </div>");
                request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, sra.getResponse());
            }
            else
            {
                obj = proceedingJoinPoint.proceed();
                return obj;
            }
        }
        return obj;
    }
}