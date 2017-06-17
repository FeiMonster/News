package monster.com.gdcpformonster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import monster.com.gdcpformonster.R;

/**
 * Created by ASUS on 2017/5/18.
 */
public class RegisterActvity extends AppCompatActivity{
    private EditText register_id;
    private EditText register_password;
    private EditText register_confirm;
    private String registerId;
    private String registerPassword;
    private String registerConfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bmob.initialize(RegisterActvity.this,"0f2fe96dc3f5c82420412e415f973d21");
        initViews();
    }

    private void initViews() {
        register_id = (EditText) findViewById(R.id.register_id);
        register_password = (EditText) findViewById(R.id.register_password);
        register_confirm = (EditText) findViewById(R.id.register_confirm);
    }
    public void click(View view ){
        registerId = register_id.getText().toString().trim();
        registerPassword = register_password.getText().toString().trim();
        registerConfirm = register_confirm.getText().toString().trim();
        if(!registerPassword.equals(registerConfirm)){
            Toast.makeText(RegisterActvity.this,"两次密码不一致",Toast.LENGTH_LONG).show();
        }else {
            register();
        }
    }

    private void register() {
        if(registerId == null){
            Toast.makeText(RegisterActvity.this,"您输入的账号不能为空",Toast.LENGTH_LONG).show();
        }else {
            BmobUser mUser = new BmobUser();
            mUser.setPassword(registerPassword);
            mUser.setUsername(registerId);
            mUser.signUp(new SaveListener<BmobUser>() {
                @Override
                public void done(BmobUser bmobUser, BmobException e) {
                    if(e == null){
                        //注册成功，跳转到登录界面
                        Toast.makeText(RegisterActvity.this,"注册成功",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActvity.this,LoginActivity.class));
                        finish();
                    }else{
                        Toast.makeText(RegisterActvity.this,"注册失败",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
