package com.example.edoardo.labyrinth;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Room extends Fragment {
    final int layouts[][]={
            {R.layout.right_bottom, R.layout.left_right_bottom, R.layout.left_bottom},
            {R.layout.right_bottom_top, R.layout.all, R.layout.left_bottom_top},
            {R.layout.right_top, R.layout.right_left_top, R.layout.right_left_top}
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(layouts[Labyrinth.x][Labyrinth.y], container, false);
    }
}