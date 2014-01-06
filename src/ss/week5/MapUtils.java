package ss.week5;

import java.util.HashMap;
import java.util.HashSet;

public class MapUtils {
	
	public static void main(String[] args){
		HashMap<String, Integer> testMap = new HashMap<String, Integer>();
		testMap.put("test", 12);
		testMap.put("test2", 3);
		testMap.put("test3", 6);
		testMap.put("test4", 9);

		System.out.println(new MapUtils().isOneOnOne(testMap));
	}
	
	public <K,V> boolean isOneOnOne(HashMap<K, V> map){
		HashSet<V> tempSet = new HashSet<V>();
		
		for(V value : map.values()){
			if(!tempSet.add(value)){
				return false;
			}
		}
		return true;
	}
}
