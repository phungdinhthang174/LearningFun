package com.example.learningfun.KhoaHoc;

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
import com.example.learningfun.TVLV.TVLV2Activity;
import com.example.learningfun.TVLV.TVLVActivity;

import java.util.ArrayList;
import java.util.List;

public class KHLV1Activity extends AppCompatActivity implements View.OnClickListener {
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khlv1);

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
        tvQuestion = findViewById(R.id.tv_questionNumkh1);
        tvContent = findViewById(R.id.tv_cauhoi_khLV1);
        tvAnswer1 = findViewById(R.id.btn_dapan1kh1);
        tvAnswer2 = findViewById(R.id.btn_dapan2kh1);
        tvAnswer3 = findViewById(R.id.btn_dapan3kh1);
        tvAnswer4 = findViewById(R.id.btn_dapan4kh1);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Có bố và mẹ",false));
        answerList.add(new Answer("Có ông bà và bố mẹ",false));
        answerList.add(new Answer("Có bố mẹ và các con",false));
        answerList.add(new Answer("Có ông bà, bố mẹ và các con",true));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Hình tròn",false));
        answerList1.add(new Answer("Hình cầu",true));
        answerList1.add(new Answer("Hình vuông",false));
        answerList1.add(new Answer("Hình tam giác",false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("Việt Nam",false));
        answerList2.add(new Answer("Hàn Quốc",false));
        answerList2.add(new Answer("Lào",true));
        answerList2.add(new Answer("Campuchia",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("Nước đường",false));
        answerList3.add(new Answer("Nước biển",true));
        answerList3.add(new Answer("Nước chanh",false));
        answerList3.add(new Answer("Nước dưa hấu",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("Mặt tiền",false));
        answerList4.add(new Answer("Mặt trăng",false));
        answerList4.add(new Answer("Mặt đường",false));
        answerList4.add(new Answer("Mặt trời",true));




        questionList.add(new Question(1,"Đâu là gia đình 3 thế hệ ?? ",answerList));
        questionList.add(new Question(2,"Trái đất có hình gì ??",answerList1));
        questionList.add(new Question(3,"Nước nào không có biển ??",answerList2));
        questionList.add(new Question(4,"Nước nào có vị mặn ?? ",answerList3));
        questionList.add(new Question(5,"Mặt nào sáng nhất ??",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1kh1:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2kh1:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3kh1:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4kh1:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(KHLV1Activity.this);
        LayoutInflater inflater = KHLV1Activity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(KHLV1Activity.this);
                    LayoutInflater inflater = KHLV1Activity.this.getLayoutInflater();
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
            AlertDialog.Builder builder3 = new AlertDialog.Builder(KHLV1Activity.this);
            LayoutInflater inflater3 = KHLV1Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    Intent intent = new Intent(KHLV1Activity.this, KHLV2Activity.class);
                    startActivity(intent);
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(KHLV1Activity.this);
            LayoutInflater inflater = KHLV1Activity.this.getLayoutInflater();
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