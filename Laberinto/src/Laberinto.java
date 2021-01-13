public class Laberinto {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int el = 3;
        int pos = bu(array, el, 0);
        System.out.println(pos);

    }

    public static int bu(int[] array, int el, int indice) {

        if (indice == array.length || array[indice] == el) {

            if (indice == array.length) {

                return -1;

            } else {
                return indice;
            }

        } else {

            return bu(array, el, indice + 1);
        }

    }
}