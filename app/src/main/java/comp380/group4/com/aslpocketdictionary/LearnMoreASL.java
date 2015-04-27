package comp380.group4.com.aslpocketdictionary;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;


public class LearnMoreASL extends ActionBarActivity {

    TextView funFacts, signOfDay;
    String[] fun_facts;
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
        signOfDay = (TextView)findViewById(R.id.textView3);

        //display sign of the day
        Backend tbd = new Backend();
        ImageView i;//create a new image view
        i = (ImageView) findViewById(R.id.signoftheday);//associates the imageview i with 'mySpecialImage' in the XML
        String mDrawableName = tbd.pathArray2[index];//creates a string from a position and pathArray2
        int resID = getResources().getIdentifier(mDrawableName,"drawable", getPackageName());//turns the string path into a resource ID in drawable
        i.setImageResource(resID);//sets the image to the resource in resID
        String signName = tbd.wordArray2[index]; //creates a string from a position and pathArray2
        signOfDay.setText("Sign of the Day - \"" + signName + "\""); //display title with name of sign for the day

        funFacts.setText(fun_facts[index]);
    }
}