package xplore;
import java.io.*;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args)throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Associate[] associate =new Associate[5];

        for(int i=0;i<associate.length;i++){
            associate[i]=new Associate(
                    Integer.parseInt(br.readLine()),
                    br.readLine(),
                    br.readLine(),
                    Integer.parseInt(br.readLine())
            );
        }

        Associate[] res=associatesForGivenTechnology(
                associate,
                br.readLine()
                );

        for(int i=0;i< res.length;i++)
            System.out.println(res[i].getIdAss());

    }

    public static Associate[] associatesForGivenTechnology(Associate[] associates, String tech){
        Associate[] resAss= new Associate[0];
        for(int i=0;i<associates.length;i++){

            if(associates[i].getTechnology().equalsIgnoreCase(tech)){

                if(associates[i].getExperienceInYears()%5==0) {

                    resAss = Arrays.copyOf(resAss, resAss.length + 1);
                    resAss[resAss.length - 1] =associates[i];

                }
            }

        }

        return resAss;
    }
}

class Associate {
    protected int id, experienceInYears;
    protected String name, technology;

    Associate(int i, String name, String tec, int exp){
        this.id=i;
        this.name=name;
        this.technology=tec;
        this.experienceInYears=exp;
    }

    public int getIdAss(){return id;}
    public String getTechnology(){return technology;}
    public int getExperienceInYears(){return experienceInYears;}
}
