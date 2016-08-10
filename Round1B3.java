import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
Technobabble

URL
https://code.google.com/codejam/contest/11254486/dashboard#s=p2
*/
public class Round1B3 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("C:\\Users\\rhasy\\Downloads\\CodeJam2016_1RB\\C-small-attempt1.in"));
		// Scanner sc = new Scanner(new File("small3.in"));
		PrintWriter pw = new PrintWriter(new File("C:\\Users\\rhasy\\Downloads\\CodeJam2016_1RB\\small3.out"));
		
		int T = sc.nextInt();
		for (int x = 1; x <= T; ++x) {
			int N = sc.nextInt();
			sc.nextLine();	// Clear cr
			
			ArrayList<String> arr = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				arr.add(sc.nextLine());
			}
			
			ArrayList<String> dic1 = new ArrayList<>();
			ArrayList<String> dic2 = new ArrayList<>();
			
		    
			
			int y = 0;
			dic1.clear();
			dic2.clear();
			for (int i = 0; i < N; ++i) {
				String word = arr.get(i);
				
				String firWord = word.split("[ ]")[0];
				String secWord = word.split("[ ]")[1];
				
				dic1.add(firWord);
				dic2.add(secWord);
				
				int cnt1 = 0;
				int cnt2 = 0;
				for (int j = 0; j < dic1.size(); ++j) {
					if (firWord.equals(dic1.get(j))) {
						cnt1++;
					}
					if (cnt1 >= 2) {
						break;
					}
				}
				for (int j = 0; j < dic2.size(); ++j) {
					if (secWord.equals(dic2.get(j))) {
						cnt2++;
					}
					if (cnt2 >= 2) {
						break;
					}
				}
				
				if (cnt1 >= 2 && cnt2 >= 2) {
					y++;
				}
			}
			
			arr.forEach((str) -> System.out.println(str));

			// System.out.println("Case #" + x + ": " + y);
			pw.println("Case #" + x + ": " + y);
		}
		
		pw.close();
		sc.close();
	}
}
