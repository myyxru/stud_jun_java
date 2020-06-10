package T1;

public class gsm_method {
    static double price_litr_gsm100 = 46.10;
    static double price_litr_gsm200_400 = 48.90;
    static double price_litr_gsm300 = 47.50;
    static double rashod_100 = 12.5;
    static double rashod_200 = 12;
    static double rashod_300 = 11.5;
    static double rashod_400 = 20;

    public static int[] probeg(String[] gsm_arr) {
        String[] probeg_sub = new String[gsm_arr.length];
        int[] probeg = new int[15];
        int end;
        for (int i = 0; i < gsm_arr.length; i++) {
            probeg_sub[i] = gsm_arr[i].substring(7);
            if (probeg_sub[i].length() > 3) {
                probeg_sub[i] = probeg_sub[i].substring(0, probeg_sub[i].indexOf('-'));
            }

            probeg[i] = Integer.parseInt(probeg_sub[i]);
        }

        return probeg;

    }

    public static int[] codeauto(String[] gsm_arr) {
        String[] codeauto_sub = new String[gsm_arr.length];
        int end;
        int[] codeauto = new int[15];
        for (int i = 0; i < gsm_arr.length; i++) {
            codeauto_sub[i] = gsm_arr[i].substring(1, 4);
            codeauto[i] = Integer.parseInt(codeauto_sub[i]);
        }

        return codeauto;

    }


    public static void total_gsm(int[] probeg,int[]codeauto) {

        double total=0;
        double total100=0;
        double total200=0;
        double total300=0;
        double total400=0;
        double max=0;
        double min;
        int typemax=0;
        int typemin=0;
        for (int i = 0; i < probeg.length; i++) {
            switch (codeauto[i]) {
                case 100:
                    total = probeg[i] / 100.0 * rashod_100 * price_litr_gsm100 + total ;
                    total100 = probeg[i] / 100.0 * rashod_100 * price_litr_gsm100 + total100 ;
                    break;
                case 200:
                    total = probeg[i] / 100.0 * rashod_200 * price_litr_gsm200_400 + total;
                    total200 = probeg[i] / 100.0 * rashod_200 * price_litr_gsm200_400 + total200;
                    break;
                case 300:
                    total = probeg[i] / 100.0 * rashod_300 * price_litr_gsm300 + total;
                    total300 = probeg[i] / 100.0 * rashod_300 * price_litr_gsm300 + total300;
                    break;
                case 400:
                    total = probeg[i] / 100.0 * rashod_400 * price_litr_gsm200_400 + total;
                    total400 = probeg[i] / 100.0 * rashod_400 * price_litr_gsm200_400 + total400;
                    break;
                default:
                    break;
            }

        }

        System.out.printf("Общий расход:"+"%.2f",total);
        System.out.println();
        System.out.printf("Расход по классу C100:  "+"%.2f",total100);
        System.out.println();
        System.out.printf("Расход по классу C200:  "+"%.2f",total200);
        System.out.println();
        System.out.printf("Расход по классу C300:  "+"%.2f",total300);
        System.out.println();
        System.out.printf("Расход по классу C400:  "+"%.2f",total400);
        System.out.println();
        if (max<total100) {
            max=total100;
            typemax=100;
        }
        if (max<total200){
            max=total200;
            typemax=200;
        }
        if (max<total300){
            max=total300;
            typemax=300;
        }
        if (max<total400){
            max=total400;
            typemax=400;
        }
        System.out.printf("Максимальный расход у типа C"+typemax+" расход составил: "+"%.2f",max);
        System.out.println();
        min=total100;
        typemin=100;
        if (min>total200){
            min=total200;
            typemin=200;
        }
        if (min>total300){
            min=total300;
            typemin=300;
        }
        if (min>total400){
            min=total400;
            typemin=400;
        }
        System.out.printf("Минимальный расход у типа C"+typemin+" расход составил: "+"%.2f",min);
        System.out.println();
    }
}










