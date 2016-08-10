import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Counting Sheep

Problem URL
https://code.google.com/codejam/contest/6254486/dashboard#s=p0
*/
public class Round1_A {

	public static void main(String[] args) throws FileNotFoundException  {
		Scanner sc = new Scanner(new File("C:\\Users\\rhasy\\Downloads\\A-large.in"));
		//Scanner sc = new Scanner(new File("large.in"));
		
		int T = sc.nextInt();
		for (int x = 1; x <= T; ++x) {
			// Read Problem;
			int N = sc.nextInt();
			
			// make array
			int[] arr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			
			// repeat
			boolean solve1 = false;
			long p = N;
			
			// 100 times?
			for (int i = 0; i < 1000; ++i) {
				String s = String.valueOf(p);
				for (int j = 0; j < s.length(); ++j) {
					int idx = Integer.parseInt(s.substring(j, j + 1));
					arr[idx] = 1;
				}
				
				boolean solve = true;
				for (int j = 0; j < arr.length; ++j) {
					if (arr[j] == 0) {
						solve = false;
						break;
					}
				}
				
				if (solve) {
					solve1 = true;
					System.out.println("Case #" + x + ": " + p);
					break;
				}
				
				p += N;
			}
			
			if (solve1 == false) {
				System.out.println("Case #" + x + ": INSOMNIA");
			}
		}
		
		sc.close();
	}

}
