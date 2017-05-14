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

//���� ip(�ǹ���ȣ)+port(�缭�Թ�ȣ)+web
@ServerEndpoint("/resource/chatserver")
public class ChatServerEndPoint {
   
	private static Set<Session> clients;
	
	//static �����ڷ� ��������.
	static{
		//������ �����带 �а� ���� ��, ������ �� �� ���� Lock�� �� �� �ִ� �÷����� �̿��ؾ���.
		//Set ���� ��, ����ȭ�� �÷����� ��������. => synchronizedSet()�̿�
		clients = Collections.synchronizedSet(new HashSet<Session>());
		
	}
	
   @OnOpen
   public void onOpen(Session session, EndpointConfig config){
      System.out.println(session.toString()+"Connected");
      clients.add(session);
   }
   
   @OnMessage
   public void onTextMessage(Session session, String data) throws IOException{
      
      //Gson.fromJson : JSON�� Java�� Object�� ��ȯ���ش�.
	  //id�� msg�� ��� JSON�� ���� Object���� �����Ƿ�, ChatData��� Object�� �ϳ��� ������ش�.
      ChatData chatData = new Gson().fromJson(data, ChatData.class);
      System.out.println("id"+chatData.getId()+"msg:"+chatData.getMsg());
      
      for(Session s:clients)
    	  s.getBasicRemote().sendText(data);
   }
   
   @OnClose
   public void onClose(Session session){
      System.out.println("Ŭ���̾�Ʈ ������ ���� �Ǿ����ϴ�.");
      clients.remove(session);
      System.out.println(session.toString()+"DisConnected");
   }
   
}