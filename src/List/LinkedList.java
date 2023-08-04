package List;

import java.util.Objects;
import java.util.Scanner;

public class LinkedList implements List, Sortable {
    private Node first;

    @Override
    public boolean insert(String value) {
        Node newNode = new Node(value);

        newNode.setNext(first);
        first = newNode;

        return true;
    }

    @Override
    public boolean insert(String value, int pos) {
        Node aux = first;
        int count = 1;

        if (aux != null) {
            Node newNode = new Node(value);

            while (count < pos - 1 && aux.getNext() != null) {
                aux = aux.getNext();
                count++;
            }

            if (count == pos - 1) {
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
            } else if (count == pos) {
                newNode.setNext(aux);
                first = newNode;
            } else {
                if (count != pos - 1)
                    System.out.println(
                            "No hay suficientes elementos para insertar en la posicion deseada. Se insertara al final de la firsta");
                aux.setNext(newNode);
            }

            return true;
        } else {
            insert(value);
        }
        return false;
    }

    @Override
    public boolean delete(String value) {
        boolean toReturn = false;
        if (first != null) {
            if (Objects.equals(value, first.getValue()) && first.getNext() == null) {
                first = null;
                toReturn = true;
            } else if (Objects.equals(value, first.getValue())) {
                first = first.getNext();
                toReturn = true;
            } else {
                Node aux = first;
                System.out.println(aux.getValue());
                while (aux.getNext() != null && !aux.getNext().getValue().equals(value)) {
                    aux = aux.getNext();
                }

                if (aux.getNext() != null) {
                    aux.setNext(aux.getNext().getNext());
                    toReturn = true;
                }
            }
        }
        if (!toReturn) System.out.println("No se encontro el elemento a eliminar.");
        return toReturn;
    }

    @Override
    public Node searchElement(String value) {
        Node aux = first;
        int count = 1;
        while (aux != null) {
            if (Objects.equals(aux.getValue(), value)) {
                System.out.println("Elemento encontrado en la posicion " + count);
                return aux;
            } else {
                aux = aux.getNext();
                count++;
            }
        }
        System.out.println("Elemento no encontrado.");
        return aux;
    }

    @Override
    public Node modifyElementByConsole(String toModifyValue) {
        Scanner input = new Scanner(System.in);
        String newValue;
        Node output = null;
        //testeando push
        if (first != null) {

            Node aux = first;
            while (aux != null) {

                if (aux.getValue().equals(toModifyValue)) {
                    output = aux;
                    System.out.println("Por favor, ingrese el nuevo valor.");
                    newValue = input.nextLine();
                    output.setValue(newValue);
                }
                aux = aux.getNext();
            }
        }

        return output;

    }

    @Override
    public void printElements() {
        if (first == null) {
            System.out.println("-");
        } else {

            Node aux = first;
            while (aux != null) {

                System.out.print("[" + aux.getValue() + "]-->");
                aux = aux.getNext();
            }
            System.out.println();
        }
    }

    @Override
    public void sort() {
        first = sortList(first);
    }

    private Node sortList(Node head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        
       Node middle = findMiddle(head);
       Node nextOfMiddle = middle.getNext();

       middle.setNext(null);

        Node leftSide = sortList(head);
        Node rightSide = sortList(nextOfMiddle);

        return merge(leftSide, rightSide);
    }

    private Node merge(Node l1, Node l2) {

        Node sortedTemp = new Node("");
        Node currentNode = sortedTemp;

        while (l1 != null && l2 != null) {
            
            int key = l1.getValue().compareToIgnoreCase(l2.getValue());
            
            if (key < 0) {
                currentNode.setNext(l1);
                l1 = l1.getNext();
            } else if (key == 0) {
                currentNode.setNext(l1);
                l1 = l1.getNext();
            } else if (key > 0) {
                currentNode.setNext(l2);
                l2 = l2.getNext();
            }

            currentNode = currentNode.getNext();
        }

        currentNode.setNext((l1 == null) ? l2 : l1); 

        return sortedTemp.getNext();
    }

    private Node findMiddle(Node head) {
        if (head == null)
            return head;
 
        Node slow = head, fast = head;
 
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

}