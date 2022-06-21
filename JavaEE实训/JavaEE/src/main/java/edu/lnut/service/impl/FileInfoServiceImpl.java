package edu.lnut.service.impl;
import java.util.List;
//service层
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import edu.lnut.dao.FilmInfoDao;
import edu.lnut.po.FilmInfo;

import edu.lnut.service.FilmInfoService;@
Service("FilmInfoService")
    //@Repository("FilmInfoService")
public class FileInfoServiceImpl implements FilmInfoService
{	@Autowired
    FilmInfoDao filmInfoDao;

	@Override
    public List < FilmInfo > selectFilmInfoList(String film_id)
    {
        // TODO Auto-generated method stub
        return filmInfoDao.selectFilmInfoList(film_id);
    }
}