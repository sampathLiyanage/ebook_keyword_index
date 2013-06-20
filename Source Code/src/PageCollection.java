//P.L.B. Sampath - 100476M

public class PageCollection extends SortedCollection{
	
	//construction method
	public PageCollection(int noOfKeyWords){
		super(noOfKeyWords);
	}
	
	//implementing abstract sort method of super class
	//sorting Keyword objects in keywords array with 'pageNo' as the primary key and 'keyword' as the secondary key
	public void sort(){
		HeapSortByPageNo hs = new HeapSortByPageNo();
		hs.sort(keywords);
		store();
	}
		
	//implementing abstract store method of super class
	//storing KeywordData objects in a StrKeyHashTable with 'pageNo' as the key
	public void store(){
		//counting no of different keywords
		int count=1;
		for(int i=1; i<noOfKeywords; i++){
			if(!(keywords[i].pageNo.equals(keywords[i+1].pageNo))){		//if pageNos of near Keyword objects are different
				count++;
			}
		}
		
		skHashtable= new StrKeyHashTable(count);		//new StrKeyGashTable with size of no of different keywords
		
		//making PageData objects and adding the objects to skHashtable
		PageData kwD= new PageData(keywords);
		kwD.addStartingKW(1, keywords[1].pageNo);		//adding first keyword index to a PageData object
	
		int j;
		for(j=1; j<noOfKeywords; j++){
			if(!(keywords[j].pageNo.equals(keywords[j+1].pageNo))){		//if pageNos of near Keyword objects are different
				kwD.addEndingKW(j);
				skHashtable.add(kwD, kwD.pageNo);		//adding a PageData object to skHashtable
				kwD= new PageData(keywords);
				kwD.addStartingKW(j+1, keywords[j+1].pageNo);
			}
		}
		kwD.addEndingKW(j);		//adding last keyword index to a KeywordData object
		skHashtable.add(kwD,kwD.pageNo);		//adding last PageData object to skHashtable
	}
	
	//for "keywords" operation
	public void showPage(String pageNo){
		if(skHashtable.get(pageNo)!=null)		//if keyword is available in skHashtable
			((PageData) skHashtable.get(pageNo)).showKeywords();		//show list of keywords of the page
		else
			System.out.println("Invalid Page Number");
	}
}
