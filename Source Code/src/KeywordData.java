//P.L.B. Sampath - 100476M

//sub class of IndexData class
public class KeywordData extends IndexData{
	public String keyword;
	
	//construction method
	public KeywordData(Keyword[] kws){
		super(kws);		//storing an sorted array of Keywords with 'keyword' as the primary key
	}
	
	//adding starting array index of the keyword
	public void addStartingKW(int index, String kw){
		startingKeywordIndex=index;
		keyword = kw.toLowerCase();		//converting keyword to lower case
	}
	
	//showing a list of page numbers that contain keyword given in a query
	public void showList( ){
		for(int i=startingKeywordIndex; i<=endingKeywordIndex; i++){
			System.out.print(keywords[i].pageNo + " ");
		}
		System.out.println();
	}
	
	//showing the first page number that contains keyword given in a query
	public void showFirst( ){
		System.out.println(keywords[startingKeywordIndex].pageNo + " ");
	}
}
