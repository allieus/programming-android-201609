package kr.festi.pinstagram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG = MainActivity.class.getName();

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView testTextView = (TextView) findViewById(R.id.testTextView);
        testTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter += 1;
                testTextView.setText(String.format("clicked %d", counter));
            }
        });

        findViewById(R.id.launchDetailActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                // intent.putExtra("name", "Steve");
                // intent.putExtra("age", 20);
                startActivity(intent);
            }
        });

        findViewById(R.id.captureButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        Log.d(TAG, "called onCreate()");
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(imageBitmap);
        }
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
