public class MergeSort<T extends  Comparable<T>> implements ISort<T> {
    public void sort(Comparable[] in) {
        //Edge case
        if (in.length <= 1) {
            return;
        }
        Comparable[] L = new Comparable[in.length / 2];
        Comparable[] R = new Comparable[in.length - L.length];
        for (int i = 0; i <L.length; i++){
            L[i] = in[i];
        }
        for (int j  = 0; j< R.length; j++){
            R[j] = in[L.length+j];
        }
        //Recursion!
        sort(L);
        sort(R);
        merge(L, R, in);
    }
    public void merge(Comparable[] left, Comparable[] right, Comparable[] in) {
        int leftp = 0;
        int rightp = 0;
        int merge= 0;
        while (leftp < left.length && rightp < right.length)
        {
            if (left[leftp].compareTo(right[rightp]) < 0) {
                in[merge] = left[leftp];
                leftp++;
            }
            else
            {
                in[merge] = right[rightp];
                rightp++;
            }
            merge++;
            }
        //add remaining stuff if still available
        while (leftp < left.length){
            in[merge] = left[leftp];
            leftp++;
            merge++;
        }
        while (rightp < right.length){
            in[merge] = right[rightp];
            rightp++;
            merge++;
        }
    }

    public String sortName() {
        return "Merge Sort";
    }

}
