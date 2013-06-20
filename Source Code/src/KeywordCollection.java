//P.L.B. Sampath - 100476M

public class KeywordCollection extends SortedCollection{
	
	//construction method
	public KeywordCollection(int noOfKeyWords){
		super(noOfKeyWords);
	}
	
	//implementing abstract sort method of super class
	//sorting Keyword objects in keywords array with 'keyword' as the primary key and 'pageNo' as the secondary key
	public void sort(){
		HeapSortByKeyword hs = new HeapSortByKeyword();
		hs.sort(keywords);	
		store();
	}
	
	//implementing abstract store method of super class
	//storing KeywordData objects in a StrKeyHashTable with 'keyword' as the key
	public void store(){
		//counting no of different keywords
		int count=1;
		for(int i=1; i<noOfKeywords; i++){
			if(!(keywords[i].keyword.equalsIgnoreCase(keywords[i+1].keyword))){		//if keywords of near Keyword objects are different
				count++;
			}
		}
		
		skHashtable= new StrKeyHashTable(count);	//new StrKeyGashTable with size of no of different keywords
		
		//making KeywordData objects and adding the objects to skHashtable
		KeywordData kwD= new KeywordData(keywords);
		kwD.addStartingKW(1, keywords[1].keyword);		//adding first keyword index to a KeywordData object
	
		int j;
		for(j=1; j<noOfKeywords; j++){
			if(!(keywords[j].keyword.equalsIgnoreCase(keywords[j+1].keyword))){	//if keywords of near Keyword objects are different
				kwD.addEndingKW(j);
				skHashtable.add(kwD, kwD.keyword);		//adding a KeywordData object to skHashtable
				kwD= new KeywordData(keywords);
				kwD.addStartingKW(j+1, keywords[j+1].keyword);
			}
		}
		kwD.addEndingKW(j);		//adding last keyword index to a KeywordData object
		skHashtable.add(kwD,kwD.keyword);		//adding last KeywordData object to skHashtable
	}
	
	//for "list" operation
	public void showList(String kw){
		kw=kw.toLowerCase();		//converting to lower case
		if(skHashtable.get(kw)!=null)		//if keyword is available in skHashtable
			((KeywordData) skHashtable.get(kw)).showList();		//show list of page numbers
		else
			System.out.println("Invalid Keyword");
	}
	
	//for "first" operation
	public void showFirst(String kw){
		kw=kw.toLowerCase();		//converting to lower case
		if(skHashtable.get(kw)!=null)		//if keyword is available in skHashtable
			((KeywordData) skHashtable.get(kw)).showFirst();		//show first page No
		else
			System.out.println("Invalid Keyword");
	}
}
