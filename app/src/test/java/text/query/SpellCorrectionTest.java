package text.query;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        try {
            sc.init(indexdir, dictfile);
            List<Term> termList = StandardTokenizer.segment("商品和服务");
            for(Term t: termList){
                System.out.print(String.format("word: %s, offset: %s, tag: %s\n", t.word, t.offset, t.nature));
            }

            String[] suggests = sc.predict("天汽预报");
            if (suggests != null && suggests.length > 0) {
                for (String suggest : suggests) {
                    System.out.println("您是不是想要找：" + suggest);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue( true );
    }
}
