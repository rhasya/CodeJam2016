import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
Getting the Digits

URL
https://code.google.com/codejam/contest/11254486/dashboard#s=p0
*/
public class Round1B1 {

	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new File("C:\\Users\\rhasy\\Downloads\\CodeJam2016_1RB\\A-small-attempt4.in"));
		Scanner sc = new Scanner(new File("C:\\Users\\rhasy\\Downloads\\CodeJam2016_1RB\\A-large.in"));
		// Scanner sc = new Scanner(new File("small1.in"));
		// PrintWriter pw = new PrintWriter(new File("C:\\Users\\rhasy\\Downloads\\CodeJam2016_1RB\\small1.out"));
		PrintWriter pw = new PrintWriter(new File("C:\\Users\\rhasy\\Downloads\\CodeJam2016_1RB\\large1.out"));
		
		String[] words = {"FOUR", "SIX", "EIGHT", "ZERO", "TWO", "FIVE", "SEVEN", "NINE", "THREE", "ONE"};
		int[] nums = {4, 6, 8, 0, 2, 5, 7, 9, 3, 1};
		
		int T = sc.nextInt();
		sc.nextLine();
		for (int x = 1; x <= T; x++) {
			String s = sc.nextLine();
			ArrayList<Integer> y = new ArrayList<Integer>();
			 
			ArrayList<Character> arr = new ArrayList<Character>();
			for (int i = 0; i < s.length(); ++i) {
				arr.add(s.charAt(i));
			}
			
			// GET ZERO
			int order = 0;
			while (order < 10) {
				String w0 = words[order];
				int[] idx = new int[w0.length()];
				for (int i = 0; i < w0.length(); ++i) {
					idx[i] = arr.indexOf(w0.charAt(i));
					if (idx[i] == -1) {
						idx[0] = -1;
						break;
					}
				}
				
				if (idx[0] != -1) {
					for (int i = 0; i < w0.length(); ++i) {
						arr.remove(arr.indexOf(w0.charAt(i)));
					}
					y.add(nums[order]);
				}
				else {
					order++;
				}
			}
			
			Collections.sort(y);
						
			// System.out.println(y);
			pw.print("Case #" + x + ": ");
			y.forEach((n) -> pw.print(n));
			pw.println();
		} 
		
		pw.close();
		sc.close();
	}
}
