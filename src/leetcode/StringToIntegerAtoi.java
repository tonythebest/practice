package leetcode;

public class StringToIntegerAtoi {

	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str == null || str.length() == 0)
			return 0;
		char[] S = str.toCharArray();
		int i = 0, out = 0, sign = 1;

		while (i < S.length && S[i] == ' ') {
			i++;
		}

		if (i == S.length)
			return 0;

		if (S[i] == '+') {
			i++;
		} else if (S[i] == '-') {
			i++;
			sign = -1;
		}

		if (i == S.length || S[i] < '0' || S[i] > '9') {
			return 0;
		}

		while (i < S.length && S[i] >= '0' && S[i] <= '9') {

			
			if (sign == 1 && (Integer.MAX_VALUE - (S[i] - '0'))/10 < out) {
				return Integer.MAX_VALUE;
			} else if (sign == -1
					&& (Integer.MIN_VALUE + (S[i] - '0'))/10 > -out) {
				return Integer.MIN_VALUE;
			} // be careful of this part!!!

			out = out * 10 + S[i] - '0';
			
//			System.out.println(out);
			i++;
		}

		out = out * sign;
		return out;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "    -10326662300y";
		StringToIntegerAtoi x = new StringToIntegerAtoi();
		System.out.println(x.atoi(a));
		
	}

}
