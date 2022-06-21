package edu.lnut.service;
/*主题表的Service层接口
 * */

import java.util.List;

import edu.lnut.po.Theme;

public interface ThemeService {
public List<Theme> findThemeList();//查找所有的Theme
public List<Theme> findFilmThemeList(String type);//查找所有的Theme
}
