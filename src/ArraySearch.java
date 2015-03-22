import java.util.Scanner;
import java.util.StringTokenizer;

public class ArraySearch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader();		
	}
	
	private static void InputReader(){
		System.out.println("Enter the numbers: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		String string = scanner.nextLine();
		StringTokenizer stringtokenizer = new StringTokenizer(string, " ");
		if (ArrayVerify.verify(stringtokenizer)){
		
		} else {
			InputReader();
		}
	}

}
