package com.fz.baidumusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fz.baidumusic.R;
import com.fz.baidumusic.bean.MusicTop;

import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class LibMusicAdapter extends BaseAdapter {
    private Context context;
    private List<MusicTop.SongListBean> musics;

    public LibMusicAdapter(Context context, List<MusicTop.SongListBean> musics) {
        this.context = context;
        this.musics = musics;
    }

    @Override
    public int getCount() {
        return musics.size();
    }

    @Override
    public Object getItem(int i) {
        return musics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.my_music_lv_iem, null);
            viewHolder.tvMusicName = (TextView) view.findViewById(R.id.tv_lv_item_music_name);
            viewHolder.tvAuthor = (TextView) view.findViewById(R.id.tv_lv_item_author);
            viewHolder.tvAlbum = (TextView) view.findViewById(R.id.tv_lv_item_album);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvMusicName.setText(musics.get(i).getTitle());
        viewHolder.tvAuthor.setText(musics.get(i).getAuthor());
        viewHolder.tvAlbum.setText(musics.get(i).getAlbum_title());
        return view;
    }

    public void updateData(List<MusicTop.SongListBean> beanList) {
        musics = beanList;
        this.notifyDataSetChanged();
    }

    private class ViewHolder {
        TextView tvMusicName;
        TextView tvAuthor;
        TextView tvAlbum;
    }
}
