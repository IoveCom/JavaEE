package edu.lnut.po;
import java.util.List;
public class Theme
{
    /**
     * 主题表持久化类-->主题表和电影信息表多对多关联。
     */
    private String theme_id; //主题编号
    private String theme_name; //主题名称
    private List < FilmInfo > filmInfos; //与电影信息表关联的属性
    @Override
    public String toString()
    {
        return "Theme [theme_id=" + theme_id + ", theme_name=" + theme_name + ", filmInfos=" + filmInfos + "]";
    }
    public List < FilmInfo > getFilmInfos()
    {
        return filmInfos;
    }
    public void setFilmInfos(List < FilmInfo > filmInfos)
    {
        this.filmInfos = filmInfos;
    }
    public String getTheme_id()
    {
        return theme_id;
    }
    public void setTheme_id(String theme_id)
    {
        this.theme_id = theme_id;
    }
    public String getTheme_name()
    {
        return theme_name;
    }
    public void setTheme_name(String theme_name)
    {
        this.theme_name = theme_name;
    }
}