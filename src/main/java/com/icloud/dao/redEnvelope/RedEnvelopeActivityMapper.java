package com.icloud.dao.redEnvelope;

import com.icloud.dao.DAO;
import com.icloud.model.redEnvelope.RedEnvelopeActivity;

public interface RedEnvelopeActivityMapper extends DAO<RedEnvelopeActivity>{
	
	RedEnvelopeActivity selectPreActivity();

}
