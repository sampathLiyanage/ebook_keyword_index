//P.L.B. Sampath - 100476M

//a hash table for any object with a String key
public class StrKeyHashTable {
	private Element[] elements;
	private int noOfElements;
	
	//an inner class
	//this type of objects are stored in hashtable
	class Element{
		//construction method
		Element(Object o, String k){
			obj=o;
			key=k;
		}
		
		Object obj;
		String key;
		Element next;		//for chaining
	}
	
	//construction method
	public StrKeyHashTable(int noOfEmt){
		noOfElements=noOfEmt;		//noOfElements that are to be stored in hashtable
		elements = new Element[noOfElements];
	}
	
	//mapping a given key to a hash key
	private int mapKey(String key){
		//hash function
		int len=key.length();
		char[] ch = new char[len];
		int temp;
		ch=key.toCharArray();
		temp=0;
		for(int i=len-1; i>=0; i--){
			temp=temp*31+(ch[len-i-1]);
		}
		return Math.abs(temp)%noOfElements;
	}
	
	//adding an object to the hashtable
	public void add(Object o, String key){
		int mappedKey = mapKey(key);
		Element ele = new Element(o,key);
		Element temp=elements[mappedKey];
		if (temp==null)		//if no collision occurs
			elements[mappedKey]=ele;
		else{		//if collision occurs
			while(true){
				if (temp.next==null){
					temp.next=ele;
					break;
				}
				temp=temp.next;
			}
		}
	}
	
	public Object get(String kw){
		Element temp = elements[mapKey(kw)];
		while(temp!=null){		//till reaching the last element of the list for collisions
			if(temp.key.equals(kw))
				break;
			temp=temp.next;
		}
		if (temp==null)		//if there is no such key in the table return null
			return null;
		return temp.obj;		//if object of the key is found return it
	}
}
