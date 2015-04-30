package githubtest.qianfeng.com.ecookrooms;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;

import Bean.DrawerBean;


public class MainActivity extends ActionBarActivity {

    //用于抽屉布局第一个listview
    private List<DrawerBean> FirstDrawerBeanList;
    //用于抽屉布局第二个listview
    private List<DrawerBean> SecondDraerBeanList;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



    }

    private void init() {
        FirstDrawerBeanList = new ArrayList<DrawerBean>();
        SecondDraerBeanList = new ArrayList<DrawerBean>();
        //第一个  用户 注册条目
        FirstDrawerBeanList.add(new DrawerBean(R.mipmap.mine_login,"登陆",R.mipmap.more_arrow_account));
        FirstDrawerBeanList.add(new DrawerBean(R.mipmap.mine_personalinfo,"注册",R.mipmap.more_arrow_account));
        //第二个   listview条目
        SecondDraerBeanList.add(new DrawerBean(R.mipmap.mine_favorites,"收藏夹",R.mipmap.more_arrow_account));
        SecondDraerBeanList.add(new DrawerBean(R.mipmap.mine_tasty,"小厨说",R.mipmap.more_arrow_account));
        SecondDraerBeanList.add(new DrawerBean(R.mipmap.mine_shoppinglist,"购物清单",R.mipmap.more_arrow_account));
        SecondDraerBeanList.add(new DrawerBean(R.mipmap.mine_findfriend,"找朋友",R.mipmap.more_arrow_account));
        SecondDraerBeanList.add(new DrawerBean(R.mipmap.mine_aboutus,"关于我们",R.mipmap.more_arrow_account));
    }

}
