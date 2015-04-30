package githubtest.qianfeng.com.ecookrooms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyPagerAdapter;
import Adapter.SecondDrawerAdapter;
import Bean.DrawerBean;
import fragments.First_Fragment;
import fragments.Second_Fragment;
import fragments.Third_Fragment;


public class MainActivity extends ActionBarActivity {
    @ViewInject(R.id.vp_main)
    private ViewPager vp_main;


    @ViewInject(R.id.drawerLayout_list_1)
    private ListView drawerLayout_list_1;


    @ViewInject(R.id.drawerLayout)
    private DrawerLayout drawerLayout;

    //用于抽屉布局第二个listview
    private List<DrawerBean> secondDraerBeanList;
    private List<Fragment> fragment_list = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com.lidroid.xutils.ViewUtils.inject(this);


        //初始化
        init();

        drawerLayout_list_1.setAdapter(new SecondDrawerAdapter(this, secondDraerBeanList));
        drawerLayout.setDrawerListener(new MyDrawerListener());


        vp_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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


        vp_main.setAdapter(MyPagerAdapter.getInstance(getSupportFragmentManager(), fragment_list));

    }


    /**
     * 初始化
     */
    private void init() {
        secondDraerBeanList = new ArrayList<DrawerBean>();
        secondDraerBeanList.add(new DrawerBean(R.mipmap.mine_login, "登陆", R.mipmap.more_arrow_account));
        secondDraerBeanList.add(new DrawerBean(R.mipmap.mine_personalinfo, "注册", R.mipmap.more_arrow_account));
        secondDraerBeanList.add(new DrawerBean(R.mipmap.mine_favorites, "收藏夹", R.mipmap.more_arrow_account));
        secondDraerBeanList.add(new DrawerBean(R.mipmap.mine_tasty, "小厨说", R.mipmap.more_arrow_account));
        secondDraerBeanList.add(new DrawerBean(R.mipmap.mine_shoppinglist, "购物清单", R.mipmap.more_arrow_account));
        secondDraerBeanList.add(new DrawerBean(R.mipmap.mine_findfriend, "找朋友", R.mipmap.more_arrow_account));
        secondDraerBeanList.add(new DrawerBean(R.mipmap.mine_aboutus, "关于我们", R.mipmap.more_arrow_account));

        First_Fragment first_fragment = new First_Fragment();
        Second_Fragment second_fragment = new Second_Fragment();
        Third_Fragment third_fragment = new Third_Fragment();
        fragment_list.add(first_fragment);
        fragment_list.add(second_fragment);
        fragment_list.add(third_fragment);

//        getActionBar().setTitle("网上厨房");
//        getActionBar().setIcon(R.drawable.userimage);


    }

    /**
     * DrawerLayout的监听
     */

    class MyDrawerListener implements DrawerLayout.DrawerListener {

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {


        }

        @Override
        public void onDrawerOpened(View drawerView) {


        }

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
}
