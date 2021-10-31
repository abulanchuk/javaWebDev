package edu.epam.task3.parser.util;

import entity.Candy;
import entity.Chocolate;
import entity.Sweet;
import entity.enumsource.PackagingType;
import entity.enumsource.Production;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;


import org.apache.log4j.Logger;

public class SweetsHandler extends DefaultHandler {
    private static Logger logger = LogManager.getLogger(SweetsHandler.class);
    private Set<Sweet> sweets;
    private Sweet currentSweet;
    private SweetTag currentXmlTag = null;
    private EnumSet<SweetTag> withText;

    // TODO: name convention?
    private final String candyNameTag = SweetTag.CANDY.getValue();
    private final String chocolateNameTag = SweetTag.CHOCOLATE.getValue();

    public SweetsHandler() {
        sweets = new HashSet<>();
        withText = EnumSet.range(SweetTag.NAME, SweetTag.FILLED);
    }

    public Set<Sweet> getSweets() {
        return sweets;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        boolean isCandyOrChocolate = candyNameTag.equals(qName) || chocolateNameTag.equals(qName);

        if (!isCandyOrChocolate) {
            SweetTag openedXmlTag = SweetTag.valueOf(convertXmlTagNameToUpperCase(qName));
            if (withText.contains(openedXmlTag)) {
                currentXmlTag = openedXmlTag;
            }
            return;
        }

        if (candyNameTag.equals(qName)) {
            currentSweet = new Candy();
            logger.log(Level.INFO, "Created candy");
        } else {
            currentSweet = new Chocolate();
            logger.log(Level.INFO, "Created chocolate");
        }

        for (int i = 0; i < attributes.getLength(); i++) {
            String attributeName = convertXmlTagNameToUpperCase(attributes.getQName(i));
            SweetTag attributeTag = SweetTag.valueOf(attributeName);

            // TODO: Add default branch
            switch (attributeTag) {
                case ID -> currentSweet.setId(attributes.getValue(i));
                case PACKING -> {
                    PackagingType type = PackagingType.valueOf(attributes.getValue(i));
                    currentSweet.setPacking(type);
                }
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        boolean isCandyOrChocolate = candyNameTag.equals(qName) || chocolateNameTag.equals(qName);
        if (isCandyOrChocolate) {
            sweets.add(currentSweet);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String tagText = new String(ch, start, length);
        if (currentXmlTag == null) {
            return;
        }

        switch (currentXmlTag) {
            case NAME -> currentSweet.setName(tagText);
            case PACKING_TIME -> currentSweet.setPackingTime(LocalDate.parse(tagText));
            case ENERGY -> currentSweet.setEnergy(Integer.parseInt(tagText));
            case SUGAR -> currentSweet.setSugar(Integer.parseInt(tagText));
            case BUTTER -> currentSweet.setButter(Integer.parseInt(tagText));
            case PROTEIN -> currentSweet.getValue().setProtein(Double.parseDouble(tagText));
            case FATS -> currentSweet.getValue().setFats(Double.parseDouble(tagText));
            case CARBOHYDRATES -> currentSweet.getValue().setCarbohydrates(Double.parseDouble(tagText));
            case PRODUCTION -> currentSweet.setProduction(Production.valueOf(tagText));
            case FILLED -> ((Candy) currentSweet).setFilled(Boolean.parseBoolean(tagText));
            default -> throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
        }
        currentXmlTag = null;
    }

    private String convertXmlTagNameToUpperCase(String name) {
        return name.replace("-", "_")
                .toUpperCase();
    }
}
