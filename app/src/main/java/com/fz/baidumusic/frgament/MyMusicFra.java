package com.fz.baidumusic.frgament;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fz.baidumusic.R;

/**
 * Created by admin on 2017/4/22.
 */

public class MyMusicFra extends Fragment {
    private ListView lvLibMusic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_music_activity, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        lvLibMusic = (ListView) view.findViewById(R.id.lv_lib_music);
    }
}
