package parser;

import entity.enums.SkinType;
import entity.parser.SkinParser;
import org.junit.Assert;
import org.junit.Test;

public class SkinTypeParserTest {

    @Test
    public void testParseSkinNatural() {
        String strType = "natUraL";
        SkinType skinType = SkinParser.parseStrToSkinType(strType);
        Assert.assertEquals(SkinType.NATURAL, skinType);
    }

    @Test
    public void testParseSkinArtificial() {
        String strType = "artIficIal";
        SkinType skinType = SkinParser.parseStrToSkinType(strType);
        Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
    }

    @Test
    public void testParseSkinDefault() {
        String strType = "dwdfwdDECE";
        SkinType skinType = SkinParser.parseStrToSkinType(strType);
        Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
    }
}
