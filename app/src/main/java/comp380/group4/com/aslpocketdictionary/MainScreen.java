package comp380.group4.com.aslpocketdictionary;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //shouldn't need to create all the arrays.
        // Backend theBigDatabase = new Backend();//run it to create a backend object to use everywhere.
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_screen);
        //Bundle extras = getIntent().getExtras();//extra should be passed form the basictraininggame activity
        /*if(extras != null) {//makes sure we're not operating on anything null
            int score = extras.getInt("yourScore");//assigns scores
            int total = extras.getInt("yourTotal");//assigns questions
            Toast.makeText(getApplication(), "You Scored " + score + " Out of " + total, Toast.LENGTH_LONG).show();//shows score/questions
            getIntent().removeExtra("yourScore");//clean up
            getIntent().removeExtra("yourTotal");//clean up
        }*/


    }

    public void goHome(View view) {
        setContentView(R.layout.activity_main_screen);
        Intent intent = new Intent(this, MainScreen.class);

    }

    //called when the user clicks the Search by Category button
    public void searchCategory(View view) {
        Intent SBCList=new Intent(getApplicationContext(),SearchByCategory.class);
        startActivity(SBCList);
    }

    /**
     * Called when the user clicks the Search By Word button
     */
    public void searchWord(View view) {
        Intent SBWList=new Intent(getApplicationContext(),SearchByWord.class);
        startActivity(SBWList);

    }
    //called when the user clicks the Training Game button
    public void trainingGame(View view) {
        Intent TGList=new Intent(getApplicationContext(),BasicTrainingGameActivity.class);
        startActivity(TGList);
    }

    //called when the user clicks the Learn More button
    public void learnMore(View view) {
        Intent LMList=new Intent(getApplicationContext(), LearnMoreASL.class);
        startActivity(LMList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
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

    public void onBackPressed() {

        return;
    }

}
