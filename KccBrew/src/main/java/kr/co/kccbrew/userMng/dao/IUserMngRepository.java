package kr.co.kccbrew.userMng.dao;

import java.util.List;
import java.util.Map;
import kr.co.kccbrew.userMng.model.UserMngVo;

public interface IUserMngRepository {
	List<UserMngVo> userList(Map<String, Object> map);
	int getUserCount(Map<String, Object> map);
	List<UserMngVo> newList();
	 UserMngVo findByUserId(String userId);
	 List<UserMngVo> findByUserInfo(String userId);
	 List<UserMngVo> findByUserInfo2(String userId);
	 void save(UserMngVo userMngVo);
	 void userMod(UserMngVo userMngVo);
	 int getNewCount();

}
