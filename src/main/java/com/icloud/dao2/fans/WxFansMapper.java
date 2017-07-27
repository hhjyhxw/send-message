package com.icloud.dao2.fans;

import java.util.List;

import com.icloud.common.QueryBuilder;
import com.icloud.model.redEnvelope.FansSendRecord;
import com.icloud.model.redEnvelope.WxFans;

public interface WxFansMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxFans record);

    int insertSelective(WxFans record);

    WxFans selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WxFans record);

    int updateByPrimaryKey(WxFans record);
    
    long countByExample(QueryBuilder example);

    List<WxFans> selectByExample(QueryBuilder example);
    
    WxFans findWxFansByOpenid(String openid);
    
    int updateByOpenId(WxFans record);
    
    List<FansSendRecord> findAllFansVo();
    
    
}