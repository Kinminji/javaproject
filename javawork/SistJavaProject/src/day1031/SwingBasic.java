package day1031;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingBasic extends JFrame{

	//버튼
	JButton btn1;
		
	//변수
	Container cp;
	
	
	//생성
	public SwingBasic(String title) {
		
		super(title);
		cp=this.getContentPane(); //content 컬러, 
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 닫기
		this.setBounds(200, 100, 500, 300); //int x int y int weidth int high (크기 조정)
		cp.setBackground(new Color(102,153,102)); //background 색 
		//this.setbackground로 하면 contentpane 때문에 겉에 pane이 있기에 색상이 안보임
		//cp.로 바꿔서 색을 입혀줘야 함
		
		
		//버튼 생성
		btn1=new JButton("Button1");
		
		//프레임에 버튼 추가 _ BorderLayout이 기본
		this.add("North", btn1); //첫글자 무조건 대문자
		this.add("South", new JButton("아래쪽"));
		this.add("East", new JButton("오른쪽"));
		this.add("West", new JButton("왼쪽"));
		this.add("Center", new JButton("가운데"));
		
		
		//버튼1에 속성
		btn1.setBackground(Color.yellow);
		btn1.setForeground(Color.BLUE);
		
		
		
		this.setVisible(true); // 무조건 제일 아래에 있어야 한다.
		
	}
	
	public static void main(String[] args) {
		
		new SwingBasic("스윙연습_1");

	}

}
