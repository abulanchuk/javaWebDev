package edu.epam.task3;

import edu.epam.task3.entity.Candy;
import edu.epam.task3.entity.Chocolate;
import edu.epam.task3.entity.Sweet;
import edu.epam.task3.entity.SweetsValue;
import edu.epam.task3.exception.ParserException;
import edu.epam.task3.parser.builder.CustomBuilder;
import edu.epam.task3.parser.builder.impl.SweetDomBuilder;
import edu.epam.task3.parser.builder.impl.SweetSaxBuilder;
import edu.epam.task3.parser.builder.impl.SweetStaxBuilder;

import edu.epam.task3.entity.enumsource.CandyType;
import edu.epam.task3.entity.enumsource.ChocolateType;
import edu.epam.task3.entity.enumsource.PackagingType;
import edu.epam.task3.entity.enumsource.Production;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SweetBuildersTest {

    private List<Sweet> sweets;

    @BeforeClass
    public void fillExpectedSweets() {
        Candy correctCandy = new Candy("c1", "Ferrero Rocher", LocalDate.parse("2021-04-01"), 603, 15, 10,
                new SweetsValue(8, 43, 44), Production.FERRERO, CandyType.CHOCO,
                PackagingType.YELLOW, true);

        Chocolate correctChocolate = new Chocolate(
                "ch1", "Alenka", LocalDate.parse("2021-05-21"), 560, 30, 20,
                new SweetsValue(7.1, 35.6, 52.4),
                Production.KOMMUNARKA, ChocolateType.MILK, PackagingType.BLACK
        );

        sweets = new ArrayList<>();
        sweets.add(correctCandy);
        sweets.add(correctChocolate);
    }


    @Test
    public void testBuildSweetSetDom() throws ParserException, ParserConfigurationException {
        CustomBuilder sweetDomBuilder = new SweetDomBuilder();
        sweetDomBuilder.buildSweetSet("src/main/resources/candies_test.xml");

        var sortedOutput = sweetDomBuilder.getSweets().stream().sorted(Comparator.comparing(Sweet::getId)).toArray();

        assertTrue(Arrays.deepEquals(sortedOutput, sweets.toArray()));
    }

    @Test
    public void testBuildSweetSetSax() throws ParserException, ParserConfigurationException {
        CustomBuilder sweetDomBuilder = new SweetSaxBuilder();
        sweetDomBuilder.buildSweetSet("src/main/resources/candies_test.xml");

        var sortedOutput = sweetDomBuilder.getSweets().stream().sorted(Comparator.comparing(Sweet::getId)).toArray();

        assertTrue(Arrays.deepEquals(sortedOutput, sweets.toArray()));

    }

    @Test
    public void testBuildSweetSetStax() throws ParserException, ParserConfigurationException {
        CustomBuilder sweetDomBuilder = new SweetStaxBuilder();
        sweetDomBuilder.buildSweetSet("src/main/resources/candies_test.xml");

        var sortedOutput = sweetDomBuilder.getSweets().stream().sorted(Comparator.comparing(Sweet::getId)).toArray();

        assertTrue(Arrays.deepEquals(sortedOutput, sweets.toArray()));
    }
}