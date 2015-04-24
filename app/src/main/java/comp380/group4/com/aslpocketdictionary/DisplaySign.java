package comp380.group4.com.aslpocketdictionary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Andrew on 4/24/2015.
 */
public class DisplaySign extends Activity{

    String stringData;

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaysign);
        Bundle extras = getIntent().getExtras();
        int numberData = extras.getInt("Position");

        Toast.makeText(this, ""+ numberData , Toast.LENGTH_SHORT).show();
        ImageView i;
        i = (ImageView) findViewById(R.id.mySpecialImage);
        Backend tbd= new Backend();
        String mDrawableName = tbd.pathArray2[numberData];
        int resID = getResources().getIdentifier(mDrawableName,"drawable", getPackageName());
        i.setImageResource(resID);

        TextView t = (TextView) findViewById(R.id.displayWord);
        t.setText(tbd.wordArray2[numberData]);

    }
}
