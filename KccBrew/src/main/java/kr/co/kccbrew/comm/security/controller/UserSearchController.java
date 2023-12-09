package kr.co.kccbrew.comm.security.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kccbrew.comm.main.model.MainPageVo;
import kr.co.kccbrew.comm.security.model.UserVo;
import kr.co.kccbrew.comm.security.service.IUserSearchService;
import kr.co.kccbrew.comm.security.service.IUserService;
import kr.co.kccbrew.comm.util.MailUtil;
import lombok.RequiredArgsConstructor;
/**
 * @ClassNmae : UserSearchController
 * @Decription : 아이디,비밀번호찾기
 * 
 * @   수정일           			    수정자            		 수정내용
 * ============      ==============     ==============
 * 2023-09-22						배수연					   	최초생성
 * @author BAESOOYEON
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
public class UserSearchController {
	@Autowired
	private IUserSearchService searchService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/userSearch", method = RequestMethod.GET)
	public String userSearch() {

		return "security/searchUser";
	}

	@ResponseBody
	@RequestMapping(value = "/userSearch", method = RequestMethod.POST)
	public Map<String, Object> userIdSearch(@RequestParam Map<String, Object> userParams) {
	    String userNm = (String) userParams.get("userNm");
	    String userTelNo = (String) userParams.get("userTelNo");
	    List<UserVo> result = searchService.searchId(userNm, userTelNo);

	    Map<String, Object> map = new HashMap<String, Object>();
	    if (result != null && !result.isEmpty()) {
	        List<Map<String, Object>> userList = new ArrayList<>();
	        for (UserVo user : result) {
	            Map<String, Object> userData = new HashMap<>();
	            userData.put("id", user.getUserId());
	            userData.put("useYn", user.getUseYn());
	            userData.put("regDate", user.getRegDttm());
	            userList.add(userData);
	        }
	        map.put("users", userList);
	    } else {
	    	map.put("users", new ArrayList<Map<String, Object>>());
	    }

	    return map;
	}
	


	// 비밀번호 찾기
	@ResponseBody
	@RequestMapping(value = "/searchPassword", method = RequestMethod.POST)
	public String findPw(@ModelAttribute UserVo vo, Model model) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = "false";
		try {
			// 회원정보 불러오기
			UserVo vo1 = searchService.searchPwd(vo);
			// 가입된 이메일이 존재한다면 이메일 전송
			if (vo1 != null) {
				result = "true";
				// 임시 비밀번호 생성(UUID이용)
				String tempPw = UUID.randomUUID().toString().replace("-", "");// -를 제거
				tempPw = tempPw.substring(0, 10);// tempPw를 앞에서부터 10자리 잘라줌

				vo1.setUserPwd(tempPw);// 임시 비밀번호 담기

				MailUtil mail = new MailUtil(); // 메일 전송하기
				mail.sendEmail(vo1);
				vo.setUserPwd(passwordEncoder.encode(tempPw));
				searchService.updatePwd(vo);

				String securePw = encoder.encode(vo1.getUserPwd());// 회원 비밀번호를 암호화하면 vo객체에 다시 저장
				vo1.setUserPwd(securePw);
System.out.println("성공!");
			} else {
				result = "false";
			}
			model.addAttribute("result", result);
			System.out.println(result);
		} catch (NullPointerException e) {
			result = "false";
			System.out.println("오류ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ");
		}
		System.out.println(result);
		return result;
	}

	
	/**
	 * 
	 * 비밀번호변경
	 */

	@RequestMapping(value = "/mypage/chgpwd", method = RequestMethod.GET)
	public String chgPassword(Model model, Principal principal) {
		String userId = principal.getName();
		UserVo user = userService.getUserById(userId);
		String password = user.getUserPwd();
		System.out.println(password);
		model.addAttribute("password", password);
		return "myPage/chgPwd";
	}

	@ResponseBody
	@PostMapping(value = "/mypage/chgpwd")
	public String confirmChange(@RequestParam(defaultValue = "")String currentPassword,
			@RequestParam(defaultValue = "")String newPassword,
			HttpServletRequest request, Model model,
			 Principal principal) {

		String userId = principal.getName();
		UserVo user = userService.getUserById(userId);
		String loginPwd = user.getUserPwd();
		boolean j = passwordEncoder.matches(currentPassword, loginPwd);
		String result = null;
		if (j) {
			System.out.println(newPassword);
			System.out.println("실행해어ㅑㄴ허ㅑㅣㅇㅎ넝니헣ㅇ니ㅑ");
			String password = passwordEncoder.encode(newPassword);
			user.setUserPwd(password);
			searchService.updatePwd(user);
			result="true";
		}
		else {
		result = "false";
		}
		return result;
	}



	/**
	 * 
	 * 비밀번호 확인
	 */
	@RequestMapping(value = "/chgpwd")
	@ResponseBody
	public String pwdTest(@RequestBody UserVo user, Principal principal) {
		String currentPassword = user.getCurrentPassword();
		System.out.println(currentPassword);
		String userId = principal.getName();
		UserVo Vo = userService.getUserById(userId);
		String loginPwd = Vo.getUserPwd();
		boolean j = passwordEncoder.matches(currentPassword, loginPwd);
		String result="false";
		if (j) {
			
			result="true";
		} 
		System.out.println(result);
		return result;
	}
}

