package edu.epam.task3;

import edu.epam.task3.validator.impl.XmlValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XmlValidatorTest {

    @Test
    public void testValidateXmlScheme() {
        assertTrue(XmlValidator.getInstance().validateXmlScheme("src/main/resources/candies.xml","src/main/resources/candies.xsd"));
    }
}