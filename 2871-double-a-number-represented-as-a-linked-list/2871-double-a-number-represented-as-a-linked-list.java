/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode doubleIt(ListNode head) 
    {
        ListNode reversedList = reverseList(head);
        ListNode current = reversedList;
        ListNode previous = null;
        int carry = 0;
        while(current != null)
        {
            int newValue = current.val * 2 + carry;
            current.val = newValue % 10;
            if(newValue > 9)
            {
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            previous = current;
            current = current.next;
        }
        if(carry != 0)
        {
            ListNode extraNode = new ListNode(carry);
            previous.next = extraNode;
        }
        ListNode result = reverseList(reversedList);
        return result;
    }
    public ListNode reverseList(ListNode node)
    {
        ListNode previous = null;
        ListNode current = node;
        ListNode nextNode;
        while(current != null)
        {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}