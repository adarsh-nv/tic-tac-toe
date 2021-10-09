package tictactoe;
import java.util.Scanner;
import java.util.Arrays;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("---------");
        String[] str = new String[]{" "," "," "," "," "," "," "," "," "};
        boolean flag = false;
        boolean checkGameOver = false;
        boolean turn = false;
        int cordX = 0;
        int cordY = 0;
        while(!checkGameOver){    
            do{
                System.out.print("Enter the coordinates: ");
                String[] str1 = sc.nextLine().split(" ");
                cordX = Integer.parseInt(str1[0]) - 1;
                cordY = Integer.parseInt(str1[1]) - 1 ;
                flag = checkInput(cordX,cordY,str);
            }while(flag);
            str[getNum(cordX,cordY)] = (turn = !turn)?"X":"O";
            printGrid(str);
            checkGameOver = checkWinner(str);
        }
    }
    
    public static void printGrid(String[] str){
        System.out.println("---------");
        System.out.println("| " + str[0] + " " + str[1] + " " + str[2] + " |");
        System.out.println("| " + str[3] + " " + str[4] + " " + str[5] + " |");
        System.out.println("| " + str[6] + " " + str[7] + " " + str[8] + " |");
        System.out.println("---------");
    }
    
    public static boolean checkInput(int cordX,int cordY,String[] str){
        try{
                if(cordX>2 || cordY>2){
                    System.out.println("Coordinates should be from 1 to 3!");
                    return true;
                }else if(str[getNum(cordX,cordY)].equals("X") || str[getNum(cordX,cordY)].equals("O")){
                    System.out.println("his cell is occupied! Choose another one!");
                    return true;
                }
                else{
                    return false;
                }
            }catch(NumberFormatException e){
                System.out.println("\nYou should enter numbers!");
                return true;
            }
    }   
    
    public static int getNum(int x,int y){
        if(x==0 && y==0){
            return 0;
        }else if(x==0 && y==1){
            return 1;
        }
        else if(x==0 && y==2){
            return 2;
        }
        else if(x==1 && y==0){
            return 3;
        }
        else if(x==1 && y==1){
            return 4;
        }
        else if(x==1 && y==2){
            return 5;
        }
        else if(x==2 && y==0){
            return 6;
        }
        else if(x==2 && y==1){
            return 7;
        }
        else 
            return 8;
        }
    
    public static boolean checkWinner(String[] str){
        int xs = 0;
        int os = 0;
        for(String i: str){
            if(i.equals("X"))
                xs++;
            else if(i.equals("O"))
                os++;
        }
        boolean xWins = checkXWin(str);
        boolean oWins = checkOWin(str);
        if (xWins && oWins || Math.abs(os - xs) > 1){
            System.out.println("Impossible");
            return true;
        }
        else if(xWins && !oWins){
            System.out.println("X wins");
            return true;
        }
        else if(oWins && !xWins){
            System.out.println("O wins");
            return true;
        }
        else if(xs + os == 9){
            System.out.println("Draw");
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean checkXWin(String[] str){
        if(str[0].equals("X") && str[1].equals("X") && str[2].equals("X"))
            return true;
        else if(str[3].equals("X") && str[4].equals("X") && str[5].equals("X"))
            return true;
        else if(str[6].equals("X") && str[7].equals("X") && str[8].equals("X"))
            return true;
        else if(str[0].equals("X") && str[3].equals("X") && str[6].equals("X"))
            return true;
        else if(str[1].equals("X") && str[4].equals("X") && str[7].equals("X"))
            return true;
        else if(str[2].equals("X") && str[5].equals("X") && str[8].equals("X"))
            return true;
        else if(str[0].equals("X") && str[4].equals("X") && str[8].equals("X"))
            return true;
        else if(str[2].equals("X") && str[4].equals("X") && str[6].equals("X"))
            return true;
        else
            return false;
    }
    public static boolean checkOWin(String[] str){
        if(str[0].equals("O") && str[1].equals("O") && str[2].equals("O"))
            return true;
        else if(str[3].equals("O") && str[4].equals("O") && str[5].equals("O"))
            return true;
        else if(str[6].equals("O") && str[7].equals("O") && str[8].equals("O"))
            return true;
        else if(str[0].equals("O") && str[3].equals("O") && str[6].equals("O"))
            return true;
        else if(str[1].equals("O") && str[4].equals("O") && str[7].equals("O"))
            return true;
        else if(str[2].equals("O") && str[5].equals("O") && str[8].equals("O"))
            return true;
        else if(str[0].equals("O") && str[4].equals("O") && str[8].equals("O"))
            return true;
        else if(str[2].equals("O") && str[4].equals("O") && str[6].equals("O"))
            return true;
        else
            return false;
    }
}
