package monster.com.gdcpformonster.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.adapter.NewsAdapter;
import okhttp3.Call;


/**
 * Created by ASUS on 2017/5/10.
 */
public class ItemFragment extends Fragment {
    private RecyclerView recyclerView;
    private String key = "78d717837ab14d176271e9c2dbcfe7bf";


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //动态找到布局文件，再从这个布局中find出TextView对象
        View contextView = inflater.inflate(R.layout.fragment_item, container, false);
        TextView mTextView = (TextView) contextView.findViewById(R.id.textview);
        Bundle mBundle = getArguments();
        String title = mBundle.getString("arg");
        mTextView.setText(title);

        return contextView;
    }
}
