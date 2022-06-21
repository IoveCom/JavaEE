package edu.lnut.dao;
import java.util.List;
import edu.lnut.po.HistoryRecords;
import edu.lnut.po.Records;
public interface RecordsDao
{
    public List < Records > findRecords(Integer userID); //查找用户历史记录
    public void insertRecords(HistoryRecords HistoryRecords); //添加用户历史记录
}