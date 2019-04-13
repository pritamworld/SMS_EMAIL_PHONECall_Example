package com.lambton.sms_email_phonecall_example;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class LocationFragment extends Fragment
{

    WebView webView;
    Button btnShowTajMahal;

    public LocationFragment()
    {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        webView = view.findViewById(R.id.wvLocation);

        btnShowTajMahal = view.findViewById(R.id.btnOpenLocation);


        btnShowTajMahal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showTajMahal();
            }
        });

        WebViewClient mWebViewClient = new WebViewClient();

        //webView.loadData("<b>Hello World</b>", "text/html", "UTF8");
        webView.setWebViewClient(mWebViewClient);
        webView.loadUrl("http://www.google.com");
    }

    public void showTajMahal()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:27.173891,78.042068?z=16"));
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getActivity(), "No Intent Available", Toast.LENGTH_SHORT).show();
        }
    }
}
