package edu.epam.task3.parser.builder.impl;

import edu.epam.task3.exception.ParserException;
import edu.epam.task3.parser.builder.CustomBuilder;
import edu.epam.task3.parser.util.SweetTag;
import entity.Candy;
import entity.Chocolate;
import entity.Sweet;
import entity.enumsource.CandyType;
import entity.enumsource.ChocolateType;
import entity.enumsource.PackagingType;
import entity.enumsource.Production;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class SweetStaxBuilder implements CustomBuilder {
    private static Logger logger = LogManager.getLogger(SweetStaxBuilder.class);
    private Set<Sweet> sweets;
    private XMLInputFactory inputFactory;

    public SweetStaxBuilder() {
        this.sweets = new HashSet<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public Set<Sweet> getSweets() {
        return sweets;
    }

    private Sweet buildSweets(XMLStreamReader reader) throws XMLStreamException {
        Sweet sweet = null;
        String name = reader.getLocalName();
        if (name.equals(SweetTag.CANDY.getValue())) {
            sweet = new Candy();
            Candy candy = (Candy) sweet;
            //String candyAttributeValue = reader.getAttributeValue(null, SweetTag.CANDY_TYPE.getValue());
            //candy.setCandyType(CandyType.valueOf(candyAttributeValue));
        } else if (name.equals(SweetTag.CHOCOLATE.getValue())) {
            sweet = new Chocolate();
            Chocolate chocolate = (Chocolate) sweet;
            //String chocolateAttributeValue = reader.getAttributeValue(null, SweetTag.CHOCOLATE_TYPE.getValue());
            //chocolate.setChocolateType(ChocolateType.valueOf(chocolateAttributeValue));
        }
        sweet.setId(reader.getAttributeValue(null, SweetTag.ID.getValue()));
        String packingAttributeValue = reader.getAttributeValue(null, SweetTag.PACKAGING.getValue());
        if (packingAttributeValue!=null){
            sweet.setPacking(PackagingType.valueOf(packingAttributeValue.toUpperCase()));
        }


        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    name = reader.getLocalName();
                    switch (SweetTag.valueOf(name.toUpperCase().replace("-", "_"))) {
                        case NAME -> sweet.setName(getXMLText(reader));
                        case PACKING_TIME -> sweet.setPackingTime(LocalDate.parse(getXMLText(reader)));
                        case ENERGY -> sweet.setEnergy(Integer.parseInt(getXMLText(reader)));
                        case SUGAR -> sweet.setSugar(Integer.parseInt(getXMLText(reader)));
                        case BUTTER -> sweet.setButter(Integer.parseInt(getXMLText(reader)));
                        case SWEETS_VALUE -> {
                        }
                        case PROTEIN -> sweet.getValue().setProtein(Double.parseDouble(getXMLText(reader)));
                        case FATS -> sweet.getValue().setFats(Double.parseDouble(getXMLText(reader)));
                        case CARBOHYDRATES -> sweet.getValue().setCarbohydrates(Double.parseDouble(getXMLText(reader)));
                        case PRODUCTION -> sweet.setProduction(Production.valueOf(getXMLText(reader).toUpperCase()));
                        case CANDY_TYPE -> ((Candy) sweet).setCandyType(CandyType.valueOf(getXMLText(reader).toUpperCase()));
                        case CHOCOLATE_TYPE -> ((Chocolate) sweet).setChocolateType(ChocolateType.valueOf(getXMLText(reader).toUpperCase()));
                        case FILLED -> ((Candy) sweet).setFilled(Boolean.parseBoolean(getXMLText(reader)));
                        default -> {
                            logger.log(Level.ERROR, name + "is not expected");
                            throw new EnumConstantNotPresentException(SweetTag.class, name);
                        }
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (name.equals(SweetTag.CHOCOLATE.getValue()) || name.equals(SweetTag.CANDY.getValue())) {
                        return sweet;
                    }
                }
            }
        }
        return sweet;
    }

    @Override
    public void buildSweetSet(String xmlPath) throws ParserException {
        XMLStreamReader streamReader = null;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(xmlPath))) {
            streamReader = inputFactory.createXMLStreamReader(inputStream);
            while (streamReader.hasNext()) {
                int type = streamReader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = streamReader.getLocalName();
                    if (name.equals(SweetTag.CANDY.getValue())) {
                        Candy candy = (Candy) buildSweets(streamReader);
                        sweets.add(candy);
                    } else if (name.equals(SweetTag.CHOCOLATE.getValue())) {
                        Chocolate chocolate = (Chocolate) buildSweets(streamReader);
                        sweets.add(chocolate);
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.log(Level.ERROR, "some problems with STAX parser");
            throw new ParserException("some problems in STAX parser");
        } catch (IOException e) {
            throw new ParserException("file not found in STAX parser");
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }

        return text;
    }
}
