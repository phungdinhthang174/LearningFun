package com.example.learningfun.DoVui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.learningfun.KhoaHoc.KHLV1Activity;
import com.example.learningfun.KhoaHoc.KHLV5Activity;
import com.example.learningfun.MainActivity;
import com.example.learningfun.Model.Answer;
import com.example.learningfun.Model.Question;
import com.example.learningfun.R;

import java.util.ArrayList;
import java.util.List;


public class DVLV5Activity extends AppCompatActivity implements View.OnClickListener {
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvlv5);

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
        tvQuestion = findViewById(R.id.tv_questionNumdv5);
        tvContent = findViewById(R.id.tv_cauhoi_dvLV5);
        tvAnswer1 = findViewById(R.id.btn_dapan1dv5);
        tvAnswer2 = findViewById(R.id.btn_dapan2dv5);
        tvAnswer3 = findViewById(R.id.btn_dapan3dv5);
        tvAnswer4 = findViewById(R.id.btn_dapan4dv5);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Cửa chính",false));
        answerList.add(new Answer("Cửa sổ",false));
        answerList.add(new Answer("Ban công",false));
        answerList.add(new Answer("Ống khói",true));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Màu cam, viền trắng",false));
        answerList1.add(new Answer("Màu đỏ, viền trắng",true));
        answerList1.add(new Answer("Màu trắng, viền đỏ",false));
        answerList1.add(new Answer("Màu đỏ, viền xanh",false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("ngày 23 tháng 12",false));
        answerList2.add(new Answer("ngày 24 tháng 12",false));
        answerList2.add(new Answer("ngày 25 tháng 12",true));
        answerList2.add(new Answer("ngày 26 tháng 12",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("sống cùng nàng bạch tuyết và 7 chú lùn",false));
        answerList3.add(new Answer("sống cùng các chú lùn và các con tuần lộc",true));
        answerList3.add(new Answer("sống cùng những chú cánh cụt",false));
        answerList3.add(new Answer("sống cùng những con gấu tuyết",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("7 con",false));
        answerList4.add(new Answer("6 con",false));
        answerList4.add(new Answer("10 con",false));
        answerList4.add(new Answer("9 con",true));




        questionList.add(new Question(1,"Ông già Noel vào nhà của các em nhỏ bằng đường nào?",answerList));
        questionList.add(new Question(2,"Ông già Noel thường mặc quần áo màu gì?",answerList1));
        questionList.add(new Question(3,"Lễ chính thức của Lễ Giáng sinh là ngày nào?",answerList2));
        questionList.add(new Question(4,"Ông già Noel sinh sống tại Bắc Cực với những người nào?",answerList3));
        questionList.add(new Question(5,"Ông già Noel cưỡi mấy con tuần lộc?",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1dv5:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2dv5:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3dv5:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4dv5:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(DVLV5Activity.this);
        LayoutInflater inflater = DVLV5Activity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(DVLV5Activity.this);
                    LayoutInflater inflater = DVLV5Activity.this.getLayoutInflater();
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
            AlertDialog.Builder builder3 = new AlertDialog.Builder(DVLV5Activity.this);
            LayoutInflater inflater3 = DVLV5Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DVLV5Activity.this);
                    LayoutInflater inflater3 = DVLV5Activity.this.getLayoutInflater();
                    View view4 = inflater3.inflate(R.layout.win, null);
                    builder3.setView(view4);
                    AlertDialog alertDialog2 = builder3.create();
                    alertDialog2.show();
                    TextView btnhome = view4.findViewById(R.id.btn_home);
                    TextView btncon = view4.findViewById(R.id.btn_cont);
                    btnhome.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DVLV5Activity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    btncon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DVLV5Activity.this, DVLV1Activity.class);
                            startActivity(intent);
                        }
                    });
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(DVLV5Activity.this);
            LayoutInflater inflater = DVLV5Activity.this.getLayoutInflater();
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