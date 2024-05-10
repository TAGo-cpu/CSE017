import java.util.Comparator;
public interface List<E> extends Collection<E>{
    public abstract void add(int index, E element);
    public abstract E get(int index);
    public abstract int indexOf(Object o);
    public abstract int lastIndexOf(Object o);
    public abstract E remove(int index);
    public abstract E set(int index, E newVal);
    public abstract void sort(Comparator<E> c);
    public abstract Object[] toArray();
    public abstract void reverse();
}