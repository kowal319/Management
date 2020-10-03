package parser;


import entity.enums.Material;
import entity.enums.SkinType;
import entity.parser.MaterialParser;
import org.junit.Assert;
import org.junit.Test;

public class MaterialParserTest {

    @Test
    public void testMaterialParseLeather() {
        String strMaterial = "leatHer";
        Material material = MaterialParser.parseStrToMaterial(strMaterial);
        Assert.assertEquals(Material.LEATHER, material);
    }

    @Test
    public void testMaterialParseFur() {
        String strMaterial = "fUr";
        Material material = MaterialParser.parseStrToMaterial(strMaterial);
        Assert.assertEquals(Material.FUR, material);
    }

    @Test
    public void testMaterialParseCotton() {
        String strMaterial = "coTTon";
        Material material = MaterialParser.parseStrToMaterial(strMaterial);
        Assert.assertEquals(Material.COTTON, material);
    }

    @Test
    public void testMaterialParseWool() {
        String strMaterial = "wOOl";
        Material material = MaterialParser.parseStrToMaterial(strMaterial);
        Assert.assertEquals(Material.WOOL, material);
    }

    @Test
    public void testMaterialParsePolyesters() {
        String strMaterial = "poLyesters";
        Material material = MaterialParser.parseStrToMaterial(strMaterial);
        Assert.assertEquals(Material.POLYESTERS, material);
    }

    @Test
    public void testMaterialParseDefault() {
        String strMaterial = "dndjvW";
        Material material = MaterialParser.parseStrToMaterial(strMaterial);
        Assert.assertEquals(Material.POLYESTERS, material);
    }
}
