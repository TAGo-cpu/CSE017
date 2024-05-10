import java.util.Iterator;
public interface Collection<E>{
    public abstract boolean add(E element);
    public abstract Iterator<E> iterator();
    public abstract boolean remove(Object o);
    public abstract void clear();
    public abstract int size();
    public abstract boolean equals(Object o);
    public abstract boolean addAll(Collection<E> c);
    public abstract boolean contains(Object o);
    public abstract boolean isEmpty();
    
}