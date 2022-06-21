package edu.lnut.po;
/*
 * 电影信息表的持久化类
 * */
import java.sql.Date;
import java.util.List;
import java.util.Objects;
public class FilmInfo
{
    private String film_id;
    private String film_name;
    private Date release_date; //上映日期
    private String film_intro; //剧情简介
    private String img_path;
    private List < Theme > Themes; //与电影主题表关联的属性
    public String getFilm_id()
    {
        return film_id;
    }
    public List < Theme > getThemes()
    {
        return Themes;
    }
    public void setThemes(List < Theme > themes)
    {
        Themes = themes;
    }@
    Override //在List中删除重复值
    public int hashCode()
    {
        return Objects.hash(film_id, film_intro, film_name, img_path, release_date);
    }@
    Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        FilmInfo other = (FilmInfo) obj;
        return Objects.equals(film_id, other.film_id) && Objects.equals(film_intro, other.film_intro) && Objects.equals(film_name, other.film_name) && Objects.equals(img_path, other.img_path) && Objects.equals(release_date, other.release_date);
    }
    public void setFilm_id(String film_id)
    {
        this.film_id = film_id;
    }@
    Override
    public String toString()
    {
        return "FilmInfo [film_id=" + film_id + ", film_name=" + film_name + ", release_date=" + release_date + ", film_intro=" + film_intro + ", img_path=" + img_path + ", Themes=" + Themes + "]";
    }
    public String getFilm_name()
    {
        return film_name;
    }
    public void setFilm_name(String film_name)
    {
        this.film_name = film_name;
    }
    public Date getRelease_date()
    {
        return release_date;
    }
    public void setRelease_date(Date release_date)
    {
        this.release_date = release_date;
    }
    public String getFilm_intro()
    {
        return film_intro;
    }
    public void setFilm_intro(String film_intro)
    {
        this.film_intro = film_intro;
    }
    public String getImg_path()
    {
        return img_path;
    }
    public void setImg_path(String img_path)
    {
        this.img_path = img_path;
    }
}