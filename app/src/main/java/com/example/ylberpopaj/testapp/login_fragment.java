package com.example.ylberpopaj.testapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
/**
 * A simple {@link Fragment} subclass.
 */

public class login_fragment extends Fragment {

    String usernameString;
    String passwordString;
    Button register_button;
    Button login_button;
    EditText username;
    EditText password;
    String fullName;


    public static Map<String, String> login_info_map = new HashMap<String, String>();
LoginDataBaseAdapter loginDataBaseAdapter;
    public login_fragment() {


        // Required empty public constructor
    }



    View inflatedView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginDataBaseAdapter=new LoginDataBaseAdapter(getContext());
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        final View view = inflater.inflate(R.layout.fragment_login_fragment, container, false);
        register_button = (Button) view.findViewById(R.id.register_button);
        login_button = (Button)  view.findViewById(R.id.login_button);

        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        usernameString = username.getText().toString();
        passwordString = password.getText().toString();
        fullName = usernameString + passwordString;


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameString = username.getText().toString();
                passwordString = password.getText().toString();
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(usernameString);

                // check if the Stored password matches with  Password entered by user
                if(passwordString.equals(storedPassword))
                {
                    SaveSharedPreference.setUserName(getContext(), usernameString);
                   String login__usr =  SaveSharedPreference.getUserName(getContext());

                    Toast.makeText(getActivity(), login__usr + " logged in.", Toast.LENGTH_LONG).show();

                    //Toast.makeText(getActivity(), login__usr, Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getActivity(), "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }});






        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usernameString = username.getText().toString();
                passwordString = password.getText().toString();
                if(loginDataBaseAdapter.getBooleanAlreadyExist(usernameString) == false){

                    Toast.makeText(getActivity(), "Username already exist in DB.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(usernameString.equals("")||passwordString.equals(""))
                {

                    Toast.makeText(getActivity(), "Empty Field, type something!", Toast.LENGTH_LONG).show();
                    return;
                }

                else
                {
                    //loginDataBaseAdapter.deleteEntry(usernameString);


                    loginDataBaseAdapter.insertEntry(usernameString,passwordString);
                    String userInputedPassword = loginDataBaseAdapter.getAppointmentDate(usernameString);
                    //Toast.makeText(getActivity(), userInputedPassword, Toast.LENGTH_LONG).show();



                }
                /*Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_LONG).show();
                String getusername = username.getText().toString();
                String getpassword = password.getText().toString();
                loginHandler(getusername,getpassword); */
            }
        });
        return view;



    }
     public void loginHandler(String usernamehandler, String passwordhandler){
                login_info_map.put(usernamehandler, passwordhandler);
         Toast.makeText(getActivity(), "Username/Password created", Toast.LENGTH_SHORT).show();
     }




}
