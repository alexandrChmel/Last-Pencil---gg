package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        int num = 0;
        String numS;
        boolean valid = false;
//          ---------- empty is error
        while(!valid) {
            try {
                    numS = scanner.nextLine();

                    while(numS.isEmpty()){
                        System.out.println("The number of pencils should be numeric");
                    }
                    num = Integer.parseInt(numS);
                    if (num <= 0) {
                        System.out.println("The number of pencils should be positive");
                    } else {
                        valid = true;
                    }
            } catch (Exception e){
                System.out.println("The number of pencils should be numeric");

            }
        }
        // --------------------------------

        System.out.println("Who will be the first (John, Jack):");
        valid = false;
        String firstN = "";
        String secondN;
        while(!valid){
            firstN = scanner.next();
            if(firstN.equals("John") || firstN.equals("Jack")){
                valid = true;
            } else{
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }
        if (firstN.equals("John")){
            secondN = "Jack";
        } else{
            secondN = " John";
        }
        //-------------------
        int count = 0;
        while (num > 0){

            for (int i = 0; i < num; i++) {
                System.out.print("|");

            }
            System.out.println();
            if (count % 2 == 0){
                System.out.println(firstN + "s turn!");
            } else{
                System.out.println(secondN + "s turn!");
            }
            int turn = 0;

            valid = false;


            while(!valid){
                try{
                    if(count % 2 == 0 && firstN.equals("Jack")){
                        turn = bot(num);
                        valid = true;
                    } else if (count % 2 == 1 && firstN.equals("John")) {
                        turn = bot(num);
                        valid = true;
                    } else{
                        turn = scanner.nextInt();
                    }

                    if(turn == 1 || turn == 2 || turn == 3){
                        if(turn > num){
                            System.out.println("Too many pencils were taken");
                        } else{
                            valid = true;
                        }

                    } else{
                        System.out.println("Possible values: '1', '2' or '3'");
                    }


                } catch (Exception e){
                    System.out.println("Possible values: '1', '2' or '3'");
                    scanner.nextLine();
                }

            }
            num -= turn;
            count++;
        }
        if (count % 2 == 0){
            System.out.println(firstN + " Won the game");
        } else{
            System.out.println(secondN + " Won the game");
        }
    }
    public static int bot(int num){
        Random random = new Random();
        int result;
        if (num % 4 == 1 && num != 1){
            result = random.nextInt(3) + 1;
        } else if(num == 1){
            result = 1;
        } else if (num % 4 == 0){
            result = 3;
        } else if (num % 4 == 3){
            result = 2;
        } else if (num % 4 == 2){
            result = 1;
        } else{
            result = 1;
            System.out.println("bad");
        }
        System.out.println(result);
        return result;

    }
}


