package com.example.edoardo.labyrinth;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.edoardo.labyrinth.Room;
import com.example.edoardo.labyrinth.Victory;

public class MainActivity extends AppCompatActivity {

    Room f1;
    public Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.edoardo.labyrinth.R.layout.activity_main);

        // portrait mode
        if (findViewById(com.example.edoardo.labyrinth.R.id.fragment) != null) {

            f1 = new Room();
            Labyrinth.x=0;
            Labyrinth.y=0;

            i=new Intent(this,Victory.class);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(com.example.edoardo.labyrinth.R.id.fragment, f1);
            ft.commit();
        }
    }

    float x1,x2,y1,y2;
    final static float MIN_DISTANCE = 250.0f;
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2=event.getY();
                float deltaX = x2 - x1;
                float deltaY = y2 - y1;

                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    // Left to Right swipe action
                    if (x2 > x1 && Labyrinth.hasLeft()) goLeft();
                    // Right to left swipe action
                    if (x2 < x1 && Labyrinth.HasRight()) goRight();
                }
                if(Math.abs(deltaY) > MIN_DISTANCE) {
                    //Up to down swipe action
                    if (y2 < y1 && Labyrinth.hasDown()) goDown();
                    //Down to up swipe action
                    if (y2 > y1 && Labyrinth.hasUp()) goUp();
                }
                if(Labyrinth.checkVictory()) startActivity(i);
                break;
        }
        return super.onTouchEvent(event);
    }

    public void goRight(){
        if(Labyrinth.x==2&& Labyrinth.y==2) {
            startActivity(i);
        }
        else{
            FragmentManager fm = getFragmentManager();
            Room nextFragment;
            Labyrinth.right();
            nextFragment = new Room();
            FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(com.example.edoardo.labyrinth.R.animator.slide_in_left, com.example.edoardo.labyrinth.R.animator.fade);
            ft.replace(com.example.edoardo.labyrinth.R.id.fragment, nextFragment);
            ft.commit();
        }
    }

    public void goLeft(){
        FragmentManager fm = getFragmentManager();
        Room nextFragment;
        Labyrinth.left();
        nextFragment = new Room();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(com.example.edoardo.labyrinth.R.animator.slide_in_right, com.example.edoardo.labyrinth.R.animator.fade);
        ft.replace(com.example.edoardo.labyrinth.R.id.fragment, nextFragment);
        ft.commit();
    }

    public void goDown(){
        FragmentManager fm = getFragmentManager();
        Room nextFragment;
        Labyrinth.down();
        nextFragment = new Room();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(com.example.edoardo.labyrinth.R.animator.slide_top, com.example.edoardo.labyrinth.R.animator.fade);
        ft.replace(com.example.edoardo.labyrinth.R.id.fragment, nextFragment);
        ft.commit();
    }

    public void goUp(){
        FragmentManager fm = getFragmentManager();
        Room nextFragment;
        Labyrinth.up();
        nextFragment = new Room();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(com.example.edoardo.labyrinth.R.animator.slide_down, com.example.edoardo.labyrinth.R.animator.fade);
        ft.replace(com.example.edoardo.labyrinth.R.id.fragment, nextFragment);
        ft.commit();
    }
}
