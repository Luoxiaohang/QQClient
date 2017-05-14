package com.qq.tools;

import java.util.HashMap;

import com.qq.window.userList;

public class FriendWindowMap {
   public static HashMap<String,userList> friendWindowMap=new HashMap<String,userList>();
   public static void addFriendWindowMap(String Id,userList ul){
	   friendWindowMap.put(Id, ul);
   }
   public static userList getFriendWindowMap(String Id){
	   return friendWindowMap.get(Id);
   }
}
