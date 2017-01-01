/*
148. Sort List
Sort a linked list in O(n log n) time using constant space complexity.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode temp = head;
        List<ListNode> list = new LinkedList<ListNode>();
        while(temp!=null){
            list.add(temp);
            temp = temp.next;
        }
        ListNode[] arr = list.toArray(new ListNode[0]);
        quickSort(arr,0,arr.length-1);
        for(int i=1;i<arr.length;i++){
            arr[i-1].next = arr[i];
        }
        arr[arr.length-1].next = null;
        return arr[0];
    }
    public void quickSort(ListNode[] a,int left,int right){
        if(right-left>1){
            int pivot = median3(a,left,right);
            int i = left;
            int j = right-1;
            while(true){
                while(a[++i].val<pivot){}
                while(a[--j].val>pivot){}
                if(i<j){
                    swap(a,i,j);
                }
                else
                    break;
            }
            swap(a,i,right-1);
            quickSort(a,left,i-1);
            quickSort(a,i+1,right);
        }
        else{
            if(a[left].val>a[right].val){
                swap(a,left,right);
            }
        }
    }
    public void swap(ListNode[] a,int i,int j){
        ListNode temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public int median3(ListNode[] a,int left,int right){
        int center = (left+right)/2;
        if(a[left].val>a[center].val){
            swap(a,left,center);
        }
        if(a[center].val>a[right].val){
            swap(a,center,right);
        }
        if(a[left].val>a[center].val){
            swap(a,left,center);
        }
        swap(a,right-1,center);
        return a[right-1].val;
    }
}
