package com.aloha.schoolmate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aloha.schoolmate.R.id;
import com.lody.welike.WelikeHttp;
import com.lody.welike.http.HttpParams;
import com.lody.welike.http.callback.HttpResultCallback;
import com.lody.welike.ui.WelikeActivity;
import com.lody.welike.ui.annotation.JoinView;

public class HttpActivity extends WelikeActivity {
	@JoinView(id = id.query, click = true)
	Button jsonGet;

	public HttpActivity() {

	}

	@Override
	public void initGlobalView(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.initGlobalView(savedInstanceState);
		setContentView(R.layout.activity_http);
	}

	@Override
	public void onWidgetClick(View widget) {
		// TODO Auto-generated method stub
		super.onWidgetClick(widget);
		if (widget == jsonGet) {
			jsonGetEvent();
		}
	}

	/**
	 * 发送一个JSON Get请求
	 */
	// http://localhost:8888/Service/getFellowDetail?id=151091
	private void jsonGetEvent() {
		HttpParams params = new HttpParams();
		params.put("id", "");
		WelikeHttp.getDefault().get("", params, new HttpResultCallback() {
			@Override
			public void onSuccess(String content) {
				// TODO Auto-generated method stub
				super.onSuccess(content);
			}
		});
	}
}
