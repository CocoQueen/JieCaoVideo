package com.example.coco.jiecaovideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {

    private JZVideoPlayerStandard mJc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJc = findViewById(R.id.videoplayer);//查找id
//       setUp方法，设置控件播放时所需的参数，第一个参数表示播放的地址
//        第二个参数表示控件使用的位置，分别是普通、列表、全屏、小窗
//      第三个参数是关于视频的一些基本信息，默认为标题
        mJc.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
//进入后直接全屏播放视频
//        mJc.startFullscreen(this,自定义的继承JCVideoPlayer的类, "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", "嫂子辛苦了");

        //picasso为视频设置缩略图
        Picasso.with(this)
                .load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png")
                .into(mJc.thumbImageView);

    }

    @Override
    public void onBackPressed() {
//        如果全屏会退出全屏播放,否则的话交给父类
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //释放所有的视频资源
        mJc.releaseAllVideos();
    }
}
