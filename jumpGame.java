package dynamicProgramming;

public class jumpGame {
//Each element in th array represents your maximum jump length at the position
	//A = [2,3,1,1,4] true
	//B = [3,2,1,0,4] false
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,4};
		int[] B = {3,2,1,0,4};
		boolean[] newInt = jump(A);
		for(int i = 0; i < A.length; i++) {
			System.out.print(newInt[i]+", ");
		}
		System.out.println("");
		boolean[] newInt2 = jump(B);
		for(int i = 0; i < B.length; i++) {
			System.out.print(newInt2[i]+", ");
		}
			//System.out.println(jump(A));
			//System.out.println(jump(B));
	}
	
	public static boolean[] jump(int[] input) {
		int n = input.length;
		boolean[] M = new boolean[n+1];
		//Base Case 
		M[n-1] = true;
		for(int i = n-2; i >= 0; i--) {
			//the last one is (n-i-1)
			for(int j = i+1; j < n; j++) {
				if(j-i <= input[i] && M[j]==true) {
					M[i] = true;
					break;
				}
				else {
					M[i] = false;
				}
			}
		}
		return M;
	}

}
