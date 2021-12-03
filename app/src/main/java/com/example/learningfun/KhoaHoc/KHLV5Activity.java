package com.example.learningfun.KhoaHoc;

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
import com.example.learningfun.TVLV.TVLV5Activity;
import com.example.learningfun.TVLV.TVLVActivity;

import java.util.ArrayList;
import java.util.List;


public class KHLV5Activity extends AppCompatActivity implements View.OnClickListener{
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khlv5);

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
        tvQuestion = findViewById(R.id.tv_questionNumkh5);
        tvContent = findViewById(R.id.tv_cauhoi_khLV5);
        tvAnswer1 = findViewById(R.id.btn_dapan1kh5);
        tvAnswer2 = findViewById(R.id.btn_dapan2kh5);
        tvAnswer3 = findViewById(R.id.btn_dapan3kh5);
        tvAnswer4 = findViewById(R.id.btn_dapan4kh5);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Những ảnh hưởng của tự nhiên đến con người và môi trường sống",false));
        answerList.add(new Answer("Tất cả các ý trên ",true));
        answerList.add(new Answer("Các sự vật, hiện tượng tự nhiên",false));
        answerList.add(new Answer("Các quy luật tự nhiên",false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Vận hành nhà máy sản xuất phân bón để sản xuất phân",true));
        answerList1.add(new Answer("Theo dõi nuôi cấy mô cây trồng trong phòng thí nghiệm",false));
        answerList1.add(new Answer("Làm thí nghiệm điều chế chất mới",false));
        answerList1.add(new Answer("Lấy mẫu đất để phân loại đất trồng",false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("Cơ thể bình thường",false));
        answerList2.add(new Answer("Cơ thể mệt mỏi",false));
        answerList2.add(new Answer("Cơ thể sẽ chết",true));
        answerList2.add(new Answer("Cơ thể khỏe mạnh",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("Cơ thể sẽ thiếu nước",false));
        answerList3.add(new Answer("Tất cả các ý",true));
        answerList3.add(new Answer("Ta có thể sẽ bị chết",false));
        answerList3.add(new Answer("Ta sẽ cảm thấy khát",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("60%",false));
        answerList4.add(new Answer("65%",false));
        answerList4.add(new Answer("50%",false));
        answerList4.add(new Answer("70%",true));




        questionList.add(new Question(1,"Khoa học tự nhiên nghiên cứu về lĩnh vực nào dưới đây?",answerList));
        questionList.add(new Question(2,"Theo dõi nuôi cấy mô cây trồng trong phòng thí nghiệm",answerList1));
        questionList.add(new Question(3,"Điều gì sẽ xảy ra nếu một trong các cơ quan của con người ngừng hoạt động?",answerList2));
        questionList.add(new Question(4,"Nếu không uống nước 3 ngày chúng ta sẽ bị gì?",answerList3));
        questionList.add(new Question(5,"Nước chiếm bao nhiêu phần trăm cơ thể con người ??",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1kh5:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2kh5:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3kh5:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4kh5:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(KHLV5Activity.this);
        LayoutInflater inflater = KHLV5Activity.this.getLayoutInflater();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(KHLV5Activity.this);
                    LayoutInflater inflater = KHLV5Activity.this.getLayoutInflater();
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
            AlertDialog.Builder builder3 = new AlertDialog.Builder(KHLV5Activity.this);
            LayoutInflater inflater3 = KHLV5Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(KHLV5Activity.this);
                    LayoutInflater inflater3 = KHLV5Activity.this.getLayoutInflater();
                    View view4 = inflater3.inflate(R.layout.win, null);
                    builder3.setView(view4);
                    AlertDialog alertDialog2 = builder3.create();
                    alertDialog2.show();
                    TextView btnhome = view4.findViewById(R.id.btn_home);
                    TextView btncon = view4.findViewById(R.id.btn_cont);
                    btnhome.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(KHLV5Activity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    btncon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(KHLV5Activity.this, KHLV1Activity.class);
                            startActivity(intent);
                        }
                    });
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(KHLV5Activity.this);
            LayoutInflater inflater = KHLV5Activity.this.getLayoutInflater();
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