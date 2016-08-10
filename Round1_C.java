import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/*
Coin Jam

URL
https://code.google.com/codejam/contest/6254486/dashboard#s=p2
*/
public class Round1_C {

	static ArrayList<Integer> prime = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException  {
		Scanner sc = new Scanner(new File("C:\\Users\\rhasy\\Downloads\\C-large.in"));
		// Scanner sc = new Scanner(new File("small_C.in"));
		
		int T = sc.nextInt();
		int N = sc.nextInt();
		int J = sc.nextInt();
		
		// T do not use;
		// N is length of string but first and last is '1';
		
		// get prime
		getPrime();

		// solve
		long min = (long)Math.pow(2, N - 1) + 1;
		long max = (long)Math.pow(2, N) - 1;
		int cnt = 0;
		
		System.out.println("Case #1:");
		
		for (long i = min; i <= max; i += 2) {
			String bs = Long.toBinaryString(i);
			
			boolean jam = true;
			int[] ar = new int[11];
			for (int r = 2; r <= 10; ++r) {
				BigInteger n = new BigInteger(bs, r);
				int d = isPrime(n);
				if (d == -1) {
					jam = false;
					break;
				}
				else {
					ar[r] = d;
				}
				
			}
			
			if (jam) {
				System.out.print(bs);
				for (int r = 2; r <= 10; ++r) {
					System.out.print(" " + ar[r]);
				}
				System.out.println();
				
				cnt++;
				if (cnt >= J) {
					break;
				}
			}
		}
		
		sc.close();
	}
	
	public static void getPrime() {
		prime.add(2);
		
		for (int i = 3; i <= 32768; ++i) {
			boolean p = true;
			for (int j = 0; j < prime.size(); ++j) {
				if (i % prime.get(j) == 0) {
					p = false;
					break;
				}
			}
			if (p) {
				prime.add(i);
			}
		}	
	}
	
	public static int isPrime(BigInteger n) {
		for (int i = 0; i < prime.size(); ++i) {
			if (n.mod(BigInteger.valueOf(prime.get(i))) == BigInteger.ZERO) {
				return prime.get(i);
			}
		}
		
		return -1;
	}
	
}
