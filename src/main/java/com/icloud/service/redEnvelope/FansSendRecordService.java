package com.icloud.service.redEnvelope;

import com.github.pagehelper.PageInfo;
import com.icloud.model.redEnvelope.FansSendRecord;

public interface FansSendRecordService{
	
	PageInfo<FansSendRecord> fingPage(int pageNum,int pageSize,FansSendRecord record) throws Exception;
    
	/**
	 * 保存
	 * @param t
	 */
	public int save(FansSendRecord t);
	
	/**
	 * 更新
	 * @param t
	 * @throws Exception
	 */
	public int update(FansSendRecord t);
}
