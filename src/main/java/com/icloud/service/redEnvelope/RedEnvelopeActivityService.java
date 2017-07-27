package com.icloud.service.redEnvelope;

import com.icloud.model.redEnvelope.RedEnvelopeActivity;
import com.icloud.service.BaseService;

public interface RedEnvelopeActivityService extends BaseService<RedEnvelopeActivity> {
	RedEnvelopeActivity selectPreActivity();
}
