package T2;

public class Main2 {
     Main2() {
        int arr[] = arrayCreator();
    }

    int[] arrayCreator() {
        int arr[] = new int[9];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public void arraysout(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void lensout(int[] arr) {
        System.out.println(arr.length);
    }

    public int[] add(int[] arr, int add) {
        int[] arradd = new int[arr.length + 1];
        int i = 0;
        while (i < arradd.length - 1) {
            arradd[i] = arr[i];
            i++;
        }
        arradd[i] = add;
        return arradd;
    }

    public int[] add(int[] arr, int add, int pos) {
        int[] arradd = new int[arr.length + 1];
        for (int i = 0; i < arradd.length; i++) {
            if (i < pos) {
                arradd[i] = arr[i];
            }
            else if (i == pos) {
                arradd[i] = add;
            }
            else if (i > pos) {
                arradd[i] = arr[i - 1];
            }
        }
        return arradd;
    }

    public int[] delpos(int[] arr, int pos) {
        int[] arrafterdel = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < pos) {
                arrafterdel[i] = arr[i];
            }
            else if (i == pos) {
            }
            else if (i > pos) {
                arrafterdel[i - 1] = arr[i];
            }
        }
        return arrafterdel;
    }

    public int[] changepos(int[] arr, int pos, int value) {
        int[] arrafterchange = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i < pos) {
                arrafterchange[i] = arr[i];
            } else if (i == pos) {
                arrafterchange[i] = value;
            } else if (i > pos) {
                arrafterchange[i] = arr[i];
            }
        }
        return arrafterchange;
    }

    public int[] sort(int[] arr, String a) {
        if (a == "->") {
            for (int i = arr.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        else if (a == "<-") {
            for (int i = 0; i < arr.length; i++) {
                for (int j = arr.length - 1; j > 0; j--) {
                    if (arr[j] > arr[j - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                }
            }
        }
        return arr;
    }

    public void maxmin(int[] arr, String a) {
        int maxmin = 0;
        if (a == "max") {
            maxmin=arr[0];
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] < arr[i + 1]) {
                    maxmin = arr[i + 1];
                }
            }
        }
        else if (a == "min") {
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i]>arr[i+1]){
                    maxmin = arr[i+1];
                }
                    }
                }
        System.out.println(maxmin);
    }

    public int[] clone (int [] arr, int value){
        for (int i = 0; i < arr.length ; i++) {
            arr[i]=value;
        }
        return arr;
    }

    public static void main(String[] args) {
        Main2 main2class = new Main2();
        int [] massiv = main2class.arrayCreator();
        main2class.arraysout(massiv);
        System.out.println();
        main2class.lensout(massiv);
        System.out.println();
        int [] massivadd = main2class.add(massiv,999);
        main2class.arraysout(massivadd);
        System.out.println();
        massivadd = main2class.add(massiv,89, 6);
        main2class.arraysout(massivadd);
        System.out.println();
        massivadd=main2class.delpos(massivadd,6);
        main2class.arraysout(massivadd);
        System.out.println();
        massivadd=main2class.changepos(massivadd,7,111);
        main2class.arraysout(massivadd);
        System.out.println();
        massivadd=main2class.sort(massivadd,"<-");
        main2class.arraysout(massivadd);
        System.out.println();
        main2class.maxmin(massivadd,"min");
        System.out.println();
        main2class.clone(massivadd,88);
        main2class.arraysout(massivadd);
        }
}

