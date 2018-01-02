package com.darly.dview.widget.clearedit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darly.dview.R;


public class ViewEditText extends LinearLayout {
	private TextView textView;
	private EditText editText;
	private Context mContext;

	private String textView_note = "TextView";
	private String textEdit_note = "";
	
	private int textViewNormalFont = 16;
	private int textViewFocusFont = 12;
	private int editTextNormalFont = 12;
	private int editTextFocusFont = 16;
	
	public ViewEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView();
		initData();
		initListener();		
	}

	private void initView() {
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.dv_viewedittext, this, true);
		textView = (TextView) findViewById(R.id.text_view);
		editText = (EditText) findViewById(R.id.text_edit);
	}
	
	private void initData(){
		textView.setText(textView_note);
		editText.setText(textEdit_note);
	}
	
	private void initListener(){
		editText.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				ViewFocusChange(hasFocus);
			}
		});
	}
	
	private void ViewFocusChange(boolean hasFocus) {
		if (hasFocus) {
			textView.setTextSize(textViewFocusFont);
			editText.setBackgroundResource(R.drawable.login_edittext_highlight);
			editText.setTextSize(editTextFocusFont);
		}else {
			textView.setTextSize(textViewNormalFont);
			editText.setBackgroundResource(R.drawable.login_edittext_normal);
			editText.setTextSize(editTextNormalFont);
		}
	}
	
	public void setTextViewText(String text) {
		textView.setText(text);
	}

	public void setEditTextText(String text) {
		editText.setText(text);
	}

	public String getEditTextText() {
		return editText.getText().toString();
	}
	
	public void setEditTextHint(String text) {
		editText.setHint(text);
	}

	public void setTextViewNormalFont(int textViewNormalFont) {
		this.textViewNormalFont = textViewNormalFont;
		textView.setTextSize(textViewNormalFont);
	}

	public void setTextViewFocusFont(int textViewFocusFont) {
		this.textViewFocusFont = textViewFocusFont;
		textView.setTextSize(textViewFocusFont);
	}

	public void setEditTextNormalFont(int editTextNormalFont) {
		this.editTextNormalFont = editTextNormalFont;
		editText.setTextSize(editTextNormalFont);
	}

	public void setEditTextFocusFont(int editTextFocusFont) {
		this.editTextFocusFont = editTextFocusFont;
		editText.setTextSize(editTextFocusFont);
	}
	
	public void setEditTextInputMode(int type) {
		editText.setInputType(type);
	}
}
