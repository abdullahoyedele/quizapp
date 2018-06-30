package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //-------------------------------
    // called when submit is clicked
    //-------------------------------
    public void submitQuiz(View view) {
        String message = null;
        //-----------------------------
        // check and calculate answers
        //-----------------------------
        ArrayList incorrectAnswers = new ArrayList();
        int correctAnswers = 0;
        if (radioQuestion1()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.java1));
        }
        if (checkQuestion2()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.jav2));
        }
        if (editQuestion3()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.jav3));
        }
        if (radioQuestion4()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.jav4));
        }
        if (editQuestion5()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.jav5));
        }
        //-----------------
        // grading quiz
        //-----------------
        if (correctAnswers == 0) {
            message = getString(R.string.message1);
        } else if (correctAnswers == 1) {
            message = getString(R.string.message2);
        } else if (correctAnswers == 2) {
            message = getString(R.string.message3);
        } else if (correctAnswers == 3) {
            message = getString(R.string.message4);
        } else if (correctAnswers == 4) {
            message = getString(R.string.message5);
        } else if (correctAnswers == 5) {
            message = getString(R.string.message6);
        }
        //--------------------------------------------------------------
        // shows or echos which questions where not answered correctly
        //--------------------------------------------------------------
        StringBuilder stringBuilder = new StringBuilder();
        for (Object incorrect : incorrectAnswers) {
            stringBuilder.append(incorrect);
            stringBuilder.append("\n");
        }
        Toast.makeText(this, getString(R.string.toast1) +" "+ correctAnswers + getString(R.string.toast2) + message + stringBuilder.toString(), Toast.LENGTH_LONG).show();
    }
    //------------------------------------------------------------------------------------------
    // Question 1 - Correct Answer is #3 (Mongolia)
    //------------------------------------------------------------------------------------------
    private boolean radioQuestion1() {
        RadioGroup ques1 = (RadioGroup) findViewById(R.id.question1);
        if (ques1.getCheckedRadioButtonId() == R.id.q1optionC) {
            return true;
        } else {
            return false;
        }
    }
    //------------------------------------------------------------------------------------------
    // Question 2  - Correct Answers are #1 (Russia), #2 (Iran) and #4 (Turkey)
    //------------------------------------------------------------------------------------------
    private boolean checkQuestion2() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.russia);
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.iran);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.nigeria);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.turkey);
        if (checkBox.isChecked() && checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked()) {
            return true;
        } else {
            return false;
        }
    }
    //------------------------------------------------------------------------------------------
    // Question 3 - Correct Answer is "world health organization"
    //------------------------------------------------------------------------------------------
    private boolean editQuestion3() {
        EditText editText = (EditText) findViewById(R.id.edit1);
        return editText.getText().toString().equalsIgnoreCase("world health organization");
    }
    //------------------------------------------------------------------------------------------
    // Question 4  - Correct Answers is #3 "North Korea"
    //------------------------------------------------------------------------------------------
    private boolean radioQuestion4() {
        RadioGroup ques1 = (RadioGroup) findViewById(R.id.question4);
        if (ques1.getCheckedRadioButtonId() == R.id.q4optionC) {
            return true;
        } else {
            return false;
        }
    }
    //------------------------------------------------------------------------------------------
    // Question 5 - Correct Answer is "United Nations"
    //------------------------------------------------------------------------------------------
    private boolean editQuestion5() {
        EditText editText = (EditText) findViewById(R.id.edit2);
        return editText.getText().toString().equalsIgnoreCase("united nations");
    }
    //------------------------
    // Reset Button Event
    //------------------------
    public void reset(View view) {
        RadioGroup radioGroup = findViewById(R.id.question1);
        radioGroup.clearCheck();
        CheckBox checkBox = findViewById(R.id.russia);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.iran);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.nigeria);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.turkey);
        checkBox.setChecked(false);
        EditText editText = findViewById(R.id.edit1);
        editText.setText("");
        RadioGroup radioGroup2 = findViewById(R.id.question4);
        radioGroup2.clearCheck();
        EditText editText2 = findViewById(R.id.edit2);
        editText2.setText("");
    }
}

