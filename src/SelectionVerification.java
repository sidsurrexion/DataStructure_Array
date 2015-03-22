import java.util.StringTokenizer;

public class SelectionVerification {
	public static ArrayCollector verify(StringTokenizer stringtokenizer){
		ArrayCollector arraycollector = new ArrayCollector();
		int i = 0;
		String string;
		while(stringtokenizer.hasMoreTokens()){
			i++;
			if(i > 1){
				arraycollector.bool = false;
				break;
			}			
			string = stringtokenizer.nextToken();
			try{
				arraycollector.n = Integer.parseInt(string);
			} catch (Exception e){
				arraycollector.bool = false;
				break;
			}
		}
		return arraycollector;
	}
}	
