package kr.co.kccbrew.batch.dao;

import org.springframework.stereotype.Repository;

import kr.co.kccbrew.batch.AsLogVo;

@Repository
public interface IBatchRepository {
	
	public AsLogVo selectRecentAsLog();
	public void updateOmissionResult();

}
