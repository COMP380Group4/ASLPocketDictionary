package comp380.group4.com.aslpocketdictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class SearchByCategory extends Activity implements AdapterView.OnItemClickListener {

    ListView list;
    String[] listofCats = {
            "greetings",
            "places",
            "time",
            "family",
            "request",
            "feelings"
    };

    int[] picsOfCats ={
            R.drawable.greetings,
            R.drawable.places,
            R.drawable.time,
            R.drawable.family,
            R.drawable.requests,
            R.drawable.feelings
    };


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_category);

        Backend tbd = new Backend();
        // Array of strings storing country names

        Resources res = getResources();

        list = (ListView) findViewById(R.id.listViewCategories2);
        myCustomAdapter myNewAdapter = new myCustomAdapter(this, listofCats, picsOfCats);
        list.setAdapter(myNewAdapter);
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedFromList =(list.getItemAtPosition(position).toString());//this is to grab the string from the list lv
        Intent SBW = new Intent(getApplicationContext(),SearchByWord.class);// this is to create a new intent
        SBW.putExtra("myUniqueId", selectedFromList.toString());// this is to pass the string into the intent
        startActivity(SBW);
    }


    class myCustomAdapter extends ArrayAdapter<String> {

        Context context;
        int[] images;
        String[] categoryArray;
        myCustomAdapter(Context c, String[] cats, int imgs[]) {
            super(c, R.layout.single_rowcategory, R.id.textcategory, cats);
            this.context=c;
            this.images=imgs;
            this.categoryArray=cats;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.single_rowcategory, parent, false);
            ImageView myImage = (ImageView) row.findViewById(R.id.imagecategory);
            TextView myCategory = (TextView) row.findViewById(R.id.textcategory);

            myImage.setImageResource(images[position]);
            myCategory.setText(categoryArray[position]);

            return row;
        }
    }


}