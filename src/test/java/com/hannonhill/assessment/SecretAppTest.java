package com.hannonhill.assessment;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SecretAppTest {

    /**
     * Test for verifying our logic for calculating prime numbers is working
     * correctly.
     * 
     * @throws Exception
     */
    @Test
    public void testSecretApp() throws Exception {
	Secret secret = new Secret() {
	    @Override
	    public int whisper(int x) {
		// TODO Figure out an actual additive function to run a positive
		// results test against
		return 0;
	    }
	};

	SecretApp secretApp = new SecretApp(secret);

	List<Integer> primes = secretApp.determinePrimeNumbers(20);
	assertEquals("One or more values are not prime numbers", "[2, 3, 4, 5, 7, 9, 11, 13, 17, 19]",
		primes.toString());
    }

}
