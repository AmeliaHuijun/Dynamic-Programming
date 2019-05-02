package dynamicProgramming;

public class MaxProductofRope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i < 6; i++) {
			System.out.println(cut(i));	
		}
		for(int i = 1; i < 6; i++) {
			System.out.println(cut2(i));	
		}
		
		for(int i = 1; i < 6; i++) {
			System.out.println(cut3(i));	
		}
	}
	
	//Method1: ���� �Ҵ�� ����ε���˼��˵��ͨ����������ȡM������ֵ��
	public static int cut(int n) {
		//Base case
		int[] M = new int[n+1];
		M[0] = 0;
		M[1] = 0;//��Ϊ��ĿҪ��������һ����1m������û�취��
		for(int i = 1; i <= n; i++) {
			int curMax = 0;
			for(int j = 1; j <= i/2; j++) {
				curMax = Math.max(curMax, Math.max(j, M[j])*Math.max(i-j, M[i-j]));
			}
			M[i] = curMax;
		}
		return M[n];
	}
	
	//Method2: ������С�Σ�С�ε���˼��˵�����ǲ���Ҫ��ȡ��񣬲���Ҫ���κ�cut���Գ�һ�����ӣ�
	public static int cut2(int n) {
		//Base Case
		int[] M = new int[n+1];
		M[0] = 0;
		M[1] = 0;
		for(int i = 1; i <= n; i++) {
			int curMax = 0;
			for(int j = 1; j < i; j++) {
				curMax = Math.max(curMax, Math.max(j, M[j])*(i-j));
			}
			M[i] = curMax;
		}
		return M[n];
	}
	
	//Method3: Recursion
	public static int cut3(int n) {
		//Base Case
		int curMax = 0;
		if(n==0||n==1) {
			return 0;
		}
		for(int i = 1; i < n; i++) {
			int better = Math.max(n-i, cut3(n-i));
			curMax = Math.max(curMax, i * better);
		}
		return curMax;
	}
}
