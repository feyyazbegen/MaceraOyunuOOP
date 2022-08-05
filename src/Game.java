import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hosgeldiniz !!");
        System.out.print("Lutfen Bir Isim Giriniz : ");
       // String playerName=input.nextLine();
        Player player = new Player("feyyaz");
        System.out.println("Sayin " + player.getPlayerName() + " bu karanlik oyuna hosgeldiniz. !!");
        System.out.println("Lutfen Bir Karakter Seciniz : ");
        player.selectCharacter();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println("Bolgeler");
            System.out.println("1 - Guvenli Ev");
            System.out.println("2 - Magaza");
            System.out.print("Gitmek istediginiz bolgeyi seciniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);
                    break;
                default:
                    location=new SafeHouse(player);
            }
            if (!location.onLocation()){
                System.out.println("Game Over");
                break;
            }
        }
    }
}
