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
		
		int[] C = {1,2,4,-1,-20,5,-1,4};
		//M[i] =  [1,3,7, 6,-14,5, 4,8];
		maxSub3(C);
		maxSub4(C);
		//the excepted result is start=5, end=7, gmax=8; but the execution result is "Start: 0, END: 7, gmax: 8."
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
	
	//the previous maxSub3 is WRONG, we need to consider the following situation
	////input = [1,2,4,-1,-20,5,-1,4];
    //M[i] =    [1,3,7, 6,-14,5, 4,8];
    //                      I
	//           S1           S2
	//               E1            E2
	//the excepted result is start=5, end=7, gmax=8; but the execution result is "Start: 0, END: 7, gmax: 8."
	//So I need reconsider. I need two set of S&E. whenever there is a new global max, I will update the solution start and solution end.
	//start;end
	//solu_start; solu_end
	//when to update stat-->when M[i-1]<0
	//when to update solu_start-->when M[i-1]<0 & when global max changed
	//when to update solu_end --> when solu_start changed
	public static void maxSub4(int[] input) {
		//Base Case
		int n = input.length;
		int[] M = new int[n+1];
		M[0] = input[0];
		int gmax = M[0];
		
		int start = 0;
		
		int solu_start = 0;
		int solu_end = 0;
		//Induction Rule
		for(int i = 1; i < n; i++) {
			if(M[i-1] >= 0) {
				M[i] = M[i-1] + input[i];
				if(M[i]>gmax) {
					solu_end = i;
				}
			}
			else {
				M[i] = input[i];
				start = i;
			}
			gmax = Math.max(gmax, M[i]);
			if(solu_end>=start) {
				solu_start = start;
			}
		}
		
		System.out.print("Start: "+solu_start+", END: "+solu_end+", gmax: "+gmax+".  ");
	}

}
