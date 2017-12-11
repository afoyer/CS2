public class SelectSort<T extends Comparable<T>> implements ISort<T> {
    public void sort(T[] in) {
        for (int i = 0; i < in.length-1; i++){
            int min = i;
            for (int j = i+1; j< in.length; j++){
                if(in[min].compareTo(in[j]) < 0){
                    min = j;

                }
            }
            T temp = in[min];
            in[min] = in[i];
            in[i] = temp;

        }
    }

    public String sortName() {
        return "Selection Sort";
    }
    public T printout(T[]in ,int i){
        return in[i];
    }
}
