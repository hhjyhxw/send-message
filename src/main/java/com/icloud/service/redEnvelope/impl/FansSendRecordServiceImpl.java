package com.icloud.service.redEnvelope.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.icloud.dao.redEnvelope.FansSendRecordMapper;
import com.icloud.model.redEnvelope.FansSendRecord;
import com.icloud.service.redEnvelope.FansSendRecordService;

@Service
@Transactional
public class FansSendRecordServiceImpl implements FansSendRecordService{

	@Autowired
	private FansSendRecordMapper fansSendRecordMapper;

	@Override
	public PageInfo<FansSendRecord> fingPage(int pageNum, int pageSize, FansSendRecord record) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(FansSendRecord t){
		return fansSendRecordMapper.insert(t);
	}

	@Override
	public int update(FansSendRecord t) {
		return fansSendRecordMapper.updateByPrimaryKey(t);
	}

	

}
