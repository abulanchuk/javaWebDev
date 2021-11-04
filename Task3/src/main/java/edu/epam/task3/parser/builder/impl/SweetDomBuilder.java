package edu.epam.task3.parser.builder.impl;

import edu.epam.task3.exception.ParserException;
import edu.epam.task3.parser.builder.CustomBuilder;
import edu.epam.task3.parser.util.SweetTag;
import edu.epam.task3.entity.Candy;
import edu.epam.task3.entity.Chocolate;
import edu.epam.task3.entity.Sweet;
import edu.epam.task3.entity.enumsource.CandyType;
import edu.epam.task3.entity.enumsource.ChocolateType;
import edu.epam.task3.entity.enumsource.PackagingType;
import edu.epam.task3.entity.enumsource.Production;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class SweetDomBuilder implements CustomBuilder {
    private static Logger logger = LogManager.getLogger(SweetDomBuilder.class);
    private Set<Sweet> sweets;
    private DocumentBuilder documentBuilder;

    public void setSweets(Set<Sweet> sweets) {
        this.sweets = sweets;
    }

    public SweetDomBuilder() throws ParserConfigurationException {
        this.sweets = new HashSet<Sweet>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
    }

    public Set<Sweet> getSweets() {
        return sweets;
    }

    @Override
    public void buildSweetSet(String xmlPath) throws ParserException {
        Document document;
        try {
            document = documentBuilder.parse(xmlPath);
            Node root = document.getDocumentElement();
            NodeList sweets = root.getChildNodes();
            for (int i = 0; i < sweets.getLength(); i++) {
                Node node = sweets.item(i);
                if (node.getNodeType() != Node.TEXT_NODE) {
                    String nodeName = node.getLocalName();

                    if (nodeName.equals(SweetTag.CANDY.getValue())) {
                        Candy candy = buildCandy(node);
                        this.sweets.add(candy);
                    } else if (nodeName.equals(SweetTag.CHOCOLATE.getValue())) {
                        Chocolate chocolate = buildChocolate(node);
                        this.sweets.add(chocolate);
                    }
                }
            }

        } catch (SAXException | IOException e) {
            logger.log(Level.ERROR, "some problems with DOM parser");
            e.printStackTrace();
            throw new ParserException(e.getMessage());
        }
    }


    private void fillSweetValue(Node valueNode, Sweet sweet) throws ParserException {
        sweet.getValue().setFats(Double.parseDouble(getNodeTextContent(valueNode, SweetTag.FATS)));
        sweet.getValue().setCarbohydrates(Double.parseDouble(getNodeTextContent(valueNode, SweetTag.CARBOHYDRATES)));
        sweet.getValue().setProtein(Double.parseDouble(getNodeTextContent(valueNode, SweetTag.PROTEIN)));
    }

    private void fillCommonFields(Node node, Sweet sweet) throws ParserException {
        String id;
        sweet.setId(node.getAttributes().getNamedItem(SweetTag.ID.getValue()).getNodeValue());

        Node packagingAttrNode = node.getAttributes().getNamedItem(SweetTag.PACKAGING.getValue());
        if (packagingAttrNode != null) {
            sweet.setPacking(PackagingType.valueOf(packagingAttrNode.getNodeValue().toUpperCase()));
        }
        sweet.setName(getNodeTextContent(node, SweetTag.NAME));
        fillSweetValue(getNodeByName(node, SweetTag.SWEETS_VALUE.getValue()), sweet);
        sweet.setPackingTime(LocalDate.parse(getNodeTextContent(node, SweetTag.PACKING_TIME)));
        sweet.setEnergy(Integer.parseInt(getNodeTextContent(node, SweetTag.ENERGY)));
        sweet.setSugar(Integer.parseInt(getNodeTextContent(node, SweetTag.SUGAR)));
        sweet.setButter(Integer.parseInt(getNodeTextContent(node, SweetTag.BUTTER)));
        sweet.setProduction(Production.valueOf(getNodeTextContent(node, SweetTag.PRODUCTION).toUpperCase(Locale.ROOT)));
    }

    private Candy buildCandy(Node root) throws ParserException {
        Candy candy = new Candy();
        fillCommonFields(root, candy);

        candy.setCandyType(CandyType.valueOf(getNodeTextContent(root, SweetTag.CANDY_TYPE).toUpperCase(Locale.ROOT)));
        candy.setFilled(Boolean.parseBoolean(getNodeTextContent(root, SweetTag.FILLED)));
        return candy;
    }

    private Chocolate buildChocolate(Node root) throws ParserException {
        Chocolate chocolate = new Chocolate();
        fillCommonFields(root, chocolate);

        chocolate.setChocolateType(ChocolateType.valueOf(getNodeTextContent(root, SweetTag.CHOCOLATE_TYPE).toUpperCase(Locale.ROOT)));
        return chocolate;
    }

    private Node getNodeByName(Node parentNode, String targetNodeName) throws ParserException {
        NodeList children = parentNode.getChildNodes();
        for (int i = 0; i < children.getLength(); ++i) {
            Node current = children.item(i);
            if (current.getNodeName().equals(targetNodeName)) {
                return current;
            }
        }
        logger.log(Level.ERROR, "some problems with DOM parser. Node " + targetNodeName + " not found");
        throw new ParserException("Node " + targetNodeName + " not found");
    }

    private String getNodeTextContent(Node parentNode, SweetTag tagName) throws ParserException {
        String tagStringName = tagName.getValue();
        Node node = getNodeByName(parentNode, tagStringName);
        return node.getTextContent();
    }
}
