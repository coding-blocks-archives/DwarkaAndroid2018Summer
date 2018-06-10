package app.harshit.helloworldapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        int a = 0/0;
        Log.w(TAG,"Hello I'm an error");
    }
}
