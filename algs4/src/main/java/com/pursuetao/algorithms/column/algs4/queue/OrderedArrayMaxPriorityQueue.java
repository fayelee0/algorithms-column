package com.pursuetao.algorithms.column.algs4.queue;

import java.util.Arrays;

// 有序数组实现优先级队列
// 1. 数组可动态扩容
// 2. 时间复杂度：
//    2.1 写：O(N)
//    2.2 读：O(1)
// 3. 空间复杂度：O(N)
public class OrderedArrayMaxPriorityQueue<K extends Comparable<K>> implements PriorityQueue<K> {
    private Object[] keys;
    private int size;

    public OrderedArrayMaxPriorityQueue() {
        this.keys = new Object[8];
    }

    public OrderedArrayMaxPriorityQueue(int cap) {
        this.keys = new Object[cap];
    }

    public OrderedArrayMaxPriorityQueue(K[] keys) {
        this.keys = Arrays.copyOf(keys, keys.length);
        this.size = this.keys.length;
    }

    @Override
    public void insert(K key) {
        this.expand();

        // 1. 找到合适的位置
        // 2. 将后续的所有数后移一位
        // 3. 将当前值插入合适位置

        if (this.isEmpty()) {
            this.keys[this.size] = key;
        } else if (key.compareTo(this.get(0)) < 0) {
            if (this.size >= 0) System.arraycopy(this.keys, 0, this.keys, 1, this.size);
            this.keys[0] = key;
        } else if (key.compareTo(this.get(this.size - 1)) > 0) {
            this.keys[this.size] = key;
        } else {
            int p = 0; // 合适的位置
            while (key.compareTo(this.get(p)) > 0) {
                p++;
            }
            if (this.size - p >= 0) System.arraycopy(this.keys, p, this.keys, p + 1, this.size - p);
            this.keys[p] = key;
        }

        this.size++;
    }

    @Override
    public K max() throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        @SuppressWarnings("unchecked")
        K max = (K) this.keys[this.size - 1];

        return max;
    }

    @Override
    public K delMax() throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        this.shrink();

        this.size--;
        @SuppressWarnings("unchecked")
        K key = (K) this.keys[this.size];
        this.keys[this.size] = null;

        return key;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    private K get(int i) {
        return (K) this.keys[i];
    }

    private void expand() {
        if (this.size == this.keys.length) {
            this.keys = Arrays.copyOf(this.keys, this.keys.length * 2);
        }
    }

    private void shrink() {
        if (this.size == this.keys.length / 2) {
            this.keys = Arrays.copyOfRange(this.keys, 0, this.keys.length / 2);
        }
    }

}
