package com.example.learningfun.DoVui;

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

import java.util.ArrayList;
import java.util.List;


public class DVLV4Activity extends AppCompatActivity implements View.OnClickListener{
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvlv4);
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
        tvQuestion = findViewById(R.id.tv_questionNumdv4);
        tvContent = findViewById(R.id.tv_cauhoi_dvLV4);
        tvAnswer1 = findViewById(R.id.btn_dapan1dv4);
        tvAnswer2 = findViewById(R.id.btn_dapan2dv4);
        tvAnswer3 = findViewById(R.id.btn_dapan3dv4);
        tvAnswer4 = findViewById(R.id.btn_dapan4dv4);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("2 ông và 1 bà",true));
        answerList.add(new Answer("2 ông và 2 bà",false));
        answerList.add(new Answer("2 bà và 1 ông",false));
        answerList.add(new Answer("3 ông và 1 bà",false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Nho, dừa, xoài, ổi, sung",false));
        answerList1.add(new Answer("Cầu, dừa, đu đủ, xoài, sung",true));
        answerList1.add(new Answer("Cầu, đu đủ, ổi, na, sầu riêng",false));
        answerList1.add(new Answer("Cam, ổi, lê, táo, đu đủ",false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("1",false));
        answerList2.add(new Answer("3",false));
        answerList2.add(new Answer("2",true));
        answerList2.add(new Answer("4",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("Người lì xì",false));
        answerList3.add(new Answer("Người xông nhà (xông đất)",true));
        answerList3.add(new Answer("Người mở hàn",false));
        answerList3.add(new Answer("Người trong gia đình",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("Thần bể nước",false));
        answerList4.add(new Answer("Thần thổ địa",false));
        answerList4.add(new Answer("Thần tài",false));
        answerList4.add(new Answer("Thần bếp",true));




        questionList.add(new Question(1,"Theo truyền thuyết dân gian, Nhà Táo có những ai?",answerList));
        questionList.add(new Question(2,"Mâm ngũ quả cúng ngày tết của miền Nam là những trái nào?",answerList1));
        questionList.add(new Question(3,"Có mấy loại bánh chưng?",answerList2));
        questionList.add(new Question(4,"Người đầu tiên đến chơi nhà trong dịp năm mới được gọi là gì?",answerList3));
        questionList.add(new Question(5,"Ông Táo là vị thần gì trong nhà?",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1dv4:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2dv4:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3dv4:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4dv4:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(DVLV4Activity.this);
        LayoutInflater inflater = DVLV4Activity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(DVLV4Activity.this);
                    LayoutInflater inflater = DVLV4Activity.this.getLayoutInflater();
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
                tvAnswer1.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer2.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer3.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer4.setBackgroundResource(R.drawable.brow_conner);
            }
        });

        alertDialog.show();

    }

    private void showAswerCorrecct() {
    }

    private void nextQuestion() {
        if (currentQuestion == mlist.size() - 1){
            AlertDialog.Builder builder3 = new AlertDialog.Builder(DVLV4Activity.this);
            LayoutInflater inflater3 = DVLV4Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    Intent intent = new Intent(DVLV4Activity.this, DVLV5Activity.class);
                    startActivity(intent);
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(DVLV4Activity.this);
            LayoutInflater inflater = DVLV4Activity.this.getLayoutInflater();
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