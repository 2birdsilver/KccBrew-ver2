package kr.co.kccbrew.strMng.dao;


import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import kr.co.kccbrew.asMng.model.AsMngVo;
import kr.co.kccbrew.strMng.model.StrMngVo;


public interface IStrMngRepository {
	List<StrMngVo> storeAll(StrMngVo strMngVo);
	List<StrMngVo> strFilter(Map<String, Object> map);
	int getStrFilterCount(Map<String, Object> map);
	List<StrMngVo> ownerList(int storeSeq);
	List<StrMngVo> locationNm();
	List<StrMngVo> locationNmSeoul();
	List<StrMngVo> search(String keyword);
	StrMngVo storeDetail(int storeSeq);
	void insert(StrMngVo store);
	void update(StrMngVo store);
	StrMngVo selectStoreByName(String storeNm);


	/**
	 * 내 계정에 등록된 점포 조회
	 * @return
	 */
	public List<StrMngVo> selectMyStr(String userId);
	/**
	 * 내 계정에 점포 추가 등록
	 * @param userId
	 * @param storeSeq
	 */
	public void insertStr(String userId,String storeSeq);
	/**
	 * 점포 제거
	 * @param userId
	 * @param storeSeq
	 */
	void deleteStr(String userId,String storeSeq);
	List<StrMngVo> strAllFilter(StrMngVo strMngVo);
	
	/**
	 * 계정내 점포 삭제, 해당 계정으로 등록한 AS 목록 삭제
	 * @return
	 */
	List<AsMngVo> selectDeleteAsList(String userId,String storeSeq);
	void deleteASresult(String asResultSeq);
	void deleteASAssign(String asAssignSeq);
	void deleteASinfo(String asInfoSeq);
	void deleteholiday(String userId,String storeSeq);
}
