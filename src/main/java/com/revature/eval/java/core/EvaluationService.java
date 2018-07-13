package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String output = "";
		String words[] = phrase.split(" ");
		for (String w : words) {
			if (w.contains("-")){
				String words2[] = w.split("-");
				for (String w2 : words2) {
					output += w2.charAt(0);
				}
			} else {
				output += w.charAt(0);
			}
			
		}
		return output.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			Double a = getSideOne();
			Double b = getSideTwo();
			Double c = getSideThree();			
			if ((Double.compare(a, b)==0)&(Double.compare(b, c)==0)) {				
				return true;
			} else { 
				return false; 
			}
		}

		public boolean isIsosceles() {
			return (((getSideOne()==getSideTwo())&(getSideTwo()!=getSideThree())) |
				   ((getSideOne()!=getSideTwo())&(getSideTwo()==getSideThree()))  |
				   ((getSideOne()==getSideThree())&(getSideTwo()!=getSideThree())));
		}

		public boolean isScalene() {
			return ((getSideOne()!=getSideTwo())&(getSideTwo()!=getSideThree())&(getSideOne()!=getSideThree()));
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			switch(c){
			case 'A': count += 1 ; break;
			case 'a': count += 1 ; break;
			case 'B': count += 3 ; break;
			case 'b': count += 3 ; break;
			case 'C': count += 3 ; break;
			case 'c': count += 3 ; break;
			case 'D': count += 2 ; break;
			case 'd': count += 2 ; break;
			case 'E': count += 1 ; break;
			case 'e': count += 1 ; break;
			case 'F': count += 4 ; break;
			case 'f': count += 4 ; break;
			case 'G': count += 2 ; break;
			case 'g': count += 2 ; break;
			case 'H': count += 4 ; break;
			case 'h': count += 4 ; break;
			case 'I': count += 1 ; break;
			case 'i': count += 1 ; break;
			case 'J': count += 8 ; break;
			case 'j': count += 8 ; break;
			case 'K': count += 5 ; break;
			case 'k': count += 5 ; break;
			case 'L': count += 1 ; break;
			case 'l': count += 1 ; break;
			case 'M': count += 3 ; break;
			case 'm': count += 3 ; break;
			case 'N': count += 1 ; break;
			case 'n': count += 1 ; break;
			case 'O': count += 1 ; break;
			case 'o': count += 1 ; break;
			case 'P': count += 3 ; break;
			case 'p': count += 3 ; break;
			case 'Q': count += 10 ; break;
			case 'q': count += 10 ; break;
			case 'R': count += 1 ; break;
			case 'r': count += 1 ; break;
			case 'S': count += 1 ; break;
			case 's': count += 1 ; break;
			case 'T': count += 1 ; break;
			case 't': count += 1 ; break;
			case 'U': count += 1 ; break;
			case 'u': count += 1 ; break;
			case 'V': count += 4 ; break;
			case 'v': count += 4 ; break;
			case 'W': count += 4 ; break;
			case 'w': count += 4 ; break;
			case 'X': count += 8 ; break;
			case 'x': count += 8 ; break;
			case 'Y': count += 4 ; break;
			case 'y': count += 4 ; break;
			case 'Z': count += 10 ; break;
			case 'z': count += 10 ; break;
			default: break;

			}
		}
		return count;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		String finalstring = string.replace("-", "");
		finalstring = finalstring.replace("(", "");
		finalstring = finalstring.replace(")", "");
		finalstring = finalstring.replace("-", "");
		finalstring = finalstring.replace(" ", "");
		finalstring = finalstring.replace(".", "");
		if (finalstring.charAt(0) == '1') {
			finalstring = finalstring.substring(1, finalstring.length());
		}
		if (finalstring.length() > 11) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < finalstring.length();i++) {
			if(!Character.isDigit(finalstring.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
		return finalstring;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> output = new HashMap<String,Integer>();
		String[] words = string.split("\\s|\\n");
		for (String word : words) {
			word = word.replace(",", "");
			if (output.containsKey(word)) {
				output.put(word, output.get(word)+1);
			} else {
				output.put(word, 1);
			}
			
		}
		return output;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			if(sortedList.size() != 1) {
				int first = sortedList.subList(0, sortedList.size()/2).indexOf(t);
				int second = sortedList.subList(sortedList.size()/2, sortedList.size()).indexOf(t);
				if (first != -1) {
					return first;
				} else if(second != -1) {
					return second + sortedList.size()/2;
				} else {
					return -1;
				}
			} else {
				if (sortedList.get(0) == t){
					return 0;
				} else {
					return -1;
				}
			}
			// TODO Write an implementation for this method declaration
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] words = string.split(" ");
		String[] newwords = new String[words.length];
		HashSet<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('A');
		vowels.add('e');
		vowels.add('E');
		vowels.add('i');
		vowels.add('I');
		vowels.add('o');
		vowels.add('O');
		vowels.add('u');
		vowels.add('U');
		for (int index = 0; index < words.length; index++) {
			if (vowels.contains(words[index].charAt(0))){
				newwords[index] = words[index];
				newwords[index] += "ay";		
			} else {
				newwords[index] = words[index].substring(1, words[index].length());
				newwords[index] += words[index].charAt(0);
				newwords[index] += "ay";
			}
			
		}
		String output = "";
		for (String word : newwords) {
			output += word + " ";
		}
		return output.trim();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int digits = 1;
		int inp = input;
		while (inp > 9) {
			inp = inp / 10;
			digits += 1;
		}
		inp = input;
		int[] digitArr = new int[digits];
		for (int i = digits-1; i >= 0; i--) {
			digitArr[i] = (int) ((inp / Math.pow(10, i)));
			inp = (int) ((input % Math.pow(10, i)));
		}
		int sum = 0;
		for (int i = 0; i < digits; i++) {
			sum += Math.pow(digitArr[i], digits);
		}
		return (sum == input);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> primefactors = new LinkedList<Long>();
		List<Long> factors = new LinkedList<Long>();
		for (Long iter = 1L; iter < l; iter++) {
			if (l%iter == 0) {
				factors.add(iter);
				factors.add(l/iter);
			}
		}
		for (Long fact : factors) {
			List<Integer> divisibles = new LinkedList<Integer>();
			for(int determine = 1; determine < fact; determine++) {
				if (fact%determine==0) {
					divisibles.add(determine);
				}
			}
			if (divisibles.size() == 1) {
				primefactors.add(fact);
			}
		}
		return primefactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String finalstring ="";
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				c += key;
				if(c >= 'z'){ c -= 26; }
				finalstring += c;
			}
			return finalstring;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		if (i <= 0) {throw new IllegalArgumentException();}
		List<Integer> primes = new ArrayList<Integer>();
		int current = 2;
		int stillneedprimes = i;
		while (stillneedprimes > 0) {
			List<Integer> divisibles = new ArrayList<Integer>();
			for(int determine = 1; determine < current; determine++) {
				if (current%determine==0) {
					divisibles.add(determine);
				}
			}
			if (divisibles.size() == 1) {
				primes.add(current);
				stillneedprimes -=1;
			}
			current +=1;
		}
		for (int x = 0; x < primes.size();x++) {
		}
		return primes.get(i-1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String input = string.replace(" ","");
			input = input.replace(",","");
			String output = "";
			for (int i = 0; i < input.length(); i++) {
				int c = (int)(input.charAt(i));
				if ((c > 96)&&(c<123)) {
					//lower case scenario
					char n = (char)(((-1*(c - 96))+27)+96);
					output += n;
				} else if ((c > 64)&&(c < 91)) {
					//upper case scenario
					char n = (char)(((-1*(c - 64))+27)+96);
					output += n;
				} else if ((c > 47)&&(c < 58)) {
					//Number
					output += input.charAt(i);
				} else {
					//not a character
				}
				if(((i+1)%5)==0) {output+=" ";}
			}
			return output.trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String input = string.replace(" ","");
			input = input.replace(",","");
			String output = "";
			for (int i = 0; i < input.length(); i++) {
				int c = (int)(input.charAt(i));
				if ((c > 96)&&(c<123)) {
					//lower case scenario
					char n = (char)(((-1*(c - 96))+27)+96);
					output += n;
				} else if ((c > 64)&&(c < 91)) {
					//upper case scenario
					char n = (char)(((-1*(c - 64))+27)+96);
					output += n;
				} else if ((c > 47)&&(c < 58)) {
					//Number
					output += input.charAt(i);
				} else {
					//not a character
				}
			}
			return output;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String input = string.replace("-", "");
		if (input.length() == 10) {
			int[] numbers = new int[10];
			int finalcount = 0;
			for (int i = 0; i < 10; i++) {
				if (Character.isLetter(input.charAt(i))){
					if(((input.charAt(i)=='X')|(input.charAt(i) == 'x'))&(i==9)) {
						numbers[i] = 10;
					} else {
						return false;
					}
				} else {
					numbers[i] = Integer.parseInt(input.substring(i, i+1));
				}
				finalcount += numbers[i] * i;
			}
			if (finalcount%11 == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		String input = string.toLowerCase();
		HashSet<Character> charset = new HashSet<Character>();
		for (int i = 97; i < 123; i++) {
			charset.add((char)i);
		}
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(charset.contains(c)) {
				charset.remove(c);
			}
		}
		if (charset.size() == 0) {
			
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		int year,month,day,hour,minute,second;
		try {
			year = given.get(ChronoField.YEAR);
		} catch (UnsupportedTemporalTypeException ex) {
			year = 0;
		}
		try {
			month = given.get(ChronoField.MONTH_OF_YEAR);
		} catch (UnsupportedTemporalTypeException ex) {
			month = 0;
		}
		try {
			day = given.get(ChronoField.DAY_OF_MONTH);
		} catch (UnsupportedTemporalTypeException ex) {
			day = 0;
		}
		try {
			hour = given.get(ChronoField.CLOCK_HOUR_OF_DAY);
		} catch (UnsupportedTemporalTypeException ex) {
			hour = 0;
		}
		try {
			minute = given.get(ChronoField.MINUTE_OF_HOUR);
		} catch (UnsupportedTemporalTypeException ex) {
			minute = 0;
		}
		try {
			second = given.get(ChronoField.SECOND_OF_MINUTE);
		} catch (UnsupportedTemporalTypeException ex) {
			second = 0;
		}
		Temporal target = LocalDateTime.of(year,month,day,hour,minute,second).plus(Duration.ofSeconds(1000000000));
		return target;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		HashSet<Integer> validmultiples = new HashSet<Integer>();
		int output = 0;
		for (int x = 0; x < i; x++) {
			for (int test : set) {
				if (x%test == 0) {
					validmultiples.add(x);
				}
			}
		}
		for (int mult : validmultiples) {
			output += mult;
		}
		return output;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		if (string.length() <= 1) {
			return false;
			//throw new IllegalArgumentException();
		} else {
			String input = string.replace("-", "");
			input = string.replace(" ", "");
			int finalsum = 0;
			int[] numbers = new int[input.length()];
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))){
					return false;
				} else {
					numbers[i] = Integer.parseInt(input.substring(i, i+1));
				}
			}
			for (int i = 0; i < input.length(); i++) {
				if((i+1)%2==0) {
					numbers[i] = numbers[i] * 2;
					if (numbers[i] > 10) {
						numbers[i] -= 9;
					}
					finalsum += numbers[i];
				}
			}
			if (finalsum%10==0) {
				return true;
			}
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String input = string.replace("?","");
		String[] words = input.split(" ");
		HashSet<String> operands = new HashSet<String>();
		String currentOperation = "";
		int[] values = new int[2];
		int loc = 0;
		operands.add("plus");
		operands.add("minus");
		operands.add("multiplied");
		operands.add("divided");
		for (String word: words) {
			boolean negative = false;
			String testword = word.toLowerCase();
			if (testword.charAt(0) == '-'){
				negative = true;
				testword = testword.substring(1);
			}
			if(operands.contains(testword)) {
				currentOperation = testword;
			}
			else if((testword == "what")|(testword=="is")|(testword=="by")){
				//Ignore these words
			} else {
				//Assume integer
				int val = 0;
				try {
					//System.out.println(testword);
					val = Integer.parseInt(testword);
					if(!negative) {
						values[loc] = val;
					} else {
						values[loc] = (val * -1);
					}
					loc += 1;
				} catch (NumberFormatException ex) {
					
				}
				
				
			}
		}
		//System.out.print(values[0] + " " + currentOperation +" " + values[1] + "\n");
		switch(currentOperation){
			case "multiplied": return values[0] * values[1];
			case "divided":
				int x = 0;
				try {
					x = values[0] / values[1];
				} catch (ArithmeticException ex) {
					
				}
				return x;
			case "plus": return values[0] + values[1];
			case "minus": return values[0] - values[1];
			default: return 0;
		}
	}

}
