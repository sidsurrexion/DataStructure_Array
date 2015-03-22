import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayComputation {
	public static ArrayCollector Insert(ArrayCollector arraycollector){
		ArrayCollector collector = new ArrayCollector();
		System.out.print("Enter the number you want to insert: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		StringTokenizer stringtokenizer = new StringTokenizer(string, ";:,. ");
		collector = SelectionVerification.verify(stringtokenizer);
		if(collector.bool == false){
			System.out.println("Enter only an integer");
			Insert(arraycollector);
		} else{
			int l = arraycollector.list.length;
			int[] new_collector = new int[l + 1];
			for(int i = 0; i <= arraycollector.list.length - 1; i++){
				new_collector[i] = arraycollector.list[i];
			}
			new_collector[l] = collector.n;
			arraycollector.list = new int[l+1];
			arraycollector.list = new_collector;
		}		
		return arraycollector;
	}
	public static ArrayCollector Delete(ArrayCollector arraycollector){
		ArrayCollector collector = new ArrayCollector();
		int n = -1;
		System.out.print("Enter the number you want to delete: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		StringTokenizer stringtokenizer = new StringTokenizer(string, ";:,. ");
		collector = SelectionVerification.verify(stringtokenizer);
		if (collector.bool == false){
			System.out.println("Enter a valid integer");
			System.out.println("");
			Delete(arraycollector);
		} else{
			arraycollector.n = collector.n;
			arraycollector.flag = false;
			arraycollector = Find(arraycollector);
			if (arraycollector.number_index == -1){
				System.out.println("The number does not exist in the list");
			} else{
				int[] new_arraycollector = new int[arraycollector.list.length - 1];
				for(int i = 0; i <= arraycollector.list.length - 1; i++){
					if (i != arraycollector.number_index){					
						n++;
						new_arraycollector[n] = arraycollector.list[i];
					}
				}
				arraycollector.list = new int[new_arraycollector.length - 1];
				arraycollector.list = new_arraycollector;
			}
		}
		return arraycollector;
	}
	public static ArrayCollector Find(ArrayCollector arraycollector){
		Boolean bool = true;
		ArrayCollector collector = new ArrayCollector();
		if(arraycollector.flag == true){
			System.out.print("Enter the number you want to find: ");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String string = scanner.nextLine();
			StringTokenizer stringtokenizer = new StringTokenizer(string, ";:,. ");
			collector = SelectionVerification.verify(stringtokenizer);
		} else {
			collector.n = arraycollector.n;
			arraycollector.flag = true;
		}
		if (collector.bool == false){
			System.out.println("Enter a valid integer");
			Find(arraycollector);
		} else{
			for (int i = 0; i < arraycollector.list.length; i++){
				if(arraycollector.list[i] == collector.n){
					arraycollector.add_entry = collector.n;
					arraycollector.number_index = i;
					bool = false;
					break;					
				}
			}
		}
		if (bool == true){
			arraycollector.number_index = -1;
		}
		return arraycollector;
	}
	public static void Display(ArrayCollector arraycollector){
		for (int i = 0; i < arraycollector.list.length; i++){
			System.out.println(arraycollector.list[i]);
		}		
	}	
	public static ArrayCollector Sort(ArrayCollector arraycollector){
		Boolean bool = true;
		int temp = 0;
		for (int i = 0; i < arraycollector.list.length - 1; i++){
			if (arraycollector.list[i] > arraycollector.list[i+1]){
				temp = arraycollector.list[i];
				arraycollector.list[i] = arraycollector.list[i+1];
				arraycollector.list[i+1] = temp;
				temp = 0;
				if (bool == true){
					bool = false;
				}
			}
		}
		if (bool == false){
			Sort(arraycollector);
		}
		return arraycollector;
	}
}
