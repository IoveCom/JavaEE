package edu.lnut.service;

import java.util.List;


import edu.lnut.po.HistoryRecords;
import edu.lnut.po.Records;

public interface UserRecordService {

public List<Records> findUserRecord(Integer integer);//查询用户历史记录
public void insertUserRecord(HistoryRecords historyRecords);//添加用户历史记录
}
