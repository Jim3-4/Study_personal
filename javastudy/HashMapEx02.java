package hash;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 지민
 * @date 2022. 3. 26. - 오후 10:53:44
 * @subject 
 * @content 
 * 
 */
public class HashMapEx02 {
public static void main(String[] args) {
	HashMap map=new HashMap();
	map.put("김자바", new Integer(100));
	map.put("이자바", new Integer(100));
	map.put("강자바", new Integer(80));
	map.put("안자바", new Integer(90));
	
	Set set =map.entrySet();
	Iterator it=set.iterator();
	
	while (it.hasNext()) {
		Map.Entry object = (Map.Entry) it.next();
		//System.out.println(object.getKey()+object.getValue());
	}
	set=map.keySet();
System.out.println(set);
Collection values=map.values();
it=values.iterator();

int total=0;
while (it.hasNext()) {
	Integer object = (Integer) it.next();
	total+=object.intValue();
}

}
}
