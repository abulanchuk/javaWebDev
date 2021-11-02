package edu.epam.task3.validator.impl;

import edu.epam.task3.parser.util.SweetsHandler;
import edu.epam.task3.validator.CustomXmlValidator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator implements CustomXmlValidator {
    private static Logger logger = LogManager.getLogger(XmlValidator.class);
    private static XmlValidator instance;

    private XmlValidator() {
    }

    public static XmlValidator getInstance() {
        if (instance == null) {
            instance = new XmlValidator();
        }
        return instance;
    }

    public boolean validateXmlScheme(String xmlPath, String xsdPath) {

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(xsdPath);
        boolean isValid = true;

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.setErrorHandler(new SweetsHandler());
            validator.validate(source);
        } catch (SAXException e) {
            logger.log(Level.ERROR, xmlPath + "is not valid");
            isValid = false;
        } catch (IOException e) {
            logger.log(Level.ERROR, xmlPath + "is not found");
            isValid = false;
        }

        return isValid;
    }
}
