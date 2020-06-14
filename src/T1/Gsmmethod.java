package T1;

public class Gsmmethod {
    double pricelitrgsm100 = 46.10;
    double pricelitrgsm200400 = 48.90;
    double pricelitrgsm300 = 47.50;
    double rashod100 = 12.5;
    double rashod200 = 12;
    double rashod300 = 11.5;
    double rashod400 = 20;

    public int[] probeg(String[] gsmArr) {
        String[] probegsub = new String[gsmArr.length]; //буферный массив для string
        int[] probeg = new int[15];
        for (int i = 0; i < gsmArr.length; i++) {
            probegsub[i] = gsmArr[i].substring(7);
            if (probegsub[i].length() > 3) {
                probegsub[i] = probegsub[i].substring(0, probegsub[i].indexOf('-'));
            }
            probeg[i] = Integer.parseInt(probegsub[i]);
        }
        return probeg;
    }

    public int[] codeauto(String[] gsmArr) {
        String[] codeautosub = new String[gsmArr.length];//буферный массив для string
        int[] codeauto = new int[15];
        for (int i = 0; i < gsmArr.length; i++) {
            codeautosub[i] = gsmArr[i].substring(1, 4);
            codeauto[i] = Integer.parseInt(codeautosub[i]);
        }
        return codeauto;
    }

    public void total_gsm(int[] probeg, int[] codeauto) {
        double total = 0;
        double total100 = 0;
        double total200 = 0;
        double total300 = 0;
        double total400 = 0;
        double max = 0;
        double min;
        int typemax = 0;
        int typemin;
        for (int i = 0; i < probeg.length; i++) {
            switch (codeauto[i]) {
                case 100:
                    total = probeg[i] / 100.0 * rashod100 * pricelitrgsm100 + total;
                    total100 = probeg[i] / 100.0 * rashod100 * pricelitrgsm100 + total100;
                    break;
                case 200:
                    total = probeg[i] / 100.0 * rashod200 * pricelitrgsm200400 + total;
                    total200 = probeg[i] / 100.0 * rashod200 * pricelitrgsm200400 + total200;
                    break;
                case 300:
                    total = probeg[i] / 100.0 * rashod300 * pricelitrgsm300 + total;
                    total300 = probeg[i] / 100.0 * rashod300 * pricelitrgsm300 + total300;
                    break;
                case 400:
                    total = probeg[i] / 100.0 * rashod400 * pricelitrgsm200400 + total;
                    total400 = probeg[i] / 100.0 * rashod400 * pricelitrgsm200400 + total400;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("Общий расход:" + "%.2f", total);
        System.out.println();
        System.out.printf("Расход по классу C100:  " + "%.2f", total100);
        System.out.println();
        System.out.printf("Расход по классу C200:  " + "%.2f", total200);
        System.out.println();
        System.out.printf("Расход по классу C300:  " + "%.2f", total300);
        System.out.println();
        System.out.printf("Расход по классу C400:  " + "%.2f", total400);
        System.out.println();
        if (max < total100) {
            max = total100;
            typemax = 100;
        }
        if (max < total200) {
            max = total200;
            typemax = 200;
        }
        if (max < total300) {
            max = total300;
            typemax = 300;
        }
        if (max < total400) {
            max = total400;
            typemax = 400;
        }
        System.out.printf("Максимальный расход у типа C" + typemax + " расход составил: " + "%.2f", max);
        System.out.println();
        min = total100;
        typemin = 100;
        if (min > total200) {
            min = total200;
            typemin = 200;
        }
        if (min > total300) {
            min = total300;
            typemin = 300;
        }
        if (min > total400) {
            min = total400;
            typemin = 400;
        }
        System.out.printf("Минимальный расход у типа C" + typemin + " расход составил: " + "%.2f", min);
        System.out.println();
    }

    public int[] gosnum(String[] gsmArr) {
        String[] gosnumsub = new String[gsmArr.length];//буферный массив для string
        int[] gosnum = new int[15];
        for (int i = 0; i < gsmArr.length; i++) {
            gosnumsub[i] = gsmArr[i].substring(5, 6);
            gosnum[i] = Integer.parseInt(gosnumsub[i]);
        }
        return gosnum;
    }

    public int[] param(String[] gsmArr) {
        String[] paramsub = new String[gsmArr.length];//буферный массив для string
        int[] param = new int[15];
        for (int i = 0; i < gsmArr.length; i++) {
            if (gsmArr[i].length() > 10) {
                paramsub[i] = gsmArr[i].substring(gsmArr[i].lastIndexOf('-') + 1);
                param[i] = Integer.parseInt(paramsub[i]);
            } else {
                param[i] = 0;
            }
        }
        return param;
    }

    public void sortprobeg(int[] codeauto, String[] gsmArr, int[] probeg,int code) {
        int lensort=0; //длина для создания массива с  одним кодом авто
        for (int i = 0; i < codeauto.length; i++) {
            if (codeauto[i] == code) {
                lensort++;
            }
        }
        String[] forsort = new String[lensort]; //массив для одного кода авто
        int [] probegforsort = new int[lensort]; //массив для сортировки со значениями интового пробега для условия
        int j = 0;
        for (int i = 0; i < codeauto.length; i++) {
            if (codeauto[i] == code) {
                forsort[j] = gsmArr[i];
                probegforsort[j] = probeg[i];
                j++;
            }
        }
        for (int i = forsort.length - 1; i > 0 ; i--) {
            for (int k = 0; k < i; k++) {
                if ( probegforsort[k] > probegforsort[k + 1]) {
                    int temprobeg = probegforsort[k]; //буфер для пузырька
                    probegforsort[k] = probegforsort[k+1];
                    probegforsort[k+1] = temprobeg;
                    String tempstr = forsort[k]; //буфер для пузырька
                    forsort[k] = forsort[k+1];
                    forsort[k+1] = tempstr;
                }
            }
        }
        for (int i = 0; i < forsort.length; i++) {
            System.out.println(forsort[i]);

        }
        System.out.println();
    }

    public void sortparam(int[] codeauto, String[] gsmArr,  int[] probeg, int[] param,int code) {
        int lensort=0; //длина для создания массива с  одним кодом авто
        for (int i = 0; i < codeauto.length; i++) {
            if (codeauto[i] == code) {
                lensort++;
            }
        }
        String[] forsort = new String[lensort]; //массив для одного кода авто
        int [] paramforsort = new int[lensort]; //массив для сортировки со значениями интового пробега для условия
        int j = 0;
        for (int i = 0; i < codeauto.length; i++) {
            if (codeauto[i] == code) {
                forsort[j] = gsmArr[i];
                paramforsort[j] = param[i];
                j++;
            }
        }
        int hidesout=0;
        for (int i = forsort.length - 1; i > 0 ; i--) {
            if (paramforsort[i]==0){
                sortprobeg(codeauto,gsmArr,probeg,code); // если параметр отсутствует делает сортировку по пробегу
                break;}
                else {
            for (int k = 0; k < i; k++) {
                hidesout++;
                if ( paramforsort[k] > paramforsort[k + 1]) {
                    int tempparam = paramforsort[k]; //буфер для пузырька
                    paramforsort[k] = paramforsort[k + 1];
                    paramforsort[k + 1] = tempparam;
                    String tempstr = forsort[k]; //буфер для пузырька
                    forsort[k] = forsort[k + 1];
                    forsort[k + 1] = tempstr;
                    }
                }
            }
        }
        if (hidesout!=0){
            for (int i = 0; i < forsort.length; i++) {
                System.out.println(forsort[i]);
             }
        }
        System.out.println();
    }
}









