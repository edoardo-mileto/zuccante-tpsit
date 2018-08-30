package com.example.andreadattero.tris;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;

public class Tris{

    protected int[][] matricePosizoni;

    private Match match;

    Tris(Match match){
        this.match = match;
        matricePosizoni= new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
    }

    public void clickPlayer(View view){
        switch (view.getId()) {
            case R.id.button0: matricePosizoni[0][0] = 1; break;
            case R.id.button1: matricePosizoni[0][1] = 1; break;
            case R.id.button2: matricePosizoni[0][2] = 1; break;
            case R.id.button3: matricePosizoni[1][0] = 1; break;
            case R.id.button4: matricePosizoni[1][1] = 1; break;
            case R.id.button5: matricePosizoni[1][2] = 1; break;
            case R.id.button6: matricePosizoni[2][0] = 1; break;
            case R.id.button7: matricePosizoni[2][1] = 1; break;
            case R.id.button8: matricePosizoni[2][2] = 1; break;
        }
        if(!match.vittoria)
            computerStrikes();
    }

    public void clickComputer(int i, int j){
        ImageButton bottone;
        Activity activity=match;
        if(i==0 && j==0){
            bottone=activity.findViewById(R.id.button0);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
        else if(i==0 && j==1){
            bottone=activity.findViewById(R.id.button1);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
        else if(i==0 && j==2){
            bottone=activity.findViewById(R.id.button2);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
        else if(i==1 && j==0){
            bottone=activity.findViewById(R.id.button3);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
        else if(i==1 && j==1){
            bottone=activity.findViewById(R.id.button4);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
        else if(i==1 && j==2){
            bottone=activity.findViewById(R.id.button5);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
        else if(i==2 && j==0){
            bottone=activity.findViewById(R.id.button6);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
        else if(i==2 && j==1){
            bottone=activity.findViewById(R.id.button7);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
        else if(i==2 && j==2){
            bottone=activity.findViewById(R.id.button8);
            bottone.setEnabled(false);
            bottone.setImageResource(R.drawable.x);
        }
    }

    public void checkPlayerVictory(Intent i) {
        if(matricePosizoni[0][0]==1 &&matricePosizoni[1][1]==1 &&matricePosizoni[2][2]==1){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You WON!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[2][0]==1 &&matricePosizoni[1][1]==1 &&matricePosizoni[0][2]==1){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You WON!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[0][1]==1 &&matricePosizoni[1][1]==1 &&matricePosizoni[2][1]==1){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You WON!");
                }
            });
            i.putExtra("vittoria",true);
        }else if(matricePosizoni[1][0]==1 &&matricePosizoni[1][1]==1 &&matricePosizoni[1][2]==1){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You WON!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[0][2]==1 &&matricePosizoni[1][2]==1 && matricePosizoni[2][2]==1){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You WON!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[0][0]==1 &&matricePosizoni[1][0]==1&&matricePosizoni[2][0]==1){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You WON!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[0][0]==1 &&matricePosizoni[0][1]==1 &&matricePosizoni[0][2]==1){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You WON!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[2][0]==1 &&matricePosizoni[2][1]==1 &&matricePosizoni[2][2]==1){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You WON!");
                }
            });
            i.putExtra("vittoria",true);
        }else {
            i.putExtra("vittoria", false);
        }
    }

    public void checkComputerVictory(Intent i) {
        if(matricePosizoni[0][0]==-1 &&matricePosizoni[1][1]==-1  &&matricePosizoni[2][2]==-1 ){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You LOST!");
                }
            });
            i.putExtra("checkVictory",true);
        }
        else if(matricePosizoni[2][0]==-1  &&matricePosizoni[1][1]==-1  &&matricePosizoni[0][2]==-1 ){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You LOST!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[0][1]==-1  &&matricePosizoni[1][1]==-1  &&matricePosizoni[2][1]==-1 ){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You LOST!");
                }
            });
            i.putExtra("vittoria",true);
        }else if(matricePosizoni[1][0]==-1  &&matricePosizoni[1][1]==-1  &&matricePosizoni[1][2]==-1 ){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You LOST!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[0][2]==-1  &&matricePosizoni[1][2]==-1  && matricePosizoni[2][2]==-1 ){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You LOST!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[0][0]==-1  &&matricePosizoni[1][0]==-1 &&matricePosizoni[2][0]==-1 ){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You LOST!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[0][0]==-1  &&matricePosizoni[0][1]==-1  &&matricePosizoni[0][2]==-1 ){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You LOST!");
                }
            });
            i.putExtra("vittoria",true);
        }
        else if(matricePosizoni[2][0]==-1  &&matricePosizoni[2][1]==-1  &&matricePosizoni[2][2]==-1 ){
            match.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    match.vittoriaText.setText("You LOST!");
                }
            });
            i.putExtra("vittoria",true);
        }else{
            i.putExtra("vittoria",false);
        }

    }

    public void computerStrikes(){
        ArrayList<String> indici= new ArrayList();
        for(int i=0; i<matricePosizoni.length;i++){
            for(int j=0; j<matricePosizoni[i].length;j++){
                if(matricePosizoni[i][j]==0){
                    indici.add(i+""+j);
                }
            }
        }
        if(indici.size()>1) {
            String pos = indici.get(new Random().nextInt(indici.size()));
            int i = Integer.parseInt("" + pos.charAt(0));
            int j = Integer.parseInt("" + pos.charAt(1));
            System.out.println("i: " + i + " j: " + j);
            matricePosizoni[i][j] = -1;
            clickComputer(i, j);
            checkComputerVictory(new Intent(match, Match.class));
        }
        else{

        }
    }
}
