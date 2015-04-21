package comp380.group4.com.aslpocketdictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;



public class SearchByCategory extends Activity {

    // Array of strings storing country names
    String[] category = new String[] {
            "Hello, Good-Bye & other common Greetings in ASL",
            "Who, What, & other common Questions in ASL",
            "Colors, Furniture, & other Common Words in ASL",
            "Months, Days, & other common Calendar Words in ASL"
    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] catpic = new int[]{
            R.drawable.greetings,
            R.drawable.questions,
            R.drawable.commonwords,
            R.drawable.calendar

    };

    // Array of strings to store currencies
    String[] wordcount = new String[]{
            "7",
            "5",
            "15",
            "12"
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_category);

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<4;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", "" + category[i]);
            hm.put("cur","Word Count : " + wordcount[i]);
            hm.put("flag", Integer.toString(catpic[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.list_view);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
    }
}
