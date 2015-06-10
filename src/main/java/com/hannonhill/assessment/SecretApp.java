package com.hannonhill.assessment;

import java.util.ArrayList;
import java.util.List;

public class SecretApp {

    private Secret secret;
    
    public SecretApp(Secret secret) {
	this.secret = secret;
    }
    
    /**
     * Loops through all prime numbers less than <i>n</i>, and checks them against the Secret.whisper() function.
     * 
     * @param n
     * @return
     */
    public boolean checkIfWhisperIsAdditive(int n) {
	List<Integer> primeNumbers = determinePrimeNumbers(n);
	
	for (int i = 0; i < primeNumbers.size(); i++) {
	    if (!checkWhisperAtIndex(primeNumbers, i)) {
		return false;
	    }
	}
	
	return true;
    }
    
    private boolean checkWhisperAtIndex(List<Integer> primes, int index) {
	Integer c = primes.get(index);
	
	for (Integer i : primes) {
	    if (!(secret.whisper(i + c) == secret.whisper(i) + secret.whisper(c))) {
		return false;
	    }
	}
	
	return true;
    }
    
    /**
     * Returns a list of all prime numbers less than <i>x</i>
     * 
     * @param x
     * @return
     */
    public List<Integer> determinePrimeNumbers(int x) {
	List<Integer> result = new ArrayList<Integer>();
	
	for (int i = 2; i < x; i++) {
	    if (isPrime(i)) {
		result.add(i);
	    }
	}
	
	return result;
    }
    
    private boolean isPrime(int n) {
	double squareRootOfN = Math.sqrt(n); // for efficiency we can check factors up to the square root of N
	
	if (n <= 1) {
	    return false;
	}
	for (int i = 2; i < squareRootOfN; i++) {
	    if (n % i == 0) {
		// n has a factor other than itself and 1, so its not a prime
		return false;
	    }
	}
	
	return true;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	try {
	    if (args[0] == null) {
		throw new IllegalArgumentException("You must pass an argument.");
	    }
	    Integer.parseInt(args[0]);
	    Class.forName("com.hannonhill.assessment.SecretImpl");
	    
	    //TODO: Once class is provided we can run the app
	    // SecretApp secretApp = new SecretApp(new SecretImpl());
	    // secretApp.run();
	} catch (NumberFormatException notAnInteger) {
	    System.out.println("You must pass an integer value.");
	} catch (ClassNotFoundException notProvided) {
	    System.out.println("Sorry, no implementation of Secret has been provided.");
	}
    }
}
