package com.bd.read.service;

import com.bd.read.entity.dto.AddReadParam;
import com.bd.read.entity.dto.PageParam;
import com.bd.read.entity.dto.UpdateReadParam;
import com.bd.read.entity.model.THistoricalReading;
import com.bd.read.entity.query.ReadQuery;
import com.github.pagehelper.PageInfo;
import java.util.List;


public interface THistoricalReadingService {
	/**
	 * 根据阅读状态获取历史阅读数据
	 * @param readFlag
	 * @return
	 */
	List<THistoricalReading> findByReadFlag(Integer readFlag);

	/**
	 * 累计阅读量
	 * @return
	 */
	Integer countReadNumber();
	
	/**
	 * 复合条件获取阅读书籍列表信息
	 * @return
	 */
	List<THistoricalReading> findAllByQuery(THistoricalReading tHistoricalReading);
	
	/**
	 * 分页获取阅读信息
	 * @param pageParam
	 * @param query
	 * @return
	 */
	PageInfo<THistoricalReading> pageByQuery(PageParam pageParam, ReadQuery query);
	
	/**
	 * 添加阅读信息
	 * @param param
	 * @return
	 */
	THistoricalReading addReadInfo(AddReadParam param);
	
	/**
	 * 根据主键获取阅读信息
	 * @param id
	 * @return
	 */
	THistoricalReading findById(Long id);
	
	/**
	 * 更新阅读信息
	 * @param param
	 * @return
	 */
	THistoricalReading updateReadInfo(UpdateReadParam param);
	
	/**
     * 逻辑删除阅读信息
     * @param id
     * @return
     */
    Integer deleteById(Long id);

	/**
	 * 批量删除阅读信息
	 * @return
	 */
	Integer batchDelete(String idListStr);
	
}
