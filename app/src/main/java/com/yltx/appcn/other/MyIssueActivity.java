package com.yltx.appcn.other;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ixzus.applibrary.impl.IToolbar;
import com.yltx.appcn.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：Wq
 * Date：2017/8/21 19:50
 * Description：//todo
 */

@Route(path = "/other/MyIssueActivity")
public class MyIssueActivity extends AppCompatActivity implements IToolbar {


    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_back_text)
    TextView toolbarBackText;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.webViewRefresh)
    ImageView webViewRefresh;
    @BindView(R.id.webViewErr)
    RelativeLayout webViewErr;
    private boolean isError = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_issue);
        ButterKnife.bind(this);

        initView();


    }

    private void initView() {

        toolbar("常见问题", true, null);


        webViewRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isError = false;
                webView.loadUrl("http://wxssj.ygs001.com/ewm/question.html");
            }
        });
//        webView.loadUrl("file:///android_asset/question.html");
        webView.loadUrl("http://wxssj.ygs001.com/ewm/question.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                showErr(true);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                showErr(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!isError) {
                    showErr(false);
                }
            }
        });
    }

    protected void toolbar(String centerText, boolean isBack, String backText) {
        if (isBack) {
            findViewById(com.ixzus.applibrary.R.id.toolbar_back).setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(backText)) {
            ((TextView) findViewById(com.ixzus.applibrary.R.id.toolbar_back_text)).setText(backText);
        }
        if (!TextUtils.isEmpty(centerText)) {
            ((TextView) findViewById(com.ixzus.applibrary.R.id.toolbar_title)).setText(centerText);
        }

    }


    private void showErr(boolean flag) {
        if (flag) {
            isError = true;
            webViewErr.setVisibility(View.VISIBLE);
        } else {
            isError = false;
            webViewErr.setVisibility(View.GONE);
        }
    }
}
