package com.example.laowa.newfragmentdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.laowa.newfragmentdemo.R;

public class MyDreamAmendActivity extends AppCompatActivity {


    private EditText et;
    private TextView tv;
    int MAX_LENGTH = 150;					//最大输入字符数150
    int Rest_Length = MAX_LENGTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dream_amend);

 //       et = (EditText) findViewById(R.id.editText);
//        tv = (TextView) findViewById(R.id.textView_show);

//        tv.setText(Html.fromHtml("您还可以输入:"+"<font color=\"red\">"+150+"/150"+"</font>"));
//        et.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // TODO Auto-generated method stub
//                if(Rest_Length > 0){
//                    Rest_Length = MAX_LENGTH - et.getText().length();
//                }
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//                // TODO Auto-generated method stub
//                tv.setText(Html.fromHtml("您还可以输入:"+"<font color=\"red\">"+Rest_Length+"/150"+"</font>"));
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // TODO Auto-generated method stub
//                tv.setText(Html.fromHtml("您还可以输入:"+"<font color=\"red\">"+Rest_Length+"/150"+"</font>"));
//            }
//        });


    }
}
