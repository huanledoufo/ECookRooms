package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.BitmapUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.List_BaseAdapter;
import Bean.RecommendUris;
import githubtest.qianfeng.com.ecookrooms.MainActivity;
import githubtest.qianfeng.com.ecookrooms.R;
import githubtest.qianfeng.com.ecookrooms.Web_Activity;

/**
 * Created by Administrator on 2015/4/30.
 */
public class First_Fragment extends Fragment {


    private ListView listView;
    private ImageView imageview1;
    private ImageView imageView3;
    private ImageView imageView2;
    private ImageView imageView4;
    private ViewPager vp_main_header;
    private List<Fragment> list;
    private List<HashMap<String, Object>> list_url = new ArrayList<HashMap<String, Object>>();
    private HashMap<String, Object> map = new HashMap<String, Object>();
    private String TAG = "First_Fragment----->";

    private List<String> listStr = new ArrayList<String>();
    private ArrayList<RecommendUris> rlist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, null);
        init(view);


        return view;
    }

    /**
     * 初始化方法
     *
     * @param view
     */

    private void init(View view) {


        listView = (ListView) view.findViewById(R.id.listview_main_fragment);
        imageview1 = (ImageView) view.findViewById(R.id.imageView_first_fragment_1);
        imageView2 = (ImageView) view.findViewById(R.id.imageView_first_fragment_2);
        imageView3 = (ImageView) view.findViewById(R.id.imageView_first_fragment_3);
        imageView4 = (ImageView) view.findViewById(R.id.imageView_first_fragment_4);
        new BitmapUtils(getActivity()).display(imageview1,"http://pic.ecook.cn/web/438883.jpg!m3");
        new BitmapUtils(getActivity()).display(imageView2,"http://pic.ecook.cn/web/2746704.jpg!m3");
        new BitmapUtils(getActivity()).display(imageView3,"http://pic.ecook.cn/web/659576.jpg!m3");
        new BitmapUtils(getActivity()).display(imageView4,"http://pic.ecook.cn/web/443495.jpg!m3");




        vp_main_header = (ViewPager) view.findViewById(R.id.vp_main_header);
        list = new ArrayList<Fragment>();

        listStr.add("http://pic.ecook.cn/web/5903768.jpg!m3");
        listStr.add("http://pic.ecook.cn/web/2835952.jpg!m3");
        listStr.add("http://pic.ecook.cn/web/5053863.jpg!m3");
        listStr.add("http://pic.ecook.cn/web/6425658.jpg!m3");
        listStr.add("http://pic.ecook.cn/web/8807043.jpg!m3");

        vp_main_header.setAdapter(new MyAdapter(getFragmentManager()));


        vp_main_header.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, "http://www.ecook.cn/public/getHomePageNew.shtml", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray arr = jsonObject.getJSONArray("recommendUris");
                    rlist = new ArrayList<>();
                    for (int i = 0; i < arr.length(); i++) {
                        RecommendUris recommendUris = new RecommendUris();
                        recommendUris.setTitle(arr.getJSONObject(i).getString("title"));
                        recommendUris.setAuthor(arr.getJSONObject(i).getString("author"));
                        recommendUris.setUri(arr.getJSONObject(i).getString("uri"));
                        recommendUris.setDisplaytime(arr.getJSONObject(i).getString("displaytime"));
                        rlist.add(recommendUris);
                    }
                    listView.setAdapter(new List_BaseAdapter(rlist, getActivity()));
                    Log.e(TAG, arr.length() + "");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                List<RecommendUris> listr = MyJsonParser.getRecommendUris(jsonObject.toString());
//                listView.setAdapter(new List_BaseAdapter(listr, getActivity()));






            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, "下载失败");
            }
        });
        requestQueue.add(jor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Web_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", rlist.get(position).getUri());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }





    /**
     * 头部的视图
     */
    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return Vp_Fragment_header.getInstance(position, listStr);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }


}