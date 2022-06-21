package edu.lnut.po;
/*
 * 电影主题表持久化类，与电影信息表多对多关系
 * */
import java.util.List;
public class FilmTheme
{
    private String film_id;
    private String film_theme; //电影主题
    private List < FilmInfo > filmInfos; //与电影信息表关联的属性
    public String getFilm_id()
    {
        return film_id;
    }
    public void setFilm_id(String film_id)
    {
        this.film_id = film_id;
    }
    public String getFilm_theme()
    {
        return film_theme;
    }
    public void setFilm_theme(String film_theme)
    {
        this.film_theme = film_theme;
    }
    public List < FilmInfo > getFilmInfos()
    {
        return filmInfos;
    }
    public void setFilmInfos(List < FilmInfo > filmInfos)
    {
        this.filmInfos = filmInfos;
    }
}