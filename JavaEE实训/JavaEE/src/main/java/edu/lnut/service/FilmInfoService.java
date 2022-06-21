package edu.lnut.service;

import java.util.List;

import edu.lnut.po.FilmInfo;
/*
 * 查询电影信息表和电影类型表,用于展示,此处有AOP
 * */
public interface FilmInfoService {
	public List<FilmInfo> selectFilmInfoList(String film_id);
}
