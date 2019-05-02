package dynamicProgramming;
// 53. Maximum Subarray
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		//         -2,1,-2,4, 3,5,6, 1,5
		System.out.println(maxSub(A));
		System.out.println(maxSub2(A));
		
		int[] B = {1,2,4,-1,-20,10,-1};
		System.out.println(maxSub(B));
		System.out.println(maxSub2(B));
		
		maxSub3(A);
		maxSub3(B);
	}
	//eg1: input = [1,2,4,-1,-2,10,-1];
	//      M[i] = [1,3,7,6,  4,14, 13];
	public static int maxSub(int[] input) {
		//Base Case
		int n = input.length;
		int[] M = new int[n+1];
		M[0] = input[0];
		//Induction Rule
		int gmax = M[0];
		for(int i = 1; i < n; i++) {
			if(M[i-1] >= 0) {
				M[i] = M[i-1] + input[i];
			}
			else {
				M[i] = input[i];
			}
			gmax = Math.max(gmax, M[i]);
		}
		return gmax;
	}
	
	//follow up1: optimize space complexity, so we don't use M[i]
	public static int maxSub2(int[] input) {
		//Base Case
		int n = input.length;
		//Induction Rule
		int gmax = input[0];
		int cur = input[0];
		for(int i = 1; i < n; i++) {
			
			if(cur >= 0) {
				cur = cur + input[i];
			}
			else {
				cur = input[i];
			}
			gmax = Math.max(gmax, cur);
		}
		return gmax;
	}
	
	//follow up2 what if we return start and end indices of solution array
	//input = [1,2,4,-1,-2,10,-1]
	//M[I] =  [1,3,7, 6, 4,14,13]
	//                      I
	//         S
	//                      E
	//When to change the end position --> when global max changed
	//input = [1,2,4,-1,-20,10,-1];
	//M[i] =  [1,3,7, 6,-14,10, 9];
	//                      I
	//                      S
	//                      E
	//input = [1,2,4,-1,-20,5,-1];
    //M[i] =  [1,3,7, 6,-14,5, 4];
    //                      I
	//         S
	//             E
	//when to change the start position --> when we meet the M[i-1]<0, and global max changed.
	
	public static void maxSub3(int[] input) {
		//Base Case
		int n = input.length;
		int[] M = new int[n+1];
		M[0] = input[0];
		//Induction Rule
		int gmax = M[0];
		int start = 0;
		int end = 0;
		for(int i = 1; i < n; i++) {
			if(M[i-1] >= 0) {
				M[i] = M[i-1] + input[i];
				if(M[i] > gmax) {
					end = i;
				}
			}
			else {
				M[i] = input[i];
				if(M[i] > gmax) {
					start = i;
					end = i;
				}
			}
			gmax = Math.max(gmax, M[i]);
		}
		System.out.print("Start: "+start+", END: "+end+", gmax: "+gmax+".  ");
	}
	

}
