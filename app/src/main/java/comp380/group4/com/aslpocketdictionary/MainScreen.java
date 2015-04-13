package comp380.group4.com.aslpocketdictionary;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_screen);
    }

    public void goHome(View view) {
        setContentView(R.layout.activity_main_screen);
        Intent intent = new Intent(this, MainScreen.class);

    }

    //called when the user clicks the Search by Category button
    public void searchCategory(View view) {
        setContentView(R.layout.activity_search_by_category);
        //Do something in response to button
        Intent intent = new Intent(this, SearchByCategory.class);
    }

    /**
     * Called when the user clicks the Search By Word button
     */
    public void searchWord(View view) {
        setContentView(R.layout.activity_search_by_word);
        // Do something in response to button
        Intent intent = new Intent(this, SearchByWord.class);

    }
    //called when the user clicks the Training Game button
    public void trainingGame(View view) {
        setContentView(R.layout.activity_training_game);
        //Do something in response to button
        Intent intent = new Intent(this, TrainingGame.class);
    }

    //called when the user clicks the Learn More button
    public void learnMore(View view) {
        setContentView(R.layout.activity_learn_more_asl);
        //Do something in response to button
        Intent intent = new Intent(this, LearnMoreASL.class);
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

}
