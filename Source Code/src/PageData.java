//P.L.B. Sampath - 100476M

//sub class of IndexData class
public class PageData extends IndexData{
	public String pageNo;
	
	//construction method
	public PageData(Keyword[] kws){
		super(kws);		//storing an sorted array of Keywords with 'pageNo' as the primary key
	}
	
	//showing a list of keywords of a given page('keywords' operation)
	public void showKeywords(){
		for(int i=startingKeywordIndex; i<=endingKeywordIndex; i++){
			System.out.print(keywords[i].keyword + " ");
		}
		System.out.println();
	}
	
	//adding starting array index of the keyword
	public void addStartingKW(int index, String pNo){
		startingKeywordIndex=index;
		pageNo = pNo;
	}
}
