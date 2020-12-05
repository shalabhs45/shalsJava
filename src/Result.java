
	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.regex.*;



	class Result {

	    /*
	     * Complete the 'reverseVowels' function below.
	     *
	     * The function is expected to return a STRING.
	     * The function accepts STRING word as parameter.
	     */
	    
	     private static boolean isVowel(char c){
	         if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
	        	 return true;
	         }
			return false;
	     }

	    public static String reverseVowels(String word) {

	        if(word.isEmpty()) return " ";
	        if(word.length() == 1) return word;
	        int count =0;
	        char[] text = word.toLowerCase().toCharArray();
	        String vowel ="";
	        for (int counter =0; counter<text.length; counter++){
	            if(isVowel(text[counter])){
	                count++;
	                vowel +=text[counter];
	            }
	        }
	     // Reverse
	             for (int counter =0; counter<text.length; counter++){
	                if (isVowel(text[counter])){
	                    text[counter] = vowel.charAt(--count);
	                }
	             }

	             return String.valueOf(text);



	    }

	}

	
