package com.welmondetest.camerabit;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    MyProgress progressBar;
    SeekBar seekBar;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener datee;
    TextView dates;
    ImageView leftDate, rightDate;
    Date cureentdate;

    int maxProgress=100;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.tv, container, false);
        progressBar = root.findViewById(R.id.progressBar);
        seekBar = root.findViewById(R.id.seekBar);
        progressBar.setProgress(0);
        dates = root.findViewById(R.id.date);
        leftDate = root.findViewById(R.id.left_btn);
        rightDate = root.findViewById(R.id.right_btn);

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
                new DatePickerDialog(getContext(), datee, myCalendar
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
                    Toast.makeText(getContext(), "reached", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                     
                // progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        return inflater.inflate(R.layout.tv, container, false);
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
