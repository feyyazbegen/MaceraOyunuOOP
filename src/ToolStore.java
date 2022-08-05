public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Magazaya Hosgeldiniz.");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zirhlar");
        System.out.println("3 - Cikis Yap");
        System.out.println("Seciminiz: ");
        int selectCase =input.nextInt();
        while (selectCase<1 || selectCase>Weapon.weapons().length){
            System.out.println("Lutfen Yeni Secim Yapin!!!");
            selectCase=input.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                return true;
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("----- Silahlar -----");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " +
                    w.getName() +
                    " <Para :  " +w.getPrice() +
                    " , Hasar : " +w.getDamage());
        }

    }
    public  void buyWeapon(){
        System.out.println("Bir Silah Seciniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID<1 || selectWeaponID>Weapon.weapons().length){
            System.out.println("Gecersiz deger, tekrar giriniz. ");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if (selectedWeapon != null){
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paraniz yok!!!");
            }
            else {
                System.out.println(selectedWeapon.getName() + " Satin aldiniz...");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paraniz: " +this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }
        }
    }

    public void printArmor(){
        System.out.println("Zirhlar");
    }
}
