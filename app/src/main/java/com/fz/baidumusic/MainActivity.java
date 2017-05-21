package com.fz.baidumusic;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fz.baidumusic.frgament.LibMusicFra;
import com.fz.baidumusic.frgament.MyMusicFra;

public class MainActivity extends Activity implements View.OnClickListener {
    //Title
    private TextView tvMusicLib, tvMyMusic;
    //头部

    //底部播放Bar
    private ImageView imgHead;
    private TextView tvMusicName, tvLrc;
    private TextView tvStartPause, tvNext;

    //fra
    private MyMusicFra mMyMusicFra;
    private LibMusicFra mLibMusicFra;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private My my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        event();
        setDefaultFra();

    }

    private void setDefaultFra() {
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        mMyMusicFra = new MyMusicFra();
        transaction.replace(R.id.ll_body, mMyMusicFra);
        transaction.commit();
    }

    private void event() {
        tvMusicLib.setOnClickListener(this);
        tvMyMusic.setOnClickListener(this);
        tvMusicName.setOnClickListener(this);
        tvLrc.setOnClickListener(this);
        tvStartPause.setOnClickListener(this);
        tvNext.setOnClickListener(this);
    }

    private void initView() {
        tvMusicLib = (TextView) findViewById(R.id.tv_title_music_library);
        tvMyMusic = (TextView) findViewById(R.id.tv_title_my_music);
        imgHead = (ImageView) findViewById(R.id.img_play_head);
        tvMusicName = (TextView) findViewById(R.id.tv_music_name);
        tvLrc = (TextView) findViewById(R.id.tv_music_lrc);
        tvStartPause = (TextView) findViewById(R.id.tv_start_pause);
        tvNext = (TextView) findViewById(R.id.tv_next);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.tv_title_my_music:
                if (mMyMusicFra == null) {
                    mMyMusicFra = new MyMusicFra();
                }
                transaction.replace(R.id.ll_body, mMyMusicFra);
                break;
            case R.id.tv_title_music_library:
                if (mLibMusicFra == null) {
                    mLibMusicFra = new LibMusicFra();
                }
                transaction.replace(R.id.ll_body, mLibMusicFra);
                break;
        }
        transaction.commit();
    }

    private class My extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
        }
    }
}
