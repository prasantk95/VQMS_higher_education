package com.example.prashantkumar.data;



import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Firebase mrootref;
    private Button sub;
    private EditText name;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.tex);
        sub = (Button) findViewById(R.id.button);

        mrootref = new Firebase("https://higher-education-c70b5.firebaseio.com/Campus");


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();

                String key = mrootref.child("posts").push().getKey();
                mrootref = new Firebase("https://data-5225b.firebaseio.com/Campus/" + key);





                    Firebase mrefChildname = mrootref.child("campus: TPO-Coordinator Name");
                    mrefChildname.setValue(name1);

                    Toast.makeText(getApplicationContext(),
                            "Registered Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent Intent = new Intent(view.getContext(), MainActivity.class);
                    finish();
                    view.getContext().startActivity(Intent);

                    //Toast.makeText(getApplicationContext(), key, Toast.LENGTH_LONG).show();



            }
        });

    }
}
