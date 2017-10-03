package com.tyler_buchheim.harrypotterandthequizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.id.message;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    private int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks question one and increments correct answer count accordingly.
     */
    private void checkQuestionOne() {
        RadioButton guessRadioButton = (RadioButton) findViewById(R.id.question_1_option_2);
        if (guessRadioButton.isChecked()) {
            correctAnswers += 1;
        }
    }

    /**
     * Checks question two and increments correct answer count accordingly.
     */
    private void checkQuestionTwo() {
        RadioButton guessRadioButton = (RadioButton) findViewById(R.id.question_2_option_4);
        if (guessRadioButton.isChecked()) {
            correctAnswers += 1;
        }
    }

    /**
     * Checks question three and increments correct answer count accordingly.
     */
    private void checkQuestionThree() {
        EditText guessEditText = (EditText) findViewById(R.id.question_3_guess);
        String guess = guessEditText.getText().toString().toLowerCase();
        String answer = getString(R.string.question_3_answer).toLowerCase();
        if (guess.equals(answer)) {
            correctAnswers += 1;
        }
    }

    /**
     * Checks question four and increments correct answer count accordingly.
     */
    private void checkQuestionFour() {
        RadioButton guessRadioButton = (RadioButton) findViewById(R.id.question_4_option_1);
        if (guessRadioButton.isChecked()) {
            correctAnswers += 1;
        }
    }

    /**
     * Checks question five and increments correct answer count accordingly.
     */
    private void checkQuestionFive() {
        EditText guessEditText = (EditText) findViewById(R.id.question_5_guess);
        String guess = guessEditText.getText().toString().toLowerCase();
        String answer = getString(R.string.question_5_answer).toLowerCase();
        if (guess.equals(answer)) {
            correctAnswers += 1;
        }
    }

    /**
     * Checks question six and increments correct answer count accordingly.
     */
    private void checkQuestionSix() {
        CheckBox guessCheckBox1 = (CheckBox) findViewById(R.id.question_6_option_1);
        CheckBox guessCheckBox2 = (CheckBox) findViewById(R.id.question_6_option_2);
        CheckBox guessCheckBox3 = (CheckBox) findViewById(R.id.question_6_option_3);
        CheckBox guessCheckBox4 = (CheckBox) findViewById(R.id.question_6_option_4);
        CheckBox guessCheckBox5 = (CheckBox) findViewById(R.id.question_6_option_5);
        CheckBox guessCheckBox6 = (CheckBox) findViewById(R.id.question_6_option_6);
        if (guessCheckBox1.isChecked() && guessCheckBox2.isChecked() && !guessCheckBox3.isChecked() &&
                guessCheckBox4.isChecked() && !guessCheckBox5.isChecked() && guessCheckBox6.isChecked()) {
            correctAnswers += 1;
        }
    }

    /**
     * Checks question seven and increments correct answer count accordingly.
     */
    private void checkQuestionSeven() {
        EditText guessEditText = (EditText) findViewById(R.id.question_7_guess);
        String guess = guessEditText.getText().toString().toLowerCase();
        String answer = getString(R.string.question_7_answer).toLowerCase();
        if (guess.equals(answer)) {
            correctAnswers += 1;
        }
    }

    /**
     * Determines the proper message given the users name and answers correct.
     * @param name of the user
     * @return message text for toast
     */
    private String getMessage(String name) {
        if (correctAnswers == 7) {
            return "7/7 Yer a wizard, " + name + "!";
        } else if (correctAnswers >= 5) {
            return correctAnswers + "/7 Well " + name + ", you're no Hermione, but pretty close!";
        } else if (correctAnswers >= 3) {
            return correctAnswers + "/7 It's okay " + name + ", Hufflepuffs are wizards too";
        } else if (correctAnswers > 0) {
            return correctAnswers + "/7 Yikes " + name + "... Well I hear Filch is due to retire soon";
        } else {
            return "0/7 Yer a muggle, " + name + "...";
        }
    }

    /**
     * Checks all questions then displays an appropriate toast.
     */
    public void getQuizResults(View v) {
        correctAnswers = 0;
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
        checkQuestionFive();
        checkQuestionSix();
        checkQuestionSeven();
        EditText nameEditText = (EditText) findViewById(R.id.name);
        String name = nameEditText.getText().toString();
        if (name.isEmpty()) {
            name = "Harry";
        }
        String message = getMessage(name);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
