package com.justplay1994.github.acm.leetcode;


/**
 * @author huangzezhou
 * 2019/11/1
 * 151. 翻转字符串里的单词
 * start 10:05
 * end 10:29
 */
public class Solution151 {
	
	public static void main(String[] args) {
		System.out.println(new Solution().reverseWords("123   456 7 8"));
	}
	static
	class Solution {
	    public String reverseWords(String s) {
    		String[] t = s.split(" ");
    		StringBuilder builder = new StringBuilder();
    		for(int i = t.length - 1; i >= 0; i--) {
    			if(t[i].length() != 0) {
    				builder.append(t[i]).append(" ");
    			}
    		}
    		if(builder.length() > 0) {
    			return builder.substring(0, builder.length() - 1);
    		}
    		return builder.toString();
	    }
	}

}
