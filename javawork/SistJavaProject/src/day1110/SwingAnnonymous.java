package day1110;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAnnonymous extends JFrame {
	
	Container cp;
	JButton btnAdd,btndelete;
	JLabel lb1Result;
	
	public SwingAnnonymous(String title) {
		
		
		super(title);
		
		cp=this.getContentPane();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 닫기
		this.setBounds(500, 700, 500, 500); //int x int y int weidth int high (크기 조정)
		cp.setBackground(new Color(255,255,200)); //background 색 
		//this.setbackground로 하면 contentpane 때문에 겉에 pane이 있기에 색상이 안보임
		//cp.로 바꿔서 색을 입혀줘야 함
		
		//디자인호출
		initDesing();
		
		this.setVisible(true);
		
}
	
	public void initDesing()
	{
		//보더레이아웃이 기본...마음대로 레이아웃 null
		this.setLayout(null);
		
		JLabel lbl1=new JLabel("숫자1");
		JLabel lbl2=new JLabel("숫자2");
		
		JTextField tfsu1=new JTextField();
		JTextField tfsu2=new JTextField();
		
		btnAdd=new JButton("+");
		btndelete=new JButton("-");
		lb1Result=new JLabel("결과 나오는곳");
		
		lbl1.setBounds(50,50,80,30);
		lbl2.setBounds(50,100,80,30);
		
		tfsu1.setBounds(250,50,100,30);
		tfsu2.setBounds(250, 100, 100, 30);
		
		btnAdd.setBounds(150,150,200,30);
		btndelete.setBounds(150,180,200,30);
		lb1Result.setBounds(100,200,250,90);
		
		//글꼴변경
		lb1Result.setFont(new Font("",Font.BOLD,11));
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(tfsu1);
		this.add(tfsu2);
		this.add(btnAdd);
		this.add(btndelete);
		this.add(lb1Result);
		
		//버튼 이벤트...익명내부클래스 형식으로 만들기
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int su1=Integer.parseInt(tfsu1.getText());
				int su2=Integer.parseInt(tfsu2.getText());
				int sum=su1+su2;
				
				//lblResult에 출력
				String result=su1+"+"+su2+"="+sum;
				//라벨에 결과 출력
				lb1Result.setText(result);
			}
		});
		
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int su1=Integer.parseInt(tfsu1.getText());
				int su2=Integer.parseInt(tfsu2.getText());
				int delete=su1-su2;
				
				String sub=su1+"-"+su2+"="+delete;
				
				lb1Result.setText(sub);
				
				
			}
		});
	}

	public static void main(String[] args) {
		
		new SwingAnnonymous("익명내부클래스 이용하여 이벤트");
		
	}
}

