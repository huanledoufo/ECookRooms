package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2015/4/30.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private static List<Fragment> list;
    public static MyPagerAdapter getInstance(FragmentManager fragmentManager, List<Fragment> mlist) {
        MyPagerAdapter ret = new MyPagerAdapter(fragmentManager);
        list = mlist;
        return ret;
    }

    public MyPagerAdapter(FragmentManager fm) {


        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
