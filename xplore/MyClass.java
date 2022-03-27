package xplore;

import java.util.Arrays;
import java.util.Scanner;

public class MyClass {
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

        Integer res[]=new Integer[0];
        for(int i=0;i<medicine.length;i++){
            if((medicine[i].getD()).equalsIgnoreCase(disease)){

                //Arrays.copyOf(res,res.length+1) used for dynamic array
                res=Arrays.copyOf(res,res.length+1);
                res[res.length-1]=medicine[i].getP();
            }
        }

        Arrays.sort(res);
        return res;
    }
}



