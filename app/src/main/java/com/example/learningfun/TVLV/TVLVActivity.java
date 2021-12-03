package com.example.learningfun.TVLV;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.learningfun.Model.Answer;
import com.example.learningfun.Model.Question;
import com.example.learningfun.R;
import com.example.learningfun.ToanLV.ToanLV2Activity;
import com.example.learningfun.ToanLV.ToanLVActivity;

import java.util.ArrayList;
import java.util.List;

public class TVLVActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvlvactivity);
        anhxa();


        mlist = getListQuestion();
        if (mlist.isEmpty()) {
            return;
        }
        setDataQuestion(mlist.get(currentQuestion));
    }

    private void setDataQuestion(Question question) {
        if (question == null) {
            return;
        }
        mquestion = question;
        tvAnswer1.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer2.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer3.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer4.setBackgroundResource(R.drawable.brow_conner);

        String titleQuestion = "Câu hỏi " + question.getNumber();
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
        tvQuestion = findViewById(R.id.tv_questionNumtv1);
        tvContent = findViewById(R.id.tv_cauhoi_tvLV1);
        tvAnswer1 = findViewById(R.id.btn_dapan1tv1);
        tvAnswer2 = findViewById(R.id.btn_dapan2tv1);
        tvAnswer3 = findViewById(R.id.btn_dapan3tv1);
        tvAnswer4 = findViewById(R.id.btn_dapan4tv1);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("sắp sếp",false));
        answerList.add(new Answer("xắp sếp",false));
        answerList.add(new Answer("xắp xếp",false));
        answerList.add(new Answer("sắp xếp",true));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Cắp",false));
        answerList1.add(new Answer("Cặp",true));
        answerList1.add(new Answer("Lắp",false));
        answerList1.add(new Answer("Tắp ",false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("tôi",false));
        answerList2.add(new Answer("học",false));
        answerList2.add(new Answer("sinh",true));
        answerList2.add(new Answer("lớp ",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("s",false));
        answerList3.add(new Answer("x",true));
        answerList3.add(new Answer("l",false));
        answerList3.add(new Answer("k",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("gà",false));
        answerList4.add(new Answer("kẻ",false));
        answerList4.add(new Answer("quả",false));
        answerList4.add(new Answer("gé",true));




        questionList.add(new Question(1,"Từ nào sau đây viết đúng ?",answerList));
        questionList.add(new Question(2,"Từ nào sau đây có tiếng khác các từ còn lại ?",answerList1));
        questionList.add(new Question(3," \"Tôi là học sinh lớp 1.\" \n" +
                "Từ nào có chứa vần /inh/",answerList2));
        questionList.add(new Question(4,"Điền vào chỗ chấm? \n" +
                "...inh đẹp .",answerList3));
        questionList.add(new Question(5,"Từ nào viết sai chính tả ?",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1tv1:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2tv1:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3tv1:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4tv1:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(TVLVActivity.this);
        LayoutInflater inflater = TVLVActivity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(TVLVActivity.this);
                    LayoutInflater inflater = TVLVActivity.this.getLayoutInflater();
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
            AlertDialog.Builder builder3 = new AlertDialog.Builder(TVLVActivity.this);
            LayoutInflater inflater3 = TVLVActivity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    Intent intent = new Intent(TVLVActivity.this, TVLV2Activity.class);
                    startActivity(intent);
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(TVLVActivity.this);
            LayoutInflater inflater = TVLVActivity.this.getLayoutInflater();
            View view2   = inflater.inflate(R.layout.dialog_chucmung,null);
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


}