package comp380.group4.com.aslpocketdictionary;

/**
 * Created by andrewhoang on 12/2/16.
 */

public interface DictionaryInterface {
    void startOfDictionary();//goes to beginning of the dictionary
    void nextEntryInDictionary();//goes to the next entry of the dictionary to traverse the list
    String getWordFromEntry();//gets a word from an entry  in the dictionary
    String getCatFromEntry();//gets a category from an entry in the dictionar
    String getPathFromEntry();// gets a path from an entry in the dictionary

}

