package com.icloud.web.redEnvelope;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.icloud.common.DateTools;
import com.icloud.model.redEnvelope.RedEnvelopeActivity;
import com.icloud.service.redEnvelope.RedEnvelopeActivityService;

@Controller
public class RedEnvelopeActivityController {
	@Autowired
	private RedEnvelopeActivityService envelopeActivityService;
	
	@RequestMapping("/admin/red_envelope_list")
	public String list(RedEnvelopeActivity activity,HttpServletRequest request) throws Exception{
		PageInfo<RedEnvelopeActivity> page = envelopeActivityService.findByPage(1, 10, activity);
		request.setAttribute("activity", activity);
		request.setAttribute("page", page);
		return "envelope/list";
	}
	
	@RequestMapping("/admin/red_envelope_page")
	@ResponseBody
	public Object listPage(RedEnvelopeActivity activity,HttpServletRequest request) throws NumberFormatException, Exception{
		String pageNum = request.getParameter("pageNum");
		PageInfo<RedEnvelopeActivity> page = envelopeActivityService.findByPage(StringUtils.isNotBlank(pageNum)?Integer.parseInt(pageNum):1, 10, activity);
		return page.getList();
	}
	
	@RequestMapping("/admin/red_envelope_input")
	public String toInput(String id,HttpServletRequest request) throws Exception{
		if(StringUtils.isNotBlank(id)){
			RedEnvelopeActivity activity = envelopeActivityService.findByKey(id);
			request.setAttribute("activity",activity);
		}else{
			request.setAttribute("activity", null);
		}
		return "envelope/input";
	}

	@RequestMapping("/admin/red_envelope_save")
	@ResponseBody
	public String save(RedEnvelopeActivity activity,String sTime,String eTime) throws Exception{
		RedEnvelopeActivity pre = envelopeActivityService.selectPreActivity();
		if(null!=pre){
			activity.setPreId(pre.getId());
		}
		if(StringUtils.isNotBlank(sTime)){
			activity.setStartTime(DateTools.str2Date(sTime, "yyyy-MM-dd HH:mm"));
		}
		if(StringUtils.isNotBlank(eTime)){
			activity.setEndTime(DateTools.str2Date(eTime, "yyyy-MM-dd HH:mm"));
		}
		activity.setCreateTime(new Date());
		if(StringUtils.isNotBlank(activity.getId())){
			envelopeActivityService.update(activity);
		}else{
			envelopeActivityService.save(activity);
		}
		return "0000";
	}
	
}
