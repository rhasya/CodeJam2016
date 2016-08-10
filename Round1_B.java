import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Revenge of the Pancakes

Problem URL
https://code.google.com/codejam/contest/6254486/dashboard#s=p1
*/
public class Round1_B {

	public static void main(String[] args) throws FileNotFoundException  {
		Scanner sc = new Scanner(new File("C:\\Users\\rhasy\\Downloads\\B-large.in"));
		// Scanner sc = new Scanner(new File("small_B.in"));
		
		int T = sc.nextInt();
		for (int x = 1; x <= T; ++x) {
			// Read Problem
			String s = sc.next();
			
			int R = 0;
			
			// Check
			for (int i = 0; i < 100; ++i) {
				// MAKE?
				if (isOk(s)) {
					break;
				}
				
				// find -
				int idx = s.lastIndexOf('-');
				
				// check +..-
				if (s.charAt(0) == '+') {
					idx = (s.substring(0, idx)).lastIndexOf('+');
				}

				s = flip(s, idx);
				R++;
			}
			
			System.out.printf("Case #%d: %d\n", x, R);
		}
		
		sc.close();
	}
	
	public static boolean isOk(String s) {
		if (s.indexOf('-') == -1) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public static String flip(String s, int n) {
		char[] ar = s.toCharArray();
		
		for (int i = 0; i <= n / 2; ++i) {
			char t = ar[i];
			ar[i] = ar[n - i] == '-' ? '+' : '-';
			ar[n - i] = t == '-' ? '+' : '-';
		}
		
		return new String(ar);
	}
}
