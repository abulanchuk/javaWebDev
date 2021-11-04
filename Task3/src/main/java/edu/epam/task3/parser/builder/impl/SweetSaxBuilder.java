package edu.epam.task3.parser.builder.impl;

import edu.epam.task3.exception.ParserException;
import edu.epam.task3.parser.builder.CustomBuilder;
import edu.epam.task3.parser.util.SweetsHandler;

import edu.epam.task3.entity.Sweet;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class SweetSaxBuilder implements CustomBuilder {
    private static Logger logger = LogManager.getLogger(SweetSaxBuilder.class);

    @Override
    public Set<Sweet> getSweets() {
        return sweets;
    }

    private Set<Sweet> sweets;
    private SweetsHandler sweetsHandler;
    private XMLReader reader;

    public SweetSaxBuilder() throws ParserException {
        sweetsHandler = new SweetsHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.log(Level.ERROR, "some problems with SAX parser");
            throw new ParserException("some problems with SAX parser");
        }
        reader.setContentHandler(sweetsHandler);
    }

    @Override
    public void buildSweetSet(String xmlPath) throws ParserException {
        try {
            reader.parse(xmlPath);
        } catch (SAXException e) {
            logger.log(Level.ERROR, "some problems with SAX parser");
            throw new ParserException(e.getMessage());
        } catch (IOException e) {
            logger.log(Level.ERROR, "file not found in SAX parser");
            throw new ParserException(e.getMessage());
        }
        sweets = sweetsHandler.getSweets();
    }

}
