

public class Solutions {

    /* Problem 24. Swap Nodes in Pairs
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     *  Problem description:
     *  Given a linked list, swap every two adjacent nodes and return its head.
     *  You must solve the problem without modifying the values in the list's nodes
     *  (i.e., only nodes themselves may be changed.)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode firstNode = cur.next;
            ListNode secondNode = cur.next.next;
            firstNode.next = secondNode.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    /* Problem 707. Design Linked List
     * https://leetcode.com/problems/design-linked-list/
     *  Problem description:
     *  Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
     *  A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
     *  If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

     *  Implement the MyLinkedList class:

     *  MyLinkedList() Initializes the MyLinkedList object.
     *  int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
     *  void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     *  void addAtTail(int val) Append a node of value val as the last element of the linked list.
     *  void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
     *  void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
     */

    class MyLinkedList {
        int size;
        ListNode head;

        public MyLinkedList() {
            head = new ListNode(0);
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            ListNode prev = head;
            ListNode newNode = new ListNode(val);
            size++;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode prev = head;
            size--;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }
}
