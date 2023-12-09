package kr.co.kccbrew.comm.security.dao;

import java.util.List;

import kr.co.kccbrew.comm.security.model.UserVo;

public interface IUserSearchRepository {
	/**
	 * @return 사용자 채팅작성
	 * @Param userNm: 사용자이름, userTelNo: 사용자전화번호
	 */
	List<UserVo> searchId(String userNm, String userTelNo);
	
	/**
	 * @return 비밀번호찾기
	 */
	UserVo searchPwd(UserVo vo);
	
	/**
	 * @return 비밀번호 변경
	 */
	void updatePwd(UserVo vo);


}
