package com.icloud.web.redEnvelope;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icloud.model.redEnvelope.RedEnvelopeActivity;
import com.icloud.service.send.SendMessageService;

@Controller
public class FansSendRecordController {
	@Autowired
	private SendMessageService sendMessageService;
	
	@RequestMapping("/send/sendMsg")
	public void sendMsg(RedEnvelopeActivity activity,HttpServletRequest request) throws Exception{
		RedEnvelopeActivity t = new RedEnvelopeActivity();
		t.setId("1");
		sendMessageService.sendModuleMessage(t);
	}
}
