import java.util.Hashtable;

class LRUCache {

    class DoublyLinkedNode{
        int key;
        int value;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
    }

    public void addToHead(DoublyLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DoublyLinkedNode node){
        DoublyLinkedNode prev = node.prev;
        DoublyLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DoublyLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public int popTail(){
        DoublyLinkedNode last = tail.prev;
        removeNode(last);
        return last.key;
    }

    Hashtable<Integer,DoublyLinkedNode> cache = new Hashtable<>();
    DoublyLinkedNode head, tail;
    int count,capacity;

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;

        head = new DoublyLinkedNode();
        head.prev = null;

        tail = new DoublyLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DoublyLinkedNode node = cache.get(key);
        if(node==null) return -1; //exception should be thrown here
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DoublyLinkedNode node = cache.get(key);
        if(node==null){
            node = new DoublyLinkedNode();
            node.key = key;
            node.value = value;
            addToHead(node);
            cache.put(key,node);
            count++;
            if(count>capacity){
                int last = popTail();
                cache.remove(last);
                count--;
            }
        }
        else{
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */