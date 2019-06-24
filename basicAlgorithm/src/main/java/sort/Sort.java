package sort;

public interface Sort {
    public <T extends Comparable<? super T>> void sort(T[] arr);
}
