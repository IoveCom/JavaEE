package edu.lnut.service.impl;
/*
 * 处理用户浏览记录的服务层,包括添加用户浏览记录和查找浏览记录
 * */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.lnut.dao.RecordsDao;
import edu.lnut.po.HistoryRecords;
import edu.lnut.po.Records;
import edu.lnut.service.UserRecordService;@
Service("UserRecordService")
public class UserRecordServiceImpl implements UserRecordService
{	@Autowired
    RecordsDao recordsDao;
	@Override
    public List < Records > findUserRecord(Integer userId)
    {
        // TODO Auto-generated method stub
        return recordsDao.findRecords(userId);
    }
    @Override //添加用户记录
    public void insertUserRecord(HistoryRecords historyRecords)
    {
        // TODO Auto-generated method stub
        //将records对象和
        recordsDao.insertRecords(historyRecords);
    }
}