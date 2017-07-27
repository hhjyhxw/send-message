package com.icloud.service.redEnvelope;

import com.github.pagehelper.PageInfo;
import com.icloud.model.redEnvelope.RedEnvelopeRecord;

public interface RedEnvelopeRecordService {
	
	PageInfo<RedEnvelopeRecord> fingPage(int pageNum,int pageSize,RedEnvelopeRecord record) throws Exception;
    
}
