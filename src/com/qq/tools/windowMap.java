package com.qq.tools;

import java.util.HashMap;

import com.qq.window.Chat;

public class windowMap {
  public static HashMap<String,Chat> whm=new HashMap<String ,Chat>();
  public static void addWindow(String Id,Chat chat){
	  whm.put(Id,chat);
  }
  public static Chat getChatWindow(String Id){
	  return whm.get(Id);
  }
}
