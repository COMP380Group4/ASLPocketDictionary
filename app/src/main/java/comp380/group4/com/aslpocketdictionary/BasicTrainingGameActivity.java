package comp380.group4.com.aslpocketdictionary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Vibrator;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.Random;


public class BasicTrainingGameActivity extends Activity {
    RadioButton rd1, rd2, rd3;
    Button butNext;
    int score;
    int total;
    int position;
    Backend tbd;
    final int size = 35;
    final int used[] = new int[size];//create a new recently used array.
    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_training_game);
        try {
            tbd = new Backend(getApplicationContext()); //create the back end arrays.
        } catch (JSONException e) {
            e.printStackTrace();
        }
        vibrator= (Vibrator) this.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        Bundle extras = getIntent().getExtras();//this is to get any info passed to this activity
        if(extras != null) {//if there is information being passed then we do some stuff
            int[] temp = extras.getIntArray("usedPositions");//we trasnfer the used array
            for(int i =0; i<size; i++){
                used[i]=temp[i];
            }
            score = extras.getInt("yourScore");//we trasnfer scores
            total = extras.getInt("yourTotal");//we trasnfer total questions asked
            getIntent().removeExtra("yourScore");//we make sure to remove everything to keep things clean
            getIntent().removeExtra("yourTotal");
            getIntent().removeExtra("usedPositions");
        }
        else{//otherwise its the firs time that this activity is being run, therefore all we need to do is populate the used array with zeroes
            for(int i =0; i<size; i++){
                used[i]=0;
            }
        }

        //The code below gets a random picture, and puts the picture on the xml. It also marks on a seperate array that we used a  particular picture.
        Random randNumber = new Random();////create new random number
        position = randNumber.nextInt(35);//35 is exclusive, 0 is included... remember arrays starts at 0 and go to 34!!!

        while(used[position]==1){//make sure position doesn't use a previously used value so we use new questions etc.
            position =randNumber.nextInt(35);
        }

        used[position]=1;//do our first action with position and marking the used array

        //here we used position to generate the picture to test our users
        ImageView i;//create a new image view
        i = (ImageView) findViewById(R.id.imagequestion);//associates the imageview i with 'mySpecialImage' in the XML
        String mDrawableName = tbd.pathArray2[position];//creates a string from a position and pathArray2
        int resID = getResources().getIdentifier(mDrawableName,"drawable", getPackageName());//turns the string path into a resource ID in drawable
        i.setImageResource(resID);//sets the image to the resource in resID

        //grab the ids of the buttons
        rd1=(RadioButton)findViewById(R.id.questionbutton1);
        rd2=(RadioButton)findViewById(R.id.questionbutton2);
        rd3=(RadioButton)findViewById(R.id.questionbutton3);
        butNext=(Button)findViewById(R.id.buttonSubmit);


        int choose = randNumber.nextInt(3);//we place the answer in a random location based on the three buttons

        int choose2 = randNumber.nextInt(35);
        while (choose2 == position){
            choose2 = randNumber.nextInt(35);
        }

        int choose3 = randNumber.nextInt(35);
        while (choose3 == position || choose3 == choose2){
            choose3 = randNumber.nextInt(35);
        }


        if(choose == 1){//answer is in position 1
            rd1.setText(tbd.wordArray2[position]);//position is the right answer
            rd2.setText(tbd.wordArray2[choose2]);//these random choose2 and choose3 just put random trash answers
            rd3.setText(tbd.wordArray2[choose3]);

        }
        else if(choose ==2){//answer is in position 2
            rd1.setText(tbd.wordArray2[choose2]);
            rd2.setText(tbd.wordArray2[position]);
            rd3.setText(tbd.wordArray2[choose3]);
        }
        else{//answer is in position 3
            rd1.setText(tbd.wordArray2[choose2]);
            rd2.setText(tbd.wordArray2[choose3]);
            rd3.setText(tbd.wordArray2[position]);
        }


        butNext.setOnClickListener(new View.OnClickListener() {//creates an onclick listener to find which button the user clicks
            @Override
            public void onClick(View v) {
                if(rd1.isChecked()==false && rd2.isChecked()==false && rd3.isChecked() == false){
                    Toast.makeText(getApplication(),"Please Select an Answer ",Toast.LENGTH_LONG).show();
                }
                else{
                    RadioGroup g = (RadioGroup) findViewById(R.id.radioGroup1);//grabs the radio group
                    int selected = g.getCheckedRadioButtonId();//finds what INDEX is selected in the group
                    RadioButton b = (RadioButton) findViewById(selected);//returns the id of the clicked button based on index.
                    //b.getText().toString();

                    if(tbd.wordArray2[position].equals(b.getText().toString()))//verifies right answer by comparing what was in selection to what was selected.
                    {
                        correct();
                        if(total<5){//as long as questions are less than five we're okay, loop will go to else once five questions are asked
                            restartGame();
                        }
                        else {
                            endGame();//new method to just end the game and return a dialog box see below
                        }
                    }
                    else {//wrong answer
                        incorrect();
                        if (total < 5) {
                            restartGame();

                        } else {

                            endGame();//new method to just end the game and return a dialog box see below
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basic_training_game, menu);
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

    public void endGame(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(BasicTrainingGameActivity.this);
        alertDialog.setTitle("Game Completed");
        alertDialog.setMessage("You Scored " + score + " out of " + total);
        alertDialog.setPositiveButton("Play Again", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                score = 0;
                total = 0;
                Intent TGList=new Intent(getApplicationContext(),BasicTrainingGameActivity.class);//get ready to relaunch the game again
                startActivity(TGList);
            }
        });
        alertDialog.setNegativeButton("OK Thanks",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent goBackHome = new Intent(getApplicationContext(),MainScreen.class);//get ready to go to homescreen
                startActivity(goBackHome);//celebrate!!!!
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.show();
    }

    public void correct(){
        score++;//plus one to score
        Toast.makeText(getApplication(),"Correct!",Toast.LENGTH_SHORT).show();
        vibrator.vibrate(new long[] { 0, 500, 0 }, -1);
        total++;//plus one to quesitons
    }

    public void incorrect(){
        total++;
        Toast.makeText(getApplication(), "Incorrect!", Toast.LENGTH_SHORT).show();
        vibrator.vibrate(new long[]{0, 400, 0, 0, 0, 0, 400, 0 , 0, 0, 0, 500}, -1);
    }

    public void restartGame(){
        Intent TGList=new Intent(getApplicationContext(),BasicTrainingGameActivity.class);//get ready to relaunch the game again
        TGList.putExtra("usedPositions", used);//pass the used array
        TGList.putExtra("yourScore", score);//pass the current score
        TGList.putExtra("yourTotal", total);//pass total number of questions
        startActivity(TGList);
    }

}