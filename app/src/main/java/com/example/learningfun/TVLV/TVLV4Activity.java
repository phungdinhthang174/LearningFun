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

import java.util.ArrayList;
import java.util.List;

public class TVLV4Activity extends AppCompatActivity implements View.OnClickListener{
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvlv4);

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
        tvQuestion = findViewById(R.id.tv_questionNumtv4);
        tvContent = findViewById(R.id.tv_cauhoi_tvLV4);
        tvAnswer1 = findViewById(R.id.btn_dapan1tv4);
        tvAnswer2 = findViewById(R.id.btn_dapan2tv4);
        tvAnswer3 = findViewById(R.id.btn_dapan3tv4);
        tvAnswer4 = findViewById(R.id.btn_dapan4tv4);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("chạy nhảy, nhún nhảy, bay nhảy",true));
        answerList.add(new Answer("chăm chỉ, khéo léo, dẻo dai",false));
        answerList.add(new Answer("núi đồi, bay lượn, mênh mông",false));
        answerList.add(new Answer("dòng sông, cánh đồng, mây trời",false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Tin vào bản thân mình",false));
        answerList1.add(new Answer("Coi trọng mình và xem thường người khác",false));
        answerList1.add(new Answer("Đánh giá mình quá cao và coi thường người khác",false));
        answerList1.add(new Answer("Coi trọng và giữ gìn phẩm giá của mình",true));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("1.Báo hiệu bộ phận đứng sau là lời nói trực tiếp của nhân vật",false));
        answerList2.add(new Answer("2.Báo hiệu một sự liệt kê",false));
        answerList2.add(new Answer("Cả 2 ý 1 và 2 đều đúng",true));
        answerList2.add(new Answer("3Báo hiệu bộ phận đứng sau giải thích cho bộ phận đứng trước",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("giúp mẹ nhổ củ cà rốt.",false));
        answerList3.add(new Answer("miệt vườn nhiều trái ngọt.",false));
        answerList3.add(new Answer("cặm cụi may áo cho bé.",true));
        answerList3.add(new Answer("nhảy nhót trên cành.",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("Bên đường, cây cối",false));
        answerList4.add(new Answer("xanh um",false));
        answerList4.add(new Answer("Bên đường",false));
        answerList4.add(new Answer("Cây cối",true));




        questionList.add(new Question(1,"Dòng nào chỉ bao gồm động từ :",answerList));
        questionList.add(new Question(2,"Dòng nào dưới đây nêu đúng nghĩa của từ tự trọng?",answerList1));
        questionList.add(new Question(3,"Dấu hai chấm trong chuỗi câu sau có tác dụng gì ?\n" +
                "Cô hỏi: \"Sao trò không chịu làm bài ?\"",answerList2));
        questionList.add(new Question(4,"Chọn vế còn thiếu để hoàn thành câu đúng:\n" +
                "\"Mẹ.......................\"",answerList3));
        questionList.add(new Question(5,"Tìm chủ ngữ trong câu sau: \"Bên đường, cây cối xanh um.\"",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1tv4:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2tv4:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3tv4:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4tv4:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(TVLV4Activity.this);
        LayoutInflater inflater = TVLV4Activity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(TVLV4Activity.this);
                    LayoutInflater inflater = TVLV4Activity.this.getLayoutInflater();
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
            AlertDialog.Builder builder3 = new AlertDialog.Builder(TVLV4Activity.this);
            LayoutInflater inflater3 = TVLV4Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    Intent intent = new Intent(TVLV4Activity.this, TVLV5Activity.class);
                    startActivity(intent);
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(TVLV4Activity.this);
            LayoutInflater inflater = TVLV4Activity.this.getLayoutInflater();
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