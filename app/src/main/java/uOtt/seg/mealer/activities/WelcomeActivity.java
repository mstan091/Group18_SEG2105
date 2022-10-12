package uOtt.seg.mealer.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import uOtt.seg.mealer.enums.EnumUserType;
import uOtt.seg.mealer.myandroidapp.R;

public class WelcomeActivity extends AppCompatActivity {

    TextView tvWelcome;
    EnumUserType userType;

    String welcomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        userType = (EnumUserType) getIntent().getExtras().get("LoginType");
        welcomeMsg = getString(R.string.welcome_msg, userType.toString());

        tvWelcome.setText(welcomeMsg);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }
}
