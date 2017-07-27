package com.icloud.service.fans;

import java.util.Queue;

import com.icloud.model.redEnvelope.FansSendRecord;

/**
 * @filename      : FansService.java
 * @description   : 
 * @author        : zdh
 * @create        : 2017年7月26日 下午4:37:53   
 * @copyright     : zhumeng.com@send-msg-project
 *
 * Modification History:
 * Date             Author       Version
 * --------------------------------------
 */
public interface WxFansService{
	
	/**
	 * 获取用户队列
	 * @author   : zdh
	 * @date     :
	 * @version  : 1.0  
	 * @return   :
	 */
	public Queue<FansSendRecord> getFansQueue(String key);

	/**
	 * 保存用户队列
	 * @author   : zdh
	 * @date     :
	 * @version  : 1.0     :
	 */
	void pushFansSendRecordQueneIntoRedis(String key);
}
