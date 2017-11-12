package com.example.prashantkumar.data;

/**
 * Created by Rishabh on 5/13/2017.
 * import com.firebase.client.Firebase;

 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Poly extends AppCompatActivity {

    private Button sub;

    private EditText name;
    private EditText add;
    private EditText classs;
    private EditText mob;
    private EditText email;
    private EditText pursue;
    private EditText mode;

    private Firebase mrootref;
    private ImageView share;
    private TextView site;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poly);
        site=(TextView) findViewById(R.id.TextViewTitle);

        name = (EditText) findViewById(R.id.EditTextName);
        add = (EditText) findViewById(R.id.EditTextAddress);
        classs = (EditText) findViewById(R.id.EditTextClass);
        mob = (EditText) findViewById(R.id.EditTextMobile);
        email = (EditText) findViewById(R.id.EditTextEmail);
        pursue = (EditText) findViewById(R.id.EditTextPursue);
        mode = (EditText) findViewById(R.id.EditTextMode);
        sub = (Button) findViewById(R.id.ButtonSend);

        mrootref = new Firebase("https://higher-education-c70b5.firebaseio.com/Poly");



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String add1=add.getText().toString();
                String classs1=classs.getText().toString();
                String mob1=mob.getText().toString();
                String email1=email.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";
                String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+\\.[a-z]+";
                String emailPattern3 = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+\\.[a-z]+\\.[a-z]+";
                String emailPattern4 = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+\\.[a-z]+\\.[a-z]+\\.[a-z]+";

                String phonePattern= "^[0-9]{10}$";
                String pursue1=pursue.getText().toString();
                String mode1=mode.getText().toString();

                // Firebase mrefChild=mrootref.child("Name");

                String key = mrootref.child("posts").push().getKey();
                mrootref= new Firebase("https://higher-education-c70b5.firebaseio.com/Poly/"+key);


                if (email1.isEmpty() || mob1.isEmpty()|| !mob1.matches(phonePattern) || !(email1.matches(emailPattern)|| email1.matches(emailPattern2)|| email1.matches(emailPattern3)|| email1.matches(emailPattern4))) {
                    Toast.makeText(getApplicationContext(),
                            "Enter valid email and mobile",
                            Toast.LENGTH_LONG).show();
                    return;
                }


                else {
                    Firebase mrefChildname = mrootref.child("Polytechnic: Name");
                    mrefChildname.setValue(name1);
                    Firebase mrefChildloc = mrootref.child("Polytechnic: Address");
                    mrefChildloc.setValue(add1);
                    Firebase mrefChilddep = mrootref.child("Polytechnic: Class Pursuing");
                    mrefChilddep.setValue(classs1);
                    Firebase mrefChildmob = mrootref.child("Polytechnic: Mobile");
                    mrefChildmob.setValue(mob1);
                    Firebase mrefChildemail = mrootref.child("Polytechnic: Email");
                    mrefChildemail.setValue(email1);
                    Firebase mrefChildpursue = mrootref.child("Polytechnic: Want to Pursue Education");
                    mrefChildpursue.setValue(pursue1);
                    Firebase mrefChildmode = mrootref.child("Polytechnic: Mode of Training");
                    mrefChildmode.setValue(mode1);

                    Toast.makeText(getApplicationContext(),
                            "Registered Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent Intent = new Intent(view.getContext(), Front1.class);
                    finish();
                    view.getContext().startActivity(Intent);

                    //Toast.makeText(getApplicationContext(), key, Toast.LENGTH_LONG).show();

                }

            }
        });


        share=(ImageView)findViewById(R.id.send);

        share.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                try {

                    String message = "I am sharing you this app https://play.google.com/store/apps/details?id=com.prashantkumar.data which helps you towards building academically capability for higher studies like Graduation- Master's(BCom,BSc,BTech,MTech,MBBS,LLB,LLM,MCA,MBA,BJMC,MJMC, .. more), M.Phil/ Phd, Skill oriented Industrial Certification, .. more ";
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.putExtra(Intent.EXTRA_TEXT, message);

                    startActivity(Intent.createChooser(share, "choose among these"));

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                // TODO DO whatever you want to do here

            }
        });
        site=(TextView) findViewById(R.id.webadd);
        site.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.vqms.co.in"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        });





    }

}


