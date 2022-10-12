package uOtt.seg.mealer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uOtt.seg.mealer.db.DatabaseHandler;
import uOtt.seg.mealer.myandroidapp.R;
import uOtt.seg.mealer.users.MealerUserClinet;

public class RegisterClientActivity extends  RegisterActivity {



    private static final int MIN_LEN_SEC = 3;
    private static final int MAX_LEN_SEC = 3;

    private static final int MIN_LEN_CARD_NUM = 4;
    private static final int MAX_LEN_CARD_NUM = 16;

    @Override
    protected   void validateUserInput() {
        super.validateUserInput();

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);

        DatabaseHandler db = new DatabaseHandler(this);


        Button btnRegister = (Button) findViewById(R.id.btnAddClient);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                validateUserInput();

                Log.d("valid", "validating ...");

                String holderName, cardNum, expireDate, secCode;

                EditText teHolderName = findViewById(R.id.teHolderName);
                EditText teCardNum = findViewById(R.id.teCardNum);
                EditText teExpireDate = findViewById(R.id.teExpireDate);
                EditText teSecCode = findViewById(R.id.teSecCod);

                holderName = teHolderName.getText().toString();
                cardNum = teCardNum.getText().toString();
                expireDate = teExpireDate.getText().toString();
                secCode = teSecCode.getText().toString();

                //validateUserInput();

                if (holderName.length() < MIN_LEN_NAME || holderName.length() > MAX_LEN_NAME) {
                    teHolderName.setError("Name is to short or too long");
                    isValid = false;
                }

                Log.d("1", "validate4d holder name");

                //Toast.makeText(RegisterClientActivity.this, "name len " + holderName.length(), Toast.LENGTH_LONG).show();
                //Toast.makeText(RegisterClientActivity.this, "num len " + cardNum.length(), Toast.LENGTH_LONG).show();

                if (cardNum.length() < MIN_LEN_CARD_NUM || cardNum.length() > MAX_LEN_CARD_NUM) {
                    teCardNum.setError("Card num is to short or too long");
                    isValid = false;
                }

                Log.d("2", "validated card number");

                if (isCardExpired(expireDate)) {
                    teExpireDate.setError("Expire data is not valid");
                    isValid = false;
                }

                Log.d("3", "validated expiration date");

                if (isUserExist(email)) {
                    teEmail.setError("User account exist");
                }

                Log.d("4", "validated email");

                if (isValid) {
                    MealerUserClinet client = new MealerUserClinet(fName, lName, email, pwd, addr);
                    Log.d("DB Insert:", "Add to database");

                    db.addClient(client);

                    // After register, redirect user back to login activity
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    view.getContext().startActivity(intent);

                    Toast.makeText(RegisterClientActivity.this, "Account registered. Please login", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(RegisterClientActivity.this, "Check input fields", Toast.LENGTH_LONG).show();
                }
            }

        });



    }

    private boolean isCardExpired(String expireDate) {
        // ToDo validation here

        return false;
    }



    private boolean isUserExist(String email) {
        // ToDo

        return false;
    }




}