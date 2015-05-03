package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

import githubtest.qianfeng.com.ecookrooms.R;


/**
 * Created by Administrator on 2015/5/1.
 */
public class Vp_Fragment_header extends Fragment {

    private static int pt;
    private static List<String> list;
    private ImageView imgv;
    private List<ImageView> list_imgv = new ArrayList<>();
    private View view;

    public static Vp_Fragment_header getInstance(int position, List<String> stringList) {
        Vp_Fragment_header ret = new Vp_Fragment_header();
        pt = position;
        list = stringList;


        return ret;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.vp_main_header, null);
        imgv = (ImageView) view.findViewById(R.id.vp_main_header_image1);
        ImageView imgv_2 = (ImageView) view.findViewById(R.id.vp_main_header_image2_1);
        ImageView imgv_3 = (ImageView) view.findViewById(R.id.vp_main_header_image2_2);
        ImageView imgv_4 = (ImageView) view.findViewById(R.id.vp_main_header_image2_3);
        ImageView imgv_5 = (ImageView) view.findViewById(R.id.vp_main_header_image2_4);
        ImageView imgv_6 = (ImageView) view.findViewById(R.id.vp_main_header_image2_5);
        list_imgv.add(imgv_2);
        list_imgv.add(imgv_3);
        list_imgv.add(imgv_4);
        list_imgv.add(imgv_5);
        list_imgv.add(imgv_6);
        new BitmapUtils(getActivity()).display(imgv, list.get(pt));

        list_imgv.get(pt).setImageResource(R.drawable.counter);


        return view;
    }


}
