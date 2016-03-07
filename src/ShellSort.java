/**
 * Created by fallb on 2016/3/5.
 * issue:about shell sort,how to choose  h to make the algorithms perform better?
 */
public class ShellSort extends Sort {
    protected ShellSort(Comparable[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int length = array.length;
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(array[j - h], array[j])) exch(j - h, j);
                }
            }
            h = h/3;
        }
    }

    @Override
    public boolean less(Comparable front, Comparable last) {
        return front.compareTo(last) > 0;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{8, 5, 9, 7, 54, 12};
        ShellSort shellSort = new ShellSort(array);
        shellSort.sort();
        shellSort.show();
    }
}
