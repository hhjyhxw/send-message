package com.icloud.web.redEnvelope;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.icloud.common.DateTools;
import com.icloud.model.redEnvelope.RedEnvelopeRecord;
import com.icloud.service.redEnvelope.RedEnvelopeRecordService;

@Controller
public class RedEnvelopeRecordController {
	@Autowired
	private RedEnvelopeRecordService envelopeRecordService;
	@RequestMapping("/admin/record_list")
	public String list(RedEnvelopeRecord record,HttpServletRequest request) throws Exception{
		PageInfo<RedEnvelopeRecord> page = envelopeRecordService.fingPage(1, 10, record);
		request.setAttribute("page", page);
		request.setAttribute("record", record);
		return "envelope/record_list";
	}
	
	@RequestMapping("/admin/record_list_page")
	@ResponseBody
	public JSONArray listPage(RedEnvelopeRecord record,HttpServletRequest request) throws Exception{
		String pageNum = request.getParameter("pageNum");
		PageInfo<RedEnvelopeRecord> page = envelopeRecordService.fingPage(StringUtils.isNotBlank(pageNum)?Integer.parseInt(pageNum):1, 10, record);
        JSONArray array = new JSONArray();
        for(RedEnvelopeRecord re:page.getList()){
        	JSONObject obj = new JSONObject();
        	obj.put("id", re.getId());
        	obj.put("money", re.getMoney());
        	obj.put("openId",re.getOpenId());
        	obj.put("status", re.getStatus());
        	obj.put("createTime", DateTools.date2Str(re.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        	array.add(obj);
        }
        return array;
		
	}

}
