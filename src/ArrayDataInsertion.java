import java.util.StringTokenizer;


public class ArrayDataInsertion {
	public static ArrayCollector InsertInitialData(StringTokenizer stringtokenizer){
		Boolean flag = true, check = false;
		ArrayCollector arraycollector = new ArrayCollector();
		int i = 0;
		String string = null, less_string = null;
		while(stringtokenizer.hasMoreTokens()){
			i++;
			less_string = stringtokenizer.nextToken();
			try{
				Integer.parseInt(less_string);
				if (check == false){
					string = less_string;
					check = true;
				} else {
					string = string + " " + less_string;
				}				
								
			} catch (Exception e){
				flag = false;
				arraycollector.bool = false;
				break;
			}
		}
		if (flag == true){
			stringtokenizer = null;
			less_string = null;
			stringtokenizer = new StringTokenizer(string, " ");
			arraycollector.list = new int[i];
			while(stringtokenizer.hasMoreTokens()){
				less_string = stringtokenizer.nextToken();
				arraycollector.index++;
				arraycollector.list[arraycollector.index] = Integer.parseInt(less_string);				
			}
		}
		return arraycollector;
	}
}
