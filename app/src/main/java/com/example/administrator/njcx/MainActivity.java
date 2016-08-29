package com.example.administrator.njcx;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import static com.example.administrator.njcx.R.layout.activity_main;


public class MainActivity extends AppCompatActivity {
    private long exitTime = 0;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(activity_main);
        webView=(WebView)findViewById(R.id.webView);
        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;
            }
        });
        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);
        Handler handler = new Handler();
        Runnable updateThread = new Runnable(){
            public void run(){
                webView.loadUrl("http://www.njcxs.cc");
            }

        };
        handler.postDelayed(updateThread, 1000);
        setContentView(webView);

    }
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }}}

}