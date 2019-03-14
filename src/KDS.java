import java.util.Date;
import java.util.Random;

public class KDS {
	public KDS() {
		
	}
	
	static public void Knuth_Durstenfeld_Shuffle(int[] s) {
		for (int i = s.length - 1; i >= 0; i--) {
			
			Random r = new Random();	
			r.setSeed(new Date().getTime());
			int x = r.nextInt(i + 1);
			
			int temp = s[x];
			s[x] = s[i];
			s[i] = temp;
		}
	}
}

// Xipaisuanfa Reference: https://blog.csdn.net/qq_26399665/article/details/79831490
// Random Reference: https://www.cnblogs.com/ningvsban/p/3590722.html
