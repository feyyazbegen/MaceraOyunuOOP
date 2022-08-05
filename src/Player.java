import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String playerName;
    private String characterName;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);



    public Player(String playerName){
        this.playerName=playerName;
        this.inventory=new Inventory();
    }

    public void selectCharacter(){
        GameChar[] charlist = {new Samurai(),new Archer(),new Knight()};
        System.out.println("------------------");
        System.out.println("KARAKTERLER");
        for(GameChar gameChar : charlist){
            System.out.println("ID: " +gameChar.getId() +
                                "\t\t  Karakter: " +gameChar.getName() +
                                "\t\t Hasar: " + gameChar.getDamage() +
                                "\t\t Saglik: " +gameChar.getHealth()+
                                "\t\t Para: " +gameChar.getMoney());
        }
        System.out.print("Lutfen Bir Karakter ID'si Seciniz: ");
        int selectCharacter = input.nextInt();
        switch (selectCharacter){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        /*
        System.out.println("Secilen Karakter : " + this.getCharacterName() +
                            "\t\t Hasar: " + this.getDamage() +
                            "\t\t Saglik: " + this.getHealth() +
                            "\t\t Para: " + this.getMoney());
        */
    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharacterName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println( "Silahiniz: " +this.getInventory().getWeapon().getName() +
                "\t\t Hasar: " + this.getDamage() +
                "\t\t Saglik: " + this.getHealth() +
                "\t\t Para: " + this.getMoney());
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
