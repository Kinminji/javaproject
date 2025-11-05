package day1104;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEvent extends JFrame implements ActionListener{
	
	Container cp;
	JButton btn1, btn2;
	
	public SwingEvent(String title) {
		// TODO Auto-generated constructor stub
		
		super(title);
		
		cp=this.getContentPane();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 닫기
		this.setBounds(200, 100, 500, 300); //int x int y int weidth int high (크기 조정)
		this.getContentPane().setBackground(new Color(255,255,200)); //background 색 
		//this.setbackground로 하면 contentpane 때문에 겉에 pane이 있기에 색상이 안보임
		//cp.로 바꿔서 색을 입혀줘야 함
		
		//디자인호출
		initDesing();
		
		this.setVisible(true);
		
}
	
	//디자인
	public void initDesing() {
		
		//기본디자인은 boarderLayout이므로 FlowLayout으로 변경
		this.setLayout(new FlowLayout()); //레이아웃을 나란히 두겠다.
		
		//버튼생성
		btn1=new JButton("배경색을 핫핑크로 변경");
		btn2=new JButton("배경색을 회색으로 변경");
		
		//프레임에 추가
		this.add(btn1);
		this.add(btn2);
		
		//btn1,btn2에 이벤트를 표시
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingEvent("스윙이벤트 연습_#1");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob=e.getSource();
		
		if(ob==btn1)
		{
			//프레임의 배경색을 바꾸기
			cp.setBackground(Color.magenta);
		}
		if(ob==btn2)
		{
			cp.setBackground(Color.gray);
		}
	}

}
