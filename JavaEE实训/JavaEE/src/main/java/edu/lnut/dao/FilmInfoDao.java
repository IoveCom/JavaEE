package edu.lnut.dao;
import java.util.List;
import edu.lnut.po.FilmInfo;
/*
 * 电影信息表Dao接口
 * */
public interface FilmInfoDao
{
    public List < FilmInfo > selectFilmInfoList(String film_id);
}