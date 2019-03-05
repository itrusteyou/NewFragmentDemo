package com.example.laowa.newfragmentdemo.FragmentMain;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.laowa.newfragmentdemo.Constant;
import com.example.laowa.newfragmentdemo.R;
import com.example.laowa.newfragmentdemo.activity.MyDreamAmendActivity;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import me.shihao.library.XStatusBarHelper;

import static android.content.Context.MODE_PRIVATE;
import static android.view.View.INVISIBLE;

/**
 *
 * Created by laowa on 2019/01/12.
 * 第三个页面，我的页面
 *
 */
public class MyFragment_me extends Fragment implements View.OnClickListener {

    //我的页面所有信息：
    private ImageButton my_page_set;

    private TextView my_name;
    private ImageView my_name_btn;

    private ImageView my_online_state_dot;
    private TextView my_online_state;

    private TextView my_dream;
    private ImageView my_dream_btn;

    private TextView my_major;
    private ImageView my_major_btn;

    private TextView my_learn;
    private ImageView my_learn_btn;

    private TextView my_habit1;
    private TextView my_habit2;
    private TextView my_habit3;
    private TextView my_habit4;
    private ImageView my_habit_btn;

    private TextView my_sex;
    private TextView my_age;
    private ImageView my_age_sex_btn;

    private TextView my_school_local;
    private ImageView my_school_local_btn;

    private TextView my_school;
    private ImageView my_school_btn;

    private TextView local_time;
    private TextView joint_data;


    private ImageView myPic;

    private AlertDialog.Builder builder = null;
    public MyFragment_me() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_me, container, false);
        myPic = view.findViewById(R.id.page_me_pic);
        my_page_set = view.findViewById(R.id.my_page_set);
        my_name = view.findViewById(R.id.my_name);
        my_name_btn = view.findViewById(R.id.my_information_btn);
        my_online_state_dot = view.findViewById(R.id.my_online_state_dot);
        my_online_state = view.findViewById(R.id.my_online_state);
        my_dream = view.findViewById(R.id.my_dream_txt);
       // my_dream_btn = view.findViewById(R.id.my_dream_txt_btn);
        my_major = view.findViewById(R.id.my_major);
     //   my_major_btn = view.findViewById(R.id.my_major_btn);
        my_learn = view.findViewById(R.id.my_learn);
     //   my_learn_btn = view.findViewById(R.id.my_learn_btn);
        my_habit1 = view.findViewById(R.id.my_habit1);
        my_habit2 = view.findViewById(R.id.my_habit2);
        my_habit3 = view.findViewById(R.id.my_habit3);
        my_habit4 = view.findViewById(R.id.my_habit4);
      //  my_habit_btn = view.findViewById(R.id.my_habit_btn);
        my_sex = view.findViewById(R.id.my_sex);
        my_age = view.findViewById(R.id.my_age);
      //  my_age_sex_btn = view.findViewById(R.id.my_sex_age_btn);
        my_school_local = view.findViewById(R.id.my_school_local);
      //  my_school_local_btn = view.findViewById(R.id.my_school_local_btn);
        my_school = view.findViewById(R.id.my_school);
      //  my_school_btn = view.findViewById(R.id.my_school_btn);
        local_time = view.findViewById(R.id.my_local_time);
        joint_data = view.findViewById(R.id.my_join_data);


        my_page_set.setOnClickListener(this);
        my_name_btn.setOnClickListener(this);
//        my_online_state.setOnClickListener(this);
//        my_dream_btn.setOnClickListener(this);
//        my_major_btn.setOnClickListener(this);
//        my_learn_btn.setOnClickListener(this);
//        my_habit_btn.setOnClickListener(this);
//        my_age_sex_btn.setOnClickListener(this);
//        my_school_local_btn.setOnClickListener(this);
//        my_school_btn.setOnClickListener(this);





        Toolbar toolbar =  view.findViewById(R.id.toolbar_me);
       // ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout =  view.findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(" ");
        Glide.with(this)
                .load(Constant.url2)
                .error(R.mipmap.pic1)
                .into(myPic);
        AppBarLayout appBarLayout =  view.findViewById(R.id.app_bar);
        XStatusBarHelper.forceFitsSystemWindows(getActivity());
        XStatusBarHelper.immersiveStatusBar(getActivity());
        XStatusBarHelper.setPadding(getContext(), appBarLayout);

        FloatingActionButton fab =  view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "打开相机", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                Intent intent = new Intent(ScrollingActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });

        return view;
    }

//    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
   public void onClick(View v) {
//        //通过布局填充器获login_layout
//        View view = getLayoutInflater().inflate(R.layout.activity_my_major_amend, null);
//        final EditText et_username = view.findViewById(R.id.et_username);
//        final EditText et_password = view.findViewById(R.id.et_password);
        switch (v.getId()) {
//            case R.id.my_page_set:
//                Toast.makeText(getContext(), "photo", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.my_name_btn:
//                AlertDialog.Builder builder0 = new AlertDialog.Builder(getActivity());
//                builder0.setTitle("昵称");
//                //获取两个文本编辑框（
//                et_username.setHint("Dreamy");
//                et_password.setVisibility(INVISIBLE);
//                builder0.setView(view);//设置login_layout为对话提示框
//                builder0.setCancelable(false);//设置为不可取消
//                //设置正面按钮，并做事件处理
//                builder0.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String name = et_username.getText().toString().trim();
//                        if (!name.equals("") && name.length() < 12) {
//                            //  my_name.setText(changeNameEditText.getText().toString());
//                            Toast.makeText(getActivity(), "更改成功", Toast.LENGTH_SHORT).show();
//                        } else if (name.equals("")) {
//                            Toast.makeText(getActivity(), "专业或者英文名不能为空", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                //设置反面按钮，并做事件处理
//                builder0.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        // Toast.makeText(getContext(), "取消登录", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder0.show();//显示Dialog对话框
////                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
////                editor.putString("name",changeNameEditText.getText().toString());
////                editor.apply();
//                break;
//            case R.id.my_online_state:
//                Toast.makeText(getContext(), "photo", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.my_information_btn:
                Intent myDreamAmendActivity = new Intent(getContext(), MyDreamAmendActivity.class);
                startActivity(myDreamAmendActivity);
//                //Toast.makeText(getContext(),"photo",Toast.LENGTH_SHORT).show();
                break;
//            case R.id.my_major_btn:
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setTitle("专业");
//                //获取两个文本编辑框（
//
//                builder.setView(view);//设置login_layout为对话提示框
//                builder.setCancelable(false);//设置为不可取消
//                //设置正面按钮，并做事件处理
//                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String name = et_username.getText().toString().trim();
//                        String pass = et_password.getText().toString().trim();
//                        if (!name.equals("") && !pass.equals("")) {
//                          //  my_name.setText(changeNameEditText.getText().toString());
//                            Toast.makeText(getActivity(), "更改成功", Toast.LENGTH_SHORT).show();
//                        } else if (name.equals("") && pass.equals("")) {
//                            Toast.makeText(getActivity(), "专业或者英文名不能为空", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                //设置反面按钮，并做事件处理
//                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                       // Toast.makeText(getContext(), "取消登录", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.show();//显示Dialog对话框
//                //Toast.makeText(getContext(),"photo",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.my_learn_btn:
//                et_username.setHint("学习");
//                et_password.setHint("英文名");
//                AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
//                builder2.setTitle("学习");
//                //通过布局填充器获login_layout
//
//                //获取两个文本编辑框（密码这里不做登陆实现，仅演示）
//                final EditText et_username2 = view.findViewById(R.id.et_username);
//                final EditText et_password2 = view.findViewById(R.id.et_password);
//                builder2.setView(view);//设置login_layout为对话提示框
//                builder2.setCancelable(false);//设置为不可取消
//                //设置正面按钮，并做事件处理
//                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String name = et_username2.getText().toString().trim();
//                        String pass = et_password2.getText().toString().trim();
//                        if (!name.equals("") && !pass.equals("")) {
//                            //  my_name.setText(changeNameEditText.getText().toString());
//                            Toast.makeText(getActivity(), "更改成功", Toast.LENGTH_SHORT).show();
//                        } else if (name.equals("") && pass.equals("")) {
//                            Toast.makeText(getActivity(), "学习或者英文名不能为空", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                //设置反面按钮，并做事件处理
//                builder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        // Toast.makeText(getContext(), "取消登录", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder2.show();//显示Dialog对话框
//                //Toast.makeText(getContext(), "photo", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.my_habit_btn:
//                final EditText et_habitan3 = view.findViewById(R.id.et_habitat3);
//                final EditText et_habitan4 = view.findViewById(R.id.et_habitat4);
//                //Toast.makeText(getContext(), "photo", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.my_sex_age_btn:
//                Toast.makeText(getContext(), "photo", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.my_school_local_btn:
//                Toast.makeText(getContext(), "photo", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.my_school_btn:
//                Toast.makeText(getContext(), "photo", Toast.LENGTH_SHORT).show();
//                break;
        }
    }




}
