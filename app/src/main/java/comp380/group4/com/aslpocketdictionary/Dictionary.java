package comp380.group4.com.aslpocketdictionary;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;
import org.json.*;

/**
 * Created by andrewhoang on 12/2/16.
 */

public class Dictionary implements DictionaryInterface{
    Context myContext ;
    String location = "listofwordsjson.json";
    private ArrayList<Entry> dictionary;


    public Dictionary(Context c) throws JSONException {//constructor
        //instantiates the array list
        myContext = c;
        ArrayList<Entry> dictionary = new ArrayList<Entry>();

        //Read from json and create the entries
        jsonToEntries();


        //Create and Put Entries

    }

    private JSONArray parseJSONData() {
        String JSONString = null;
        JSONObject JSONObject = null;
        JSONArray jsonArray = null;
        try {

            //open the inputStream to the file
            InputStream inputStream = myContext.getAssets().open(location);

            int sizeOfJSONFile = inputStream.available();

            //array that will store all the data
            byte[] bytes = new byte[sizeOfJSONFile];

            //reading data into the array from the file
            inputStream.read(bytes);

            //close the input stream
            inputStream.close();

            JSONString = new String(bytes, "UTF-8");  //here the byte array which has the data needs to be turned into something
            JSONObject = new JSONObject(JSONString);
            jsonArray = JSONObject.getJSONArray("dictionary");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        catch (JSONException x) {
            x.printStackTrace();
            return null;
        }
        return jsonArray;
   }


    private void jsonToEntries() throws JSONException {//read from a JSON file, put JSON into an entry, STOP when there is no more to read
        //Dictionary is created, now to read JSON objects

        JSONArray myJsonStuff = parseJSONData();
        Toast.makeText(myContext,"I got passed parsing!",Toast.LENGTH_SHORT).show();

        for(int i = 0; i< myJsonStuff.length(); i++){
            JSONObject row = myJsonStuff.getJSONObject(i);

            String theWord = row.getString("word");
            String theCat = row.getString("category");
            String thePath = row.getString("path");

            Toast.makeText(myContext,theWord + theCat + thePath +" "+ i,Toast.LENGTH_LONG).show();

        }

        //loop until no more JSON objects
        //read a JSON object
        //call createEntry
        //put Entry into the dictionary


    }

    private void createEntry() {//creates an entry object

    }

    private void putEntry() {//passes an entry into the dictionary

    }

    @Override
    public void startOfDictionary() {

    }

    @Override
    public void nextEntryInDictionary() {

    }

    @Override
    public String getWordFromEntry() {
        return null;
    }

    @Override
    public String getCatFromEntry() {
        return null;
    }

    @Override
    public String getPathFromEntry() {
        return null;
    }




}

