/*
378. Kth Smallest Element in a Sorted Matrix
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[(int)Math.pow(matrix.length,2)+1];
        int index = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                arr[index++] = matrix[i][j];
            }
        }
        buildMinHeap(arr);
        int length = arr.length-1;
        int kthMin = 0;
        while(k--!=0){
            kthMin = deleteMin(arr,length);
            length--;
        }
        return kthMin;
    }
    
    public void buildMinHeap(int[] a){
        for(int i=(a.length-1)/2;i>0;i--){
            heapify(a,i,a.length-1);
        }
    }
    public void heapify(int[] a,int i,int length){
        int left = i*2;
        int right = i*2+1;
        int min = i;
        if(left<=length && a[i]>a[left]){
            min = left;
        }
        if(right<=length && a[min]>a[right]){
            min = right;
        }
        if(min!=i){
        	swap(a,min,i);
            heapify(a,min,length-1);
        }
    }
    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public int deleteMin(int[] a,int length){
        int min = a[1];
        swap(a,1,length);
        heapify(a,1,length-1);
        return min;
    }
}
