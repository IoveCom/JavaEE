package edu.lnut.annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import edu.lnut.po.FilmInfo;
import edu.lnut.po.HistoryRecords;

import edu.lnut.po.User;
import edu.lnut.service.UserRecordService;
/**
 * 切面类，在此类中编写通知
 */
@Aspect@ Component
public class HistoryAspect
{@Autowired
    private UserRecordService userRecordService;
    // 定义切入点表达式
    @Pointcut("execution(* edu.lnut.service.impl.FileInfoServiceImpl.selectFilmInfoList(..))") // 所有返回值类型，edu.lnut.service.impl.FileInfoServiceImpl下的所有方法
    private void myPointCut()
        {} // 使用一个返回值为void、方法体为空的方法来命名切入点
        // 后置通知
    @AfterReturning(value = "myPointCut()", returning = "rvt")
    public void AfterReturning(JoinPoint joinPoint, Object rvt)
    {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra; // 获取ServletRequestAttributes对象
        HttpServletRequest request = sra.getRequest(); // 获取request对象
        HttpSession session = request.getSession(); // 获取Session对象
        List < FilmInfo > filmInfos = objToList(rvt, FilmInfo.class);
        HistoryRecords historyRecords = new HistoryRecords(); // 浏览记录的bean
        User user = (User) session.getAttribute("USER_SESSION");
        if(filmInfos != null && user != null)
        {
            historyRecords.setFilmid(filmInfos.get(0).getFilm_id());
            historyRecords.setUserid(user.getUserid());
            try
            {
                historyRecords.setDate(getNowDate()); // 获取日期
            }
            catch(ParseException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            userRecordService.insertUserRecord(historyRecords); // 调用Service层的插入数据方法,在打开播放后进行插入数据
        }
    }
    private < T > List < T > objToList(Object obj, Class < T > cla)
    {
        List < T > list = new ArrayList < T > ();
        if(obj instanceof ArrayList <? > )
        {
            for(Object o: (List <? > ) obj)
            {
                list.add(cla.cast(o));
            }
            return list;
        }
        return null;
    }
    private Date getNowDate() throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date time = null;
        time = sdf.parse(sdf.format(new Date()));
        return time;
    }
}