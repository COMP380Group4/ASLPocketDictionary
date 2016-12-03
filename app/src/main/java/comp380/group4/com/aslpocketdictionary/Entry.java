package comp380.group4.com.aslpocketdictionary;

import java.security.KeyStore;

/**
 * Created by andrewhoang on 12/2/16.
 */

public class Entry implements EntryInterface {
    //Each entry consists for a word, category, and path

    String word;
    String category;
    String path;

    void Entry(){//constructor

    }


    @Override
    public void putEntryWord(String s) {
        word = s;

    }

    @Override
    public void putEntryCategory(String s) {
        category=s;

    }

    @Override
    public void putEntryPath(String s) {
        path=s;

    }

    @Override
    public String getEntryWord() {
        String result = "Word not set";

        return result;
    }

    @Override
    public String getEntryCategory() {
        String result = "Category not set";

        return result;

    }

    @Override
    public String getEntryPath() {
        String result = "Result not set";

        return result;
    }
}
