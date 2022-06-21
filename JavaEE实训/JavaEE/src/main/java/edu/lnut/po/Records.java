package edu.lnut.po;
/*
 * 查找用户浏览记录的POJO
 * */
import java.util.Date;
import java.util.List;
public class Records
{
    private Integer userid;
    private String username;
    private String email;
    private List < FilmInfo > filmInfos;
    private Date recordDate;
    public Date getRecordDate()
    {
        return recordDate;
    }
    public void setRecordDate(Date recordDate)
    {
        this.recordDate = recordDate;
    }
    public Integer getUserid()
    {
        return userid;
    }
    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public List < FilmInfo > getFilmInfos()
    {
        return filmInfos;
    }
    public void setFilmInfos(List < FilmInfo > filmInfos)
    {
        this.filmInfos = filmInfos;
    }@
    Override
    public String toString()
    {
        return "Records [userid=" + userid + ", username=" + username + ", email=" + email + ", filmInfos=" + filmInfos + ", recordDate=" + recordDate + "]";
    }
}