package day1107;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.w3c.dom.NameList;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] name= {"박성진","강영현","김원필","윤도운"};
		
		ArrayList<String> st=new ArrayList<String>();

		for(int i=0;i<name.length;i++)
		{
			st.add(name[i]);
		}
		System.out.println("데이터의 갯수: "+st.size());
		
		for(int i=0;i<name.length;i++)
		{
			String s=name[i];
			System.out.println(s);
		}
		
	}

}
