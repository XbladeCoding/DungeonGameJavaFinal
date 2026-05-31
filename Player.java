import java.util.ArrayList;

public class Player {
    private int posx;
    private int posy;
    private int hp;
    private int dmg;
    private int def;
    private int points;
    ArrayList<Item> inventory = new ArrayList<>();

    public Player(int hp, int dmg, int def, int points, ArrayList<Item> inventory) {
        this.hp = hp;
        this.dmg = dmg;
        this.def = def;
        this.points = points;
        this.inventory = inventory;
    }

    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    public void equip(Item Item) {
        if (inventory.contains(Item)) {
            dmg += Item.getDmg();
            def += Item.getDef();
            inventory.remove(Item);
        }
    }

    public void takeDmg(int dmgTaken) {
        this.hp -= dmgTaken;
    }

    public void heal(Item healingItem) {
        if (healingItem.getHP() > 0 && inventory.contains(healingItem)) {
            hp += healingItem.getHP();
            inventory.remove(healingItem);
        }
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int pts) {
        points += pts;
    }

    public int getDmg() {
        return this.dmg;
    }

    public int getHp() {
        return this.hp;
    }

    public int getDef() {
        return this.def;
    }

    public int getPosx() {
        return this.posx;
    }

    public int getPosy() {
        return this.posy;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public void move(String direction) {
        switch (direction) {
            case "north":
                posy++;
                break;
            case "south":
                posy--;
                break;
            case "east":
                posx++;
                break;
            case "west":
                posx--;
                break;
            default:
                System.out.println("Invalid direction.");
                break;
        }
    }
}