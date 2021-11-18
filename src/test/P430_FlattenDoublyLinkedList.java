package test;

import java.util.Stack;

public class P430_FlattenDoublyLinkedList {

    public Node flatten(Node head) {
        Node temp = head;
        Node prev = null;
        Node next;
        Node child;
        Stack<Node> stack = new Stack<>();

        while (temp != null || !stack.isEmpty()) {
            // if stack has something
            if (temp == null) {
                next = stack.pop();
                prev.next = next;
                next.prev = prev;
                temp = next;
            }

            // if current linkedlist has something
            if (temp.child == null) {
                prev = temp;
                temp = temp.next;
            } else {
                // if has child, store child
                child = temp.child;
                // disconnect child
                temp.child = null;
                prev = temp;
                if (temp.next != null) {
                    // if has next, disconnect and store in stack
                    temp.next.prev = null;
                    stack.push(temp.next);
                }
                // connect temp and child
                temp.next = child;
                child.prev = temp;
                temp = child;
            }
        }
        return head;
    }
}
