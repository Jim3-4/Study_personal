package hash;

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
	static HashMap phoneBook=new HashMap();
public static void main(String[] args) {
	addPhoneNo("친구","이자바","010-111-11111");
	addPhoneNo("친구","김자바	","2");
	addPhoneNo("친구","김자바","010-3-");
	addPhoneNo("회사","이과장","010-3");
	addPhoneNo("회사","김대리","010-4");
	addPhoneNo("회사","박대리","010-6");
	addPhoneNo("회사","김대리","010-5");
	addPhoneNo("세탁","010-8");
	
	printList();
}//main
static void addPhoneNo(String groupName, String name, String tel) {
	addGroup(groupName);
	HashMap group=(HashMap)phoneBook.get(groupName);
	group.put(tel, group);
}

private static void addGroup(String groupName) {
	// TODO Auto-generated method stub
	if(!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap());
	}
}
static void addPhoneNo(String name, String tel) {
	addPhoneNo("기타", name, tel);
	
}
static void printList() {
	Set set=phoneBook.entrySet();
	Iterator it=set.iterator();
	
	while (it.hasNext()) {
		Map.Entry e =( Map.Entry) it.next();
		Set subSet=((HashMap)e.getValue()).entrySet();
		Iterator subIt=subSet.iterator();
		while (subIt.hasNext()) {
			Map.Entry subE = (Map.Entry) subIt.next();
			String telNo= (String)subE.getKey();
			String name=(String)subE.getValue();
			System.out.println(name+" "+telNo);
		}
		System.out.println();
	}
}
	

}//class
