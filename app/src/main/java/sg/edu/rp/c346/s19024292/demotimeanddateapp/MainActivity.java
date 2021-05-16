package sg.edu.rp.c346.s19024292.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        tvDisplay = findViewById(R.id.textView);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        btnReset = findViewById(R.id.btnReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();
                tvDisplay.setText(String.format("Time is %d:%d",hour,minute));
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int day =dp.getDayOfMonth();
                int month = dp.getMonth();
                int year = dp.getYear();
                tvDisplay.setText(String.format("Date is %d/%d/%d",day,month,year));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020,0,1);
            }
        });


    }
}