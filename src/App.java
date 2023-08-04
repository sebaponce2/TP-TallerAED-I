import java.util.Scanner;
import List.LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        int option, index;
        String value;

        while (flag) {
            System.out.println("\nPor favor, indique una de las siguientes opciones:");
            System.out.println("1 - Insertar un nuevo elemento.");
            System.out.println("2 - Insertar un nuevo elemento por posicion.");
            System.out.println("3 - Eliminar un elemento.");
            System.out.println("4 - Buscar un elemento.");
            System.out.println("5 - Modificar un elemento.");
            System.out.println("6 - Imprimir la lista completa.");
            System.out.println("7 - Ordenar la lista.");
            System.out.println("X - Cualquier otro numero para salir.");
            System.out.println();
            option = input.nextInt();


            switch (option) {
                case 1:
                    System.out.println("Por favor, ingrese el valor del elemento.");
                    input.nextLine();
                    value = input.nextLine();

                    list.insert(value);

                    break;
                case 2:
                    System.out.println("Por favor, ingrese el valor del elemento.");
                    input.nextLine();
                    value = input.nextLine();

                    System.out.println("Por favor, ingrese la posicion.");
                    index = input.nextInt();

                    list.insert(value, index);

                    break;
                case 3:
                    System.out.println("Por favor, ingrese el valor del elemento a eliminar.");
                    input.nextLine();
                    value = input.nextLine();

                    list.delete(value);

                    break;
                case 4:
                    System.out.println("Por favor, ingrese el valor del elemento a buscar.");
                    input.nextLine();
                    value = input.nextLine();

                    System.out.println();
                    list.searchElement(value);
                    
                    break;
                case 5:
                    System.out.println("Por favor, ingrese el valor del elemento a modificar.");
                    input.nextLine();
                    value = input.nextLine();
                    
                    list.modifyElementByConsole(value);

                    break;
                case 6:
                    System.out.println();
                    list.printElements();

                    break;
                case 7:
                    System.out.println();
                    list.sort();

                    break;
                default:
                    flag = false;
                    break;
            }
            

        }
        
    }
}
