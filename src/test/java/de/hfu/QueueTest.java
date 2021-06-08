package de.hfu;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue;

    @Before
    public void erzeugeUtil () {
        this.queue = new Queue(10);
    }

    @Test(expected=IllegalArgumentException.class, timeout=1000)
    public void testEmptyQueueException() {
        this.queue = new Queue(0);
    }

    @Test(expected=IllegalStateException.class, timeout=1000)
    public void testEmptyDequeue() {
        queue.dequeue();
    }

    @Test
    public void testFullEnqueue() {
        for (int i=0; i<10;i++) {
            queue.enqueue(2);
        }
        queue.enqueue(5);
        assertEquals(5,queue.queue[queue.tail]);
    }

    @Test
    public void testEnqueueMax() {
        for (int i=0; i<10;i++) {
            queue.enqueue(2);
        }
        assertEquals(2,queue.queue[queue.tail]);
    }

    @Test
    public void testEnqueueMin() {
        queue.enqueue(5);
        for (int i=1; i<10;i++) {
            queue.enqueue(2);
        }
        assertEquals(5,queue.queue[queue.head]);
    }

    @Test
    public void testDequeue() {
        queue.enqueue(5);
        for (int i=1; i<6;i++) {
            queue.enqueue(2);
        }
        assertEquals(5,queue.dequeue());
    }

    @Test
    public void testDequeue2() {
        queue.enqueue(5); //1
        queue.enqueue(2); //2
        queue.enqueue(8); //3
        queue.enqueue(7); //4
        queue.enqueue(9); //5
        queue.enqueue(1); //6
        //Index:  0  1  2  3  4  5  6  7  8  9
        //Array: [5][2][8][7][9][1] [] [] [] []
        //      ^                ^
        //     head(-1)         tail(5)
        assertEquals(5,queue.dequeue());
        assertEquals(2,queue.dequeue());
        assertEquals(8,queue.dequeue());
        assertEquals(7,queue.dequeue());
        assertEquals(9,queue.dequeue());
        assertEquals(1,queue.dequeue());
        //Index:  0  1  2  3  4  5  6  7  8  9
        //Array: [5][2][8][7][9][1] [] [] [] []
        //                       ^  ^
        //                     tail(5)
        //                        head(6)
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(8);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.enqueue(202);
        //Index:  0  1  2  3  4  5  6  7  8  9
        //Array: [9][202][8][7][9][1][5][2][8][7]
        //                       ^  ^
        //                     tail(5)
        //                       head(6)
        assertEquals(202, queue.queue[1]);
    }

    @Test(expected=IllegalStateException.class, timeout=1000)
    public void testDequeueOut () {
        for (int i=0; i < 6; i++) {
            queue.enqueue(5);
        }

        for (int i=0; i < 7; i++) {
            queue.dequeue();
        }

    }

}
