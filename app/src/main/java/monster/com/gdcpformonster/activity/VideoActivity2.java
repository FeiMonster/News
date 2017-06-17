package monster.com.gdcpformonster.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import monster.com.gdcpformonster.R;

/**
 * Created by ASUS on 2017/5/15.
 */

public class VideoActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video1);
    WebView webView = (WebView) findViewById(R.id.video_webview);
    String video_url = "http://my.tv.sohu.com/us/257527992/84319122.shtml";
    // 加载url
    webView.loadUrl(video_url);
    // 初始化比例
    webView.setInitialScale(50);

    WebSettings setting = webView.getSettings();
    // 支持使用接口
    setting.setUseWideViewPort(true);
    // 支持脚本JavaScript
    setting.setJavaScriptEnabled(true); // Support JavaScript
    // like flash plugin.
    setting.setSupportZoom(true); // Zoom Control on web (You don't need
    // this if ROM supports Multi-Touch
    setting.setBuiltInZoomControls(true); // Enable Multitouch if supported
    // by ROM

    webView.setWebViewClient(new MyWebViewClient());

}

public class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url); // webview里面的链接还在同一个页面中加载
        return true;
    }
}
}
