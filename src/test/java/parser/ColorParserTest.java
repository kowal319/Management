package parser;

import entity.enums.Color;
import entity.parser.ColorParser;
import org.junit.Assert;
import org.junit.Test;

public class ColorParserTest {

    @Test
    public void testParseColorBlue() {
        String strColor = "bluE";
        Color color = ColorParser.parseStrToColor(strColor);
        Assert.assertEquals(Color.BLUE, color);
    }

    @Test
    public void testParseColorWhite(){
        String strColor = "White";
        Color color = ColorParser.parseStrToColor(strColor);
        Assert.assertEquals(Color.WHITE, color);
    }

    @Test
    public void testParseColorBlack(){
        String strColor = "bLaCk";
        Color color = ColorParser.parseStrToColor(strColor);
        Assert.assertEquals(Color.BLACK, color);
    }

    @Test
    public void testParseColorRed(){
        String strColor = "rEd";
        Color color = ColorParser.parseStrToColor(strColor);
        Assert.assertEquals(Color.RED, color);
    }

    @Test
    public void testParseColorGreen(){
        String strColor = "green";
        Color color = ColorParser.parseStrToColor(strColor);
        Assert.assertEquals(Color.GREEN, color);
    }

    @Test
    public void testParseColorYellow(){
        String strColor = "YeLloW";
        Color color = ColorParser.parseStrToColor(strColor);
        Assert.assertEquals(Color.YELLOW, color);
    }

    @Test
    public void testPareColorNoColor(){
        String strColor = "sadfdsf";
        Color  color = ColorParser.parseStrToColor(strColor);
        Assert.assertEquals(Color.WHITE, color);

    }
    }