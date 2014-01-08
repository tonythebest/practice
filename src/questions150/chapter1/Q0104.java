package questions150.chapter1;

public class Q0104 {

	public static String fill20Percent (String s) {
		
		//test it with Java API
		System.out.println(s);
		String b = s.replaceAll(" ", "%20");
		System.out.println(s);
		System.out.println(b);
		
		//test with my own code
		char[] ss = s.toCharArray();
		int numSpace = 0;
		for (int i = 0; i< ss.length; i++) {
			if (ss[i]==' ') numSpace++; //ss[i].equals(' ') not work!!!
		}
		
		char[] ssOut = new char[ss.length+numSpace*2]; //*3 is wrong!!!
		int ind = 0;
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] == ' ') {
				ssOut[ind++] = '%';
				ssOut[ind++] = '2';
				ssOut[ind++] = '0';
			} else {
				ssOut[ind++] = ss[i];
			}
		}
		
		return String.valueOf(ssOut);
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
