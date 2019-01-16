/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int buffer = 0;
        while(l1 != null || l2 != null || buffer != 0){
            int temp = buffer;
            if(l1!=null){
                temp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            buffer = temp / 10;
            temp = temp % 10;
            if(current == null){
                result = new ListNode(temp);
                current = result;
            }else{
                current.next = new ListNode(temp);
                current = current.next;
            }
        }
        return result;
    }
}