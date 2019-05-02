package dynamicProgramming;
//45. Jump Game 2

public class MinimumJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] B = {2,3,1,1,4};
		int[] newInt = minJump1(B);
		for(int i = 0; i < B.length; i++) {
			System.out.print(newInt[i]+",  ");
		}
	}
	
	public static int[] minJump1(int[] input) {
		//Base Case
		int n = input.length;
		int[] M = new int[n+1];
		M[n-1] = 0;
		//Induction Rule
		for(int i = n-2; i >= 0; i--) {
			int curMin = n;
			for(int j = 1; j <= input[i]; j++) {
				if(i+j<n) {
					curMin = Math.min(curMin, 1+M[i+j]);
				}
			}
			M[i] = curMin;
		}
		return M;
	}
}
