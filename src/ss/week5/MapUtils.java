package ss.week5;

import java.util.*;

public class MapUtils {
	
	public static void main(String[] args){
		HashMap<String, Integer> testMap = new HashMap<String, Integer>();
		testMap.put("test", 12);
		testMap.put("test2", 3);
		testMap.put("test3", 6);
		testMap.put("test4", 9);
        HashMap<Integer, Double> testMap2 = new HashMap<Integer, Double>();
        testMap2.put(12, 1.0);
        testMap2.put(3, 2.0);
        testMap2.put(6, 3.0);
        testMap2.put(9, 4.0);

        System.out.println(new MapUtils().compose(testMap, testMap2));
	}
	
	public static <K,V> boolean isOneOnOne(HashMap<K, V> map){
		HashSet<V> tempSet = new HashSet<V>();
		
		for(V value : map.values()){
			if(!tempSet.add(value)){
				return false;
			}
		}
		return true;
	}

    public static <K,V, K2, V2> boolean compatible(HashMap<K, V> map1, HashMap<K2, V2> map2){
        for(V value : map1.values()){
            if(!map2.containsKey(value)){
                return false;
            }
        }
        return true;
    }

    public static <K,V, K2, V2> HashMap<K, V2> compose(HashMap<K, V> map1, HashMap<K2, V2> map2){
        HashMap<K, V2> returnMap = new HashMap<>();
        if(compatible(map1, map2)){
            for(Map.Entry<K, V> entry : map1.entrySet()){
                returnMap.put(entry.getKey(), map2.get(entry.getValue()));
            }
        }
        return returnMap;
    }

    public static <K> List<K> merge(List<K> list){
        LinkedList<K> sortedList = new LinkedList<>();
        return sortedList;
        //LinkedList no access to underlying nodes? What is the advantage of linkedlist over arraylist? (very slow sort implementation?)

    }

    private static <K> void getMiddle(LinkedList<K> list){
    }
}
