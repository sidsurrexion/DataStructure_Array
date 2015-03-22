import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayVerify {
	public static Boolean verify(StringTokenizer stringtokenizer){
		Boolean bool = true, flag = true, check = false;
		int n = 0, i = 0;
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
				bool = false;
				break;
			}
		}
		if (flag == true){
			stringtokenizer = null;
			less_string = null;
			stringtokenizer = new StringTokenizer(string, " ");
			int[] list = new int[i];
			while(stringtokenizer.hasMoreTokens()){
				less_string = stringtokenizer.nextToken();
				list[n] = Integer.parseInt(less_string);
				n++;
			}
			ArrayTraversal(list);
		}
		return bool;
	}
	
	private static void ArrayTraversal(int list[]){
		System.out.println("Enter the number whose index is to be found");
		NumberSearch(list);
	}
	
	private static void NumberSearch(int list[]){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		String string = null, set = null;
		string = scanner.nextLine();
		StringTokenizer stringtokenizer = new StringTokenizer(string, " ");
		while(stringtokenizer.hasMoreTokens()){
			set = stringtokenizer.nextToken();
			try{
				n = Integer.parseInt(set);
				for(int i = 0; i < list.length; i++){
					if (list[i] == n){
						System.out.println("The index of the number " + n + " is: "+i);
						break;
					}
				}
			} catch (Exception e){
				System.out.println(set + "The string is not a digit");
			}
		}
	}
}
