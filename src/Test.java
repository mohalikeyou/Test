import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author CrazyYao
 * @create 2022-06-12 16:23
 */
public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        head = new ListNode(-1);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        while (index >= 0) {
            --index;
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode curr = new ListNode(val);
        curr.next = head.next;
        head.next = curr;
        ++size;
    }

    public void addAtTail(int val) {
        ListNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = new ListNode(val);
        ++size;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;

        ListNode curr = head;

        while (index > 0) {
            curr = curr.next;
            --index;
        }

        curr.next = new ListNode(val,curr.next.next);
        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;

        ListNode curr = head;

        while (index > 0) {
            curr = curr.next;
            --index;
        }

        curr.next = curr.next.next;

        --size;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//remote test
//remote test2








