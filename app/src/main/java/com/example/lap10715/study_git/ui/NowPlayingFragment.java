package com.example.lap10715.study_git.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lap10715.study_git.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;
import javax.inject.Named;

import static java.security.AccessController.getContext;

/**
 * Created by nahuy on 7/7/18.
 */

public class NowPlayingFragment {
    @Inject
    MyAdapter myAdapter;
    @Inject
    @Named(value = "now_playing")
    MovieLoader nowPlayingLoader;

    public NowPlayingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_now_playing);

        FragmentComponent fragmentComponent = DaggerFragmentComponent
                .builder()
                .fragmentModule(new FragmentModule(getContext(),recyclerView ))
                .build();

        fragmentComponent.inject(this);

        recyclerView.setAdapter(myAdapter);
        myAdapter.loadData(nowPlayingLoader);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true)
    public void sendMessage(Integer type){
        if(type == 0){
            MessageEvent event = new MessageEvent("Tab Now Playing is selected!");
            EventBus.getDefault().post(event);
        }
    }
}
