package hash;

import java.lang.Character.Subset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 지민
 * @date 2022. 3. 26. - 오후 11:18:24
 * @subject 
 * @content 
 * 
 */
public class HashMapex3 {

public static void main(String[] args) {

	String[] data= {"a","k", "a","k","d","k","a", "k","k","z","d"};
	HashMap map=new HashMap();
	for (int i = 0; i < data.length; i++) {
		if(map.containsKey(data[i])) {
			Integer value=(Integer)map.get(data[i]);
			map.put(data[i], new Integer(value.intValue()+1));
		}else {
			map.put(data[i], new Integer(1));
		}
		
	}
	Iterator it=map.entrySet().iterator();
	while (it.hasNext()) {
		Map.Entry entry=(Map.Entry) it.next();
		int  value=((Integer)entry.getValue()).intValue();
		System.out.println(entry.getKey()+":"+printBar('#', value)+""+value);
	}
	
	
}//main

private static String printBar(char c, int value) {
	char[] bar=new char[value];
	for (int i = 0; i < bar.length; i++) {
		bar[i]=c;
	}
	return new String(bar);
}
}//class
