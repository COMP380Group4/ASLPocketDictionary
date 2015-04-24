package comp380.group4.com.aslpocketdictionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class SearchByWord extends Activity implements AdapterView.OnItemClickListener {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_word);

        // Listview Data

        Backend theBigDatabase = new Backend();//run it to create a backend object to use everywhere.
        String products[] = theBigDatabase.wordArray2;
        /*String products[] = {"Hello", "Good-Bye", "School", "Class", "Morning",
                "Night", "Thanks",
                "Why", "Midterm", "Professor", "friend"};
        /*

         */
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                SearchByWord.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }


        });
    }

    //this is not in onCreate this a seperate method
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle dataBundle = new Bundle();
        dataBundle.putInt("Position",position);
        Intent ds = new Intent(getApplicationContext(),DisplaySign.class);
        ds.putExtras(dataBundle);
        startActivity(ds);
        //Backend tbd = new Backend();//run it to create a backend object to use everywhere.
        //Toast.makeText(this, tbd.pathArray.get(position), Toast.LENGTH_SHORT).show();//displays in a toast the path store in the file
        //Toast.makeText(this, tbd.getSpecificPath(position).toString(), Toast.LENGTH_SHORT).show();//returns the URI then changes it to a STRING to display

    }

}
