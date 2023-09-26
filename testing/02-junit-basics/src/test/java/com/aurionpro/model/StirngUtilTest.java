package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StirngUtilTest {

	void test() {
		fail("Not yet implemented");
	}
	
	 @Test
	    public void testTruncate() {
	        String input = "AASD,SDwe,SADE";
	        String expectedOutput = "SD,SDwe,SADE";

	        String result = StirngUtil.trancateInFirst2Position(input);
	        assertEquals(expectedOutput, result);
	    }
	 
	   @Test
	    public void testAreFirstAndLastTwoCharactersSameWithSameCharacters() {
	        String input = "ASDAS";
	        boolean result = StirngUtil.areFirstAndLastTwoCharactersSame(input);
	        assertTrue(result);
	    }

}
