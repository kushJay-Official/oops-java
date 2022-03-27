package xplore;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class Question11 {

    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Student[] students= new Student[4];

        for(int i=0;i<students.length;i++){

            students[i]=new Student(
                    Integer.parseInt(br.readLine()),
                    br.readLine(),
                    br.readLine(),
                    Double.parseDouble(br.readLine()),
                    Boolean.parseBoolean(br.readLine())
            );
        }
        int res=findCountOfDayscholarStudents(students);
        if(res!=0)
            System.out.println(res);
        else
            System.out.println("There are no such dayscholar students");

        Student[] reA=findStudentwithSecondHighestScore(students);

        for(int i=0;i< reA.length;i++)
            System.out.println(reA[i].getRollNo()+"#"+reA[i].getName()+"#"+reA[i].getScore());

    }
    public static int findCountOfDayscholarStudents(Student[] students){
        int count=0;

        for(int i=0;i<students.length;i++){
            if((students[i].getScore()>80) && (students[i].getDayScholar()))
                count++;
        }

        return count;
    }

    public static Student[] findStudentwithSecondHighestScore(Student[] students){
        Student[] res=new Student[0];

        for(int i=0;i<students.length;i++){
            if(!students[i].getDayScholar()){
                res=Arrays.copyOf(res, res.length+1);
                res[res.length-1]=students[i];
            }

        }

        //for sorting object

        for(int i=0;i<res.length-1;i++){
            for(int j=0;j< res.length-i-1;j++){

                if(res[j].getScore()<res[j+1].getScore()){
                    Student temp=res[j];
                    res[j]=res[j+1];
                    res[j+1]=temp;
                }
            }
        }



        return res;
    }
}

class Student{

    protected int rollNo;
    protected String name, branch;
    protected double score;
    protected boolean dayScholar;

    public Student(int r, String n, String b, double s, boolean ds){
        this.rollNo=r;
        this.name=n;
        this.branch=b;
        this.score=s;
        this.dayScholar=ds;
    }

    public double getScore(){return score;}
    public boolean getDayScholar(){return dayScholar;}
    public String getName(){return name;}
    public int getRollNo(){return rollNo;}

}