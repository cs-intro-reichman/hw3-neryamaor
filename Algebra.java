// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 >= 0) {
			int i = 0;
			while (i < x2) {
				x1++;
				i++;
			}
		} else {
			int i = 0;
			while (i < -x2) {
				x1--;
				i++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		return plus(x1, -x2);
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x2 == 0) return 0;
		
		int absX2 = x2;
		boolean negX2 = false;
		if (x2 < 0) {
			absX2 = -x2;
			negX2 = true;
		}
		
		int absX1 = x1;
		boolean negX1 = false;
		if (x1 < 0) {
			absX1 = -x1;
			negX1 = true;
		}
		
		int result = 0;
		int i = 0;
		while (i < absX2) {
			result = plus(result, absX1);
			i++;
		}
		
		// If signs differ, negate result
		if ((negX1 && !negX2) || (!negX1 && negX2)) {
			result = -result;
		}
		
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) return 1;
		if (x == 0) return 0;
		
		int result = 1;
		int i = 0;
		while (i < n) {
			result = times(result, x);
			i++;
		}
		
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int absX1 = x1;
		int absX2 = x2;
		boolean negX1 = false;
		boolean negX2 = false;
		
		if (x1 < 0) {
			absX1 = -x1;
			negX1 = true;
		}
		if (x2 < 0) {
			absX2 = -x2;
			negX2 = true;
		}
		
		int count = 0;
		int i = 0;
		while (count <= absX1) {
			if (plus(count, absX2) > absX1) {
				break;
			}
			count = plus(count, absX2);
			i++;
		}
		
		// If signs differ, negate result
		if ((negX1 && !negX2) || (!negX1 && negX2)) {
			i = -i;
		}
		
		return i;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int quotient = div(x1, x2);
		return minus(x1, times(quotient, x2));
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 0;
		while (pow(i, 2) < x) {
			i++;
		}
		if (pow(i, 2) > x) {
			i--;
		}
		return i;
	}    
}
