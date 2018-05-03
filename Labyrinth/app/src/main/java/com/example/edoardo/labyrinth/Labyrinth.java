package com.example.edoardo.labyrinth;

public class Labyrinth {
    public static int x,y;

    public static void right(){
        if(HasRight()){
            y++;
        }
    }

    public static void left(){
        if(hasLeft()){
            y--;
        }
    }

    public static void down(){
        if(hasDown()){
            x++;
        }
    }

    public static void up(){
        if(hasUp()){
            x--;
        }
    }

    public static boolean HasRight(){
        if((y+1<=2)||(Labyrinth.x==2&& Labyrinth.y==2)) return true;
        else return false;
    }

    public static boolean hasLeft(){
        if(y-1>=0) return true;
        else return false;
    }

    public static boolean hasDown(){
        if(x+1<=2) return true;
        else return false;
    }

    public static boolean hasUp(){
        if(x-1>=0) return true;
        else return false;
    }

    public static boolean checkVictory(){
        if (x==2 && y==3) return true;
        else return false;
    }

}
