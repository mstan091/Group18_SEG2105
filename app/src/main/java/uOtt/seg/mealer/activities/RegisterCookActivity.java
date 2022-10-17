package uOtt.seg.mealer.activities;

import static android.view.View.*;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import uOtt.seg.mealer.db.DatabaseHandler;
import uOtt.seg.mealer.myandroidapp.R;

public class RegisterCookActivity extends AppCompatActivity {

    protected void validateUserInput() {
        //super.validateUserInput();
        DatabaseHandler db = new DatabaseHandler(this);

        Button btnRegister = (Button) findViewById(R.id.btnAddClient2);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText firstName = findViewById(R.id.teFName);
                EditText lastName = findViewById(R.id.teLName);
                EditText emailField = findViewById(R.id.teEmail);
                EditText password = findViewById(R.id.tePwd);
                EditText retypePassword = findViewById(R.id.tePwd2);
                EditText address = findViewById(R.id.teAddr);
                EditText cookDesc = findViewById(R.id.etCookDescription);

                String fN = firstName.getText().toString();
                String lN = lastName.getText().toString();
                String eF = emailField.getText().toString();
                String p = password.getText().toString();
                String rP = retypePassword.getText().toString();
                String a = address.getText().toString();
                String cD = cookDesc.getText().toString();


                if (fN.isEmpty()) {
                    firstName.setError("Please enter your first name");
                }

                if (lN.isEmpty()) {
                    lastName.setError("Please enter your last name");
                }

                if (eF.isEmpty() || !eF.contains("@")) {
                    emailField.setError("Please enter a valid email");

                }

                if (p.isEmpty()) {
                    password.setError("Please enter a password");
                }

                if (rP.isEmpty() || rP != p) {
                    retypePassword.setError("Please reenter your password");
                }

                if (a.isEmpty()) {
                    address.setError("Please enter an address");
                }

                if (cD.isEmpty()) {
                    address.setError("Please add a cook description");
                }

        }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cook);

        Button btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ContextWrapper cw = new ContextWrapper(getApplicationContext());
                File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
                File file = new File(directory, "mario" + ".png");

                ImageView imgChk = (ImageView) findViewById(R.id.imageView);
                imgChk.setImageDrawable(Drawable.createFromPath(file.toString()));

            }
        });

        validateUserInput();
    }




}
