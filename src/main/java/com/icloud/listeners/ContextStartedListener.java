package com.icloud.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.icloud.service.fans.WxFansService;

/**
 * @filename      : ContextStartedListener.java
 * @description   : 
 * @author        : zdh
 * @create        : 2017年7月26日 下午4:33:59   
 * @copyright     : zhumeng.com@send-msg-project
 *
 * Modification History:
 * Date             Author       Version
 * --------------------------------------
 */
@Component
public class ContextStartedListener implements ApplicationListener<ContextRefreshedEvent>{
	
		@Autowired
		private WxFansService wxFansService;
	    @Override
	    public void onApplicationEvent(ContextRefreshedEvent ev) {
	    	//初始化粉丝队列
	    	wxFansService.pushFansSendRecordQueneIntoRedis("fansqueue");
	        //防止重复执行。
	        if(ev.getApplicationContext().getParent() == null){
	         
	             
	        }
	    }
	 

}
