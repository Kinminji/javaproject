package day1107;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex6Map {

	public static void main(String[] args) {
		// Map은 키(key)와 값(value)의 쌍으로 저장
		//key는 중복 불가
		Map<String, String> map=new HashMap<String, String>();
		
		//put으로 담고 get으로 가져온다
		map.put("name", "이효리");
		map.put("addr", "서울시 강남구");
		map.put("age", "26세");
		//중복된키
		map.put("name", "유재석"); //이전 키값에 덮어씌워짐
		
		System.out.println("key값 size: "+map.size());
		System.out.println();
		
		System.out.println("key값을 정확하게 알면 value를 얻을 수 있다.");
		System.out.println("이름: "+map.get("name"));
		System.out.println("주소: "+map.get("addr"));
		System.out.println("나이: "+map.get("age"));
		
		//맵에 없는 키값으로 얻으려면 null을 얻는다.
		System.out.println("도시: "+map.get("city"));
		System.out.println();
		
		System.out.println("**key값을 먼저 한꺼번에 얻을 후 값을 출력하는 방법**");
		Set<String> keyset=map.keySet();

		System.out.println("방법#1_Iterator");
		Iterator<String> keyIter=keyset.iterator();
		while(keyIter.hasNext())
		{
			String key=keyIter.next();
			System.out.println(key+"==>"+map.get(key));
		}
		
		System.out.println("방법#2_for~each");
		for(String key:keyset)
			System.out.println(key+"==>"+map.get(key));
	}

}
