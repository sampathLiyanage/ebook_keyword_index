//P.L.B. Sampath - 100476M

//for storing keyword and pageNo of each input
public class Keyword {
	public String keyword, pageNo;
	
	//construction method
	//stores 'keyword' and 'pageNo' of a query in input file
	public Keyword(String aKeyword, String aPageNo){
		keyword=aKeyword;
		pageNo=aPageNo;
	}
	
	public String getKeyword(){
		return keyword;
	}
	
	public String getPageNo(){
		return pageNo;
	}
}
