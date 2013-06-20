//P.L.B. Sampath - 100476M

//an abstract class for sorting collection of Keyword objects
public abstract class SortedCollection {
	protected Keyword[] keywords;		//for storing Keyword objects 
			//'0'th bit of keywords array is not used
	protected StrKeyHashTable skHashtable;		//for storing KeywordData objects with 'keyword' as the key
	protected int noOfKeywords, size;		//size=no of Keyword objects added
	
	//construction method
	public SortedCollection(int noOfKeyWords){
		noOfKeywords=noOfKeyWords;
		keywords=new Keyword[noOfKeyWords+1];		//making a new Keyword array with a size of (no Of keywords+1)
		size=1;		//make next Keyword object to be added to 1st bit of keywords array
	}
	
	//adding Keyword object to keywords array
	public void addKeyword(Keyword aKeyword){
		keywords[size]=aKeyword;
		if(size==noOfKeywords){		//if last Keyword object is added
			sort();
			store();
		}
		size++;
	}
	
	//an abstract method for sorting keywords
	public abstract void sort();
	
	//an abstract method for storing data in a proper manner
	public abstract void store();
}
