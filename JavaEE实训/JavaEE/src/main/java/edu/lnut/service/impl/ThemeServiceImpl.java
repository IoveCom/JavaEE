package edu.lnut.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.lnut.dao.ThemeDao;
import edu.lnut.po.Theme;
import edu.lnut.service.ThemeService;
@Service("themeService")
public class ThemeServiceImpl implements ThemeService
{	@Autowired
    private ThemeDao themeDao;
	@Override
    public List < Theme > findThemeList()
    {
        // TODO Auto-generated method stub
        List < Theme > themes = themeDao.selectThemeList();
        return themes;
    }
    public List < Theme > findFilmThemeList(String type)
    {
        // TODO Auto-generated method stub
        return themeDao.selectFilmInfoList(type);
    }
}