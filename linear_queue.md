# 线性表之队列

## 优先级队列

> 1. 删除最大元素
> 2. 插入元素

### 应用场景

1. 模拟系统

事件的键为发生时间，而系统需要按照时间顺序处理所有事件

2. 任务调度

键值对应的优先级决定了应该首先执行哪些任务

3. 数值计算

键值代表计算错误，需要按照键值指定的顺序来修正它们

### 抽象数据类型

```java
public class MaxPriorityQueue<K extends Comparable<K>> {
    // 创建优先级队列
    public MaxPriorityQueue() {}
    
    // 创建指定容量的优先级队列
    public MaxPriorityQueue(int cap) {}
    
    // 使用键数组创建优先级队列
    public MaxPriorityQueue(K[] keys) {}

    // 插入元素
    void insert(K key) {}
    
    // 返回最大元素
    K max() {}

    // 删除并返回最大元素
    K delMax() {}

    // 返回队列为空
    boolean isEmpty() {}

    // 返回队列元素个数
    int size() {}
}
```