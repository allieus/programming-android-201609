package kr.festi.pinstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    final String TAG = DetailActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Toast.makeText(this, String.format("Passed %d", name.length()), Toast.LENGTH_SHORT).show();

        Log.d(TAG, "called onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "called onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "called onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "called onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "called onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "called onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "called onRestart()");
    }
}
