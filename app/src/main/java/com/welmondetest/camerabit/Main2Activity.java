package com.welmondetest.camerabit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    ProgressBar progressBar;
    SeekBar seekBar;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener datee;
    TextView dates;
    ImageView leftDate,rightDate;
    Date cureentdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv);
        progressBar=findViewById(R.id.progressBar);
        seekBar=findViewById(R.id.seekBar);
progressBar.setProgress(0);
dates=findViewById(R.id.date);
leftDate=findViewById(R.id.left_btn);
rightDate=findViewById(R.id.right_btn);

        seekBar.setMax(100);
        progressBar.setMax(100);
        myCalendar = Calendar.getInstance();

        cureentdate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String dateToStr = format.format(cureentdate);



        dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Main2Activity.this, datee, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        rightDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dates.setText(String.valueOf(incrementDateByOne(cureentdate)));
                cureentdate=incrementDateByOne(cureentdate);
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dates.setText(sdf.format(cureentdate));
            }
        });

        leftDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dates.setText(String.valueOf(decrementDateByOne(cureentdate)));
                cureentdate=decrementDateByOne(cureentdate);
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dates.setText(sdf.format(cureentdate));
            }
        });



        datee = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void updateLabel() {

        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dates.setText(sdf.format(myCalendar.getTime()));


    }

    public Date incrementDateByOne(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return nextDate;
    }

    /**
     * Get previous date from current selected date
     *
     * @param date date
     */
    public Date decrementDateByOne(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -1);
        Date previousDate = c.getTime();
        return previousDate;
    }
}
