package mastene.lab1;

import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class A2 extends AppCompatActivity {

    int myResultCode = 1;   /** result code for A3 intent **/
    String t4Text = "Default text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        Intent t1Intent = getIntent();
        String t1Text = t1Intent.getStringExtra("t1");

        TextView t2Text = findViewById(R.id.t2);
        t2Text.setText("hello " + t1Text);

        Button b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToA3();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView t2View = findViewById(R.id.t2);

        if(myResultCode == requestCode){
            if(resultCode == RESULT_OK){
                t4Text = data.getStringExtra("returnString");
                TextView t3View = findViewById(R.id.t3);
                t3View.setText("From A3: " + t4Text);
            }
            /*else if(resultCode == RESULT_CANCELED){

            }*/
        }
    }

    /** Function changeToA3 changes the activity to A3 **/
    private void changeToA3(){
        Intent i = new Intent(this, A3.class);
        startActivityForResult(i, myResultCode);
    }

}
