package ardnahcimor.orp.truecallercalls.model;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by romichandra on 27-08-2017.
 */

public class modelWordCount {
    String htmlContent;
    TreeMap<String,Integer> wordCount;

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public TreeMap<String, Integer> getWordCount() {
        return wordCount;
    }

    public void setWordCount(TreeMap<String, Integer> wordCount) {
        this.wordCount = wordCount;
    }
}
