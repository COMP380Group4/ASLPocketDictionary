package comp380.group4.com.aslpocketdictionary;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;
/**
 * Created by Raffi on 4/17/2015.
 */
public class TrainingGameResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_game_result);
//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
        TextView t=(TextView)findViewById(R.id.textResult);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        switch (score)
        {
            case 1:
            case 2: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 3:
            case 4:t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 5:t.setText("Who are you? A trivia wizard???");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_training_game_result, menu);
        return true;
    }
}
