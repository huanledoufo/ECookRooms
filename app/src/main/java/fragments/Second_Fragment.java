package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import activity.Shake2;
import githubtest.qianfeng.com.ecookrooms.R;

/**
 * Created by Administrator on 2015/4/30.
 */
public class Second_Fragment extends Fragment{
    private ImageView caipu_image4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_caipu, null);
        caipu_image4 = (ImageView) view.findViewById(R.id.Caipu_image4);
        caipu_image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Shake2.class);
                startActivity(intent);

            }
        });




        return view;
    }
}
