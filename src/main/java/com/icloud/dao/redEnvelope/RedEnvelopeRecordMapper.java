package com.icloud.dao.redEnvelope;

import com.icloud.dao.DAO;
import com.icloud.model.redEnvelope.RedEnvelopeRecord;

public interface RedEnvelopeRecordMapper extends DAO<RedEnvelopeRecord> {
	RedEnvelopeRecord findByObject(RedEnvelopeRecord record);
}
