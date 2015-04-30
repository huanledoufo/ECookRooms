package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import Bean.DrawerBean;
import githubtest.qianfeng.com.ecookrooms.R;

/**
 * Created by Administrator on 2015/4/30.
 */
public class SecondDrawerAdapter extends BaseAdapter {


    private Context context;
    private List<DrawerBean> SecondDrawerBeanList;

    public SecondDrawerAdapter(Context context, List<DrawerBean> secondDrawerBeanList) {
        this.context = context;
        SecondDrawerBeanList = secondDrawerBeanList;
    }

    @Override
    public int getCount() {
        return SecondDrawerBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return SecondDrawerBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if( convertView == null)
        {
            holder = new ViewHolder();
            convertView = LinearLayout.inflate(context, R.layout.fragment_drawer_adapter, null);
            holder.imgv1_drawer_adapter = ((ImageView) convertView.findViewById(R.id.imgv1_drawer_adapter));
            holder.tv_drawer_adapter = ((TextView) convertView.findViewById(R.id.tv_drawer_adapter));
            holder.imgv2_drawer_adapter = ((ImageView) convertView.findViewById(R.id.imgv2_drawer_adapter));
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        DrawerBean drawerBean = SecondDrawerBeanList.get(position);
        holder.imgv1_drawer_adapter.setImageResource(drawerBean.getIv1());
        holder.tv_drawer_adapter.setText(drawerBean.getTv());
        holder.imgv2_drawer_adapter.setImageResource(drawerBean.getIv2());

        return convertView;
    }


    public class  ViewHolder
    {
        private ImageView imgv1_drawer_adapter;
        private TextView tv_drawer_adapter;
        private ImageView imgv2_drawer_adapter;
    }
}
