package comp380.group4.com.aslpocketdictionary;

/**
 * Created by andrewhoang on 12/2/16.
 */

public interface EntryInterface {
    void putEntryWord(String s);

    void putEntryCategory(String s);

    void putEntryPath(String s);

    String getEntryWord();

    String getEntryCategory();

    String getEntryPath();
}
