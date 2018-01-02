package com.darly.dview.widget.clearedit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darly.dview.R;


public class ViewEditTextEx extends LinearLayout {
	private Context mContext;
	
	private TextView textView;
	private EditText editText1;
	private EditText editText2;

	private String textView_note = "TextView";
	private String textEdit_note = "";
	
	private int textViewNormalFont = 16;
	private int textViewFocusFont = 12;
	private int editTextNormalFont = 12;
	private int editTextFocusFont = 16;
	
	public ViewEditTextEx(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView();
		initData();
		initListener();		
	}

	private void initView() {
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.dv_viewedittextex, this, true);
		textView = (TextView) findViewById(R.id.text_view);
		editText1 = (EditText) findViewById(R.id.edit_1);
		editText2 = (EditText) findViewById(R.id.edit_2);
	}
	
	private void initData(){
		textView.setText(textView_note);
		editText1.setText(textEdit_note);
		editText2.setText(textEdit_note);
	}
	
	private void initListener(){
		editText1.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				ViewFocusChange(hasFocus, textView, editText1);
			}
		});
		editText2.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				ViewFocusChange(hasFocus, textView, editText2);
			}
		});		
	}
	
	private void ViewFocusChange(boolean hasFocus, TextView textView, EditText editText) {
		if (hasFocus) {
			textView.setTextSize(textViewFocusFont);
			editText.setBackground(getResources().getDrawable(R.drawable.login_edittext_highlight));
			editText.setTextSize(editTextFocusFont);
		}else {
			textView.setTextSize(textViewNormalFont);
			editText.setBackground(getResources().getDrawable(R.drawable.login_edittext_normal));
			editText.setTextSize(editTextNormalFont);
		}
	}
	
	public void setTextViewText(String text) {
		textView.setText(text);
	}

	public void setEditTextOneText(String text) {
		editText1.setText(text);
	}

	public String getEditTextOneText() {
		return editText1.getText().toString();
	}
	
	public void setEditTextOneHint(String text) {
		editText1.setHint(text);
	}

	public void setEditTextTwoText(String text) {
		editText2.setText(text);
	}

	public String getEditTextTwoText() {
		return editText2.getText().toString();
	}
	
	public void setEditTextTwoHint(String text) {
		editText2.setHint(text);
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
		editText1.setTextSize(editTextNormalFont);
		editText2.setTextSize(editTextNormalFont);
	}

	public void setEditTextFocusFont(int editTextFocusFont) {
		this.editTextFocusFont = editTextFocusFont;
		editText1.setTextSize(editTextFocusFont);
		editText2.setTextSize(editTextFocusFont);
	}
	
	public void setEditTextOneInputMode(int type) {
		editText1.setInputType(type);
	}

	public void setEditTextTwoInputMode(int type) {
		editText2.setInputType(type);
	}
	
	public void setEditTextOneEnable(boolean value) {
		editText1.setEnabled(value);
	}

	public void setEditTextTwoEnable(boolean value) {
		editText2.setEnabled(value);
	}	
}
