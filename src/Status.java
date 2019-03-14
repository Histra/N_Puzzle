
public class Status {
	public Status(){
		
	}
	
	static public int N = 24;
	private int[] status = new int[N + 1];
	private int empty;
	private long zoberist;
	private int ev;
	
	public Status(int[] s, long zoberist) {
		if (s.length != N + 1) {
			System.out.println("Input Error!\n");
		}else {
			this.SetStatus(s);
			this.SetEmpty();
			this.SetZoberist(zoberist);
			this.SetEv();
		}
	}
	
	public int[] GetStatus() {
		return this.status;
	}
	
	public void SetStatus(int[] s) {
		this.status = s;
	}
	
	public int GetEmpty() {
		return this.empty;
	}
	
	public void SetEmpty() {
		for (int i = 0; i < Status.N + 1; i ++) {
			if (this.status[i] == 0) {
				this.empty = i;
				break;
			}
		}
	}
	
	public long GetZoberist() {
		return this.zoberist;
	}
	
	public void SetZoberist(long zoberist) {
		this.zoberist = zoberist;
	}
	
	public void SetEv() {
		for (int i = 0; i < this.status.length - 1; i ++) {
			for (int j = i + 1; j < this.status.length; j ++) {
				if (this.status[i] > this.status[j]) {
					this.ev ++;
				}
			}
		}
		this.ev += (int)Math.sqrt(Status.N + 1);
	}
	
	public int GetEv() {
		return this.ev;
	}
	
	public void PrintStatus() {
		System.out.println("The Current Status is: ");
		int num = (int)(Math.sqrt(N + 1));
		
		System.out.print("+");
		for (int i = 0; i < num; i ++) {
			System.out.print("---+");
		}
		System.out.println();
		
		for (int i = 0; i < num; i ++) {
			System.out.print("|");
			for (int j = 0; j < num; j ++) {
				// System.out.print(" " + this.status[i * num + j] + " |");
				System.out.printf("%2d |", this.status[i * num + j]);
			}
			System.out.println();
			
			System.out.print("+");
			for (int ii = 0; ii < num; ii ++) {
				System.out.print("---+");
			}
			System.out.println();
		}
		System.out.println();
	}
}
