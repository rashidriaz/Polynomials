package calculator.polynomials.dsa;

public class Sort {
    public static void sort(AlgebraicTerm[] array, int left, int right){
        if(left < right)
        {
            int q = partition(array, left, right);
            sort(array, left, q);
            sort(array, q + 1, right);
        }
    }
    private static int partition(AlgebraicTerm[] array, int left, int right){
        AlgebraicTerm pivot = array[left];
        int i = left;
        for(int j = left + 1; j <= right; j++){
            if (array[j].exponent > pivot.exponent){
                i = i + 1;
                AlgebraicTerm temp = array[i];
                array[i]= array[j];
                array[j]= temp;
            }
        }

        AlgebraicTerm temp = array[i];
        array[i] = array[left];
        array[left] = temp;

        return i;

    }
}
