package xplore;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Medicine[] medicine = new Medicine[4];
        String search;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < medicine.length; i++) {
            String medicineName = sc.nextLine();
            String batchNo = sc.nextLine();
            String disease = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            medicine[i] = new Medicine(medicineName, batchNo, disease, price);

        }

        search = sc.nextLine();
        System.out.println("linne23 ............");
        Integer[] price = medicinePriceForGivenDisease(medicine, search);
        System.out.println("linne24 ............");

        for(int i=0;i<price.length;i++) {
            System.out.println(price[i]);
        }
    }
    public static Integer[] medicinePriceForGivenDisease(Medicine[] medicine,String disease)
    {
        //method logic
        //code to find price, sort and return the sorted array.

        List<Integer> res= new ArrayList<>();
        for(int i=0;i<medicine.length;i++){
            if((medicine[i].getD()).equals(disease))
                res.add(medicine[i].getP());
        }
        System.out.println("linne41............");
        int size= res.size();
        System.out.println("size of Arrayalist..........."+size);
       // Integer[] rs= new Integer[size];
        Object rs[]  =res.toArray();
        System.out.println("size of Arrayalist......rs......"+rs.length);
        for(Object i:rs) {
            System.out.println("for ...1"+i);
           // rs[i] = res.get(i);
            System.out.println("for ed..");
        }
        System.out.println("for end method .......");
        return (Integer[]) rs;
    }
}

class Medicine
{
    //code to build Medicine class
    private String medicineName;
    private String batchNo;
    private String disease;
    private int price;

    Medicine(String mn, String bn, String d, int p){
        this.medicineName=mn;
        this.batchNo=bn;
        this.disease=d;
        this.price=p;
    }

    public String getMed(){return medicineName;}
    public String getD(){return disease;}
    public int getP(){return price;}
}

