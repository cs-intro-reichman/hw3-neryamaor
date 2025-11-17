/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		// Remove spaces for comparison
		str1 = str1.replace(" ", "");
		str2 = str2.replace(" ", "");
		String temp = str2;
		if (str1.length() != str2.length()){
			return false;
		}
		for(int i = 0; i < str1.length(); i++){//רץ על אותיות המילה הראשונה
			char c1 = str1.charAt(i);
            boolean found = false;
			for (int j= 0; j < temp.length() ;j++ ){//רץ על אותיות המילה הזמנית 
                if (c1 == temp.charAt(j)) {
                temp = temp.substring(0, j) + temp.substring(j + 1);
                found = true;
                break;
                }
		    }
			if (!found){
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		int strlenght = str.length();
		String wordprepsString = "";
		for(int i = 0; i < strlenght ; i++){
			char c = str.charAt(i);
			if(c >= 'A'&& c <='Z'){//אם היא אות גדולה 
		       wordprepsString += (char)(c + 32);
			}else if (c >= 'a' && c <= 'z'){
				wordprepsString += c;
			}else if (c == ' '){
				wordprepsString += c;
			}
		}
		return wordprepsString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String temp = str;
		String newword = "";
		for(int i = 0 ; i < str.length(); i++){
		  int j = (int) (Math.random() * temp.length());
          newword += temp.charAt(j) ;
		  temp = temp.substring(0, j) + temp.substring(j+1);
		}
		return newword;
	}
}
