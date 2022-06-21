package edu.lnut.po;
/*
 * 浏览历史表的持久化对象
 * */
import java.util.Date;
public class HistoryRecords
{
    private String filmid;
    private Integer userid;
    private Date date;
    public String getFilmid()
    {
        return filmid;
    }
    public void setFilmid(String filmid)
    {
        this.filmid = filmid;
    }
    public Integer getUserid()
    {
        return userid;
    }
    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }
    public Date getDate()
    {
        return date;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
}