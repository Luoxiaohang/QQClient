package com.qq.tools;

import java.util.HashMap;

import com.qqClient.Service.CliConSerThread;

public class ThreadMap {
   public static HashMap<String,CliConSerThread> hm=new HashMap<String,CliConSerThread>();
	
   public static void addThread(String uId,CliConSerThread cct){
	  hm.put(uId,cct);
  }
   public static CliConSerThread getThread(String uId){
	   return hm.get(uId);
   }
}
