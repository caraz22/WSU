package eight;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Random;

public class TiledTask {
    
    public static void main(String[] args) {

        Random rng = new Random();

        ArrayDeque<Integer> tileStack = new ArrayDeque<>();
        Queue<Integer> tileQueue = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            tileStack.push(rng.nextInt(1, 4));
        }

        for (int i = 0; i < 10; i++) {
            tileQueue.offer(rng.nextInt(1, 4));
        }

        System.out.println(tileStack);
        System.out.println(tileQueue);

        System.out.println(tileGame(tileStack, tileQueue));
    }

    public static int tileGame(ArrayDeque<Integer> stack, Queue<Integer> q) throws NoSuchElementException, NullPointerException {
        int turns = 0;

        int q1 = 0;
        int q2 = 0;
        int q3 = 0;

        while (!stack.isEmpty()) {
            int tile = stack.peek();  
            try {
                if (tile == 1) {
                    stack.remove(tile);
                    stack.removeFirst();
                } else if (tile == 2) {
                    stack.remove(tile);
                    stack.pop();
                    stack.pop();
                } else if (tile == 3) {
                    stack.remove(tile);
                    q1 = q.poll();
                    q2 = q.poll();
                    q3 = q.poll();
                    stack.push(q1);
                    stack.push(q2);
                    stack.push(q3);
                }
            } catch (NoSuchElementException ne) {
                turns++;
                break;                
            } catch (NullPointerException npe) {
                turns++;
                break;
            }
            
            turns++;            
        } 

        return turns;
    }
}
