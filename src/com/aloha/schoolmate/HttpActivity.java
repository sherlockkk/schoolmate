package com.aloha.schoolmate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aloha.schoolmate.R.id;
import com.lody.welike.WelikeHttp;
import com.lody.welike.http.HttpParams;
import com.lody.welike.http.HttpRequest;
import com.lody.welike.http.HttpResponse;
import com.lody.welike.http.callback.HttpResultCallback;
import com.lody.welike.ui.WelikeActivity;
import com.lody.welike.ui.WelikeToast;
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
		params.put("id", "151091");
		WelikeHttp.getDefault().get(
				"http://192.168.1.114:8888/Service/getFellowDetail", params,
				new HttpResultCallback() {
					@Override
					public void onSuccess(String content) {
						super.onSuccess(content);
						WelikeToast.toast("返回的JSON为:" + content);
						System.out.println(content);
					}

					@Override
					public void onFailure(HttpResponse response) {
						super.onFailure(response);
						WelikeToast.toast("JSON请求发送失败.");
					}

					@Override
					public void onCancel(HttpRequest request) {
						super.onCancel(request);
					}
				});
	}
}
