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

import java.util.ArrayList;
import java.util.List;


public class KHLV2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khlv2);

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
        tvQuestion = findViewById(R.id.tv_questionNumkh2);
        tvContent = findViewById(R.id.tv_cauhoi_khLV2);
        tvAnswer1 = findViewById(R.id.btn_dapan1kh2);
        tvAnswer2 = findViewById(R.id.btn_dapan2kh2);
        tvAnswer3 = findViewById(R.id.btn_dapan3kh2);
        tvAnswer4 = findViewById(R.id.btn_dapan4kh2);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Tôm",true));
        answerList.add(new Answer("Gạo",false));
        answerList.add(new Answer("Khoai lang",false));
        answerList.add(new Answer("Ngô",false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Vitamin E",false));
        answerList1.add(new Answer("Vitamin C",false));
        answerList1.add(new Answer("Vitamin D",false));
        answerList1.add(new Answer("Vitamin E",true));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("Để đủ các loại vitamin",false));
        answerList2.add(new Answer("Để đủ chất khoáng",false));
        answerList2.add(new Answer("Tất cả các ý trên",true));
        answerList2.add(new Answer("Chống táo bón",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("Không khí, ánh sáng, nhiệt độ thích hợp",false));
        answerList3.add(new Answer("Thức ăn",false));
        answerList3.add(new Answer("Nước uống",false));
        answerList3.add(new Answer("Tất cả các ý trên",true));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("giấy",false));
        answerList4.add(new Answer(" vải bông",false));
        answerList4.add(new Answer("Tất cả các ý trên",false));
        answerList4.add(new Answer("Chai thủy tinh",true));




        questionList.add(new Question(1,"Trong một số thức ăn dưới đây, thức ăn nào không chứa chất bột đường?",answerList));
        questionList.add(new Question(2,"Trong cà rốt có chứa nhiều viatamin gì ?",answerList1));
        questionList.add(new Question(3,"Vì sao nên ăn rau và và quả chín hằng ngày?",answerList2));
        questionList.add(new Question(4,"Như mọi sinh vật khác, con người cần gì để duy trì sự sống của mình?",answerList3));
        questionList.add(new Question(5,"Vật nào dưới đây không cho nước thấm qua?",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1kh2:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2kh2:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3kh2:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4kh2:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(KHLV2Activity.this);
        LayoutInflater inflater = KHLV2Activity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(KHLV2Activity.this);
                    LayoutInflater inflater = KHLV2Activity.this.getLayoutInflater();
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
            AlertDialog.Builder builder3 = new AlertDialog.Builder(KHLV2Activity.this);
            LayoutInflater inflater3 = KHLV2Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    Intent intent = new Intent(KHLV2Activity.this, KHLV3Activity.class);
                    startActivity(intent);
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(KHLV2Activity.this);
            LayoutInflater inflater = KHLV2Activity.this.getLayoutInflater();
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