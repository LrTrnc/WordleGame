package cmp;

public class Checker {
	
	public static String key="laraa";
	
	
	public static WordData checkWord(String str) {
		int correct =0;
		int pos = 0;
		
		int[] data= new int[5];
		char[] c = new char[5];
		char[] ckey = new char[5];
		for(int i=0;i<5;i++) {
			c[i]=str.toUpperCase().charAt(i);
			ckey[i]=key.toUpperCase().charAt(i);
		}
		
		
		
		// CORRECT CHECK
		for(int i=0;i<5;i++) {
			if(c[i]==ckey[i]) {
				data[i] = 2;	
				ckey[i]='-';
			}
		}

		// POSITION CHECK
		for(int i=0;i<5;i++)  {
			int index = isCharContains(ckey, c[i]);
			if(index != -1 ) {
				ckey[index]='-';
				data[i]=1;
			}
		}
		
		
		return new WordData(str.toUpperCase(), data);
		
	}
	public static int isCharContains(char[] array, char target) {
		for(int i = 0;i<array.length;i++)
			if(array[i]==target)return i;
		return -1;
	}
	
}
