package mastene.lab1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A3 extends AppCompatActivity {

    Intent returnIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        Button b3 = findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToA3();
            }
        });
    }
    
    /**
    * Takes the user back to A2, and sends the return intent
    **/
    private void backToA3(){
        TextView t4Text = findViewById(R.id.t4);
        String tempText = t4Text.getText().toString();
        t4Text.setText(tempText);
        returnIntent.putExtra("returnString", tempText);
        setResult(Activity.RESULT_OK, returnIntent);
        finish(); //Takes the user back to the activity they were sent here from.
    }
}
