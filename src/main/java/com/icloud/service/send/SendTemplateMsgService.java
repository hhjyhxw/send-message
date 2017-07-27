package com.icloud.service.send;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.icloud.model.redEnvelope.FansSendRecord;


/**
 * 分装模板消息 类型
 */
@Service
public class SendTemplateMsgService {

	/**
	 * 红包伙伴模板消息
	 * @param vo 粉丝对象
	 * @return
	 */
	public boolean sendHongBaoMessage(FansSendRecord vo) {
		try{
			
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			//发送数据
			//设置开头语
			JSONObject first = new JSONObject();
			first.put("value", "红包活动强劲来袭，最高188，数量有限，先到先得！立即点击抢购红包！");// 开头语,默认黑色first.put("color", "#173177");
			//商品信息
			JSONObject keyword1 = new JSONObject();
			keyword1.put("value", "红包领取");
			//消费金额
			JSONObject keyword2 = new JSONObject();
			keyword2.put("value", "100000");
			//备注
			JSONObject remark = new JSONObject();
			remark.put("value", "红包活动先到先得，领完了就没办法进入到相应的页面，统一领红包活动，每期抢完为止。");
			
			//数据嵌套
			data.put("first", first);
			data.put("keyword1", keyword1);
			data.put("keyword2", keyword2);
			data.put("remark", remark);
			
			String modelId = "edgok6oAAKJVYOXsx6vEhkoYs9RdsD8CvuwmhViULZs";

			
			jsonObj.put("template_id", modelId);
			jsonObj.put("url","http://www.baidu.com");
			jsonObj.put("topcolor", "#173177");
			jsonObj.put("touser", vo.getOpenId());
			jsonObj.put("data", data);
			
			//配置好请求的字符串直接请求
			String result= WxSendMessageUtil.sendModelMessage(jsonObj.toString());
			if("0".equals(result)){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
//	public static void main(String[] args){
//		FansSendRecord vo = new FansSendRecord();
//		vo.setOpenId("ocoMKt2a_9XrLt2NBG5CupS6THE4");
//		vo.setNickName("落叶");
//		vo.setActivityId("1");
//		boolean b = sendHongBaoMessage(vo);
//		System.out.println(b);
//	}
}