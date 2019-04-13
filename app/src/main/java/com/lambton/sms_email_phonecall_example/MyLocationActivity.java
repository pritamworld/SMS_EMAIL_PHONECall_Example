package com.lambton.sms_email_phonecall_example;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.UTFDataFormatException;

public class MyLocationActivity extends AppCompatActivity
{

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        webView = findViewById(R.id.wvLocation);

        WebViewClient mWebViewClient = new WebViewClient();

        //webView.loadData("<b>Hello World</b>", "text/html", "UTF8");
        webView.setWebViewClient(mWebViewClient);
        webView.loadUrl("http://www.google.com");
    }

    public void showTajMahal(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:27.173891,78.042068?z=16"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
