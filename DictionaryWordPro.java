package dynamicProgramming;
//139£¬word break
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//Note:
//The same word in the dictionary may be reused multiple times in the segmentation.
//You may assume the dictionary does not contain duplicate words.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DictionaryWordPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet <String> dict = new HashSet<>();
		dict.add("bob");
		dict.add("cat");
		dict.add("rob");
		
//		for(String string: dict) {
//			System.out.println(string);
//		}
		
		List<String> list = new ArrayList<String>();
		list.add("bob");
		list.add("cat");
		list.add("rob");
		
		String s1 = "bobcatrob";
		String s2 = "bcoabt";
		//System.out.println(s1.substring(3, 6));
		
		boolean[] result = WordBreak(s2, list);
		//System.out.println(result);
		for(int i=1; i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
	
	public static boolean[] WordBreak(String s, List<String> wordDict) {
		//Base Case
		int n = s.length();
		boolean[] M = new boolean[n+1];
		M[1] = wordDict.contains(s.substring(0));
		//induction rule
		for(int i = 2; i <= n; i++) {
			boolean current = wordDict.contains(s.substring(0, i));
			for(int j = 1; j < i; j++) {
				current = current || (M[j] && wordDict.contains(s.substring(j, i)));
			}
			M[i] = current;
		}
		return M;
	}
	

}
