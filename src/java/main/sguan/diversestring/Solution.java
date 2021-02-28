//if a character appears 3 or more times consecutively, its not diverse. 

class CodeChef
{
    public static boolean isDiverse(String input){
        boolean isDiverse = true;
        
        char[] charArr = input.toCharArray();
        int count = 1;
        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] == charArr[i+1]) {
                count++;
                if (count >= 3) {
                    return false;
                }
            } else {
                count = 1;
            }
        }
        
        return isDiverse;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String input1 = "aaabbbccc";
		String input2 = "abcaa";
		String input3 = "aaaaaaaaa";
		String input4 = "abaaaa";
		
		System.out.println("input1 " + CodeChef.isDiverse(input1));
		System.out.println("input2 " + CodeChef.isDiverse(input2));
		System.out.println("input3 " + CodeChef.isDiverse(input3));
		System.out.println("input4 " + CodeChef.isDiverse(input4));
	}
}
