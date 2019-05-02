package dynamicProgramming;
//input = {7, 2, 3, 1, 5, 8, 9, 6}
//output = {1, 5, 8, 9}

public class LongestAscendingSubarrsy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {7, 2, 3, 1, 5, 8, 9, 6};
		System.out.println(las(n));
	}
	//input = {7, 2, 3, 1, 5, 8, 9, 6}
	//M[i] =  {1, 1, 2, 1, 2, 3, 4, 1}
	
	public static int las(int[] n) {
		//base case:
		int[] M = new int[n.length+1];
		M[0] = 1;
		int gmax = M[0];
		//System.out.println(M[0]);
		for(int i=1; i<n.length; i++) {
			if(n[i]>n[i-1]) {
				M[i] = M[i-1]+1;
			}
			else {
				M[i] = 1;
			}
			if(M[i]>gmax) {
				gmax = M[i];
			}
			//System.out.println(M[i]);
		}
		return gmax;
	}

}
