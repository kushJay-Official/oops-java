package xplore;

import java.io.*;
import java.util.*;



public class Question8 {
    public static void main(String[] args)throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Player1[] player =new Player1[4];

        for(int i=0;i<player.length;i++){
            player[i]=new Player1(
                    Integer.parseInt(br.readLine()),
                    br.readLine(),
                    br.readLine(),
                    Integer.parseInt(br.readLine())
            );

        }

        Player1[] res=searchPlayerForMatch(player,
                br.readLine()
                );

        int[] resId=new int[res.length];
        for(int i=0;i<res.length;i++)
            resId[i]=res[i].getId();

        Arrays.sort(resId);

        for(int i=0;i< resId.length;i++)
            System.out.println(resId[i]);

    }

    public static Player1[] searchPlayerForMatch(Player1[] play, String target){
        Player1[] resPlayer=new Player1[0];

        for(int i=0;i<play.length;i++){

            if(play[i].getSide().equalsIgnoreCase(target)){
                resPlayer=Arrays.copyOf(resPlayer, resPlayer.length+1);
                resPlayer[resPlayer.length-1]=play[i];
            }

        }

        return resPlayer;
    }
}


class Player1{

    protected int id;
    protected String country, side;
    protected double price;

    Player1(int id, String cn, String s, double p){
        this.id=id;
        this.country=cn;
        this.side=s;
        this.price=p;
    }
    public int getId(){return id;}
    public String getSide(){return side;}

}