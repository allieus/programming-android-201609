package kr.festi.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.num0Button).setOnClickListener(this);
        findViewById(R.id.num1Button).setOnClickListener(this);
        findViewById(R.id.num2Button).setOnClickListener(this);
        findViewById(R.id.num3Button).setOnClickListener(this);
        findViewById(R.id.num4Button).setOnClickListener(this);
        findViewById(R.id.num5Button).setOnClickListener(this);
        findViewById(R.id.num6Button).setOnClickListener(this);
        findViewById(R.id.num7Button).setOnClickListener(this);
        findViewById(R.id.num8Button).setOnClickListener(this);
        findViewById(R.id.num9Button).setOnClickListener(this);

        findViewById(R.id.plusOperator).setOnClickListener(this);
        findViewById(R.id.multiplyOperator).setOnClickListener(this);
        findViewById(R.id.divideOperator).setOnClickListener(this);
        findViewById(R.id.subtractOperator).setOnClickListener(this);
        findViewById(R.id.equalOperator).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String label = ((Button) view).getText().toString();

        final TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        final String newText = resultTextView.getText() + label;
        resultTextView.setText(newText);
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( keyCode == KeyEvent.KEYCODE_BACK ) {
            TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
            String resultString = resultTextView.getText().toString();
            if ( resultString.length() > 0 ) {
                resultTextView.setText("");
                return true; // handled this event
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
