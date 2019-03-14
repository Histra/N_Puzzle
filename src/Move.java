import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Move {
	public Move() {
		
	}
	public List<Status> GetNextMove(Status currentStatus) {
		List<Status> statusList = new ArrayList<Status>();
		
		int empty = currentStatus.GetEmpty();
		int[] s;
		final int[] D = new int[]{-3, -1, 1, 3};
		for (int i = 0; i < D.length; i ++) {
			// ²»ÓÃ¹Üzoberist
			int pos = empty + D[i];
			if (pos >= 0 && pos < currentStatus.GetStatus().length) {
				s = Arrays.copyOf(currentStatus.GetStatus(), currentStatus.GetStatus().length);
				int temp = s[pos];
				s[pos] = s[empty];
				s[empty] = temp;
				Status st = new Status(s, 0);/// zoberist = 0. let it go~
				statusList.add(st);
			}
		}
		return statusList;
	}
}
