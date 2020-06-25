package MainTask3;

public class ReshetoEratosfen {
    public int[] algoritmresheto(int max) {

            int z = max + 1;
            boolean[] f = new boolean[z];
            int i;
            // Заполняем массив true
            for (i = 0; i < z; i++)
                f[i] = true;
            f[0] = f[1] = false; //Удаляем числа, которые точно не простые 0 и 1
            // Алгоритм Решето Эратосфена
            int j;
            for (i = 2; i < Math.sqrt(z) + 1; i++) {
                // Вычеркиваем числа кратные данному числу
                if (f[i]) {
                    for (j = 2 * i; j < z; j += i) {
                        f[j] = false;
                    }
                }
            }
            // Подсчитываем количество простых чисел
            int c = 0;
            for (i = 0; i < z; i++) {
                if (f[i])
                    c++;
            }
            int[] arr = new int[c];
            // Итоговый массив
            for (i = 0, j = 0; i < z; i++) {
                if (f[i])
                    arr[j++] = i;
            }


        return arr;
    }

}