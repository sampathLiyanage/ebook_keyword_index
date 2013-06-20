//P.L.B. Sampath - 100476M

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class EBookBrowser {
	
private static PageCollection pageCollection;
private static KeywordCollection kwCollection;
	
	public static void main(String args[]) throws IOException{
		EBookBrowser ebookBrowser = new EBookBrowser();
		BufferedReader input = new BufferedReader(new FileReader("input.txt"));
		String line,keyword,instruction, operand;
		String pageNo;
		int noOfKeywords=0;
		char[] lineChars = new char[20];
		
		//counting no of keywords of the input
		while((line=input.readLine())!=null){
			if (line.equals("Keyword List Start")){
				while(!(line=input.readLine()).equals("Keyword List End")){
					noOfKeywords++;
				}
			break;
			}
		}
		
		
		BufferedReader input1 = new BufferedReader(new FileReader("input.txt"));
		pageCollection = new PageCollection(noOfKeywords);
		kwCollection= new KeywordCollection(noOfKeywords);
		
		//getting input of the input text file
		while((line=input1.readLine())!=null){
			
			//adding data to memory
			if (line.equals("Keyword List Start")){		//if start of the keyword list reaches
				while(!(line=input1.readLine()).equals("Keyword List End")){		//till end of the keyword list reaches
					lineChars = line.toCharArray();		//getting char array of the string in a line
					for(int i=0; i<line.length(); i++){
						//Dividing line string to two strings to get the 'keyword' and 'page no'
						if(lineChars[i]=='\t'){
							keyword=line.substring(0, i);
							pageNo= line.substring(i+1);
							Keyword temp = new Keyword(keyword, pageNo);		//creating keyword object
							kwCollection.addKeyword(temp);			//adding keyword object to keywordCollection
							pageCollection.addKeyword(temp);		//adding the keyword object to pageCollection
						}
					}
				}
				
			}
			
			
			
			//reading queries
			if (line.equals("Queries Start")){			//if start of the Queries reaches
				while(!(line=input.readLine()).equals("Queries End")){		//till end of Queries reaches
					lineChars = line.toCharArray();		//getting char array of the string in a line
					//Dividing line string to two strings to get the 'instruction' and 'operand'
					for(int i=0; i<line.length(); i++){
						if(lineChars[i]==' '){
							instruction=line.substring(0, i);
							operand= line.substring(i+1);
							ebookBrowser.execute(instruction, operand);		//calling for executing the instruction
						}
					}
				}
			}
		}
	}
	
	
	//Executing queries
	
	//"Keywords" operation
	public void keywords(String pageNo){
		pageCollection.showPage(pageNo);
	}
	
	//"First" operation
	public void first(String keyword){
		kwCollection.showFirst(keyword);
	}
	
	//"List" operation
	public void list(String keyword){
		kwCollection.showList(keyword);
	}
	
	//execution queries
	public void execute(String instruction, String operand){
		if(instruction.equals("Keywords"))
			keywords(operand);
		if(instruction.equals("First"))
			first(operand);
		if(instruction.equals("List"))
			list(operand);
	}
}
