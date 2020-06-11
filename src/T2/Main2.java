package T2;

public class Main2 {
    Main2() {
        int arr[] = arrayCreator(10);
    }
    public int[] arrayCreator ( int index){
        int arr[] = new int[index];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

//    public static void main(String[] args) {
//        Main2 arr2 = new Main2();
//        for (int i:arr2) {
//            System.out.println(arr2[i]);
//        }



        //public void add ( int a, int index){
       // }

    }


