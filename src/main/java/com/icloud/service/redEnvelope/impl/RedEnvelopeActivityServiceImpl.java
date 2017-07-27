package com.icloud.service.redEnvelope.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.dao.redEnvelope.RedEnvelopeActivityMapper;
import com.icloud.model.redEnvelope.RedEnvelopeActivity;
import com.icloud.service.redEnvelope.RedEnvelopeActivityService;

@Service
@Transactional
public class RedEnvelopeActivityServiceImpl implements RedEnvelopeActivityService {

	@Autowired
	private RedEnvelopeActivityMapper mapper;
	@Override
	public void save(RedEnvelopeActivity t) throws Exception {
		mapper.save(t);
	}

	@Override
	public void update(RedEnvelopeActivity t) throws Exception {
		mapper.update(t);
	}

	@Override
	public List<RedEnvelopeActivity> findList(RedEnvelopeActivity t) throws Exception {
		return mapper.findForList(t);
	}

	@Override
	public Integer findCount(RedEnvelopeActivity t) throws Exception {
		return null;
	}

	@Override
	public void delete(String id) throws Exception {
		
	}

	@Override
	public RedEnvelopeActivity findByKey(String id) throws Exception {
		return mapper.findForObject(id);
	}

	@Override
	public PageInfo<RedEnvelopeActivity> findByPage(int pageNo, int pageSize, RedEnvelopeActivity t) throws Exception {
		PageHelper.startPage(pageNo, pageSize);
		return new PageInfo<>(mapper.findForList(t));
	}

	@Override
	public RedEnvelopeActivity selectPreActivity() {
		return mapper.selectPreActivity();
	}

}
