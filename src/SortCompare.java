/**
 * Created by fallb on 2016/3/5.
 */
public class SortCompare {
    public static double time(String alg, Comparable[] array) throws Exception {
        Sort sort = null;
        switch (alg) {
            case "Insertion":
                sort = new InsertionSort(array);
                break;
            case "Selection":
                sort = new SelectionSort(array);
                break;
            case "Shell":
                sort = new ShellSort(array);
                break;
            case "Merge":
                sort = new MergeSort(array);
                break;
            case "MergeUp":
                sort = new MergeSortUp(array);
                break;
            case "Quick":
                sort = new QuickSort(array);
                break;
            default:
                throw new Exception("算法名称错误");
        }
        long currentTime = System.currentTimeMillis();
        if (sort != null) {
            sort.sort();
        }
        return System.currentTimeMillis() - currentTime;
    }

    public static double timeRandomInput(String alg, int n, int t) throws Exception {
        double total = 0.0;
        Double[] array = new Double[n];
        for (int j = 0; j < t; j++) {
            for (int i = 0; i < n; i++) {
                array[i] = Math.random() * 1000;
            }
            total += time(alg, array);
        }
        return total;
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Error,there must be 4 params");
            System.exit(0);
        }
        String alg1 = args[0];
        String alg2 = args[1];
        double[] resultArray = new double[1000];
        int n, t;
        try {
            n = Integer.parseInt(args[2]);
            t = Integer.parseInt(args[3]);
            double t1 = timeRandomInput(alg1, n, t);
            double t2 = timeRandomInput(alg2, n, t);
            System.out.printf("For %d random double\n", n);
            System.out.printf("%s/%s is %f", alg1, alg2, t1 / t2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
