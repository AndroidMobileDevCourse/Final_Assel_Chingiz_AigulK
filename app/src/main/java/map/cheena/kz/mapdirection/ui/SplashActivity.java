package map.cheena.kz.mapdirection.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.paperdb.Paper;
import map.cheena.kz.mapdirection.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Paper.init(SplashActivity.this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isLogged = Paper.book().read("login", false);
                if (isLogged) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        }, 800);
    }
}
