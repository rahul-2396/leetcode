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
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        ListNode previous = head;
        ListNode current = head.next;
        int count = 1;
        List<Integer> list = new ArrayList<>();
        while(current != null && current.next != null)
        {
            count += 1;
            if((current.val > previous.val && current.val > current.next.val ) || (current.val < previous.val && current.val < current.next.val ))
            {
                list.add(count);
            }
            previous = current;
            current = current.next;
        }
        if(list.size() < 2)
        {
            return new int[] {-1, -1};
        }
        int maxElement = list.get(0);
        int minElement = list.get(0);
        for(int num : list)
        {
            if(num > maxElement)
            {
                maxElement = num;
            }
            if(num < minElement)
            {
                minElement = num;
            }
        }
        int maxDifference = maxElement - minElement;
        int minDifference = Integer.MAX_VALUE;
        Collections.sort(list);
        for(int i = 1; i < list.size(); i++)
        {
            int difference = list.get(i) - list.get(i - 1);
            if(difference < minDifference)
            {
                minDifference = difference;
            }
        }
        return new int[] {minDifference, maxDifference};
    }
}