
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MainFunction {
	
	public Status InitialStatus(long[][] zoberist) {
		int[] s = new int[Status.N + 1];
		
		for (int i = 0; i < Status.N + 1; i ++) {
			s[i] = i;
		}
		
		KDS.Knuth_Durstenfeld_Shuffle(s);
		
		long zob = 0;
		for (int i = 0; i < Status.N + 1; i ++) {
			zob = zob^zoberist[i][s[i]];
		}
		
		Status status = new Status(s, zob); 
		
		return status;
	}
	
	public static void main(String[] args) {
		MainFunction mf = new MainFunction();
		System.out.print("Please Input The (N*N-1) Puzzle's N: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Status.N = n;
		
		long[][] zoberist = new long[Status.N + 1][Status.N + 1];
		Random random = new Random();
		for (int i = 0; i < Status.N + 1; i ++) {
			for (int j = 0; j < Status.N + 1; j ++) {
				zoberist[i][j] = random.nextLong();
			}
		}
		Map<Long, Integer>hash_zob_num = new HashMap<Long, Integer>();	
		
		List<Status> Record = new ArrayList<Status>();
		
		int Right = (int)Math.sqrt(Status.N + 1);
		
		final int MAX = 100;
		int i = 0;
		do{
			Status status = mf.InitialStatus(zoberist); 
			if (hash_zob_num.get(status.GetZoberist()) == null && (status.GetEv() + Right) % 2 == 0) {
				//System.out.printf("[%d] ", i + 1);
				// status.PrintStatus();
				Record.add(i, status);
				hash_zob_num.put(status.GetZoberist(), i);
				i ++;
			}else {
				//System.out.println("The Generated Status is Repetitive, Still Searching...");
			}
		}while(i != MAX);	
		
		/*int ii = 0;
		for (Status s : Record) {
			System.out.printf("[%d] ", ii + 1); 
			ii ++;
			s.PrintStatus();
		}*/
		
		for (int j = 0; j < 3; j ++) {
			int x = random.nextInt(MAX);
			Status currentStatus = Record.get(x);
			currentStatus.PrintStatus();
			System.out.println("The NEXT Status are: ");
			Move move = new Move();
			for (Status s : move.GetNextMove(currentStatus)) {
				s.PrintStatus();
			}
			System.out.println("--------------------------\n");
		}
		
		System.out.println("\n");
	}

}




/*
 *  Coder: 16020031075 WangGang
 *  Reference: None
 *  Date: 2019.3.14
 *  Time complexity: I donot want to know.
 */

//Zoberist Hash Reference: https://www.cnblogs.com/IThaitian/p/3616507.html