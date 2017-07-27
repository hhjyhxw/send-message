package com.icloud.service.send;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icloud.common.master.Master;
import com.icloud.common.master.Worker;
import com.icloud.model.redEnvelope.FansSendRecord;
import com.icloud.model.redEnvelope.RedEnvelopeActivity;
import com.icloud.service.fans.WxFansService;
import com.icloud.service.redEnvelope.FansSendRecordService;
import com.icloud.service.redEnvelope.RedEnvelopeActivityService;

/**
 * @filename      : SendMessageService.java
 * @description   : 活动模板消息业务处理类
 * @author        : zdh
 * @create        : 2017年7月25日 下午5:51:19   
 * @copyright     : zhumeng.com@send-msg-project
 *
 * Modification History:
 * Date             Author       Version
 * --------------------------------------
 */
@Service
@Transactional
public class SendMessageService {
	
	@Autowired
	private RedEnvelopeActivityService envelopeActivityService; 
	@Autowired
	private FansSendRecordService fansSendRecordService;
	@Autowired
	private SendTemplateMsgService sendTemplateMsgService;
	@Autowired
	private WxFansService wxFansService;

	/**
	 * 定时查询 红包活动 并发送模板消息
	 * @author   : zdh
	 * @date     :
	 * @version  : 1.0     :
	 * @throws Exception 
	 */
	public void sendModuleMessage(RedEnvelopeActivity t) throws Exception{
		/*1、获取红包活动列表*/
//		List<RedEnvelopeActivity> list = envelopeActivityService.findList(t);
		
		/*2、获取粉丝数*/
		Queue<FansSendRecord> queue = wxFansService.getFansQueue("fansqueue");
		/*3、启动发送模板线程*/
		Master master = new Master(new Worker(),10,queue,this);
		master.execute();
	}
	
	public boolean sendMsg(FansSendRecord vo){
		int result = inserFansSendRecord(vo);
		//保存成功
		if(result==1){
			//发送模板消息成功
			if(sendTemplateMsgService.sendHongBaoMessage(vo)){
				vo.setSendStatus("1");
				updateFansSendRecord(vo);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 保存发送记录
	 * @author   : zdh
	 * @date     :
	 * @version  : 1.0  
	 * @param entry
	 * @return   :
	 * @throws Exception 
	 */
	public int inserFansSendRecord(FansSendRecord entry){
		return fansSendRecordService.save(entry);
	}
	
	public int updateFansSendRecord(FansSendRecord entry){
		return fansSendRecordService.update(entry);
	}
}
