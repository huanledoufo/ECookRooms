package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.Timer;
import java.util.TimerTask;

import githubtest.qianfeng.com.ecookrooms.MainActivity;
import githubtest.qianfeng.com.ecookrooms.R;


public class StartActivity extends ActionBarActivity {
    @ViewInject(R.id.image_start)
    private ImageView image_start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ViewUtils.inject(this);
        new BitmapUtils(this).display(image_start, "http://pic.ecook.cn/web/8585893.jpg");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task, 3000);

    }


}
