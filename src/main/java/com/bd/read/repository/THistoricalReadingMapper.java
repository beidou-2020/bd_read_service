package com.bd.read.repository;

import com.bd.read.entity.model.THistoricalReading;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface THistoricalReadingMapper {
	
	/**
	 * 根据阅读状态获取今年的阅读历史数据
	 * @param readFlag
	 * @return
	 */
	List<THistoricalReading> findByReadFlag(@Param("readFlag") Integer readFlag);

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
	 * 删除阅读信息
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Long id);
    
    /**
     * 逻辑删除阅读信息
     * @param id
     * @return
     */
    Integer deleteById(@Param("id") Long id, @Param("removeUser") Long removeUser);

    int insert(THistoricalReading record);

    /**
     * 添加阅读信息
     * @param record
     * @return
     */
    int insertSelective(THistoricalReading record);

    /**
     * 根据主键获取阅读信息
     * @param id
     * @return
     */
    THistoricalReading selectByPrimaryKey(@Param("id") Long id);

    /**
     * 更新阅读信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(THistoricalReading record);

    int updateByPrimaryKey(THistoricalReading record);

	/**
	 * 批量删除阅读信息
	 * @param list
	 * @return
	 */
	Integer batchDelete(@Param("list") List<Long> list, @Param("removeUser") Long removeUser);

	/**
	 * 暂停阅读
	 * @param id
	 * @return
	 */
	Integer timeOutReadInfo(@Param("id") Long id);

	/**
	 * 重新开始阅读
	 * @param id
	 * @return
	 */
	Integer restartReadInfo(@Param("id") Long id, @Param("endtime") Date endtime);
}