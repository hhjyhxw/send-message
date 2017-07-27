package com.icloud.service.redEnvelope.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.dao.redEnvelope.RedEnvelopeRecordMapper;
import com.icloud.model.redEnvelope.RedEnvelopeRecord;
import com.icloud.service.redEnvelope.RedEnvelopeRecordService;

@Service
@Transactional
public class RedEnvelopeRecordServiceImpl implements RedEnvelopeRecordService{

	@Autowired
	private RedEnvelopeRecordMapper mapper;
	@Override
	public PageInfo<RedEnvelopeRecord> fingPage(int pageNum, int pageSize, RedEnvelopeRecord record) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<RedEnvelopeRecord>(mapper.findForList(record));
	}
	
	

}
