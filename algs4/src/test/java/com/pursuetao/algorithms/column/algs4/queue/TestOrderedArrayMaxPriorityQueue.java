package com.pursuetao.algorithms.column.algs4.queue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestOrderedArrayMaxPriorityQueue {
    private PriorityQueue<Integer> priorityQueue;

    @Before
    public void setUp() {
        priorityQueue = new OrderedArrayMaxPriorityQueue<>();
    }

    @Test
    public void OrderedArrayMaxPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new OrderedArrayMaxPriorityQueue<>();
        assertThat(priorityQueue.isEmpty(), is(true));
        assertThat(priorityQueue.size(), is(0));
    }

    @Test
    public void OrderedArrayMaxPriorityQueueWithCapacity() {
        PriorityQueue<Integer> priorityQueue = new OrderedArrayMaxPriorityQueue<>(8);
        assertThat(priorityQueue.isEmpty(), is(true));
        assertThat(priorityQueue.size(), is(0));
    }

    @Test
    public void OrderedArrayMaxPriorityQueueWithArray() {
        Integer[] keys = new Integer[]{1, 2, 3, 4};
        PriorityQueue<Integer> priorityQueue = new OrderedArrayMaxPriorityQueue<>(keys);
        assertThat(priorityQueue.isEmpty(), is(false));
        assertThat(priorityQueue.size(), is(4));
    }

    @Test
    public void insert() {
        assertThat(priorityQueue.isEmpty(), is(true));
        assertThat(priorityQueue.size(), is(0));

        int limit = 1024;
        for (int i = 0; i < limit; i++) {
            priorityQueue.insert(i);
            assertThat(priorityQueue.isEmpty(), is(false));
            assertThat(priorityQueue.size(), is(i+1));
        }

        assertThat(priorityQueue.isEmpty(), is(false));
        assertThat(priorityQueue.size(), is(limit));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void maxWithEmpty() {
        priorityQueue.max();
    }

    @Test
    public void max() {
        assertThat(priorityQueue.isEmpty(), is(true));
        assertThat(priorityQueue.size(), is(0));

        priorityQueue.insert(20);
        assertThat(priorityQueue.isEmpty(), is(false));
        assertThat(priorityQueue.size(), is(1));
        assertThat(priorityQueue.max(), is(20));

        priorityQueue.insert(10);
        assertThat(priorityQueue.isEmpty(), is(false));
        assertThat(priorityQueue.size(), is(2));
        assertThat(priorityQueue.max(), is(20));

        priorityQueue.insert(30);
        assertThat(priorityQueue.isEmpty(), is(false));
        assertThat(priorityQueue.size(), is(3));
        assertThat(priorityQueue.max(), is(30));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void delMaxWithEmpty() {
        priorityQueue.delMax();
    }

    @Test
    public void delMax() {
        assertThat(priorityQueue.isEmpty(), is(true));
        assertThat(priorityQueue.size(), is(0));

        int limit = 100;
        for (int i = 0; i < limit; i++) {
            priorityQueue.insert(i);
        }

        assertThat(priorityQueue.isEmpty(), is(false));
        assertThat(priorityQueue.size(), is(limit));

        for (int i = 0;i < limit; i++) {
            assertThat(priorityQueue.delMax(), is(limit - i - 1));
            assertThat(priorityQueue.size(), is(limit - i - 1));
        }

        assertThat(priorityQueue.isEmpty(), is(true));
        assertThat(priorityQueue.size(), is(0));
    }

    @Test
    public void isEmpty() {
        assertThat(priorityQueue.isEmpty(), is(true));
        priorityQueue.insert(0);
        assertThat(priorityQueue.isEmpty(), is(false));
        priorityQueue.delMax();
        assertThat(priorityQueue.isEmpty(), is(true));
    }

    @Test
    public void size() {
        assertThat(priorityQueue.size(), is(0));
        priorityQueue.insert(0);
        assertThat(priorityQueue.size(), is(1));
        priorityQueue.delMax();
        assertThat(priorityQueue.size(), is(0));
    }

}
