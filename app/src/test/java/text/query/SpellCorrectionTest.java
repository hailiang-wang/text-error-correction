package text.query;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test for simple SpellCorrection.
 */
public class SpellCorrectionTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SpellCorrectionTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SpellCorrectionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCorrect()
    {
        Path currentRelativePath = Paths.get("..");
        String curdir = currentRelativePath.toAbsolutePath().toString();
        Path indexdir = Paths.get(curdir, "tmp", "lucene.spell-correction");
        Path dictfile = Paths.get(curdir, "app", "src", "main", "resources", "pipimovieUTF8.txt");
        SpellCorrection sc = new SpellCorrection();
        sc.init(indexdir.toString(), dictfile.toString());
        assertTrue( true );
    }
}
