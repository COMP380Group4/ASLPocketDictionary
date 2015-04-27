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
    ArrayList<String> productList = new ArrayList<String>();//initialize the Array list
    String[] products;//initialize products

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_word);

        // Listview Data
        Backend theBigDatabase = new Backend();//run it to create a backend object to use everywhere.

        Bundle extras = getIntent().getExtras();//get some info if anything is passed
        if(extras != null) {//makes sure we're not operating on anything null. This also prevents the bottom code from running if it isn't being requested by searchbycategory
            String myNewString = extras.getString("myUniqueId");
            for (int i = 0; i < 35; i++) {
                if (theBigDatabase.categoryArray2[i].equals(myNewString)) {//if we have a category match, then add the associated word from the word array into the productlist
                    productList.add(theBigDatabase.wordArray2[i]);
                }
                else{

                }
            }
           products = productList.toArray(new String[productList.size()]);//if we got passed a category use the productlist to create a product array

        }else{
           products= theBigDatabase.wordArray.toArray(new String[theBigDatabase.wordArray.size()]);//if there is nothing coming in from an intent, just grab the whole thing
        }

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
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
        //Bundle dataBundle = new Bundle();
        String selectedFromList =(lv.getItemAtPosition(position).toString());//this is to grab the string from the list lv
        Intent ds = new Intent(getApplicationContext(),DisplaySign.class);// this is to create a new intent
        ds.putExtra("myUniqueId", selectedFromList.toString());// this is to pass the string into the intent
        startActivity(ds);
        //dataBundle.putInt("Position",position);
        //dataBundle.putString(selected,selected);

        //ds.putExtra(selected,selected);
       // ds.putExtras(dataBundle);

        //Backend tbd = new Backend();//run it to create a backend object to use everywhere.
        //Toast.makeText(this, tbd.pathArray.get(position), Toast.LENGTH_SHORT).show();//displays in a toast the path store in the file
        //Toast.makeText(this, tbd.getSpecificPath(position).toString(), Toast.LENGTH_SHORT).show();//returns the URI then changes it to a STRING to display

    }

}
