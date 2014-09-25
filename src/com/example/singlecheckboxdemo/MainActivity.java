package com.example.singlecheckboxdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnCheckedChangeListener{
	
	private String[] answers = new String[]{"A.小兔子","B.狗熊","C.长颈鹿","D.大象"};
	private TextView choiceTV, questionTV;
	private LinearLayout buttonParent;
	private List<CheckBox> buttons;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		setExam();
	}
	
	public void initView(){
		choiceTV = (TextView) findViewById(R.id.answer);
		questionTV = (TextView) findViewById(R.id.question);
		buttonParent = (LinearLayout) findViewById(R.id.button_parent);
		buttons = new ArrayList<CheckBox>();
		choiceTV.setText("请选择答案");
	}
	
	public void setExam(){
		questionTV.setText("森林里最大的动物是什么？");
		for(int i=0;i<answers.length;i++){
			CheckBox button = (CheckBox) LayoutInflater.from(this).inflate(R.layout.check_button, null);
			button.setText(answers[i]);
			button.setId(i);
			buttonParent.addView(button);
			buttons.add(button);
			button.setOnCheckedChangeListener(this);
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (buttonView.isChecked()) {
			for (int i = 0; i < buttons.size(); i++) {
				if (i != buttonView.getId()) {
					buttons.get(i).setChecked(false);
				} else {
					buttons.get(buttonView.getId()).setChecked(true);
				}
			}
			choiceTV.setText(answers[buttonView.getId()]);
		}else{
			choiceTV.setText("请选择答案");
		}
		
	}
	
	
	

}
