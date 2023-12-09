package kr.co.kccbrew.sysMng.cdMng.dao;

import java.util.List;

import kr.co.kccbrew.sysMng.cdMng.model.CdMngVo;



public interface ICdMngRepository { 
	/*그룹코드  이름 가져오기*/
	List<CdMngVo> selectNm();
	/* 그룹코드 조회 */
	List<CdMngVo> grcdList();
	/* 상세코드 조회 */
	List<CdMngVo> grcdDtlList(String cdId);
	/* 상세코드 상세조회 */
	CdMngVo selectCd(String cdId, String cdDtlId);
	/* 그룹코드 상세조회 */
	CdMngVo selectGrpDetail(String cdId);
	/* 그룹코드 등록 */
	void insert1(CdMngVo codeMng);
	/* 상세코드 등록 */
	void insert2(CdMngVo codeMng);
	
	
	/* 코드 수정 */
	void cdMod(CdMngVo codeMng);
	void grpUpdate1(CdMngVo codeMng);
	void grpUpdate2(CdMngVo codeMng);

}
