public class Array<E> {
    // private will keep the data save, user can not get that from outside
    private E[] data;
    private int size;

    public Array(int capacity) {
//        WRONG
//        data = new E[capacity];
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("addlast fail");
//        }
//
//        data[size] = e;
//        size++;
        add(e, size);
    }

    public void addFisrt(E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("add fail");
//        }
//
//        data[0] = e;
//        size++;
        add(e, 0);
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add index not correct");
        }
        if (size == data.length) {
//            throw new IllegalArgumentException("add fail");
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    // can not be called by user
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    // protect data array
    public E get(int index) {
        // so that user will not get illegale place of array
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail. Index is illegal");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set fail. Index is illegal");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            // 类对象值比较：compare E element use value compare instead of 引用比较
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // return the value of delete
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete failed index wrong");
        }

        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        // object need to be freed, garbage collection
        data[size] = null; // Loitering objects != memory leak

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    // remove all, find all

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
