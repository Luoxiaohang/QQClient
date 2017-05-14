package com.qq.window;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.qq.bean.TextMessage;
import com.qq.tools.MessageType;
import com.qq.tools.ThreadMap;
import com.qqClient.Service.CliConSerThread;
import com.qqClient.Service.ConectionServise;

public class Chat extends JFrame implements ActionListener{

	JTextArea jta=null;
    JScrollPane jsp=null;
    JTextField jtf=null;
    JButton jb=null;
    JPanel jp;
    String myId,friendId;
	
    public static void main(String[] args) {
		Chat chat=new Chat("航","mm");

	}
    public Chat(String myId,String friendId){
    	this.myId=myId;
    	this.friendId=friendId;
    	Container c=this.getContentPane();
    	jta=new JTextArea(20,30);
    	jsp=new JScrollPane(jta);
    	c.add(jsp,"Center");
    	jtf=new JTextField(15);
    	jb=new JButton("发送");
    	jb.addActionListener(this);
    	jp=new JPanel(new FlowLayout(FlowLayout.CENTER));
    	jp.add(jtf);
    	jp.add(jb);
    	c.add(jp,"South");
    	this.setSize(400,300);
    	try {
			this.setIconImage(ImageIO.read(new File("image/qq.gif")));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	this.setTitle(this.myId+"与"+this.friendId+"聊天中");
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb){								
			 try {
				 TextMessage message=new TextMessage(myId,friendId,jtf.getText(),MessageType.message);
				 ObjectOutputStream oos=new ObjectOutputStream(ThreadMap.getThread(myId).getSocket().getOutputStream());
				 oos.writeObject(message);
			 } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			jta.append("我对"+friendId+"说"+jtf.getText()+"\n");						
			jtf.setText("");
		}
		
	}
	
	public void ShowMessage(TextMessage tm) {
			    jta.append(tm.getSender()+"对我说"+tm.getMessage()+"\n");
	}
}
