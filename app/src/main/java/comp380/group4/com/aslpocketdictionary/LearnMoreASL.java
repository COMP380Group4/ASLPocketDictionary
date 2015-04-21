package comp380.group4.com.aslpocketdictionary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;


public class LearnMoreASL extends ActionBarActivity {

    TextView funFacts;
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

        //initialize index
        index = dayOfYear%fun_facts.length;

        //initialize TextView
        funFacts = (TextView)findViewById(R.id.funFacts);

        //display sign of the day

        //import the fun facts string array from Values folder
        fun_facts = getResources().getStringArray(R.array.fun_facts);

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
