package explod.io.videojsplayer.web.video;

import android.app.Activity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import explod.io.videojsplayer.web.JsBridge;

public class VideoBridge extends JsBridge {

	private static final String TAG = VideoBridge.class.getSimpleName();

	public VideoBridge(Activity activity, WebView webView) {
		super(activity, webView);
	}

	@JavascriptInterface
	public void showTableOfContents() {
		Log.i(TAG, "Show table of contents");
		// todo: show table of contents
	}

	@JavascriptInterface
	public void onVideoEnd() {
		onNextVideo();
	}

	@JavascriptInterface
	public void onNextVideo() {
		Log.d(TAG, "video end");
		// todo: next video
	}

	@JavascriptInterface
	public void onPreviousVideo() {
		Log.d(TAG, "video end");
		// todo: prev video
	}

}
