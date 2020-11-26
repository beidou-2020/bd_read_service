package com.bd.read.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bd.read.entity.dto.AddReadParam;
import com.bd.read.entity.dto.PageParam;
import com.bd.read.entity.dto.UpdateReadParam;
import com.bd.read.entity.model.THistoricalReading;
import com.bd.read.entity.query.ReadQuery;
import com.bd.read.repository.THistoricalReadingMapper;
import com.bd.read.service.THistoricalReadingService;
import com.bd.read.util.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class THistoricalReadingServiceImpl implements THistoricalReadingService {
	
	@Resource
	private THistoricalReadingMapper tHistoricalReadingMapper;

	@Override
	public List<THistoricalReading> findByReadFlag(Integer readFlag) {
		return tHistoricalReadingMapper.findByReadFlag(readFlag);
	}

	@Override
	public Integer countReadNumber() {
		return tHistoricalReadingMapper.countReadNumber();
	}

	@Override
	public List<THistoricalReading> findAllByQuery(THistoricalReading tHistoricalReading) {
		return tHistoricalReadingMapper.findAllByQuery(tHistoricalReading);
	}

	@Override
	public PageInfo<THistoricalReading> pageByQuery(PageParam pageParam, ReadQuery query) {
		PageHelper.startPage(pageParam.getCurrentPageNumber(), pageParam.getPageSize());
		THistoricalReading reading = new THistoricalReading();
		BeanUtil.copyProperties(query, reading);
		List<THistoricalReading> listByQuery = tHistoricalReadingMapper.findAllByQuery(reading);
		PageInfo<THistoricalReading> pageInfo = new PageInfo<>(listByQuery);
		return pageInfo;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public THistoricalReading addReadInfo(AddReadParam param) {
		THistoricalReading reading = new THistoricalReading();
		BeanUtil.copyProperties(param, reading);
		tHistoricalReadingMapper.insertSelective(reading);
		log.info("插入成功后的数据主键ID为：{}", reading.getId());
		return reading;
	}

	@Override
	public THistoricalReading findById(Long id) {
		return tHistoricalReadingMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public THistoricalReading updateReadInfo(UpdateReadParam param) {
		THistoricalReading reading = new THistoricalReading();
		BeanUtil.copyProperties(param, reading);
		tHistoricalReadingMapper.updateByPrimaryKeySelective(reading);
		return reading;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public Integer deleteById(Long id) {
		return tHistoricalReadingMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public Integer batchDelete(String idListStr) {
		List<Long> idList = Arrays.stream(idListStr.split(",")).
				map(id -> Long.parseLong(id)).collect(Collectors.toList());
		if (CollectionUtils.isEmpty(idList)){
			return 0;
		}
		return tHistoricalReadingMapper.batchDelete(idList);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public Integer timeOutReadInfo(Long id) {
		try{
			Integer result = tHistoricalReadingMapper.timeOutReadInfo(id);
			return result;
		}catch (Exception ex){
			log.error("暂停ID：{}的阅读信息异常", JSONObject.toJSONString(id));
		}

		return 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public Integer restartReadInfo(Long id) {
		try{
			Integer result = tHistoricalReadingMapper.restartReadInfo(id);
			return result;
		}catch (Exception ex){
			log.error("重启ID：{}的阅读信息异常", JSONObject.toJSONString(id));
		}
		return 0;
	}
}
