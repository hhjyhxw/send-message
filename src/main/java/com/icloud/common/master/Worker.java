package com.icloud.common.master;
import java.util.Map;
import java.util.Queue;

import com.icloud.model.redEnvelope.FansSendRecord;
import com.icloud.service.send.SendMessageService;
import com.icloud.service.send.SendTemplateMsgService;
/**
 * @filename      : Worker.java
 * @description   : Worker进程实现
 * @author        : zdh
 * @create        : 2017年7月25日 下午4:52:32   
 * @copyright     : zhumeng.com@multitask
 *
 * Modification History:
 * Date             Author       Version
 * --------------------------------------
 */
public class Worker  implements Runnable{

	//任务队列，用于取得子任务
	protected Queue<FansSendRecord> workQueue;
	//子任务处理结果集
	protected Map<String ,Object> resultMap;
	//发送模板消息类
	protected SendTemplateMsgService sendTemplateMsgService;
	//保存发送记录类
	protected SendMessageService sendMessageService;
	
	public void setWorkQueue(Queue<FansSendRecord> workQueue){
		this.workQueue= workQueue;
	}
	
	public void setResultMap(Map<String ,Object> resultMap){
		this.resultMap=resultMap;
	}

	public void setSendTemplateMsgService(SendTemplateMsgService sendTemplateMsgService) {
		this.sendTemplateMsgService = sendTemplateMsgService;
	}

	public void setSendMessageService(SendMessageService sendMessageService) {
		this.sendMessageService = sendMessageService;
	}

	//子任务处理的逻辑，在子类中实现具体逻辑
	public Object handle(FansSendRecord vo){
		vo.setActivityId(1L);
		try{
			return sendMessageService.sendMsg(vo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void run() {
		
		while(true){
			//获取子任务
			FansSendRecord input= workQueue.poll();
			if(input==null){
				break;
			}
			//处理子任务
			Object re = handle(input);
			resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}

}
