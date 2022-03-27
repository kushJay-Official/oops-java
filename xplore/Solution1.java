package xplore;


import java.util.Scanner;

public  class Solution1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AutonomousCar[] car=new AutonomousCar[4];

        for(int i=0;i<car.length;i++){
            int cID=sc.nextInt();
            sc.nextLine();
            String brd=sc.nextLine();
            int notc=sc.nextInt();
            int notp=sc.nextInt();
            sc.nextLine();
            String env=sc.nextLine();

            car[i]=new AutonomousCar(cID,brd,notc,notp,env);
        }
        String en=sc.nextLine();
        String br=sc.nextLine();

        int testpassed=findTestPassedByEnv(car,en);
        AutonomousCar ac=updateCarGrade(car, br);

        if(testpassed==0)
            System.out.println("There is no tests passed in this particular environment");
        else
            System.out.println(testpassed);

        if (ac==null)
            System.out.println("no car is available for specified brand");
        else
            System.out.println(ac.getBrand()+"::"+ac.getGrade());
    }

    public static int findTestPassedByEnv(AutonomousCar[] car, String envr){
        int sum=0;
        for(int i=0;i<car.length;i++){
            if(envr.equalsIgnoreCase(car[i].getEnvironment()))
                sum=sum+car[i].getNoOfTestPassed();
        }
        return sum;
    }

    public static AutonomousCar updateCarGrade(AutonomousCar[] car, String brd){
        int rating=0;
        for(int i=0;i<car.length;i++){
            if(brd.equalsIgnoreCase(car[i].getBrand()))
                rating=(int)(car[i].getNoOfTestPassed()*100)/car[i].getNoOfTestsConducted();

            if(rating>=80)
                car[i].setGrade("A1");
            else
                car[i].setGrade("B2");
            return car[i];
        }
        return null;
    }
}

class AutonomousCar {
    private int carId, noOfTestsConducted, noOfTestPassed;
    private String brand, environment, grade;

    AutonomousCar(int cid, String bnd, int noft, int nofp,
                   String env){
        this.carId=cid;
        this.noOfTestPassed=nofp;
        this.noOfTestsConducted=noft;
        this.brand=bnd;
        this.environment=env;
    }
    int getCarId(){return carId;}
    int getNoOfTestsConducted(){return  noOfTestsConducted;}
    int getNoOfTestPassed(){return noOfTestPassed;}
    String getBrand(){return brand;}
    String getEnvironment(){return environment;}
    void setGrade(String gr){this.grade=gr;}
    String getGrade(){return grade;}


}
