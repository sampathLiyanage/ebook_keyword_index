//P.L.B. Sampath - 100476M

//a subclass of HeapSort class
//this considers 'keyword' as the primary key and 'pageNo' as the secondary key of Keyword objects
public class HeapSortByKeyword extends HeapSort{
	
	//construction method
	HeapSortByKeyword(){
		super();
	}
	
	//maxHeapify operation
	//does the operation considering 'keyword' as the primary key and 'pageNo' as the secondary
	public void maxHeapify(int i){
		int left, right, largest;
		Keyword temp;
		left=2*i;
		right=2*i+1;
		if(left<=heapSize){
			if(keywords[left].keyword.equalsIgnoreCase(keywords[i].keyword)){		//if keywords of the two Keyword objects are equal
				if(keywords[left].pageNo.compareTo(keywords[i].pageNo)>0){	//comparing pageNo of the Keyword objects
					largest=left;
				}
				else
					largest=i;
			}
			else if(keywords[left].keyword.compareToIgnoreCase(keywords[i].keyword)>0){
				largest=left;
			}
			else 
				largest = i;
		}
		
		else 
			largest =i;
		
		if(right<=heapSize){
			if(keywords[right].keyword.equalsIgnoreCase(keywords[largest].keyword)){	//if keywords of the two Keyword objects are equal
				if(keywords[right].pageNo.compareTo(keywords[largest].pageNo)>0){	//comparing pageNo of the Keyword object
					largest=right;
				}
			}
			else if(keywords[right].keyword.compareToIgnoreCase(keywords[largest].keyword)>0)
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
