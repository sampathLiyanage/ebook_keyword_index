//P.L.B. Sampath - 100476M

//storing two array indexes - starting index and ending index of same keyword
public class IndexData {
	public int startingKeywordIndex, endingKeywordIndex;		
	public Keyword[] keywords;
	
	//construction method
	public IndexData(Keyword[] kws){
		keywords=kws;
	}
	
	public int getNoOfData(){
		return endingKeywordIndex-startingKeywordIndex; 
	}
	
	public void addStartingKW(int index, int pNo){
		startingKeywordIndex=index;
	}
	
	public void addEndingKW(int index){
		endingKeywordIndex=index;
	}
}
