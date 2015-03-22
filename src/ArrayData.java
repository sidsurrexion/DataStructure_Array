import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayData {
	static ArrayCollector arraycollector = new ArrayCollector();
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		arraycollector = DataSelection();
		SelectOptions(arraycollector);		
	}
	
	private static ArrayCollector DataSelection(){
		System.out.println("Enter the numbers:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		StringTokenizer stringtokenizer = new StringTokenizer(string, ",:;. ");
		arraycollector = ArrayDataInsertion.InsertInitialData(stringtokenizer);
		if(arraycollector.bool == false){
			System.out.println("Incorrect entries provided by the user");
			arraycollector = DataSelection();
		}
		return arraycollector;
	}
	
	private static void SelectOptions(ArrayCollector arraycollector){
		ArrayCollector collector = new ArrayCollector();
		System.out.println("Select from the below options: ");
		System.out.println("1. Insert");
		System.out.println("2. Display");
		System.out.println("3. Find");
		System.out.println("4. Delete");
		System.out.println("5. Sort");
		System.out.println("6. Exit");
		System.out.println("");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		System.out.println("");
		StringTokenizer stringtokenizer = new StringTokenizer(string, ",:;. ");
		collector = SelectionVerification.verify(stringtokenizer);
		if (collector.bool == false){
			System.out.println("Please enter the correct option");
			SelectOptions(arraycollector);
		} else {
			arraycollector.n = collector.n;
			switch(arraycollector.n){
			case 1:
				arraycollector = ArrayComputation.Insert(arraycollector);
				System.out.println("");
				SelectOptions(arraycollector);
			case 2:
				ArrayComputation.Display(arraycollector);
				System.out.println("");
				SelectOptions(arraycollector);
			case 3:
				arraycollector = ArrayComputation.Find(arraycollector);
				if (arraycollector.number_index == -1){
					System.out.println("The number does not exist");
				} else {
					System.out.println("The index of the number "+arraycollector.add_entry+" is: "+arraycollector.number_index);
				}				
				System.out.println("");
				SelectOptions(arraycollector);
			case 4:
				arraycollector = ArrayComputation.Delete(arraycollector);
				System.out.println("");
				SelectOptions(arraycollector);
			case 5:
				arraycollector = ArrayComputation.Sort(arraycollector);
				System.out.println("");
				SelectOptions(arraycollector);
			case 6:
				System.exit(0);
			}
		}
	}
}
