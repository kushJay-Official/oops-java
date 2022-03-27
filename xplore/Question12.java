package xplore;
import java.util.*;
import java.io.*;

public class Question12
{

    public static void main(String[] args)throws Exception
    {
        // code to read values

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int objcount=Integer.parseInt(br.readLine());

        Bill[] bills=new Bill[objcount];

        for(int i=0;i<bills.length;i++){

            bills[i]=new Bill(
                    Integer.parseInt(br.readLine()),
                    br.readLine(),
                    br.readLine(),
                    Double.parseDouble(br.readLine()),
                    Boolean.parseBoolean(br.readLine())
            );

        }

        // code to call required method
        Bill res[]= findBillWithMaxBillAmountBasedOnStatus(bills,
                Boolean.parseBoolean(br.readLine()));

        int rescount=getCountWithTypeOfConnection(bills,
                br.readLine());

        if(res.length!=0)
            System.out.println(res[(res.length-1)].getBillNo()+"#"+res[(res.length-1)].getName());
        else
            System.out.println("There are no bill with the given status");


        // code to display the result

        if(rescount!=0)
            System.out.println(rescount);
        else
            System.out.println("There are no bills with given type of connection");

    }

    //code the first method
    static Bill[] findBillWithMaxBillAmountBasedOnStatus(Bill[] b, boolean s){

        Bill[] res= new Bill[0];

        for(int i=0;i<b.length;i++){

            if(b[i].getStatus()==s){
                res=Arrays.copyOf(res,res.length+1);
                res[res.length-1]=b[i];
            }
        }

        //for sorting

        for(int i=0;i<res.length-1;i++){
            for(int j=0;j<res.length-i-1;j++){
                if(res[j].getBillAmount()>res[j+1].getBillAmount()){
                    Bill temp= res[j];
                    res[j]=res[j+1];
                    res[j+1]=temp;
                }
            }
        }
        return res;
    }

    //code the second method

    static int getCountWithTypeOfConnection(Bill[] b, String t){
        int count=0;
        for(int i=0;i<b.length;i++){
            if(b[i].getTypeOfConnection().equalsIgnoreCase(t))
                count++;

        }
        return count;
    }

}

//code the class

class Bill{
    private int billNo;
    private String name, typeOfConnection;
    private double billAmount;
    private boolean status;

    public Bill(int b, String n, String toc, double ba, boolean s){

        this.billNo=b;
        this.name=n;
        this.typeOfConnection=toc;
        this.billAmount=ba;
        this.status=s;

    }

    public int getBillNo(){return billNo;}
    public String getName(){return name;}
    public String getTypeOfConnection(){return typeOfConnection;}
    public boolean getStatus(){return status;}
    public double getBillAmount(){return billAmount;}

}
