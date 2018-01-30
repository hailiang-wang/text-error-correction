package text.query;


import org.apache.log4j.Logger;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import java.io.IOException;
import java.nio.file.Path;

/**
 * SpellCorrection
 *
 */
public class SpellCorrection
{
    final static Logger logger = Logger.getLogger(SpellCorrection.class);
    private FSDirectory fsDirectory = null;
    private PlainTextDictionary plainTextDictionary = null;
    private SpellChecker spellChecker = null;
    private IndexWriterConfig indexWriterConfig;
    private boolean isInited = false;


    public SpellCorrection(){

    }

    /**
     * Init Spell Correction Instance
     * @param indexDir
     * @param dictPath
     */
    public void init(final Path indexDir, final Path dictPath) throws IOException {
        logger.info(String.format("init indexDir: %s, dictPath: %s", indexDir.toString(), dictPath.toString()));
        this.fsDirectory = FSDirectory.open(indexDir);
        this.spellChecker = new SpellChecker(this.fsDirectory);
        this.plainTextDictionary = new PlainTextDictionary(dictPath);
        this.indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
        this.spellChecker.indexDictionary(this.plainTextDictionary, this.indexWriterConfig, true);
        this.isInited = true;
    }

    public String[] predict(final String query) throws IOException {
        logger.info(String.format("predict: %s", query));
        String[] suggests = this.spellChecker.suggestSimilar(query,3);
        return  suggests;
    }

}
