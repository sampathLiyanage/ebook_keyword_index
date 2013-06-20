//P.L.B. Sampath - 100476M

//an abstract class
public abstract class HeapSort {
	protected int length, heapSize;
	protected Keyword[] keywords;
	
	//construction methosd
	HeapSort(){
		length=0;
		heapSize=0;
	}
	
	//sorting the array given as argument
	//this sorts the array from 1st index to last. the '0'th index is not considered
	public void sort(Keyword[] kws){
		keywords=kws;
		length=keywords.length-1;
		heapSize=length;
		heapSort();
	}
	
	//maxHeapify operation is to be implemented
	abstract void maxHeapify(int i);
	
	//buildMaxHeap operation
	private void buildMaxHeap(){
		heapSize=length;
		for (int i=length/2; i>0 ;i--){
			maxHeapify(i);
		}
	}
	
	//heapSort operation
	void heapSort(){
		Keyword temp;
		buildMaxHeap();
		for(int i=length; i>1; i--){
			temp=keywords[1];
			keywords[1]=keywords[i];
			keywords[i]=temp;
			heapSize--;
			maxHeapify(1);
			
		}
	}
}
