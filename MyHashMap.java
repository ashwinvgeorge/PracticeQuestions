package com.avgeorge.collections.hashmap;


public class MyHashMap <K,V>{
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table;
    private int mapCapacity;


    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity) {
        mapCapacity = capacity;
        table = new Node[mapCapacity];
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Put new entry into map
     * @param newKey
     * @param value
     */
    public void put(K newKey, V value) {
        if (newKey == null) {
            return;
        }

        int hash = hash(newKey);
        Node<K,V> newNode = new Node<K,V>(newKey, newKey.hashCode(), value, null);

        if (table[hash] == null) {
            table[hash] = newNode;
        } else {
            Node<K, V> previous = null;
            Node<K, V> current = table[hash];

            while (current != null) {
                if (current.hashCode == newNode.hashCode && current.key.equals(newNode.key)) {
                    current.value = newNode.value;
                } else {
                    if (previous == null) {
                        newNode.next = current;
                        table[hash] = newNode;
                        return;
                    } else {
                        newNode.next = current;
                        previous.next = newNode;
                    }
                }
                previous = current;
                current = current.next;
                previous.next = newNode;
            }
        }
    }


    /**
     * Method to get value for a key in our map
     * @param key
     * @return
     */
    public V get(K key) {
        int hash = hash(key);

        if(table[hash] == null) {
            return null;
        } else {
            Node<K,V> temp = table[hash];
            while(temp != null) {
                if(temp.hashCode == key.hashCode() && temp.key.equals(key)) {
                    return temp.value;
                } else {
                    temp = temp.next;
                }
            }
            return null;
        }
    }

    /**
     * Method to remove a given key from map
     * and return true for success and false for failure
     * @param key
     * @return
     */
    public boolean remove(K key) {
        int hash = hash(key);

        if(table[hash] == null) {
            return false;
        } else {
            Node<K,V> previous = null;
            Node<K,V> current = table[hash];

            while(current != null) {
                if(key.hashCode() == current.hashCode && key.equals(current.key)) {
                    if(previous == null) {
                        table[hash] = table[hash].next;
                    } else {
                        previous.next = current.next;
                    }
                    return true;
                }
                previous = current;
                current = current.next;
            }
        }
        return false;
    }

    /**
     * Method to display the map according to
     * indexes of the node array
     */
    public void display() {
        for (int i=0; i<mapCapacity; i++) {
            if(table[i] != null) {
                Node<K,V> node = table[i];
                System.out.println("Values at index " + i);
                while(node != null) {
                    System.out.println("{" + node.key + " = " + node.value + "}");
                    node = node.next;
                }
            }
        }
    }

    /**
     * Generate hash for the map based on the key
     * @param newKey
     * @return
     */
    private int hash(K newKey) {
        return newKey == null ? 0 : Math.abs(newKey.hashCode()) % mapCapacity;
    }

    /**
     * Inner class for the Hashmap
     * where each node represents
     * a LinkedList further at that index
     * @param <K>
     * @param <V>
     */
    static class Node<K,V> {
        int hashCode;
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, int hashCode, V value, Node<K,V> next) {
            this.key = key;
            this.hashCode = hashCode;
            this.value = value;
            this.next = next;
        }
    }
}
