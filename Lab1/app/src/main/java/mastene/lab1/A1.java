package mastene.lab1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class A1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Implements AdapterView.OnItemSelectedListener so that I may use OnItemSelectedListener on the color spinner

    Spinner spinner1;   //Holds the oprions that the user can change between

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        spinner1 = findViewById(R.id.s1);
        String[] items = new String[]{"Red", "Blue", "Black"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, items);
        spinner1.setAdapter(adapter);

        spinner1.setSelection(loadSpinner());   //Loads the preference

        spinner1.setOnItemSelectedListener(this);   //Sets listener

        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToA2();
            }
        });
    }

    /**
    * The function changes the view to A2
    **/
    private void changeToA2(){
        TextView t1View = findViewById(R.id.t1);
        String tempText = t1View.getText().toString();

        Intent i = new Intent(this, A2.class);
        i.putExtra("t1", tempText);
        startActivity(i);
    }

    /**
     * The function gets the previously selected spinner item from the preferences.
     * @return int - the previously selected item.
     */
    private int loadSpinner(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        return pref.getInt("A1Color", 0);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("A1Color", i);
        editor.apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        spinner1.setSelection(0);   //Defaults to the first item.
    }
}
