package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.List;

import Bean.RecommendUris;
import githubtest.qianfeng.com.ecookrooms.R;

/**
 * Created by Administrator on 2015/5/2.
 */
public class List_BaseAdapter extends BaseAdapter {

    private  List<RecommendUris> rlist;
    private  Context context;

    public List_BaseAdapter(List<RecommendUris> list, Context mcontext) {
        rlist = list;
       context = mcontext;

    }

    @Override
    public int getCount() {
        return rlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LinearLayout.inflate(context, R.layout.firstpage_list, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.firstpage_list_image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.firstpage_list_textview_nickname);
            viewHolder.title = (TextView) convertView.findViewById(R.id.firstpage_list_textview_content);
            viewHolder.time = (TextView) convertView.findViewById(R.id.firstpage_list_textview_time);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
//        new BitmapUtils(context).display(viewHolder.imageView, rlist.get(position).getUri());
        viewHolder.time.setText(rlist.get(position).getDisplaytime());
        viewHolder.title.setText(rlist.get(position).getTitle());
        viewHolder.name.setText(rlist.get(position).getAuthor());


        return convertView;
    }


    public class ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView name;
        private TextView time;
    }
}
