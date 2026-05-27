import java.util.ArrayList;

public class Player {
    private int posx;
    private int posy;
    private int hp;
    private int dmg;
    ArrayList<Item> inventory = new ArrayList<>();

    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    public void equip(Item dmgItem) {
        if (dmgItem.getDmg() > 0 && inventory.contains(dmgItem)) {
            dmg += dmgItem.getDmg();
            inventory.remove(dmgItem);
        }
    }

    public void takeDmg(int dmgTaken) {
        this.dmg -= dmgTaken;
    }

    public void heal(Item healingItem) {
        if (healingItem.getHP() > 0 && inventory.contains(healingItem)) {
            hp += healingItem.getHP();
            inventory.remove(healingItem);
        }
    }

    public int getDmg() {
        return this.dmg;
    }

    public int getHp() {
        return this.hp;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public void move(String direction) {
        switch (direction) {
            case "north":
                posy++;
            case "south":
                posy--;
            case "east":
                posx++;
            case "west":
                posx--;
        }
    }
}