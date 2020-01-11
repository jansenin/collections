package my_collections.implementations;

import my_collections.List;

import java.util.Arrays;

public class LinkedList<T> implements List<T> {
    private class Node {
        private T value;
        private Node next;
        private Node previous;

        private Node(T value) {
            this.value = value;
        }

        private Node() { }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (value != null ? !value.equals(node.value) : node.value != null) return false;
            if (next != null ? !next.equals(node.next) : node.next != null) return false;
            return previous != null ? previous.equals(node.previous) : node.previous == null;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {

    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        if (size == 0) {
            head = tail = newNode;
            size++;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    @Override
    public void add(T element, int index) {
        if ((index > size) || (index < 0)) throw new ArrayIndexOutOfBoundsException();
        if (index == size) {
            add(element);
        } else {
            Node changeNode = getNode(index);
            Node newNode = new Node(element);
            if (changeNode == head) {
                head = newNode;
                head.next = changeNode;
                changeNode.previous = head;
            }  else {
                newNode.next = changeNode;
                newNode.previous = changeNode.previous;

                newNode.previous.next = newNode;
                newNode.next.previous = newNode;
            }
            size++;
        }
    }

    @Override
    public T get(int i) {
        return getNode(i).value;
    }

    private T removeNode(Node delNode) {
        if (delNode != null && size == 1) {
            head = tail = null;
        } else if (delNode == tail || delNode == head) {
            if (delNode == head) {
                if (size > 1) {
                    head.next.previous = null;
                    head = head.next;
                } else {
                    head = tail = null;
                }
            }
            if (delNode == tail) {
                if (size > 1) {
                    tail.previous.next = null;
                    tail = tail.previous;
                } else {
                    head = tail = null;
                }
            }
        } else {
            delNode.previous.next = delNode.next;
            delNode.next.previous = delNode.previous;

        }
        size--;
        return delNode.value;
    }


    @Override
    public T remove(int index) {
        return removeNode(getNode(index));
    }

    @Override
    public T removeFirst(T element) {
        return removeNode(getNode(element));
    }

    @Override
    public T removeLast(T element) {
        return removeNode(getLastNode(element));
    }

    @Override
    public List<T> removeAll(T element) {
        List<T> resultList = new LinkedList<>();
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.value.equals(element)) {
                resultList.add(currentNode.value);
                removeNode(currentNode);
            }
            currentNode = currentNode.next;
        }

        return resultList;
    }

    private Node getNode(int i) {
        if ((i >= size) || (i < 0)) throw new ArrayIndexOutOfBoundsException();
        Node result = head;
        for (int j = 0; j < i; j++) {
            if (result == null) return null;
            result = result.next;
        }
        return result;
    }

    private Node getNode(T element) {
        Node result = head;
        int i = 0;
        while (result != null) {
            if (result.value.equals(element)) {
                break;
            }
            result = result.next;
            i++;
        }
        if (i >= size) return null;
        return result;
    }

    private Node getLastNode(T element) {
        Node result = tail;
        int i = size - 1;
        while (result != null) {
            if (result.value.equals(element)) {
                break;
            }
            result = result.previous;
            i--;
        }
        if (i < 0) return null;
        return result;
    }

    @Override
    public int indexOf(T element) {
        Node result = head;
        int i = 0;
        while (result != null) {
            if (result.equals(element)) {
                break;
            }
            result = result.next;
            i++;
        }
        if (i >= size) return -1;
        return i;
    }

    @Override
    public int lastIndexOf(T element) {
        Node result = tail;
        int i = size - 1;
        while (result != null) {
            if (result.equals(element)) {
                break;
            }
            result = result.previous;
            i--;
        }
        if (i < 0) return -1;
        return i;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        Object[] result = new Object[size];
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            result[i] = currentNode.value;
            currentNode = currentNode.next;
            if (currentNode == null) break;
        }

        return (T[]) result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedList<?> that = (LinkedList<?>) o;

        if (size != that.size) return false;
        Node currentNode1 = head;
        Node currentNode2 = (Node) that.head;

        while (currentNode1 != null) {
            if (!currentNode1.value.equals(currentNode2.value)) return false;
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + (tail != null ? tail.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(toArray()) +
                '}';
    }
}
