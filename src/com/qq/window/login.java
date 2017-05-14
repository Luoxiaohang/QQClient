package com.qq.window;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.qq.bean.TextMessage;
import com.qq.bean.UserMessage;
import com.qq.tools.ErrorTip;
import com.qq.tools.FriendWindowMap;
import com.qq.tools.MessageType;
import com.qq.tools.ThreadMap;
import com.qqClient.Service.ConectionServise;

public class login extends JFrame implements ActionListener,MouseListener{
    
	JPanel jp_top,jp_c1,jp_c2,jp_c3,jp_buttom;
	Image image=null;
	JButton jb_login,jb_cancle,jb_guide,jb_clean;
	JRadioButton jrb_cloak,jrb_remember;
	ButtonGroup bg;
	JTabbedPane jtp=null;
	JLabel jl_image,jl_qqNum,jl_qqpw, jl_fpw ,jl_protect;
	JTextField jtf;
	JPasswordField jpf;
	public static void main(String[] args) {
		login login=new login();

	}
   public login(){
	   Container c=this.getContentPane();
	   //处理上部
	   jl_image=new JLabel(new ImageIcon("image/tou.gif"));
	   c.add(jl_image,"North");
	   //处理中部
	   jtp=new JTabbedPane();
	   jp_c1=new JPanel(new GridLayout(3,3));
	   //处理第一个窗格
	   jl_qqNum=new JLabel("QQ号码",JLabel.CENTER);
	   jl_qqpw=new JLabel("QQ密码",JLabel.CENTER);
	   jl_fpw=new JLabel("忘记密码",JLabel.CENTER);
	   jl_fpw.addMouseListener(this);
	   jl_protect=new JLabel("申请密码保护",JLabel.CENTER);
	   jl_protect.addMouseListener(this);
	   jb_clean=new JButton(new ImageIcon("image/clear.gif"));
	   jb_clean.addActionListener(this);
	   jtf=new JTextField(15);
	   jpf=new JPasswordField(15);
	   jrb_cloak=new JRadioButton("隐身登录");
	   jrb_remember=new JRadioButton("记住密码");
	   bg=new ButtonGroup();
	   bg.add(jrb_cloak);
	   bg.add(jrb_remember);
	   jp_c1.add(jl_qqNum);
	   jp_c1.add(jtf);
	   jp_c1.add(jb_clean);
	   jp_c1.add(jl_qqpw);
	   jp_c1.add(jpf);
	   jp_c1.add(jl_fpw);
	   jp_c1.add(jrb_cloak);
	   jp_c1.add(jrb_remember);
	   jp_c1.add(jl_protect);
	   jp_c2=new JPanel();
	   jp_c3=new JPanel();
	   jtp.add(jp_c1,"QQ号码");
	   jtp.add(jp_c2,"手机号码");
	   jtp.add(jp_c3,"电子邮箱");
	   c.add(jtp,"Center");
	   //处理底部
	   jp_buttom=new JPanel(new FlowLayout());
       jb_login=new JButton(new ImageIcon("image/denglu.gif"));
       jb_login.addActionListener(this);
       jb_cancle=new JButton(new ImageIcon("image/quxiao.gif"));
       jb_cancle.addActionListener(this);
       jb_guide=new JButton(new ImageIcon("image/xiangdao.gif"));
       jb_guide.addActionListener(this);
	   jp_buttom.add(jb_login);
	   jp_buttom.add(jb_cancle);
	   jp_buttom.add(jb_guide);
	   c.add(jp_buttom,"South");
	   
	   this.setSize(350,250);
	   this.setLocation(500,300);
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   this.setVisible(true);	   
   }

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb_login){			
		
		UserMessage um=new UserMessage(jtf.getText(),jpf.getText());
		ConectionServise cs=new ConectionServise();
		
		if(jtf.getText().equals("")||jpf.getText().equals("")||cs.CheceUser(um)==false){
			@SuppressWarnings("unused")
			ErrorTip error=new ErrorTip("帐号或密码错误！！") ;
		}
		else{
			userList ul=new userList(jtf.getText());
			FriendWindowMap.addFriendWindowMap(jtf.getText(), ul);
			
			try {
				
				ObjectOutputStream oos=new ObjectOutputStream(ThreadMap.getThread(jtf.getText()).getSocket().getOutputStream());
				TextMessage tm2=new TextMessage(jtf.getText(),null,null,MessageType.OnlinefriendListMessage);
				oos.writeObject(tm2);			
			
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}					   
			this.dispose();		    
		}
	}
	else if(e.getSource()==jb_cancle){
		
	}
	else if(e.getSource()==jb_guide){
			
		}
	else if(e.getSource()==jb_clean){
		
	}
	
}
@Override
public void mouseClicked(MouseEvent e) {
 if(e.getSource()==jl_fpw){
		
	}
	else if(e.getSource()==jl_protect){
		
	}
	
}
@Override
public void mousePressed(MouseEvent e) {
	
	
}
@Override
public void mouseReleased(MouseEvent e) {
	
	
}
@Override
public void mouseEntered(MouseEvent e) {
	
	
}
@Override
public void mouseExited(MouseEvent e) {
	
	
}
}
