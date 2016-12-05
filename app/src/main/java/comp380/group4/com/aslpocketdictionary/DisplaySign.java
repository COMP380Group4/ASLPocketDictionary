package comp380.group4.com.aslpocketdictionary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

/**
 * Created by Andrew on 4/24/2015.
 */
public class DisplaySign extends Activity{

    String stringData;

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaysign);
        //Bundle extras = getIntent().getExtras();
        //String wordData = extras.getString("selected");

        Intent myNewIntent = getIntent();//creates a new intent
        String myNewString = myNewIntent.getStringExtra("myUniqueId");//gets the string from SearchByWord under the "myUniqueId" id

        Backend tbd= null;
        try {
            tbd = new Backend(getApplicationContext());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int numberData= tbd.getAPosition(myNewString);//gets the position of the string based on a method in the Backend class

        /*We have to use getAPosition rather than just passing the position from ItemClickListener because
        we use a filter to parse down the list for the user based on what text they input.
        If we don't try to find a matching position it'll just broadcast the position of the smaller list, versus what actually is in the array.
        */

        //int numberData = extras.getInt("Position");
        //Toast.makeText(this, ""+ numberData , Toast.LENGTH_SHORT).show();
        ImageView i;//create a new image view
        i = (ImageView) findViewById(R.id.mySpecialImage);//associates the imageview i with 'mySpecialImage' in the XML
        String mDrawableName = tbd.pathArray2[numberData];//creates a string from a position and pathArray2
        int resID = getResources().getIdentifier(mDrawableName,"drawable", getPackageName());//turns the string path into a resource ID in drawable
        i.setImageResource(resID);//sets the image to the resource in resID
        TextView t = (TextView) findViewById(R.id.displayWord);//sets t to the text id 'displayword'
        t.setText(tbd.wordArray2[numberData]);//takes the string in the array and puts it into t text view

    }
}
