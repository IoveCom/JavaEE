package edu.lnut.dao;
import java.util.List;
import edu.lnut.po.Theme;
public interface ThemeDao
{
    /*
     * Theme主题表Dao接口
     * */
    public List < Theme > selectThemeList();
    public List < Theme > selectFilmInfoList(String type);
}