package dynamicProgramming;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibN(3));
		System.out.println(fibN2 (3));
	}
	//Recursion
	 public static int fibN(int n) {
		 if(n==0) {
			 return 0;
		 }
		 if(n==1) {
			 return 1;
		 }
		 return fibN(n-1)+fibN(n-2);
	 }
	 //Dp
	 public static int fibN2(int n) {
		 int[] fibsFound = new int[n+1];
		 fibsFound[0] = 0;
		 fibsFound[1] = 1;
		 for(int i = 2; i<=n; i++) {
			 fibsFound[i] = fibsFound[i-1]+fibsFound[i-2];
		 }
		 return fibsFound[n];
	 }
}
