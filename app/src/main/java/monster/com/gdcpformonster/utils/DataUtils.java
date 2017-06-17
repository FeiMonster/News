package monster.com.gdcpformonster.utils;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.net.MalformedURLException;
import java.net.URL;

import monster.com.gdcpformonster.bean.NewsBean;
import okhttp3.Call;

/**
 * Created by ASUS on 2017/5/13.
 */

public class DataUtils {

    private NewsBean bean;

    public void getResult(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String data = "type=top&key=78d717837ab14d176271e9c2dbcfe7bf";
                try {
                    URL strurl = new URL("http://v.juhe.cn/toutiao/index?" + data);
                    OkHttpUtils.get().url(String.valueOf(strurl)).build().execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e) {
                            //返回数据失败
                        }

                        @Override
                        public void onResponse(Call call, String s) {
                                    //返回数据成功
                            Gson gson = new Gson();
                            bean = new NewsBean();
                            bean = gson.fromJson(s,NewsBean.class);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }){

        }.start();
    }
}
