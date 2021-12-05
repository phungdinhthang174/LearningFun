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
import com.example.learningfun.KhoaHoc.KHLV2Activity;
import com.example.learningfun.Model.Answer;
import com.example.learningfun.Model.Question;
import com.example.learningfun.R;

import java.util.ArrayList;
import java.util.List;


public class DVLV1Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvlv1);

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
        tvQuestion = findViewById(R.id.tv_questionNumdv1);
        tvContent = findViewById(R.id.tv_cauhoi_dvLV1);
        tvAnswer1 = findViewById(R.id.btn_dapan1dv1);
        tvAnswer2 = findViewById(R.id.btn_dapan2dv1);
        tvAnswer3 = findViewById(R.id.btn_dapan3dv1);
        tvAnswer4 = findViewById(R.id.btn_dapan4dv1);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Con cóc",true));
        answerList.add(new Answer("Con gà",false));
        answerList.add(new Answer("Con chó",false));
        answerList.add(new Answer("Con bò",false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Con bò",false));
        answerList1.add(new Answer("Con gà",false));
        answerList1.add(new Answer("Con chó",false));
        answerList1.add(new Answer("Con vịt",true));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("Con nai",false));
        answerList2.add(new Answer("Con gà",false));
        answerList2.add(new Answer("Con ốc",true));
        answerList2.add(new Answer("Con chó ",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("Quả dứa",false));
        answerList3.add(new Answer("Quả mít",false));
        answerList3.add(new Answer("Quả nhãn",true));
        answerList3.add(new Answer("Quả cóc",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("Hoaa đào",false));
        answerList4.add(new Answer("Hoa mai",false));
        answerList4.add(new Answer("Hoa phượng",false));
        answerList4.add(new Answer("Hoa trinh nữ",true));




        questionList.add(new Question(1,"Phục phà phục phịch.\n" +
                "Chân quỳ tay chống? Là con gì?",answerList));
        questionList.add(new Question(2,"Con gì chân ngắn. Mà lại có màng. Mỏ bẹt màu vàng. Hay kêu cạp cạp.Là con gì?",answerList1));
        questionList.add(new Question(3,"Vừa bằng quả ổi.\n Vừa nổi vừa chìm.\n Là con gì??",answerList2));
        questionList.add(new Question(4,"Da cóc mà bọc bột lọc, \n" +
                "Bột lọc mà bọc hòn than?\n" +
                "Là quả gì?",answerList3));
        questionList.add(new Question(5,"Hoa gì ẹ thẹn bên đường ??",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1dv1:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2dv1:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3dv1:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4dv1:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(DVLV1Activity.this);
        LayoutInflater inflater = DVLV1Activity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(DVLV1Activity.this);
                    LayoutInflater inflater = DVLV1Activity.this.getLayoutInflater();
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
            AlertDialog.Builder builder3 = new AlertDialog.Builder(DVLV1Activity.this);
            LayoutInflater inflater3 = DVLV1Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    Intent intent = new Intent(DVLV1Activity.this, DVLV2Activity.class);
                    startActivity(intent);
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(DVLV1Activity.this);
            LayoutInflater inflater = DVLV1Activity.this.getLayoutInflater();
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