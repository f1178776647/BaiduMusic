package com.fz.baidumusic.frgament;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fz.baidumusic.R;
import com.fz.baidumusic.adapter.LibMusicAdapter;
import com.fz.baidumusic.bean.Music;
import com.fz.baidumusic.bean.MusicTop;
import com.fz.baidumusic.netUtils.MyApplication;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/22.
 */

public class LibMusicFra extends Fragment implements View.OnClickListener{
    private LibMusicAdapter adapter;
    private ListView lvLib;
    private List<MusicTop.SongListBean> musics;
    private TextView tvTop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lib_music_activity, container, false);
        initView(view);
        return view;
    }

    private void initDatas() {
        String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&" +
                "from=webapp_music&method=baidu.ting.billboard.billList&type=1&size=10&offset=20";
        StringRequest request = new StringRequest(Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                MusicTop musicTop = gson.fromJson(s, MusicTop.class);
                musics = musicTop.getSong_list();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        request.setTag("LibFra");
        MyApplication.getHttpQueues().add(request);
    }

    private void initView(View view) {
        tvTop= (TextView) view.findViewById(R.id.tv_head_ranking);
        tvTop.setOnClickListener(this);
        musics = new ArrayList<>();
        lvLib = (ListView) view.findViewById(R.id.lv_lib_music);
        adapter = new LibMusicAdapter(getActivity(), musics);
        lvLib.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_head_ranking:
                initDatas();
                adapter.updateData(musics);
                break;
        }
    }

    class My implements MediaPlayer.OnPreparedListener {
        MediaPlayer mediaPlayer;

        public My() {
            mediaPlayer = new MediaPlayer();
        }

        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
        }
    }
}
