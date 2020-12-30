package com.bd.read.controller;

import com.alibaba.fastjson.JSONObject;
import com.bd.read.controller.common.Result;
import com.bd.read.entity.dto.AddReadParam;
import com.bd.read.entity.dto.PageParam;
import com.bd.read.entity.dto.UpdateReadParam;
import com.bd.read.entity.enumerate.ResultCode;
import com.bd.read.entity.model.THistoricalReading;
import com.bd.read.entity.query.ReadQuery;
import com.bd.read.service.THistoricalReadingService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/read")
@Slf4j
public class ReadController {

	@Resource
	private THistoricalReadingService tHistoricalReadingService;

	
	/**
	 * 阅读信息列表
	 * @param pageParam
	 * @param query
	 * @return
	 */
	@GetMapping(value = "/list", produces = "application/json;charset=utf-8")
	@ResponseBody
	public PageInfo<THistoricalReading> list(@Valid PageParam pageParam, ReadQuery query) {
		PageInfo<THistoricalReading> pageInfo = tHistoricalReadingService.pageByQuery(pageParam, query);
		return pageInfo;
	}


	/**
	 * 添加阅读信息
	 * @param param
	 * @return
	 */
	@PostMapping(value = "/add", produces = "application/json;charset=utf-8")
	@ResponseBody
	public THistoricalReading add(@RequestBody @Valid AddReadParam param) {
		THistoricalReading result = tHistoricalReadingService.addReadInfo(param);
		return result;
	}

	
	/**
	 * 更新阅读信息
	 * @param param
	 * @return
	 */
	@PostMapping(value = "/update", produces = "application/json;charset=utf-8")
	@ResponseBody
	public THistoricalReading update(@RequestBody @Valid UpdateReadParam param) {
		THistoricalReading result = tHistoricalReadingService.updateReadInfo(param);
		return result;
	}
	
	/**
	 * 删除阅读信息
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/deleteById/{id}", produces = "application/json;charset=utf-8")
	@ResponseBody
	public THistoricalReading deleteById(@PathVariable("id") Long id) {
		THistoricalReading readInfo = tHistoricalReadingService.findById(id);
		if (Objects.isNull(readInfo)){
			return null;
		}
		tHistoricalReadingService.deleteById(id);
		return readInfo;
	}
	
	/**
	 * 查看阅读详情
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/readDetails/{id}", produces = "application/json;charset=utf-8")
	@ResponseBody
	public THistoricalReading readDetails(@PathVariable(name = "id") Long id) {
		THistoricalReading readInfo = tHistoricalReadingService.findById(id);
		return readInfo;
	}

	/**
	 * 根据阅读状态获取今年的阅读历史数据(2：读完)
	 * @return
	 */
	@GetMapping("/todayYearByReadFlag")
	@ResponseBody
	public Result todayYearByReadFlag(){
		List<THistoricalReading> list = tHistoricalReadingService.findByReadFlag(2);
		return Result.ok(list);
	}

	/**
	 * 获取累计阅读量
	 * @return
	 */
	@GetMapping("/countReadNumber")
	@ResponseBody
	public Result countReadNumber(){
		Integer count = tHistoricalReadingService.countReadNumber();
		return Result.ok(count);
	}

	/**
	 * 批量删除
	 * @param idListStr
	 * @return
	 */
	@PostMapping("/batchDelete")
	@ResponseBody
	public Result batchDelete(@RequestParam("idListStr") String idListStr){
		// 参数不能为空
		if (StringUtils.isEmpty(idListStr)){
			return Result.fail(ResultCode.PARAM_ERROR.code(), ResultCode.PARAM_ERROR.msg());
		}

		Integer data = tHistoricalReadingService.batchDelete(idListStr);
		return Result.ok(data);
	}

	/**
	 * 暂停阅读信息
	 * @param id
	 * @return
	 */
	@PostMapping("/timeOut/{id}")
	@ResponseBody
	public Result timeOutReadInfo(@PathVariable(name = "id") Long id){
		log.info("暂停阅读，ID：{}", JSONObject.toJSONString(id));
		Integer result = tHistoricalReadingService.timeOutReadInfo(id);
		return Result.ok(result);
	}

	/**
	 * 重新开始阅读
	 * @param id
	 * @return
	 */
	@PostMapping("/restart/{id}")
	@ResponseBody
	public Result restartReadInfo(@PathVariable(name = "id") Long id){
		log.info("重新开始阅读，ID：{}", JSONObject.toJSONString(id));
		Integer result = tHistoricalReadingService.restartReadInfo(id);
		return Result.ok(result);
	}
	
	

}
