package com.example.learningfun.ToanLV;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.learningfun.MainActivity;
import com.example.learningfun.Model.Answer;
import com.example.learningfun.Model.Question;
import com.example.learningfun.R;

import java.util.ArrayList;
import java.util.List;

public class ToanLVActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvQuestion,tvContent,tvAnswer1,tvAnswer2,tvAnswer3,tvAnswer4;

    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toan_lvactivity);
        anhxa();

        mlist = getListQuestion();
        if (mlist.isEmpty()){
            return;
        }
        setDataQuestion(mlist.get(currentQuestion));
    }

    private void setDataQuestion(Question question) {
        if (question ==  null){
            return;
        }
        mquestion = question;
        tvAnswer1.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer2.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer3.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer4.setBackgroundResource(R.drawable.brow_conner);

        String titleQuestion = "Câu hỏi "+ question.getNumber();
        tvQuestion.setText(titleQuestion);
        tvContent.setText(question.getContent());
        tvAnswer1.setText(question.getAnswerList().get(0).getContent());
        tvAnswer2.setText(question.getAnswerList().get(1).getContent());
        tvAnswer3.setText(question.getAnswerList().get(2).getContent());
        tvAnswer4.setText(question.getAnswerList().get(3).getContent());

        tvAnswer1.setOnClickListener(this);
        tvAnswer2.setOnClickListener(this);
        tvAnswer3.setOnClickListener(this);
        tvAnswer4.setOnClickListener(this);

    }

    public void anhxa(){
        tvQuestion = findViewById(R.id.tv_questionNum);
        tvContent = findViewById(R.id.tv_cauhoi_toanLV1);
        tvAnswer1 = findViewById(R.id.btn_dapan1);
        tvAnswer2 = findViewById(R.id.btn_dapan2);
        tvAnswer3 = findViewById(R.id.btn_dapan3);
        tvAnswer4 = findViewById(R.id.btn_dapan4);

    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("4",true));
        answerList.add(new Answer("5",false));
        answerList.add(new Answer("6",false));
        answerList.add(new Answer("7",false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("2",false));
        answerList1.add(new Answer("3",false));
        answerList1.add(new Answer("6",false));
        answerList1.add(new Answer("7",true));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("7",true));
        answerList2.add(new Answer("1",false));
        answerList2.add(new Answer("3",false));
        answerList2.add(new Answer("4",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("7",false));
        answerList3.add(new Answer("1",false));
        answerList3.add(new Answer("3",true));
        answerList3.add(new Answer("4",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("7",false));
        answerList4.add(new Answer("8",false));
        answerList4.add(new Answer("3",false));
        answerList4.add(new Answer("10",true));

        List<Answer> answerList5 = new ArrayList<>();
        answerList5.add(new Answer("7",false));
        answerList5.add(new Answer("1",false));
        answerList5.add(new Answer("3",true));
        answerList5.add(new Answer("4",false));


        questionList.add(new Question(1," Kết quả của phép tính 2+2 là :",answerList));
        questionList.add(new Question(2,"Kết quả của phép tính 5+2 là :",answerList1));
        questionList.add(new Question(3,"Kết quả của phép tính 8-5 là :",answerList2));
        questionList.add(new Question(3,"Kết quả của phép tính 6+4 là :",answerList2));
        questionList.add(new Question(3,"Kết quả của phép tính 10-7 là :",answerList2));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(ToanLVActivity.this);
        LayoutInflater inflater = ToanLVActivity.this.getLayoutInflater();
        View view1   = inflater.inflate(R.layout.dialog_answer,null);
        builder.setView(view1);
        AlertDialog alertDialog = builder.create();
        TextView btnCo = view1.findViewById(R.id.btn_Yes);
        TextView btnKo = view1.findViewById(R.id.btn_No);
        btnCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.isCorrect()){

                    nextQuestion();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ToanLVActivity.this);
                    LayoutInflater inflater = ToanLVActivity.this.getLayoutInflater();
                    View view3   = inflater.inflate(R.layout.dialog_thatbai,null);
                    builder.setView(view3);
                    AlertDialog alertDialog1 = builder.create();
                    alertDialog1.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            alertDialog1.dismiss();
                        }
                    },1500);
                }
                alertDialog.dismiss();
                tvAnswer1.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer2.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer3.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer4.setBackgroundResource(R.drawable.brow_conner);
            }
        });
        btnKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();

    }

    private void showAswerCorrecct() {
    }

    private void nextQuestion() {
        if (currentQuestion == mlist.size() - 1){
            AlertDialog.Builder builder3 = new AlertDialog.Builder(ToanLVActivity.this);
            LayoutInflater inflater3 = ToanLVActivity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    Intent intent = new Intent(ToanLVActivity.this,ToanLV2Activity.class);
                    startActivity(intent);
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(ToanLVActivity.this);
            LayoutInflater inflater1 = ToanLVActivity.this.getLayoutInflater();
            View view2   = inflater1.inflate(R.layout.dialog_chucmung,null);
            builder.setView(view2);
            AlertDialog alertDialog1 = builder.create();
            alertDialog1.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog1.dismiss();
                }
            },1500);
            currentQuestion++;
            setDataQuestion(mlist.get(currentQuestion));
        }

    }

    private void showDialog(String mess){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mess);
        builder.setCancelable(false);

        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                currentQuestion = 0;
                setDataQuestion(mlist.get(currentQuestion));
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}