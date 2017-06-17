package monster.com.gdcpformonster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.net.MalformedURLException;
import java.net.URL;

import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.bean.Bean;
import okhttp3.Call;

/**
 * Created by ASUS on 2017/5/9.
 */

public class HomeFragment extends Fragment{
    private EditText edt_xingzuo,edt_time;
    private TextView tv_date,tv_xingzuo,tv_all,tv_detail;
    private Button find;
    private View mView;
    private String KEY = "3ee5e9a3cc165bdcf2d0f95861bbb8f6";
    private String data;
    String datetime,all,summary,name;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //引入我们的布局
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestData();
                Log.d("TAG","我被点击了");
            }
        });
        return mView;
    }

    private void initViews() {
        edt_xingzuo = (EditText) mView.findViewById(R.id.edt_xingzuo);
        edt_time = (EditText) mView.findViewById(R.id.edt_time);
        tv_date = (TextView) mView.findViewById(R.id.tv_date);
        tv_xingzuo = (TextView) mView.findViewById(R.id.tv_xingzuo);
        tv_all = (TextView) mView.findViewById(R.id.tv_all);
        tv_detail = (TextView) mView.findViewById(R.id.tv_detail);
        find = (Button) mView.findViewById(R.id.bt_find);

    }


    private void RequestData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    data = "consName=" +edt_xingzuo.getText() + "&type=" + edt_time.getText() +"&key=" + KEY;
                    URL strurl = new URL("http://web.juhe.cn:8080/constellation/getAll?" + data);
                    OkHttpUtils.get().url(String.valueOf(strurl)).build().execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e) {
                            //请求数据失败
                        }

                        @Override
                        public void onResponse(Call call, String response) {
                                //请求数据成功
                            Gson gson = new Gson();
                            Bean bean = new Bean();
                            bean  = gson.fromJson(response,Bean.class);
                            datetime = bean.getDatetime();
                            all = bean.getAll();
                            summary = bean.getSummary();
                             name = bean.getName();

                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }){

        }.start();
        tv_xingzuo.setText("星座："+name);
        tv_date.setText("时间："+datetime);
        tv_all.setText("幸运指数："+all);
        tv_detail.setText("具体分析："+summary);
    }
}
