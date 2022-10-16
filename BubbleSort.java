import java.util.*;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> unsorted = new ArrayList<>();
		for(int i = 0; i < 11; i++) {
			System.out.print("Enter a value for the list: ");
			unsorted.add(sc.nextInt());
		}
		System.out.print(sort(unsorted));
	}

	public static ArrayList<Integer> sort(ArrayList<Integer> list) {
		boolean sorted = false;
		int swaps = 0;
		int temp;
		while(!sorted) {
			swaps = 0;
			for(int i= 0; i < list.size()-1; i++) {
				if(list.get(i) > list.get(i+1)) {
					temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					swaps += 1;
				}
			}
			if(swaps == 0) {
				sorted = true;
			}
		}
		return list;
	}
}