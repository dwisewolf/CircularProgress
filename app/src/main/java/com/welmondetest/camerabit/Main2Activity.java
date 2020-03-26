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

    MyProgress progressBar;
    SeekBar seekBar;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener datee;
    TextView dates;
    ImageView leftDate, rightDate;
    Date cureentdate;

    int maxProgress=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv);
        progressBar = findViewById(R.id.progressBar);
        seekBar = findViewById(R.id.seekBar);
        progressBar.setProgress(0);
        dates = findViewById(R.id.date);
        leftDate = findViewById(R.id.left_btn);
        rightDate = findViewById(R.id.right_btn);

        seekBar.setMax(100);
      //  progressBar.setMax(100);
        progressBar.setPrimaryProgressColor(R.color.red);
        myCalendar = Calendar.getInstance();
progressBar.setPrimaryCapSize(0);
progressBar.setSecondaryCapSize(0);
        cureentdate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String dateToStr = format.format(cureentdate);
        seekBar.setMax(1000);


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
                cureentdate = incrementDateByOne(cureentdate);
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dates.setText(sdf.format(cureentdate));
            }
        });

        leftDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dates.setText(String.valueOf(decrementDateByOne(cureentdate)));
                cureentdate = decrementDateByOne(cureentdate);
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
                progressBar.setPrimaryProgressColor(R.color.red);
                if (progress>maxProgress){
                    progressBar.setPrimaryCapSize(21);

                   progressBar.colorreset();
                    Toast.makeText(Main2Activity.this, "reached", Toast.LENGTH_SHORT).show();
                 progress=progress-maxProgress;
                  //  progressBar.setProgressDrawable(getDrawable(R.drawable.more_max_progress));
                    progressBar.setProgress(progress);
                    dates.setText(String.valueOf(progress));
                }
                else if(progress<maxProgress){

                    progressBar.setSecondaryCapSize(21);
               //     progressBar.setProgressDrawable(getDrawable(R.drawable.custom_progressbar_drawable));
                  //  progressBar.setProgress(progress);
                    progressBar.setSecondaryProgress(progress);
                    dates.setText(String.valueOf(progress));
                }
                else
                    Toast.makeText(Main2Activity.this, "", Toast.LENGTH_SHORT).show();
                   // progressBar.setProgress(progress);
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

    public Date decrementDateByOne(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -1);
        Date previousDate = c.getTime();
        return previousDate;
    }
}


