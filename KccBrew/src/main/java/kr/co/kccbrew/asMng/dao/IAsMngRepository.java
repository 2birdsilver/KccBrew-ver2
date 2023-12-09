package kr.co.kccbrew.asMng.dao;

import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import kr.co.kccbrew.asMng.model.AsMngVo;


@Repository
public interface IAsMngRepository {
	/**
	 * @return 조회한 AS 리스트
	 */
	public List<AsMngVo>selectASList(Map<String, Object> map);
	/**
	 * @return AS 리스트의 총 수
	 */
	public int countASList(AsMngVo asMngVo);
	/**
	 *  AS 전체 조회
	 */
	public List<AsMngVo>selectAllASList(AsMngVo asMngVo); 
	/**
	 * 점포 정보 조회
	 * @return 로그인한 아이디로 매핑된 점포 정보 
	 */
	public List<AsMngVo> selectStrInfo(String userId);
	
	/**
	 * AS 이미지 파일 등록
	 * @param asMngVo 파일 시퀀스 번호 받기위한 Vo
	 */
	public void insertFile(AsMngVo asMngVo);
	
	/**
	 * AS 이미지 파일 등록
	 * @param asMngVo 파일 정보 들어가있음
	 */
	public void insertFileDtl(AsMngVo asMngVo);
	/**
	 * AS 등록
	 * @param asMngVo
	 */
	public void insertAs(AsMngVo asMngVo);
	
	/**
	 * AS detail 조회
	 * @param asInfoSeq seq번호
	 * @param asAssignSeq 수리배정번호
	 * @param storeSeq 점포번호
	 * @return AsMngVo
	 */
	public AsMngVo selectAsInfoDetail(String asInfoSeq,String asAssignSeq,String storeSeq);
	
	/**
	 * AS건에 등록한 파일 정보 조회
	 * @param fileDtlId
	 * @return
	 */
	public List<AsMngVo> selectAsImg(String fileDtlId);
	
	/**
	 * 코드 조회
	 * @param code
	 * @return
	 */
	public List<AsMngVo> selectCd(String code);
	
	/**
	 * 지역 상세코드 조회
	 * @param locationCd
	 * @return
	 */
	public List<AsMngVo> selectLocationDtlCd(String locationCd);
	
	/**
	 * 선택한 날짜에 점포 휴일 체크
	 * @param date 선택 날짜
	 * @param storeSeq AS 신청인
	 * @return
	 */
	public int checkStrSchedule(String date,String storeSeq);
	
	/**
	 * 
	 * @param date 방문 선택 날짜
	 * @param locationCd 지역 코드
	 * @param machineCd 장비코드
	 * @return List<AsMngVo>
	 */
	public List<AsMngVo> selectMechList(String date,String locationCd,String machineCd);
	
	/**
	 * 기사 배정
	 * @param asMngVo
	 */
	public void insertAsAssign(AsMngVo asMngVo);
	
	/**
	 * AS status 상태 변경
	 * @param asMngVo
	 */
	public void updateAsInfoStatus(AsMngVo asMngVo);
	
	/**
	 * 반려 등록
	 */
	public void updateInfoReject(String seq,String content,String userId);
	public void updateAssignReject(String seq,String content,String userId);
	
	/**
	 * 기사의 배정 반려건에 대한 처리
	 */
	public void updateRejectConfirm(Map<String, Object> map);
	
	/**
	 * 수리기사 AS 결과 입력 
	 */
	public void insertResult(AsMngVo asMngVo);

	/**
	 * 점포점주 AS 결과입력
	 */
	public void updateResultMng(AsMngVo asMngVo);
	/**
	 * 재배정 여부
	 * @param asMngVo
	 */
	public void updateAsResultConfirm(AsMngVo asMngVo);
	
	void asMod(AsMngVo asMngVo);
	void deleteFile(String imgSeq);
	/**
	 * AS 접수 취소
	 * @param asInfoSeq
	 */
	public void deleteAs(String asInfoSeq);
	public List<AsMngVo> getAsHistory(String asInfo,String userTypeCd);
}
