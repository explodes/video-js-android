package explod.io.videojsplayer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import explod.io.videojsplayer.R;
import explod.io.videojsplayer.web.HTML5WebView;
import explod.io.videojsplayer.web.video.VideoBridge;
import explod.io.videojsplayer.web.video.VideoClient;

public class MainActivity extends AppCompatActivity {

	ViewGroup mContainerView;

	HTML5WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContainerView = (ViewGroup) findViewById(R.id.webview_container);

		initWebView();

		if (savedInstanceState != null) {
			mWebView.restoreState(savedInstanceState);
		} else {
			// load the main.html file that kept in assets folder
			mWebView.loadUrl("file:///android_asset/videoplayer/main.html");
		}

		mContainerView.addView(mWebView.getLayout());
	}

0
	private void initWebView() {

		mWebView = new HTML5WebView(this);

		// settings
//		WebSettings webSettings = mWebView.getSettings();
//		webSettings.setJavaScriptEnabled(true);
//		//Set whether the DOM storage API is enabled.
//		webSettings.setDomStorageEnabled(true);
//		//setBuiltInZoomControls = false, removes +/- controls on screen
//		webSettings.setBuiltInZoomControls(false);
//		webSettings.setAllowFileAccess(true);
//		webSettings.setAppCacheEnabled(true);
//		webSettings.setUseWideViewPort(false);
//		// these settings speed up page load into the webview
//		webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

		mWebView.addJavascriptInterface(new VideoBridge(this, mWebView), "jsBridge");
		mWebView.setWebChromeClient(new VideoClient());
		mWebView.setBackgroundColor(0xff000000);
		mWebView.requestFocus(View.FOCUS_DOWN);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mWebView.saveState(outState);
	}

	@Override
	public void onStop() {
		super.onStop();
		mWebView.stopLoading();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (mWebView.inCustomView()) {
				mWebView.hideCustomView();
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

}
