package comp380.group4.com.aslpocketdictionary;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrew on 4/21/2015.
 */
public class Backend {

        int size = 35;//Right now we're assuming the entire backend is hardcoded for speed and simplicity.

        String[] wordArray2 = {
                "hello", "good bye", "home", "work",
                "school", "store", "church", "day", "night",
                "week", "month", "year", "mom", "dad",
                "brother", "sister", "grandpa", "grandma", "please",
                "excuse", "thank you", "help", "who", "when",
                "where", "what", "happy", "angry", "sad",
                "sorry", "cry", "like", "good", "bad",
                "love",};


        String[] categoryArray2 = {
                "greetings", "greetings", "places", "places",
                "places", "places", "places", "time", "time",
                "time", "time", "time", "family", "family",
                "family", "family", "family", "family", "requests",
                "requests", "requests", "requests", "requests", "requests",
                "requests", "requests", "feelings", "feelings", "feelings",
                "feelings", "feelings", "feelings", "feelings", "feelings",
                "feelings"};

        String[] pathArray2 = {
                "hello.gif", "goodbye.gif", "home.gif", "work.gif", "school.gif",
                "store.gif", "church.gif", "day.gif", "night.gif", "week.gif",
                "month.gif", "year.gif", "mom.gif", "dad.gif", "sibiling.gif",
                "sibiling.gif", "grandpa.gif", "grandpa.gif", "please.gif", "excuse.gif",
                "thankyou.gif", "help.gif", "who.gif", "when.gif", "where.gif",
                "what.gif", "happy.gif", "angry.gif", "sad.gif", "sorry.gif",
                "cry.gif", "like.gif", "good.gif", "bad.gif", "love.gif"};


    //Turn the hardcoded arrays above to ArrayLists in order to use List view and use the
    //list methods to make thigns easier

    ArrayList<String> wordArray= new ArrayList<String>(Arrays.asList(wordArray2));
    ArrayList<String> categoryArray= new ArrayList<String>(Arrays.asList(categoryArray2));
    ArrayList<String> pathArray= new ArrayList<String>(Arrays.asList(pathArray2));

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
}

