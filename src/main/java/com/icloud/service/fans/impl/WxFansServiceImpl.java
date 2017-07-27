package com.icloud.service.fans.impl;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icloud.dao2.fans.WxFansMapper;
import com.icloud.model.redEnvelope.FansSendRecord;
import com.icloud.service.fans.WxFansService;
import com.icloud.service.redis.RedisService;

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
@Service
@Transactional
public class WxFansServiceImpl implements WxFansService{
	@Autowired
	private RedisService redisService;
	@Autowired
	private  WxFansMapper wxFansMapper;
	
	/**
	 * 获取粉丝队列
	 */
	@Override
	public Queue<FansSendRecord> getFansQueue(String key) {
		return (Queue<FansSendRecord>) redisService.get(key);
	}
	
	/**
	 * 保存粉丝队列
	 */
	@Override
	public void pushFansSendRecordQueneIntoRedis(String key) {
//		List<FansSendRecord> list = wxFansMapper.findAllFansVo();
//		Queue<FansSendRecord> queue = new ConcurrentLinkedQueue<FansSendRecord>();
//		for (FansSendRecord obj:list) {
//			obj.setSendStatus("0");
//			queue.add(obj);
//		}
//		redisService.set(key,queue);
		
		
		
//		List<FansSendRecord> list = wxFansMapper.findAllFansVo();
		Queue<FansSendRecord> queue = new ConcurrentLinkedQueue<FansSendRecord>();
		FansSendRecord obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("落叶");
		obj.setOpenId("ocoMKt2a_9XrLt2NBG5CupS6THE4");
		queue.add(obj);
		
		obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("mars15");
		obj.setOpenId("ocoMKt2T0KEJoWqPhadxabb-3C9g");
		queue.add(obj);
		
		obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("林宝成");
		obj.setOpenId("ocoMKt_bOB-7uSk5NrAQkyLOQeQ0");
		queue.add(obj);
		
		obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("DLWS_NX");
		obj.setOpenId("ocoMKt0xwDVzp9dVFCd-L8_6u7go");
		queue.add(obj);
	
		obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("竹录钟源");
		obj.setOpenId("ooku7jp9q8QighZTRnqYNRxN9zFU");
		queue.add(obj);
		
		obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("陈春林");
		obj.setOpenId("ocoMKtymCobQSg_Jb3mlAseRL018");
		queue.add(obj);
		
		obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("小黑");
		obj.setOpenId("ocoMKt2qlIkxyFj9ZzXZYjfASZgA");
		queue.add(obj);
		
		obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("蜈蚣");
		obj.setOpenId("ocoMKt5DtWF6rLc7tMO0O4KV6Dsk");
		queue.add(obj);
		
		obj =  new FansSendRecord();
		obj.setActivityId(1L);
		obj.setNickName("蛋蛋一笑");
		obj.setOpenId("ocoMKtyDRw0AIhznkl9LlK-P_MDA");
		queue.add(obj);
//		for (FansSendRecord obj:list) {
//			obj.setSendStatus("0");
//			queue.add(obj);
//		}
		redisService.set(key,queue);
	}

	


}
