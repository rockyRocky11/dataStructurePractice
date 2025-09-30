package com.data.structures.practice.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class AnimalShelf {

    public static void main(String[] args) {
        AnimalShelf animalShelf = new AnimalShelf();
//        animalShelf.enqueue(new int[]{0, 0});
//        animalShelf.enqueue(new int[]{1, 0});
//        System.out.println(Arrays.toString(animalShelf.dequeueCat()));
//        System.out.println(Arrays.toString(animalShelf.dequeueDog()));
//        System.out.println(Arrays.toString(animalShelf.dequeueAny()));

        animalShelf.enqueue(new int[]{0, 0});
        animalShelf.enqueue(new int[]{1, 0});
        animalShelf.enqueue(new int[]{2, 1});
        System.out.println(Arrays.toString(animalShelf.dequeueDog()));
        System.out.println(Arrays.toString(animalShelf.dequeueCat()));

        System.out.println(Arrays.toString(animalShelf.dequeueAny()));
    }
    private Deque<Integer>[] q = new Deque[2];

    public AnimalShelf() {
        Arrays.setAll(q, k -> new ArrayDeque<>());
    }

    public void enqueue(int[] animal) {
        q[animal[1]].offer(animal[0]);
    }

    public int[] dequeueAny() {
        if (q[0].isEmpty() || (!q[1].isEmpty() && q[1].peek() < q[0].peek())) {
            return dequeueDog();
        }
        return dequeueCat();
    }

    public int[] dequeueDog() {
        return q[1].isEmpty() ? new int[] {-1, -1} : new int[] {q[1].poll(), 1};
    }

    public int[] dequeueCat() {
        return q[0].isEmpty() ? new int[] {-1, -1} : new int[] {q[0].poll(), 0};
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */
