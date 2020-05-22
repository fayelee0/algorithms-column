package com.pursuetao.algorithms.column.algs4.queue;

public interface PriorityQueue<K extends Comparable<K>> {
    void insert(K key);
    K max();
    K delMax();
    boolean isEmpty();
    int size();
}
