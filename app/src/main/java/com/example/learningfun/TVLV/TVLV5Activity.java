package com.example.learningfun.TVLV;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.learningfun.ToanLV.ToanLV5Activity;
import com.example.learningfun.ToanLV.ToanLVActivity;

import java.util.ArrayList;
import java.util.List;

public class TVLV5Activity extends AppCompatActivity implements View.OnClickListener{
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvlv5);


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
        tvQuestion = findViewById(R.id.tv_questionNumtv5);
        tvContent = findViewById(R.id.tv_cauhoi_tvLV5);
        tvAnswer1 = findViewById(R.id.btn_dapan1tv5);
        tvAnswer2 = findViewById(R.id.btn_dapan2tv5);
        tvAnswer3 = findViewById(R.id.btn_dapan3tv5);
        tvAnswer4 = findViewById(R.id.btn_dapan4tv5);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Tiện đi học về, em ghé qua nhà bà nội.",true));
        answerList.add(new Answer("Tiện đi học về, em gé qua nhà bà nội.",false));
        answerList.add(new Answer("Cả 2 câu đều đúng",false));
        answerList.add(new Answer("Cả 2 câu đều sai",false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Nhân dân, nhân cộng, nhân đức",false));
        answerList1.add(new Answer("Công nhân, nhân chứng, bệnh nhân",false));
        answerList1.add(new Answer("Công nhân, nhân chứng, bệnh nhân",true));
        answerList1.add(new Answer("Nhân dân, nhân từ, nhân tài",false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("Dù đói khổ chúng ta cũng cần phải thơm tho.",false));
        answerList2.add(new Answer("Dù đói khổ chúng ta cũng phải sạch sẽ.",false));
        answerList2.add(new Answer("Dù đói rách, khổ sở chúng ta cũng cần phải sống trong sạch và lương thiện.",true));
        answerList2.add(new Answer("Chúng ta cần phải giúp đỡ những người đói rách, khổ sở.",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer(" Câu đơn",true));
        answerList3.add(new Answer("Câu đặc biệt",false));
        answerList3.add(new Answer("Câu ghép",false));
        answerList3.add(new Answer("Câu rút gọn",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("2 cặp",false));
        answerList4.add(new Answer("1 cặp",false));
        answerList4.add(new Answer("4 cặp",false));
        answerList4.add(new Answer("2 cặp",true));




        questionList.add(new Question(1,"Câu nào sai đây viết đúng chính tả :",answerList));
        questionList.add(new Question(2,"Những từ \"nhân\" có nghĩa \"lòng thương người\" là:",answerList1));
        questionList.add(new Question(3,"Câu tục ngữ \" Đói cho sạch, rách cho thơm\" có nghĩa là:",answerList2));
        questionList.add(new Question(4,"Câu sau đây là loại câu gì?\n" +
                "\"Đền đài, miếu mạo, cung điện của họ lúp xúp dưới chân.\"",answerList3));
        questionList.add(new Question(5,"Câu tục ngữ \"Lên thác xuống ghềnh\" có mấy cặp từ trái nghĩa?",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1tv5:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2tv5:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3tv5:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4tv5:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(TVLV5Activity.this);
        LayoutInflater inflater = TVLV5Activity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(TVLV5Activity.this);
                    LayoutInflater inflater = TVLV5Activity.this.getLayoutInflater();
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
            AlertDialog.Builder builder3 = new AlertDialog.Builder(TVLV5Activity.this);
            LayoutInflater inflater3 = TVLV5Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(TVLV5Activity.this);
                    LayoutInflater inflater3 = TVLV5Activity.this.getLayoutInflater();
                    View view4 = inflater3.inflate(R.layout.win, null);
                    builder3.setView(view4);
                    AlertDialog alertDialog2 = builder3.create();
                    alertDialog2.show();
                    TextView btnhome = view4.findViewById(R.id.btn_home);
                    TextView btncon = view4.findViewById(R.id.btn_cont);
                    btnhome.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(TVLV5Activity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    btncon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(TVLV5Activity.this, TVLVActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(TVLV5Activity.this);
            LayoutInflater inflater = TVLV5Activity.this.getLayoutInflater();
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