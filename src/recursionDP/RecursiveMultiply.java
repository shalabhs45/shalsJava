package recursionDP;

public class RecursiveMultiply {
	// Java program to find product of two numbers
	// using recursion

		//Recursive function to calculate the product 
		//of 2 integers 
		static int multrecur(int n, int m) 
		{ 
		// case 1 : n<0 and m>0 
		// swap the position of n and m to keep second 
		// parameter positive 
		if (n > 0 && m < 0) { 
			return multrecur(m, n); 
		} 
		// case 2 : both n and m are less than 0 
		// return the product of their absolute values 
		else if (n < 0 && m < 0) { 
			return multrecur((-1 * n), (-1 * m)); 
		} 
		
		// if n>m , swap n and m so that recursion 
		// takes less time 
		if (n > m) { 
			return multrecur(m, n); 
		} 
		
		// as long as m is not 0 recursively call multrecur for 
		// n and m-1 return sum of n and the product of n times m-1 
		else if (m != 0) { 
			return n + multrecur(n, m - 1); 
		} 
		
		// m=0 then return 0 
		else { 
			return 0; 
		} 
		} 

		//Driver code 
		public static void main(String[] args) { 
			
			System.out.println("5 * 3 = " + multrecur(5, 3)); 
			System.out.println("5 * (-3) = " + multrecur(5, -3)); 
			System.out.println("(-5) * 3 = " + multrecur(-5, 3)); 
			System.out.println("(-5) * (-3) = " +multrecur(-5, -3)); 
		} 
	 

}
