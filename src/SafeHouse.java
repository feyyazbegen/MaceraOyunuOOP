public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    @Override
    public boolean onLocation() {
        System.out.println("Güvemli Evdesiniz. Canınız Yenilendi");
        return true;
    }
}
