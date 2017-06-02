package com.example.ylberpopaj.testapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;




/**
 * A simple {@link Fragment} subclass.
 */
public class appointment_frag extends Fragment {

    EditText inputTime;
    DatePicker datePicker;
    Button showTimeButton;
    String inputTimeString;
    int day;
    int month;
    int year;
    String time;
    LoginDataBaseAdapter loginDataBaseAdapter;
    String dayMonthYear;
    public appointment_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String out_usr = SaveSharedPreference.getUserName(getContext());
        //Toast.makeText(getActivity(), out_usr, Toast.LENGTH_SHORT).show();
        loginDataBaseAdapter=new LoginDataBaseAdapter(getContext());
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        final View view = inflater.inflate(R.layout.fragment_appointment_frag, container, false);
        inputTime = (EditText) view.findViewById(R.id.timePick);
        datePicker = (DatePicker) view.findViewById(R.id.datePicker);


        showTimeButton = (Button) view.findViewById(R.id.showTimeButton);


        showTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                day = datePicker.getDayOfMonth();
                month = datePicker.getMonth();
                year = datePicker.getYear();
                time = inputTime.getText().toString();
                dayMonthYear = Integer.toString(month) + " / "  + Integer.toString(day) +  " / " +Integer.toString(year) + " at " + time;

                inputTimeString = inputTime.getText().toString();
                String user_name = SaveSharedPreference.getUserName(getContext());
                loginDataBaseAdapter.addAppointmentDate(user_name, dayMonthYear);

                //Toast.makeText(getActivity(), loginDataBaseAdapter.getAppointmentDate("john"), Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }

}
