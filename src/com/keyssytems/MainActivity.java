package com.keyssytems;

import java.io.File;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {
	static final String TAG = "ChartTest";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initChart1("http://chart.icfdev.ru/pie");
		initChart2("http://chart.icfdev.ru/bar");
		initChart3("http://chart.icfdev.ru/table");
	}
	
	ProgressBar progressBar1;
	public void initChart1(String URL) {
		progressBar1 = (ProgressBar) findViewById(R.id.progress1);
		WebView webView1 = (WebView) findViewById(R.id.webview1);
		webView1.getSettings().setJavaScriptEnabled(true);
		webView1.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				if (progress < 100 && progressBar1.getVisibility() == ProgressBar.GONE){
					progressBar1.setVisibility(ProgressBar.VISIBLE);
				}
				progressBar1.setProgress(progress);
				if (progress == 100) {
					progressBar1.setVisibility(ProgressBar.GONE);
				}
			}
		});
		webView1.setInitialScale(getScale(webView1));
		webView1.loadUrl(URL);
	}
	
	ProgressBar progressBar2;
	public void initChart2(String URL) {
		progressBar2 = (ProgressBar) findViewById(R.id.progress2);
		WebView webView2 = (WebView) findViewById(R.id.webview2);
		webView2.getSettings().setJavaScriptEnabled(true);
		webView2.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				if (progress < 100 && progressBar2.getVisibility() == ProgressBar.GONE){
					progressBar2.setVisibility(ProgressBar.VISIBLE);
				}
				progressBar2.setProgress(progress);
				if (progress == 100) {
					progressBar2.setVisibility(ProgressBar.GONE);
				}
			}
		});
		webView2.setInitialScale(getScale(webView2));
		webView2.loadUrl(URL);
	}
	
	ProgressBar progressBar3;
	public void initChart3(String URL) {
		progressBar3 = (ProgressBar) findViewById(R.id.progress3);
		WebView webView3 = (WebView) findViewById(R.id.webview3);
		webView3.getSettings().setJavaScriptEnabled(true);
		webView3.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				if (progress < 100 && progressBar3.getVisibility() == ProgressBar.GONE){
					progressBar3.setVisibility(ProgressBar.VISIBLE);
				}
				progressBar3.setProgress(progress);
				if (progress == 100) {
					progressBar3.setVisibility(ProgressBar.GONE);
				}
			}
		});
		webView3.setInitialScale(getScale(webView3));
		webView3.loadUrl(URL);
	}
	
	@SuppressWarnings("deprecation")
	private int getScale(final WebView webView) {
	    int scale = (int) (100 * webView.getScale() - 60);
	    return scale;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	void clearCache(Context context) {
	    clearCacheFolder(context.getCacheDir());
	}

	void clearCacheFolder(final File dir) {      
		if (dir!= null && dir.isDirectory()) {         
			try {             
				for (File child:dir.listFiles()) {               
					if (child.isDirectory()) 
	                    clearCacheFolder(child);
	                else
	                	child.delete(); 
	            }         
	        } catch(Exception e) {             
	            Log.e(TAG, "Failed to clean the cache error message="+e.getMessage());         
	        }     
	    }     
	}
	
	@Override
	public void onDestroy() {
	    super.onDestroy();
	    clearCache(this);
	}
}
