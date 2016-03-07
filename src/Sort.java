/**
 * Created by fallb on 2016/3/3.
 */
public abstract class Sort {

    protected Comparable[] array = null;

    protected Sort(Comparable[] array){
        this.array = array;
    }

    public  abstract void  sort();

    /**
     * 实现排序的比较算法，通过重写该方法可以得到
     * 从大到下或者从下到大的排序。
     * @param front 比较的前一个元素
     * @param last 比较的后一个元素
     * @return
     */
    public  abstract boolean less(Comparable front,Comparable last);

    public  void  exch(int lo,int hi){
        Comparable temp = array[hi];
        array[hi] = array[lo];
        array[lo] = temp;

    }

    public  void show(){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public  boolean isSorted(){
        for (int i=0;i<array.length;i++){
            if (less(array[i],array[i+1])) return false;
        }
        return true;
    }

}
