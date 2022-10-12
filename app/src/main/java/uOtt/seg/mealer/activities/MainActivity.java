package uOtt.seg.mealer.activities;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import uOtt.seg.mealer.db.DatabaseHandler;
import uOtt.seg.mealer.enums.EnumUserType;
import uOtt.seg.mealer.myandroidapp.R;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    String loginID;
    EnumUserType userType = EnumUserType.Client;

    RadioGroup rgLoginType;
    RadioButton rbClient, rbCook, rbAdmin;
    EditText edLoginID;

    @Override
    protected void onResume() {

        super.onResume();
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = null;

                Toast.makeText(MainActivity.this, "register", Toast.LENGTH_SHORT).show();

                if (userType == EnumUserType.Cook) {
                    intent = new Intent(view.getContext(), RegisterCookActivity.class);
                    intent.putExtra("LoginType", userType);
                    Toast.makeText(MainActivity.this, "Cook register !", Toast.LENGTH_SHORT).show();
                } else if (userType == EnumUserType.Client) {
                    intent = new Intent(view.getContext(), RegisterClientActivity.class);
                    intent.putExtra("LoginType", userType);
                } else {
                    Toast.makeText(MainActivity.this, "Admin no need to register !", Toast.LENGTH_SHORT).show();
                    return;
                }

                view.getContext().startActivity(intent);

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edLoginID = (EditText) findViewById(R.id.editLoginID);

        rbClient = (RadioButton) findViewById(R.id.rbClient);
        rbCook = (RadioButton) findViewById(R.id.rbCook);
        rbAdmin = (RadioButton) findViewById(R.id.rbAdmin);

        rbClient.setOnClickListener(this);
        rbCook.setOnClickListener(this);
        rbAdmin.setOnClickListener(this);


        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WelcomeActivity.class);
                intent.putExtra("UserID", edLoginID.getText().toString());
                intent.putExtra("LoginType", userType);
                view.getContext().startActivity(intent);

            }

        });

 /*       Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = null;

                Toast.makeText(MainActivity.this, "register", Toast.LENGTH_SHORT).show();

                if (userType == EnumUserType.Cook) {
                    intent = new Intent(view.getContext(), RegisterCookActivity.class);
                    intent.putExtra("LoginType", userType);
                    Toast.makeText(MainActivity.this, "Cook register !", Toast.LENGTH_SHORT).show();
                } else if (userType == EnumUserType.Client) {
                    intent = new Intent(view.getContext(), RegisterClientActivity.class);
                    intent.putExtra("LoginType", userType);
                } else {
                    Toast.makeText(MainActivity.this, "Admin no need to register !", Toast.LENGTH_SHORT).show();
                    return;
                }

                view.getContext().startActivity(intent);

            }

        });*/



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbClient:

                //if (rbClient.isChecked()) {
                    userType = EnumUserType.Client;
                    Toast.makeText(this, "Client login", Toast.LENGTH_SHORT).show();
                //}

                break;

            case R.id.rbCook:

                //if (rbClient.isChecked()) {
                    userType = EnumUserType.Cook;
                    Toast.makeText(this, "Cook login", Toast.LENGTH_SHORT).show();
                //}

                break;

            case R.id.rbAdmin:

                //if (rbClient.isChecked()) {
                    userType = EnumUserType.Admin;
                    Toast.makeText(this, "Admin login", Toast.LENGTH_SHORT).show();
                //}


        }
    }
}