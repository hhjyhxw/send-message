package com.icloud.dao.redEnvelope;

import com.icloud.model.redEnvelope.FansSendRecord;
import com.icloud.model.redEnvelope.FansSendRecordKey;

public interface FansSendRecordMapper {
    int deleteByPrimaryKey(FansSendRecordKey key);

    int insert(FansSendRecord record);

    int insertSelective(FansSendRecord record);

    FansSendRecord selectByPrimaryKey(FansSendRecordKey key);

    int updateByPrimaryKeySelective(FansSendRecord record);

    int updateByPrimaryKey(FansSendRecord record);
}