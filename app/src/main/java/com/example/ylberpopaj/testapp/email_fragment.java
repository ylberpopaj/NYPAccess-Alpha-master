package com.example.ylberpopaj.testapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class email_fragment extends Fragment {
    WebView webView;

    public email_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_email_fragment, container, false);
        webView = (WebView) view.findViewById(R.id.webView);
        webView.loadUrl("http://m.gmail.com/");



        return view;
    }

}
