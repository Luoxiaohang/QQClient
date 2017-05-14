package com.qq.window;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.qq.bean.TextMessage;
import com.qq.tools.windowMap;

public class userList extends JFrame implements ActionListener,MouseListener{

    JButton jb_friend,jb_stranger,jb_blacklist;
    JLabel [] jl=new JLabel[50];
	JScrollPane jsp=null;
	JPanel jp_c=null,jp_buttom;
	String myname=null;
    public static void main(String[] args) {
		userList ul=new userList("航");

	}
    public void updateFriendList(TextMessage tm ){
    	System.out.println(tm.getMessage());
    	String[] friendOnLine=tm.getMessage().split(" ");
    	for(int i=0;i<50;i++)
	    {	 
    	  for(int j=0;j<friendOnLine.length;j++){
	            if(jl[i].getText().equals(friendOnLine[j])){	              
	            	jl[i].setEnabled(true);	
	            }  		  
    	  }   	
	    }
    }
    public userList(String myname){
    	this.myname=myname;
		Container c=this.getContentPane();
	    jb_friend=new JButton("我的好友");
	    jb_friend.addActionListener(this);
	    jb_stranger=new JButton("陌生人");
	    jb_stranger.addActionListener(this);
	    jb_blacklist=new JButton("黑名单");
	    jb_blacklist.addActionListener(this);
	    c.add(jb_friend,"North");
	    //处理好友列表	   
	    jp_c=new JPanel(new GridLayout(50,1,0,8));
	    for(int i=0;i<50;i++)
		    {	 
	    	  jl[i]=new JLabel(String.valueOf(i),new ImageIcon("image/mm.jpg"),JLabel.LEFT);
		      jl[i].setEnabled(false);
	    	  jl[i].addMouseListener(this);
	    	 jp_c.add(jl[i]);
		    }
	    jsp=new JScrollPane(jp_c);
	    c.add(jsp,"Center");
	    jp_buttom=new JPanel(new GridLayout(2,1));
	    jp_buttom.add(jb_stranger);
	    jp_buttom.add(jb_blacklist);
	    c.add(jp_buttom,"South");
	   
	    this.setSize(200,450);
	    this.setTitle(this.myname);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb_friend){
			
		}
		else if(e.getSource()==jb_stranger){
			
		}
		else if(e.getSource()==jb_blacklist){
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			for(int i=0;i<50;i++){
				if(e.getSource()==jl[i])
				{
					Chat chat=new Chat(this.myname,jl[i].getText());
					windowMap.addWindow(this.myname+""+jl[i].getText(), chat);
				}
				}
		}		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i=0;i<50;i++){
		if(e.getSource()==jl[i])
		{
			jl[i].setForeground(Color.RED);			
		}
		}	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		for(int i=0;i<50;i++){
			if(e.getSource()==jl[i])
			{
				jl[i].setForeground(Color.black);			
			}
			}
		
	}
}
