package comp380.group4.com.aslpocketdictionary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;


public class LearnMoreASL extends ActionBarActivity {

    TextView funFacts;
    String[] fun_facts;
    ArrayList<String> fun_factList = new ArrayList<>();
    int index;

    Calendar calendar = Calendar.getInstance();
    int dayOfYear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_learn_more_asl);

        //initialize dayOfYear
        dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        //import the fun facts string array from Values folder
        fun_facts = getResources().getStringArray(R.array.fun_facts);


        //initialize index
        index = dayOfYear%fun_facts.length;

        //initialize TextView
        funFacts = (TextView)findViewById(R.id.funFacts);

        //display sign of the day
        Backend tbd = new Backend();
        ImageView i;//create a new image view
        i = (ImageView) findViewById(R.id.signoftheday);//associates the imageview i with 'mySpecialImage' in the XML
        String mDrawableName = tbd.pathArray2[index];//creates a string from a position and pathArray2
        int resID = getResources().getIdentifier(mDrawableName,"drawable", getPackageName());//turns the string path into a resource ID in drawable
        i.setImageResource(resID);//sets the image to the resource in resID

        funFacts.setText(fun_facts[index]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_more_asl, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
