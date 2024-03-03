import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int row,col;
        System.out.println("Mayın tarlası oyunumuza hoşgeldiniz");
        System.out.println("----------------------------");


        while (true){
            System.out.print("Enter number of rows : ");
            row = scan.nextInt();
            System.out.print("Enter number of column : ");
            col = scan.nextInt();

            if (row < 2 || col < 2){
                System.out.println("Geçersiz seçim.");

            }else {
                mineSweeper game = new mineSweeper(row,col);
                game.run();
                break;
            }
        }







    }
}
