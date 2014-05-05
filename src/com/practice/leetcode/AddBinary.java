package com.practice.leetcode;

/**
 * http://oj.leetcode.com/problems/add-binary/
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		} // make "a" the longer one
		
        char[] result = new char[a.length() + 1];
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        int ir = result.length - 1;
        int carrier = 0;
        while (ir >= 0) {
        	int va = (ia >= 0)? a.charAt(ia--) - '0' : 0;
        	int vb = (ib >= 0)? b.charAt(ib--) - '0' : 0;
        	int vr = (va + vb + carrier) % 2;
        	carrier = (va + vb + carrier) / 2;
        	result[ir--] = (char)(vr + '0');
        }
        
        if (result[0] == '0') return new String(result, 1, a.length());
        else return new String(result);
    }

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(new AddBinary().addBinary(a, b));

		a = "0";
		b = "0";
		System.out.println(new AddBinary().addBinary(a, b));
	}

}
