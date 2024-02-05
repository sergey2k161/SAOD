import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> stek = null;
        List<Integer> secondStek = null;
        int[] counter = {0};
        int action;

        while (true){
            System.out.println("\nВыбор необходимого действия:");
            System.out.println("**********************************************");
            System.out.println("* 1) Добавить элемент(ы) в вершину стека.    *");
            System.out.println("* 2) Показать состояние стека.               *");
            System.out.println("* 3) Удаление элемента из вершины стерка.    *");
            System.out.println("* 4) Вывод элементов вспомогательного стека. *");
            System.out.println("**********************************************");
            System.out.print("\nДейсвтие: ");
            try{
                action = scanner.nextInt();
                switch (action){
                    case 1:
                        if(stek == null){
                            stek = new ArrayList<>();
                        }
                        if(secondStek == null){
                            secondStek = new ArrayList<>();
                        }
                        AddItem(secondStek, stek, scanner, counter);
                        break;
                    case 2:
                        showStek(stek);
                        break;
                    case 3:
                        DellLastItem(secondStek, stek, counter, scanner);
                        break;
                    case 4:
                        showSecondStek(secondStek);
                        break;
                    default:
                        System.out.println("Некоректный ввод.");
                }
            } catch (InputMismatchException e){
                System.out.println("Ошибка: Давай по новой :D");
                scanner.next();
            }
        }
    }
    static void AddItem(List<Integer> secondStek,List<Integer> stek, Scanner scanner, int[] counter) {
        System.out.println("Каким способ добавить элементы?");
        System.out.println("1) Рандом.");
        System.out.println("2) Вручную.");
        System.out.println("3) Взять с вершины вспомогательного стека.");
        int methodAdd;
        try {
            methodAdd = scanner.nextInt();
            switch (methodAdd){
                case 1: // Рандом
                    int minValue = 10;
                    int maxValue = 20;
                    int randomValue = minValue + (int) (Math.random() * (maxValue - minValue + 1));
                    int randomNumItem = randomValue;
                    for(int i =0; i<randomNumItem; i++){
                        int newItem = minValue + (int) (Math.random() * (maxValue - minValue + 1));
                        stek.add(newItem);
                        counter[0]++;
                    }
                    break;
                case 2: // вручную
                    System.out.print("Введите колличество элементов которое хотите добавить: ");
                    int numItem = scanner.nextInt();

                    System.out.println("Вводите поочередно элементы которые хотите добавить.");
                    for(int i =0; i<numItem; i++){
                        if(i>numItem){
                            System.out.println("Введено больше элементов. ");
                            break;
                        }
                        int newItem = scanner.nextInt();
                        stek.add(newItem);
                        counter[0]++;
                    }
                    break;
                case 3: // С секонд стека
                    if (!secondStek.isEmpty() && secondStek != null) {
                        int removedElement = secondStek.remove(secondStek.size() - 1);
                        stek.add(removedElement);
                        counter[0]++;
                        System.out.println("Последний элемент перемещен в основной стек.");
                    } else {
                        System.out.println("Вспомогательный стек пуст. Нет элементов для перемещения.");
                    }
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }catch (InputMismatchException e){
            System.out.println("Ошибка: Давай по новой :D");
            scanner.next();
        }
    }
    static void DellLastItem(List<Integer> secondStek,List<Integer> stek, int[] counter, Scanner scanner){
        if(!stek.isEmpty() && stek != null){
            System.out.println("Какие действия совершить с удаленным элементом?");
            System.out.println("1)Удалить с освобождением памяти.");
            System.out.println("2)Включить его в вершину вспомогательного стека удаленных элементов.");
            int dellScaner;
            try{
                dellScaner = scanner.nextInt();
                switch (dellScaner){
                    case 1:
                        System.out.println("Удален элемент: " + (stek.size()-1));
                        stek.remove(stek.size()-1);
                        counter[0]--;
                        System.out.println("Последний элемент удален.");
                        break;
                    case 2:
                        System.out.println("Добавлен элемент: " + stek.get(stek.size() - 1));
                        secondStek.add(stek.get(stek.size() - 1));
                        stek.remove(stek.size() - 1);
                        counter[0]--;
                        System.out.println("Последний элемент перемещен в вспомогательный стек.");
                        break;
                    default:
                        System.out.println("Некорректный выбор.");
                }
            }catch (InputMismatchException e){
                System.out.println("Ошибка: Давай по новой :D");
                scanner.next();
            }
        }
        else {
            System.out.println("Стек пуст. Удаление не возможно.");
        }
    }
    static void showSecondStek(List<Integer> secondStek) {
        if (secondStek != null && !secondStek.isEmpty()) {
            System.out.print("Элементы в стеке: ");
            for (int element : secondStek) {
                System.out.print(element + " ");
            }
            System.out.println();
        } else {
            System.out.println("Стек пуст.");
        }
    }
    static void showStek(List<Integer> stek) {
        if (stek != null && !stek.isEmpty()) {
            System.out.print("Элементы в стеке: ");
            for (int element : stek) {
                System.out.print(element + " ");
            }
            System.out.println();
        } else {
            System.out.println("Стек пуст.");
        }
    }
}