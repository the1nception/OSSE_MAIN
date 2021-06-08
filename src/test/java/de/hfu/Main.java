package de.hfu;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        Queue ringbuffer = new Queue(10);
        ringbuffer.enqueue(5); //1
        ringbuffer.enqueue(2); //2
        ringbuffer.enqueue(8); //3
        ringbuffer.enqueue(7); //4
        ringbuffer.enqueue(9); //5
        ringbuffer.enqueue(1); //6
        //Index:  0  1  2  3  4  5  6  7  8  9
        //Array: [5][2][8][7][9][1] [] [] [] []
        //      ^                ^
        //     head(-1)         tail(5)
        //     9
        ringbuffer.dequeue();
        ringbuffer.dequeue();
        ringbuffer.dequeue();
        ringbuffer.dequeue();
        ringbuffer.dequeue();
        ringbuffer.dequeue();
        //Array: [5][2][8][7][9][1] [] [] [] []
        //                       ^  ^
        //                     tail(5)
        //                        head(6)
        ringbuffer.enqueue(5);
        ringbuffer.enqueue(2);
        ringbuffer.enqueue(8);
        ringbuffer.enqueue(7);
        ringbuffer.enqueue(9);
        ringbuffer.enqueue(202);
        //Index:  0  1  2  3  4  5  6  7  8  9
        //Array: [9][202][8][7][9][1][5][2][8][7]
        //                       ^  ^
        //                     tail(5)
        //                       head(6)
    }
}
