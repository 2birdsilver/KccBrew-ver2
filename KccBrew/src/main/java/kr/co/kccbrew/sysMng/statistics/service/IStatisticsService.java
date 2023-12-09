package kr.co.kccbrew.sysMng.statistics.service;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import kr.co.kccbrew.asMng.model.AsMngVo;
import kr.co.kccbrew.sysMng.statistics.model.StatisticsVo;

public interface IStatisticsService {
	/**
	 * 월별 장비별 AS 건수 조회
	 * @param date : 해당 달
	 * @return
	 */
	public List<StatisticsVo> machineByMonth(String date);
	/**
	 * 평점 상위/하위 기사
	 * @param date
	 * @return
	 */
	public List<StatisticsVo> highRankMecha(String date);
	public List<StatisticsVo> lowRankMecha(String date);
	
	/**
	 * 장비별 월별 재접수율
	 * @param date
	 * @return
	 */
	public List<StatisticsVo> reapplyRateByMachine(String date);
	
	/**
	 * 통계 엑셀다운로드
	 * @param response
	 * @param vo
	 */
	public void downloadExcel(HttpServletResponse response,StatisticsVo vo);
}