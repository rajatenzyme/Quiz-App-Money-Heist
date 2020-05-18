package com.example.finalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	final int q1_ans = R.id.question_1_2;
	final int q2_ans = R.id.question_2_1;
	final String q4_ans = "netflix";
	final int q5_ans = R.id.question_5_1;
	final String q6_ans = "professor";
	final String q7_ans = "rajat";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void verifyAns(View v) {
		ArrayList<String> wrongAns = new ArrayList<>();

		int corr_Ans = 0;

		if(verify_que_1() ){corr_Ans++;} else { wrongAns.add("Question 1");}
		if(verify_que_2() ){corr_Ans++;} else { wrongAns.add("Question 2");}
		if(verify_que_3() ){corr_Ans++;} else { wrongAns.add("Question 3");}
		if(verify_que_4() ){corr_Ans++;} else { wrongAns.add("Question 4");}
		if(verify_que_5() ){corr_Ans++;} else { wrongAns.add("Question 5");}
		if(verify_que_6() ){corr_Ans++;} else { wrongAns.add("Question 6");}
		if(verify_que_7() ){corr_Ans++;} else { wrongAns.add("Question 7");}

		StringBuilder str_build = new StringBuilder();
		for( String str: wrongAns)
		{
			str_build.append(str);
			str_build.append("\n");
		}

		Context context = getApplicationContext();
		CharSequence text = "You got " + corr_Ans + "/7 answers right.\n\nRecheck the following:\n" + str_build.toString();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	private boolean verify_que_1() {
		RadioGroup rg = findViewById(R.id.que_1_rg);

		if(rg.getCheckedRadioButtonId() == q1_ans) {
			return true;
		}

		return false;
	}

	private boolean verify_que_2() {
		RadioGroup rg = findViewById(R.id.que_2_rg);

		if(rg.getCheckedRadioButtonId() == q2_ans) {
			return true;
		}

		return false;
	}

	private boolean verify_que_3() {
		CheckBox c1 = findViewById(R.id.que_3_cb_1);
		CheckBox c2 = findViewById(R.id.que_3_cb_2);
		CheckBox c3 = findViewById(R.id.que_3_cb_3);

		if (c1.isChecked() && c2.isChecked() && c3.isChecked()) {
			return true;
		}

		return false;
	}

	private boolean verify_que_4() {
		EditText et = findViewById(R.id.que_4_et);

		return et.getText().toString().trim().equalsIgnoreCase(q4_ans);
	}

	private boolean verify_que_5() {
		RadioGroup rg = findViewById(R.id.que_5_rg);

		if(rg.getCheckedRadioButtonId() == q5_ans) {
			return true;
		}

		return false;
	}

	private boolean verify_que_6() {
		EditText et = findViewById(R.id.que_6_et);

		return et.getText().toString().trim().equalsIgnoreCase(q6_ans);
	}

	private boolean verify_que_7() {
		EditText et = findViewById(R.id.que_7_et);

		return et.getText().toString().trim().equalsIgnoreCase(q7_ans);
	}
}