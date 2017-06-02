package com.example.ylberpopaj.testapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class facebook_fragment extends Fragment {

    WebView webView;
    public facebook_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_facebook_fragment, container, false);

        webView = (WebView) view.findViewById(R.id.webViewFacebook);
        webView.loadUrl("http://facebook.com/");


        return view;
    }

}
