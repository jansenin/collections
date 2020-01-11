package my_collections;

public interface List<T> {
    void add(T element);

    void add(T element, int index);

    T get(int i);

    T remove(int index);

    T removeFirst(T element);

    T removeLast(T element);

    List<T> removeAll(T element);

    int indexOf(T element);

    int lastIndexOf(T element);

    int size();

    T[] toArray();
}
