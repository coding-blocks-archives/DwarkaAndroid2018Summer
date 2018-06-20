package com.example.ashutosh_pc.calculo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Home extends AppCompatActivity implements View.OnClickListener {
    private Button but0;
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private Button but9;
    private Button butplus;
    private Button butmin;
    private Button butmulti;
    private Button butdiv;
    private Button butequal;
    private Button butdot;
    private ImageButton del;
    private EditText Inputtext;
    private TextView Resulttext;
    private boolean stateerror=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        InitializeButtons();
        SetonClick();
        Inputtext.addTextChangedListener(textWatcher);
    }

    private void InitializeButtons() {
        this.Inputtext = findViewById(R.id.editText);
        this.Resulttext = findViewById(R.id.textView2);
        this.but0 = findViewById(R.id.but0);
        this.but1 = findViewById(R.id.button1);
        this.but2 = findViewById(R.id.but2);
        this.but3 = findViewById(R.id.but3);
        this.but4 = findViewById(R.id.but4);
        this.but5 = findViewById(R.id.but5);
        this.but6 = findViewById(R.id.but6);
        this.but7 = findViewById(R.id.but7);
        this.but8 = findViewById(R.id.but8);
        this.but9 = findViewById(R.id.but9);
        this.butplus = findViewById(R.id.butplus);
        this.butmin = findViewById(R.id.butmin);
        this.butmulti = findViewById(R.id.butmulti);
        this.butdiv = findViewById(R.id.butdiv);
        this.butequal = findViewById(R.id.butequal);
        this.butdot = findViewById(R.id.butdot);
        this.del = findViewById(R.id.imagebuttonbck);
    }


    private void SetonClick() {
        this.but0.setOnClickListener(this);
        this.but1.setOnClickListener(this);
        this.but2.setOnClickListener(this);
        this.but3.setOnClickListener(this);
        this.but4.setOnClickListener(this);
        this.but5.setOnClickListener(this);
        this.but6.setOnClickListener(this);
        this.but7.setOnClickListener(this);
        this.but8.setOnClickListener(this);
        this.but9.setOnClickListener(this);
        this.butplus.setOnClickListener(this);
        this.butmin.setOnClickListener(this);
        this.butmulti.setOnClickListener(this);
        this.butdiv.setOnClickListener(this);
        this.butequal.setOnClickListener(this);
        this.del.setOnClickListener(this);
        this.butdot.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int Id = view.getId();
        switch (Id) {

            case R.id.but0:
                Append("0");
                break;
            case R.id.button1:
                Append("1");
                break;
            case R.id.but2:
                Append("2");
                break;
            case R.id.but3:
                Append("3");
                break;
            case R.id.but4:
                Append("4");
                break;
            case R.id.but5:
                Append("5");
                break;
            case R.id.but6:
                Append("6");
                break;
            case R.id.but7:
                Append("7");
                break;
            case R.id.but8:
                Append("8");
                break;
            case R.id.but9:
                Append("9");
                break;
            case R.id.butplus:
                if (EndsWithOperator())
                    Replace("+");
                else
                    Append("+");
                break;
            case R.id.butmin:
                if (EndsWithOperator())
                    Replace("-");
                else
                    Append("-");
                break;
            case R.id.butmulti:
                if (EndsWithOperator())
                    Replace("x");
                else
                    Append("x");
                break;
            case R.id.butdiv:
                if (EndsWithOperator())
                    Replace("/");
                else
                    Append("/");
                break;
            case R.id.butequal:
                Calculate(true);
                break;
            case R.id.butdot:
                Log.e("TAG", "onClick: ");
                Append(".");
                break;
            case R.id.imagebuttonbck:
                Delete();
                break;
            default:
                break;
        }
    }

    private void Append(String str) {
        this.Inputtext.getText().append(str);

    }

    private void Delete() {
        if (!IsEmpty()) {
            this.Inputtext.getText().delete(getInput().length() - 1, getInput().length());
        }
    }

    private String getInput() {
        return this.Inputtext.getText().toString();
    }

    private boolean IsEmpty() {
        return this.getInput().isEmpty();
    }

    private void Replace(String str) {
        Inputtext.getText().replace(getInput().length() - 1, getInput().length(), str);
    }

    private boolean EndsWithOperator() {
        return getInput().endsWith("+") || getInput().endsWith("-") || getInput().endsWith("x") || getInput().endsWith("/");
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Calculate(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void Calculate(boolean IseqealClick) {
        String input=getInput();
    try {
        if(!IsEmpty()){
            if(input.contains("x")){
                input=input.replaceAll("x","*");
            }
        }
        Expression expression=new ExpressionBuilder(input).build();
        double result=expression.evaluate();
        if(IseqealClick) {
            Inputtext.setText(String.valueOf(result));
            Resulttext.setText("");
        }else
            Resulttext.setText(String.valueOf(result));

    }catch(Exception e){
        stateerror=true;
    }

    }
}
