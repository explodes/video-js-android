package explod.io.videojsplayer.web;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;

public class JsBridge {


	private static final String TAG = JsBridge.class.getSimpleName();

	private Activity mActivity;

	private WebView mWebView;

	public JsBridge(Activity activity, WebView webView) {
		mActivity = activity;
		mWebView = webView;
	}

	protected void callInWebView(String call) {
		Log.v(TAG, "js call: " + call);
		final String webUrl = "javascript:" + call;
		// Add this to avoid android.view.windowmanager$badtokenexception unable to add window
		if (!mActivity.isFinishing())
			// load url on ui thread
			mActivity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					mWebView.loadUrl(webUrl);
				}
			});
	}

	protected Activity getActivity() {
		return mActivity;
	}

	protected WebView getWebView() {
		return mWebView;
	}
}
