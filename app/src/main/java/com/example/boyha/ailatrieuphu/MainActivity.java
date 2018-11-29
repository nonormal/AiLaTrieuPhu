package com.example.boyha.ailatrieuphu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

class Question{
    public int id;
    public String question;
    public Boolean answer;

}
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView edtQuest;
    Button btnTrue;
    Button btnFalse;
    int numquest=0;
    boolean iscorrect;
    Question[] listQuest=createListQuest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtQuest=(TextView) findViewById(R.id.edtQuestion);
        btnTrue=(Button)findViewById(R.id.btnTrue);
        btnFalse=(Button)findViewById(R.id.btnFalse);

        edtQuest.setText(listQuest[numquest].question.toString());

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);

    }
    public Question[] createListQuest(){
        Question[] q = new Question[2];
        q[0]=new Question();
        q[0].question="Huy ế có phải không?";
        q[0].answer=true;

        q[1]=new Question();
        q[1].question="Huy ăn nhiều lắm phải không?";
        q[1].answer=false;
        return q;
    }
    public boolean changeAnswer (Question[] listQuest,boolean iscorrect,int numquest){
        edtQuest=(TextView) findViewById(R.id.edtQuestion);
        if(iscorrect==listQuest[numquest].answer){
            edtQuest.setText(listQuest[numquest+1].question.toString());
            Toast.makeText(MainActivity.this,"Chính xác",Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            Toast.makeText(MainActivity.this,"Sai rồi!! Chọn lại",Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void onClick(View v){
        btnTrue=(Button)findViewById(R.id.btnTrue);
        btnFalse=(Button)findViewById(R.id.btnFalse);
        while(numquest<=listQuest.length-1){
            if(v.getId()==btnTrue.getId()){
                iscorrect=changeAnswer(listQuest,true,numquest);
                if (iscorrect==true){
                    numquest++;
                }
                break;
            }
            if(v.getId()==btnFalse.getId()){
                iscorrect=changeAnswer(listQuest,false,numquest);
                if (iscorrect==true){
                    numquest++;
                }
                break;
            }
        }
    }
}
