package uOtt.seg.mealer.activities;

import static android.view.View.*;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import uOtt.seg.mealer.myandroidapp.R;

public class RegisterCookActivity extends AppCompatActivity {

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
    }




}
