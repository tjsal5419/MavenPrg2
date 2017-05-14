package com.newlecture.web.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

//소켓 ip(건물번호)+port(사서함번호)+web
@ServerEndpoint("/resource/chatserver")
public class ChatServerEndPoint {
   
	private static Set<Session> clients;
	
	//static 생성자로 생성해줌.
	static{
		//누군가 쓰레드를 읽고 있을 때, 조작을 할 수 없게 Lock을 걸 수 있는 컬렉션을 이용해야함.
		//Set 생성 시, 동기화된 컬렉션을 생성해줌. => synchronizedSet()이용
		clients = Collections.synchronizedSet(new HashSet<Session>());
		
	}
	
   @OnOpen
   public void onOpen(Session session, EndpointConfig config){
      System.out.println(session.toString()+"Connected");
      clients.add(session);
   }
   
   @OnMessage
   public void onTextMessage(Session session, String data) throws IOException{
      
      //Gson.fromJson : JSON을 Java의 Object로 변환해준다.
	  //id와 msg가 담긴 JSON을 담을 Object형이 없으므로, ChatData라는 Object를 하나를 만들어준다.
      ChatData chatData = new Gson().fromJson(data, ChatData.class);
      System.out.println("id"+chatData.getId()+"msg:"+chatData.getMsg());
      
      for(Session s:clients)
    	  s.getBasicRemote().sendText(data);
   }
   
   @OnClose
   public void onClose(Session session){
      System.out.println("클라이언트 접속이 해제 되었습니다.");
      clients.remove(session);
      System.out.println(session.toString()+"DisConnected");
   }
   
}