package linkedlist.base;

import java.util.List;

public interface BaseLinkedList<T extends BaseNode> {

    T arrayToLinkedList(int arr[]);

    void printLinkedList(T head);

    int lengthOfLinkedList(T head);

    boolean searchElement(T head, int target);

    List<Integer> linkedListToList(T head);

    int[] linkedListToArray(T head);

    T insertAtHead(T head, int x);

    T insertAtTail(T head, int X);

    T insertAtKPosition(T head, int X, int K);

    T insertBeforeX(T head, int x, int val);

    T deleteHeadNode(T head);

    T deleteTailNode(T head);

    T deleteKthNode(T head, int k);

    T deleteNodeWithValueX(T head, int X);




}
