package xplore;
import java.io.*;
import java.util.*;

public class Question10 {
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Inventory[] inventories= new Inventory[4];

        for(int i=0;i<inventories.length;i++){
            inventories[i]=new Inventory(
                    br.readLine(),
                    Integer.parseInt(br.readLine()),
                    Integer.parseInt(br.readLine()),
                    Integer.parseInt(br.readLine())
            );

        }

        Inventory[] temIn=replenish(inventories,
                Integer.parseInt(br.readLine())
                );

        for(int i=0;i<temIn.length;i++){
            if(temIn[i].getThreshold()>=75)
                System.out.println(temIn[i].getInventoryId()+" Critical Filling");
            if(temIn[i].getThreshold()<=74 && temIn[i].getThreshold()>=50)
                System.out.println(temIn[i].getInventoryId()+" Moderate Filling");
            if(temIn[i].getThreshold()<50)
                System.out.println(temIn[i].getInventoryId()+" Non-Critical Filling");
        }

    }

    public static Inventory[] replenish(Inventory[] in, int limit){
        Inventory[] resIn=new Inventory[0];

        for(int i=0;i<in.length;i++){
            if(in[i].getThreshold()<=limit){
                resIn=Arrays.copyOf(resIn, resIn.length+1);
                resIn[resIn.length-1]=in[i];
            }
        }

        return resIn;
    }
}


class Inventory{
    protected String inventoryId;
    protected int maximumQuantity, currentQuantity, threshold;

    public Inventory(String id, int mq,int cq, int th){
        this.inventoryId=id;
        this.maximumQuantity=mq;
        this.currentQuantity=cq;
        this.threshold=th;
    }

    public String getInventoryId(){return inventoryId;}
    public int getThreshold(){return threshold;}
}