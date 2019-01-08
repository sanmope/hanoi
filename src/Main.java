import java.util.*;
public class Main{
    public static void main(String []args){
        System.out.println("Hello World");
        int n = 11;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
        for (int i = n - 1; i >= 0; i--) towers[0].add(i);
        Tower.towers = towers;
        towers[0].moveDisks(n, towers[2], towers[1]);
        System.out.println("Result ##");
        Tower.printTowers();
    }
}

class Tower{
    private int index;
    private Stack<Integer> disks;
    public static int moves=0;
    public static Tower[] towers;

    public Tower(int index){
        this.index = index;
        disks = new Stack<Integer>();
    }

    public int index() {
        return index;
    }

    public static void printTowers(){
//        for (Tower t: Tower.towers) System.out.println("tower N°: " + t.index() + " stack : " + t.disks.toString());
        System.out.println("tower N°: " + Tower.towers[0].index() + " stack : " +  Tower.towers[0].disks.toString());
        System.out.println("tower N°: " + Tower.towers[1].index() + " stack : " +  Tower.towers[1].disks.toString());
        System.out.println("tower N°: " + Tower.towers[2].index() + " stack : " +  Tower.towers[2].disks.toString());

    }

    public void add (int disk){
        if (!disks.isEmpty() && disks.peek() < disk){
            System.out.println("Error placing the disk: " + disk);
        }else{
            disks.push(disk);
        }
    }

    public void moveTopTo(int n, Tower destination){
        int pop = disks.pop();
        destination.add(pop);
        System.out.println("Move disk " + pop + " from tower " + index() + " to tower " + destination.index());
        Tower.moves = Tower.moves + 1;
        System.out.println("Moves : " +  Tower.moves);
    }

    public void moveDisks(int n, Tower destination, Tower buffer){
        if (n > 0){
            moveDisks(n-1,buffer,destination);
            Tower.printTowers();
            moveTopTo(n,destination);
            buffer.moveDisks(n-1,destination,this);
        }
    }
}

