package monster.com.gdcpformonster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import monster.com.gdcpformonster.R;

/**
 * Created by ASUS on 2017/5/18.
 */
public class WoAcitvity extends AppCompatActivity {
    private ImageView iv_home;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo);
        initViews();
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WoAcitvity.this,MainActivity.class));
                finish();
            }
        });

    }



    private void initViews() {
        iv_home = (ImageView) findViewById(R.id.ivb_home);
    }
}
