package text.query;


import org.apache.log4j.Logger;


/**
 * SpellCorrection
 *
 */
public class SpellCorrection
{

    final static Logger logger = Logger.getLogger(SpellCorrection.class);

    public SpellCorrection(){

    }

    /**
     * Init Spell Correction Instance
     * @param indexDir
     * @param dictPath
     */
    public void init(final String indexDir, final String dictPath){
        logger.info(String.format("init indexDir: %s, dictPath: %s", indexDir, dictPath));
    }

}
