package com.example.coco.jiecaovideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {

    private JZVideoPlayerStandard mJc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJc = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        mJc.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
//        mJc.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        Picasso.with(this)
                .load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png")
                .into(mJc.thumbImageView);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mJc.releaseAllVideos();
    }
}
