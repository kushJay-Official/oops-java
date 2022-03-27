package xplore;

/*
* Create a Class Player with below attributes:

playerId - int
playerName - String
iccRank - int
noOfMatchesPlayed - int
totalRunsScored - int

Write getters, setters and parameterized constructor as required.

Create class Solution with main method.

Implement static method - findAverageScoreOfPlayers in Solution class.

This method will take an int parameter named target along with the other parameter as array of

Player objects.
The method will calculate the average runrate of the player based on totalRunsScored and

noOfMatchesPlayed and return the same in a double array where the noOfMatchesPlayed attribute

is greater than or equal to the int parameter target passed.

This method should be called from the main method and display the Grade of the players.

If the averageRunRate is greater than or equal to 80 then it should print "Grade A Player". If

the averageRunRate is between 50 to 79 then it should print "Grade B Player", else it should

print "Grade C Player" .

Before calling this method(findAverageScoreOfPlayers) in the main method, use Scanner object to

read values for four Player objects referring the attributes in the above sequence.
then, read the value for noOfMatchesPlayed parameter.
Next call the method findAverageScoreOfPlayers, write the logic to display the Grade(in the main method) and display the result.

Consider below sample input and output:

Input:
100
Sachin
1
102
13000
101
Shewag
2
110
10000
102
Dhoni
3
80
7500
104
Kholi
4
70
7000
100

Output:
Grade A Player
Grade A Player
* */

import java.util.Arrays;
import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Player[] player= new Player[4];

        for (int i=0;i< player.length;i++){
            int id, r, nmp,trs;
            String n;

            id=sc.nextInt();
            n=sc.nextLine();
            sc.nextLine();
            r=sc.nextInt();
            nmp=sc.nextInt();
            trs=sc.nextInt();

            player[i]=new Player(id, n, r,nmp,trs);
        }
        int tar= sc.nextInt();


        double[] averageRunRate= findAverageScoreOfPlayers(player,tar);

        for (int i=0;i<averageRunRate.length;i++){
            if(averageRunRate[i]>=80)
                System.out.println("Grade A Player");
            else if(averageRunRate[i]<80 && averageRunRate[i]>=50)
                System.out.println("Grade B Player");
            else
                System.out.println("Grade C Player");
        }

    }

    public static double[] findAverageScoreOfPlayers(Player[] players, int target){
        double[] res= new double[0];

        for(int i=0;i< players.length;i++){
            if(players[i].getNoOfMatchesPlayed()>=target){
                res= Arrays.copyOf(res,res.length+1);
                res[res.length-1]=(double) players[i].getTotalRunScored()/players[i].getNoOfMatchesPlayed();
            }
        }

        return res;
    }

}


class Player {
    protected int playerId, iccRank, noOfMatchesPlayed, totalRunScored;
    protected String playerName;

    Player(int id, String n, int r, int nmp, int trs) {
        this.playerId = id;
        this.playerName = n;
        this.iccRank = r;
        this.noOfMatchesPlayed = nmp;
        this.totalRunScored = trs;
    }

    public int getNoOfMatchesPlayed(){return noOfMatchesPlayed;}
    public int getTotalRunScored(){return totalRunScored;}

}
