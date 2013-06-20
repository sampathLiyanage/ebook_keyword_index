//P.L.B. Sampath - 100476M

//a subclass of HeapSort class
//this considers 'pageNo' as the primary key and 'keyword' as the secondary key of Keyword objects
public class HeapSortByPageNo extends HeapSort{
	
	//construction method
	HeapSortByPageNo(){
		super();
	}
	
	//maxHeapify operation
	//does the operation considering 'pageNo' as the primary key and 'keyword' as the secondary
	void maxHeapify(int i){
		int left, right, largest;
		Keyword temp;
		left=2*i;
		right=2*i+1;
		if(left<=heapSize){
			if(keywords[left].pageNo.equals(keywords[i].pageNo)){	//if page numbers of the two Keyword objects are equal
				if(keywords[left].keyword.compareTo(keywords[i].keyword)>0){	//comparing keywords of the Keyword objects
					largest=left;
				}
				else
					largest=i;
			}
			else if(keywords[left].pageNo.compareTo(keywords[i].pageNo)>0){
				largest=left;
			}
			else 
				largest = i;
		}
		
		else 
			largest =i;
		
		if(right<=heapSize){
			if(keywords[right].pageNo.equals(keywords[largest].pageNo)){	//if page numbers of the two Keyword objects are equal
				if(keywords[right].keyword.compareTo(keywords[largest].keyword)>0){	//comparing keywords of the Keyword objects
					largest=right;
				}
			}
			else if(keywords[right].pageNo.compareTo(keywords[largest].pageNo)>0)
				largest=right;
		}
		
		if (largest!=i){
			temp=keywords[i];
			keywords[i]=keywords[largest];
			keywords[largest]=temp;
			maxHeapify(largest);
		}
	}
	
	
	
}
