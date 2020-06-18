import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList implements Iterable<String> {
    /**
     * Константа - сообщение для ошибки.
     */
    private String msgException = "The element is not found...";

    /**
     * Переменная хранит кол-во элементов в списке.
     */
    private int size;

    /**
     * Ссылка на первый элемент в списке.
     */
    private Node first;

    /**
     * Ссылка на последний элемент в списке.
     */
    private Node last;

    /**
     * Пустой (дефолтный) конструктор.
     */
    MyLinkedList() {
    }

    /**
     * Конструктор, который позваляет сразу добавить массив в список.
     *
     * @param values - массив для добавления;
     */
    MyLinkedList(String... values) {
        this.addAll(values);
    }

    /**
     * Метод возвращает кол-во элементов в списке.
     *
     * @return кол-во элементов;
     */
    public int size() {
        return this.size;
    }

    /**
     * Метод проверяет, пустой ли наш список или нет.
     * Проверка происходит по переменной size. Если она 0, то список пуст.
     *
     * @return true - список пуст, либо false;
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Метод очищает все данные в списке.
     * По сути просто присваиваем переменной кол-ва элементов 0
     * и обнуляем ссылки на первый и конечный элемент
     */
    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * Возвращаем список в виде массива типа Object[].
     *
     * @return массив элементов из списка типа Object
     */
    public String[] toArray() {
        String[] resultArray = new String[this.size];
        int index = 0;
        for (Node link = this.first; link != null; link = link.next) {
            resultArray[index++] = link.value;
        }
        return resultArray;
    }

    /**
     * Метод возвращает список в виде строки.
     * Используем для вывода списка, какмассив через класс Arrays и метод toString()
     *
     * @return список в виде строки;
     */
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    /**
     * Добавляем элемент в список в конец.
     *
     * @param value - элемент для добавления
     */
    public void add(String value) {
        if (this.first == null) {
            first = new Node(null, null, value);
        } else {
            Node prevElement = this.last == null ? this.first : this.last;
            this.last = new Node(prevElement, null, value);
            prevElement.next = this.last;
        }
        this.size++;
    }

    /**
     * Метод проверяет, входит ли индекс вдиапазон списка.
     *
     * @param index - индекс для проверки;
     * @return true - если корректный индекс или false;
     */
    private boolean checkIndexToRange(int index) {
        return index >= 0 && index < this.size;
    }

    /**
     * Получаем ссылку на Node (внутренний класс для хранения элементов в списке)
     * по индексу. Если индекс больше чем кол-во элементов поделить на 2, то
     * ищем циклом с конца списка, или поиск начинаем с начала.
     *
     * @param index - индекс для поиска элемента;
     * @return ссылку (Node)
     */
    private Node getLinkByIndex(int index) {
        Node result;
        if (this.size >> 1 >= index) {
            result = this.first;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = this.last;
            for (int i = this.size - 1; i > index; i--) {
                result = result.prev;
            }
        }
        return result;
    }

    /**
     * Метод добавляет массив элементов в список.
     * использует метод add()
     *
     * @param values - массив элементов;
     * @return true - если все элементы добавлены или false;
     */
    public boolean addAll(String... values) {
        boolean result = values != null && values.length > 0;
        if (result) {
            for (String value : values) {
                add(value);
            }
        }
        return result;
    }

    /**
     * Метод возвращает элемент из списка по индексу.
     * Использует метод поиска ссылки на элемент по индексу и
     * метод проверки корректности индекса
     * Если индекс некорректный, то выбрасывается исключение NoSuchElementException
     *
     * @param index - индекс для возврата элемента;
     * @return элемент по индексу;
     */
    public String get(int index) {
        String result;
        if (checkIndexToRange(index)) {
            result = getLinkByIndex(index).value;
        } else {
            throw new NoSuchElementException(this.msgException);
        }
        return result;
    }

    /**
     * Удаляем элемент из списка по Node.
     *
     * @param node - элемент для удаления;
     * @return true - если удаление прошло успешно или false;
     */
    private boolean deleteByLink(Node node) {
        boolean result = node != null;
        if (result) {
            if (node.next == null && node.prev == null) {
                first = null;
                last = null;
            } else if (node.prev == null) {
                first = node.next;
                first.prev = null;
            } else if (node.next == null) {
                last = node.prev;
                last.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }
        return result;
    }

    /**
     * Метод удаляет элемент по индексу.
     * использует метод проверки индекса и метод для удаления элемента по Node.
     *
     * @param index - индекс для удаления;
     * @return true - если индекс корректный или false;
     */
    public boolean delete(int index) {
        boolean result = checkIndexToRange(index);
        if (result) {
            result = deleteByLink(getLinkByIndex(index));
        }
        return result;
    }

    /**
     * Метод добавляет элемент в список в определённый индекс. При этом раздвигает другие элементы.
     *
     *
     * @param index - индес, куда следует вставить элемент в список;
     * @param value - значение для вставки;
     * @return true - если индекс корректный и элемент был добавлен или false
     */
    public boolean add(int index, String value) {
        boolean result = true;
        if (index == this.size) {
            add(value);
        } else if (checkIndexToRange(index)) {
            Node oldElement = getLinkByIndex(index);
            Node newElement = new Node(oldElement.prev, oldElement, value);
            if (oldElement.prev == null) {
                this.first = newElement;
                this.last = oldElement;
            } else {
                oldElement.prev.next = newElement;
                oldElement.prev = newElement;
            }
            this.size++;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Метод по заданию. Идём циклом по элементам типа Node.
     * У каждого Node получаем value (String)
     * Затем смотрим, ести ли переданный в метод символ в value методом contains()
     * Если есть, то идём циклом по строке и перед каждым сиволом, переданным в метод
     * ставим его индес и затем перезаписываем новую строку за место старой.
     *
     * @param symbol - символ для поиска по строке (value);
     */
    public void updateLinkedByTask(char symbol) {
        if (!isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Node node = this.first; node != null; node = node.next) {
                String value = node.value;
                if (value != null && value.indexOf(symbol) != -1) {
                    sb.delete(0, sb.length());
                    for (int index = 0; index < value.length(); index++) {
                        if (value.charAt(index) == symbol) {
                            sb.append(index);
                        }
                        sb.append(value.charAt(index));
                    }
                    node.value = sb.toString();
                }
            }
        }
    }

    /**
     * Метод изменяет данные по индексу на новые.
     *
     * @param index - индекс для изменнеия данных;
     * @param value - данные, на которые хотим заменить;
     * @return возвращаем старые данные, которые были до перезаписи;
     */
    public String update(int index, String value) {
        String result;
        if (checkIndexToRange(index)) {
            Node temp = getLinkByIndex(index);
            result = temp.value;
            temp.value = value;
        } else {
            throw new NoSuchElementException(this.msgException);
        }
        return result;
    }

    /**
     * Переопределённый метод iterator(). Служит для возможности работать со списком через
     * итератор или цикл foreach
     *
     * @return итератор для нашего списка;
     */
    @Override
    public Iterator<String> iterator() {
        return new IteratorLinked();
    }

    /**
     * Вспомогательный класс Node для хранения элементов в списке.
     */
    private class Node {
        /**
         * Ссылка на предыдущий элемент Node.
         */
        private Node prev;

        /**
         * Ссылка на следующий элемент Node.
         */
        private Node next;

        /**
         * сам элемент, который храним в списке.
         */
        private String value;

        /**
         * Конструктор для класса Node.
         *
         * @param prev - ссылка на предыдущий элемент;
         * @param next - ссылка на следующий элемент;
         * @param value - значение, которое храним в списке;
         */
        Node(Node prev, Node next, String value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    /**
     * Класс, наследник интерфейса Iterator.
     * Свой итератор для нашего списка.
     */
    private class IteratorLinked implements Iterator<String> {
        /**
         * Курсор - место, откуда начинаем двигаться по списку.
         */
        private Node cursor = first;

        /**
         * Проверяет, есть ли следующий элемент в списке.
         * На самом деле он уже стоит на том элементе, который выведется следующим.
         * Он просто смотрит, что курсор не равен null.
         *
         * @return true - если элемент существует и можно его вывести.
         */
        @Override
        public boolean hasNext() {
            return this.cursor != null;
        }

        /**
         * Возвращаем элемент из списка и переключаем курсор на следующий элемент.
         * Если мы пытаемся вывести элемент, которого нет, то будет выброшено исключение.
         *
         * @return элемент из списка, на котором стоит курсор.
         */
        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException(msgException);
            }
            String result = cursor.value;
            this.cursor = this.cursor.next;
            return result;
        }
    }
}

class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAll("sfdsf", "fsDSdfss", "asdefsdaS", "sssssss", "rewreSdadS");
        System.out.println(list);
        list.updateLinkedByTask('S');
        System.out.println(list);
    }
}