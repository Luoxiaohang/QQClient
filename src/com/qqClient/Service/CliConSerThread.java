package com.qqClient.Service;

import java.io.ObjectInputStream;
import java.net.Socket;

import com.qq.bean.TextMessage;
import com.qq.tools.FriendWindowMap;
import com.qq.tools.MessageType;
import com.qq.tools.windowMap;
import com.qq.window.Chat;
import com.qq.window.userList;

public class CliConSerThread extends Thread implements MessageType{
    Socket s=null;	
    public CliConSerThread(Socket s){
	   this.s=s;
   }
    public Socket getSocket(){
    	return this.s;
    }
	public void run(){
		
		while(true){
		try {			
		    ObjectInputStream ois=new ObjectInputStream(this.s.getInputStream());				
		    TextMessage tm=(TextMessage) ois.readObject();
		    
		    if(tm.getMessageType().equals(message)){		
		    Chat chat=windowMap.getChatWindow(tm.getReceiver()+""+tm.getSender());
		    chat.ShowMessage(tm);
		    }
		    else if(tm.getMessageType().equals(OnlinefriendListMessage)){
		    	userList ul=FriendWindowMap.getFriendWindowMap(tm.getReceiver());
		        ul.updateFriendList(tm);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
