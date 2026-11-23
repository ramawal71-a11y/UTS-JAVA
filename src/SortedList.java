import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortedList<T> {
    private final ArrayList<T> items = new ArrayList<>();
    private final Comparator<T> comparator;

    public SortedList(Comparator<T> comparator) {
        if (comparator == null) throw new IllegalArgumentException("Comparator tidak boleh null");
        this.comparator = comparator;
    }

    public void insert(T item) {
        if (item == null) throw new IllegalArgumentException("Item tidak boleh null");
        int low = 0, high = items.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (comparator.compare(items.get(mid), item) <= 0) low = mid + 1;
            else high = mid;
        }
        items.add(low, item);
    }

    public T search(T key) {
        for (T item : items)
            if (comparator.compare(item, key) == 0) return item;
        return null;
    }

    public boolean remove(T key) {
        for (int i = 0; i < items.size(); i++) {
            if (comparator.compare(items.get(i), key) == 0) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public T get(int index) { return items.get(index); }
    public int size() { return items.size(); }
    public boolean isEmpty() { return items.isEmpty(); }
    public void clear() { items.clear(); }
    public List<T> toList() { return new ArrayList<>(items); }
}
