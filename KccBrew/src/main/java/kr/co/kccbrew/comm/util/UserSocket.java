package kr.co.kccbrew.comm.util;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
/**
 * @ClassNmae : UserSocket
 * @Decription : 실시간 문의 채팅을 위한 사용자소켓
 * 
 * @   수정일           			    수정자            		 수정내용
 * ============      ==============     ==============
 * 2023-10-02							배수연					   	최초생성
 * @author BAESOOYEON
 * @version 1.0
 */
@ServerEndpoint("/userchat/{user_id}")
public class UserSocket {
	

	//searchUser 함수의 filter 표현식을 위한 인터페이스
	private interface SearchExpression {
		//람다식을 위한 함수
		boolean expression(User user);
	}
	//서버와 유저간의 접속을 key로 구분하기 위한 이너 클래스
	public class User {
	    Session session;
	    String key;
	    String user_id; // 유저 아이디 필드 추가
	}
	
	//유저와 서버간의 접속 리스트 -> 동기화처리
	public static List<User> sessionUsers = Collections.synchronizedList(new ArrayList<>());
	//리스트에서 탐색(session)
	private static User getUser(Session session) {
		return searchUser(x -> x.session == session);
	}
	
	//리스트에서 탐색(key)
	private static User getUser(String key) {
		return searchUser(x -> x.key.equals(key));
	}
	
	//접속 리스트 탐색
	private static User searchUser(SearchExpression func) {
		Optional<User> op = sessionUsers.stream().filter(x -> func.expression(x)).findFirst();		
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
	//접속
	@OnOpen
	public void handleOpen(Session userSession, @PathParam("user_id") String user_id) throws IOException {
	    User user = new User();
	    user.key = UUID.randomUUID().toString().replace("-", "");
	    user.user_id = user_id; // 전달된 user_id 사용
	    user.session = userSession;
	    System.out.println(userSession);
	    System.out.println("================++=================");
	    sessionUsers.add(user);
	    // key와 user_id 모두 전송
	    user.session.getBasicRemote().sendText("uuid:" + user.key + ",user_id:" + user.user_id);
	    AdminSocket.visit(user.key, user.user_id); // visit 메소드에 user_id도 전달
	}
	
	//JS에서 전달받을 때
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		User user = getUser(userSession);
		System.out.println(user);
	    System.out.println("==========dddd======++=================");
		if (user != null) {
			System.out.println(message);
			//어떤 유저가 메세지를 보냈는지 admin에게 전달
			AdminSocket.sendMessage(user.key, message);
		}
	}
	//운영자 -> user 메세지
	public static void sendMessage(String key, String message) {
		User user = getUser(key);
		if (user != null) {
			try {
				//메세지 받음(기존 usersession = 웹소켓세션)
				user.session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//종료 시
	@OnClose
	public void handleClose(Session userSession) {
		User user = getUser(userSession);
		System.out.println(user);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		if (user != null) {
			//admin에 종료 전송 -> 방 닫힘
			AdminSocket.bye(user.key);
			sessionUsers.remove(user);
		}
	}

	//유저 UK get -> admin에 보낼용도
	public static String[] getUserKeys() {
		String[] ret = new String[sessionUsers.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = sessionUsers.get(i).key;
		}
		return ret;
	}
}