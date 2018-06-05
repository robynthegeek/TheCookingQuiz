package com.robynandcory.thecookingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public int quizScore = 0;

    /**
     * Called when user hits the Check my Answers button
     *
     * @param view 'check my answers' button
     *             adds 10 to quiz score for each fully correct answer
     */

    public void checkAnswers(View view) {
        if (getQuestion1()) {
            quizScore += 10;
        }
        if (getQuestion2()) {
            quizScore += 10;
        }
        if (getQuestion3()) {
            quizScore += 10;
        }
        if (getQuestion4()) {
            quizScore += 10;
        }
        if (getQuestion5()) {
            quizScore += 10;
        }
        if (getQuestion6()) {
            quizScore += 10;
        }
        if (getQuestion7()) {
            quizScore += 10;
        }
// Toast 'Try again' is only shown if all questions are answered incorrectly.
        if (quizScore == 0) {
            Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_LONG).show();

            // Score Toast displays total quiz score when check answers is pressed
        } else {
            Toast.makeText(MainActivity.this, "You scored " + quizScore + " points out of 70!", Toast.LENGTH_LONG).show();
            quizScore = 0;
        }
    }

    public Boolean getQuestion1() {
        RadioButton questionOne = findViewById(R.id.answer1_2);
        return questionOne.isChecked();
    }

    public Boolean getQuestion2() {
        RadioButton questionTwo = findViewById(R.id.answer2_4);
        return questionTwo.isChecked();
    }

    /**
     * returns true if the user enters any combination of the word roux for question three to allow for formatting and indefinite articles.
     */
    public Boolean getQuestion3() {
        EditText questionThreeEditText = findViewById(R.id.questionThree);
        String questionThreeString = questionThreeEditText.getText().toString();
        if (questionThreeString.toLowerCase().contains("roux")) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean getQuestion4() {
        RadioButton questionFour = findViewById(R.id.answer4_3);
        return questionFour.isChecked();
    }

    public Boolean getQuestion5() {
        RadioButton questionFive = findViewById(R.id.answer5_1);
        return questionFive.isChecked();
    }

    public Boolean getQuestion6() {
        RadioButton questionSix = findViewById(R.id.answer6_4);
        return questionSix.isChecked();
    }

    /**
     * Checks answers for question 7, compares to set of correct answers
     *
     * @return boolean true for all 3 correct answers and no incorrect answers.
     */

    public Boolean getQuestion7() {
        Set<Integer> answerQuestion7 = new HashSet<>();
        answerQuestion7.add(R.id.answer7_1);
        answerQuestion7.add(R.id.answer7_3);
        answerQuestion7.add(R.id.answer7_4);
        Set<Integer> submittedAnswersQuestion7 = new HashSet<>();

        CheckBox questionOne = findViewById(R.id.answer7_1);
        if (questionOne.isChecked()) {
            submittedAnswersQuestion7.add(R.id.answer7_1);
        }

        CheckBox questionTwo = findViewById(R.id.answer7_2);
        if (questionTwo.isChecked()) {
            submittedAnswersQuestion7.add(R.id.answer7_2);
        }

        CheckBox questionThree = findViewById(R.id.answer7_3);
        if (questionThree.isChecked()) {
            submittedAnswersQuestion7.add(R.id.answer7_3);
        }

        CheckBox questionFour = findViewById(R.id.answer7_4);
        if (questionFour.isChecked()) {
            submittedAnswersQuestion7.add(R.id.answer7_4);
        }

        CheckBox questionFive = findViewById(R.id.answer7_5);
        if (questionFive.isChecked()) {
            submittedAnswersQuestion7.add(R.id.answer7_5);
        }
        return submittedAnswersQuestion7.equals(answerQuestion7);
    }
}

