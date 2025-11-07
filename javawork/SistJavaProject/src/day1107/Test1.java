package day1107;

import java.util.ArrayList;

public class Test1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] name= {"박성진","강영현","김원필","윤도운"};
		
		ArrayList<String> st=new ArrayList<String>();
		
		for(String na:name)
		{
			st.add(na);
		}
		System.out.println(st.size()+"개");
		
		for(int i=0;i<st.size();i++) {
			String s=st.get(i);
			System.out.println(s);
		}
		
	}

}
