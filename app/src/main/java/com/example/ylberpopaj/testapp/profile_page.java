package com.example.ylberpopaj.testapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class profile_page extends Fragment {
    LoginDataBaseAdapter loginDataBaseAdapter;
TextView app_day;
TextView profile_name;

    public profile_page() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile_page, container, false);
        //        inputTime = (EditText) view.findViewById(R.id.timePick);
        loginDataBaseAdapter=new LoginDataBaseAdapter(getContext());
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        String user_name = SaveSharedPreference.getUserName(getContext());
        String app_date = loginDataBaseAdapter.getAppointmentDate(user_name);
        //app_date = padStr(app_date, "0" , 8);
       // String[] ary = app_date.split("");

        //app_date = parseString(ary);
        app_day = (TextView) view.findViewById(R.id.textView5);

        app_day.setText(app_date);
        profile_name = (TextView) view.findViewById(R.id.textView3);


        profile_name.setText(user_name);

        // Inflate the layout for this fragment
        return view;
    }
    public String parseString(String[] string){
        int i = 1;
        String snake = "";
        while( i < 9 ){
            if(i == 2  || i == 4 || i == 8){
                snake = snake +  string[i] + "|";
            }else {
            snake = snake + string[i];}
              i++;
        }
        return snake;
    }


    public String padStr(String str, String pad, int len) {

        while (str.length() < len)
            str = pad + str;
        return str;
    }
}
