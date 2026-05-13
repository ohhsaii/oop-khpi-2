package ua.khpi.oop.lab10.container;

import java.util.Iterator;
import java.util.NoSuchElementException;

// власний узагальнений контейнер
public class JournalContainer<T> implements Iterable<T> {
    private Object[] elements;
    private int size;

    public JournalContainer() {
        elements = new Object[10]; // початковий розмір масиву
        size = 0;
    }

    // додавання нового елемента
    public void add(T item) {
        if (size == elements.length) {
            grow(); // збільшуємо масив, якщо місця немає
        }
        elements[size++] = item;
    }

    // отримання елемента за індексом
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("неправильний індекс");
        }
        return (T) elements[index];
    }

    public int size() {
        return size;
    }

    // метод для збільшення масиву вдвічі
    private void grow() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    // повертаємо наш ітератор
    @Override
    public Iterator<T> iterator() {
        return new JournalIterator();
    }

    // внутрішній клас ітератора
    private class JournalIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("більше немає елементів");
            }
            return (T) elements[currentIndex++];
        }
    }
}