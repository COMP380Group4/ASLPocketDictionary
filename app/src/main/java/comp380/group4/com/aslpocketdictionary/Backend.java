package comp380.group4.com.aslpocketdictionary;

import android.content.Context;
import android.net.Uri;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrew on 4/21/2015.
 */
public class Backend {

    Context recievedContext;

    int size = 35;//Right now we're assuming the entire backend is hardcoded for speed and simplicity.

    String[] wordArray2;

    String[] categoryArray2;

    String[] pathArray2;

    ArrayList<String> wordArray;
    ArrayList<String> categoryArray;
    ArrayList<String> pathArray;

    MyApp contextHelper = new MyApp();

    public Backend(Context c) throws JSONException {

        recievedContext = c;
        Dictionary myNewDictionary = new Dictionary(c);
        int length = myNewDictionary.lengthOfDictionaryOfEntries();
        wordArray2 = new String[length];
        categoryArray2 = new String [length];
        pathArray2 = new String[length];
        for(int j = 0; j< length; j++){
            Entry tempEntry = new Entry();
            tempEntry = myNewDictionary.getEntryNumber(j);

            wordArray2[j] = tempEntry.word;
            categoryArray2[j] = tempEntry.category;
            pathArray2[j]= tempEntry.path;

        }

        makeArrays();
    }

    //Turn the hardcoded arrays above to ArrayLists in order to use List view and use the
    //list methods to make things easier
    void makeArrays(){
        wordArray= new ArrayList<String>(Arrays.asList(wordArray2));
        categoryArray= new ArrayList<String>(Arrays.asList(categoryArray2));
        pathArray= new ArrayList<String>(Arrays.asList(pathArray2));

    }


    //these GETTERS are to return an array in order to use the ListViews in the XML files
    ArrayList<String> getWordArray(){
        return wordArray;
    }

    ArrayList<String> getCategoryArray(){
        return categoryArray;
    }

    ArrayList<String> pathArray(){
        return categoryArray;
    }

//Provide the index, assuming you are a word and these will provide a String in the case of category
    // or in the case of path, a URI

    String getSpecificCateogry(int s){//provide an index
        return categoryArray.get(s);//returns the category at the index
    }

    Uri getSpecificPath(int s){//input a specific array index and it SHOULD output the URI to get the image...
        String myPath = pathArray.get(s);
        return Uri.parse("android.resource://comp380.group4.com.aslpocketdictionary/raw/"+myPath);
    }

    int getAPosition(String s) {
        int i = 0;
        String testMe = wordArray2[i];//grabs the string in the array because things were bugging out the more complicated I let it become
        for(i=0; !s.equals(testMe); i++){//this goe through the entire array looking for a match
            testMe=wordArray2[i+1];
        }
        return i;//returns the match
    }
}