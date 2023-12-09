package kr.co.kccbrew.sysMng.statistics.dao;

import java.util.List;

import kr.co.kccbrew.sysMng.statistics.model.StatisticsVo;

public interface IStatisticsRepository {
	/**
	 * 연도별 장비별 AS 건수 조회
	 * @param start 시작일
	 * @param end 종료일
	 * @return
	 */
	public List<StatisticsVo> machineByMonth(String start,String end);
	
	/**
	 * 연도별  평점 상위/하위 기사
	 * @param start
	 * @return
	 */
	public List<StatisticsVo> highRankMecha(String start,String end);
	public List<StatisticsVo> lowRankMecha(String start,String end);
	
	/**
	 * 장비별 월별 재접수율
	 * @param start
	 * @param end
	 * @return
	 */
	public List<StatisticsVo> reapplyRateByMachine(String start,String end);
}