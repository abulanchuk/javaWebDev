package edu.epam.task4.service;

import edu.epam.task4.exception.InvalidTypeException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VowelsAndConsonantsTest extends BaseServiceTest {

    @Test
    public void testToCountVowelsAndConsonants() throws InvalidTypeException {
        int[] correctResult = new int[2];
        correctResult[0] = 6;
        correctResult[1] = 7;
        int [] resultFromMethod = VowelsAndConsonants.toCountVowelsAndConsonants(this.text,5);
        assertEquals(resultFromMethod,correctResult);
    }
}