public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null, oddTail = null, evenHead = null, evenTail = null;
        int i = 1;
        while (head != null) {
            if (i % 2 == 1) {
                if (oddTail == null) {
                    oddHead = head;
                    oddTail = oddHead;
                } else {
                    oddTail.next = head;
                    oddTail = head;
                }
            } else {
                if (evenTail == null) {
                    evenHead = head;
                    evenTail = evenHead;
                } else {
                    evenTail.next = head;
                    evenTail = head;
                }
            }
            head = head.next;
            i++;
        }

        if (oddTail == null) {
            return null;
        } else {
            oddTail.next = evenHead;
            if(evenTail!=null){
                evenTail.next = null;
            }
            return oddHead;
        }
    }

}
