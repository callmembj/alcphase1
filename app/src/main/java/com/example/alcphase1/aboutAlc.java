package com.example.alcphase1;

import androidx.appcompat.app.AppCompatActivity;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.net.http.SslError;

import android.os.Bundle;

public class aboutAlc extends AppCompatActivity {

    private WebView about_alc;
    SwipeRefreshLayout swipeRefreshLayout;
    private String mURL = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        about_alc = findViewById(R.id.about_alc_web_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);


        //swipeRefreshLayout.setOnRefreshListener(() -> about_alc.reload ());

        about_alc.getSettings().setJavaScriptEnabled(true);
        about_alc.setHorizontalScrollBarEnabled(false);
        about_alc.canGoBack();
        about_alc.canGoBack();
        about_alc.setWebViewClient(new MyWebViewClient());
        about_alc.loadUrl(mURL);
    }

    class MyWebViewClient extends WebViewClient  {
        @Override
        public void onPageFinished(WebView view, String url) {
            swipeRefreshLayout.setRefreshing(false);
            mURL = url;
            super.onPageFinished(view,url);
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }
}
