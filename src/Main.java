import java.util.Arrays;

public class Main {
	
	//=================LINKED LIST MERGESORT====================
	public static LinkedList.Node mergeSortedLL(LinkedList.Node a, LinkedList.Node b) {
		LinkedList.Node finalnode = null;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.data >= b.data) {
			finalnode = b;
			finalnode.next = mergeSortedLL(a, b.next);
		} else {
			finalnode = a;
			finalnode.next = mergeSortedLL(a.next, b);
		}
		return finalnode;
	}

	public static LinkedList.Node mergeSortLL(LinkedList.Node head) {
		//Base case if head is null or if head is only element in linked list
		if (head == null || head.next == null) {
			return head;
		}
		//Get middle
		int llLength = 0;
		llLength = LinkedList.findLengthLL2(head);
		LinkedList.Node middleNode = head;
		for (int i = 0; i < (llLength/2); i++) { //loops through half the list
			middleNode = middleNode.next;
		}
		LinkedList.Node nextMiddleNode = middleNode.next;
		middleNode.next = null;
		
		//mergeSort on the left and right list
		LinkedList.Node a = mergeSortLL(head);
		LinkedList.Node b = mergeSortLL(nextMiddleNode);
		LinkedList.Node sorted = mergeSortedLL(a, b);
		return sorted;
	}
	//===========================================================
	
	//=====================QUICKSORT=============================
	
	public static int qsPartition(int[] array, int low, int high) { //changed to int
		int i, j;
		int pivotItem = array[low]; //changed to int
		j = low;
		for (i = low + 1; i <= high; i++) {
			if (array[i] < pivotItem) {
				j++;
				//exchange array[i] and array[j]
				int temp = array[i]; //changed to int
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int pivotPoint = j;
		int temp2 = array[low]; //changed to int
		array[low] = array[pivotPoint];
		array[pivotPoint] = temp2;
		return pivotPoint;
	}
	
	public static void quickSort(int[] array, int low, int high) { //changed to int
		if (high > low) {
			int partitionIndex = qsPartition(array, low, high);
			quickSort(array, low, partitionIndex-1);
			quickSort(array, partitionIndex+1, high);
		}
	}
	
	//===========================================================
	
	//=====================QUICKSORT 2===========================
	
	public static int qsPartition2(int[] array, int low, int high) { //changed to int
		int i, j;
		int pivotItem = array[low]; //changed to int
		i = low;
		j = high+1;
		do {
			i++;
		} while (i < high && array[i] <= pivotItem);
		do {
			j--;
		} while (array[j] > pivotItem);
		while (i < j) {
			int temp = array[i]; //changed to int
			array[i] = array[j];
			array[j] = temp;
			do {
				i++;
			} while (array[i] <= pivotItem);
			do {
				j--;
			} while (array[j] > pivotItem);
		}
		int pivotPoint = j;
		int temp2 = array[low]; //changed to int
		array[low] = array[pivotPoint];
		array[pivotPoint] = temp2;
		return pivotPoint;
	}
	
	public static void quickSort2(int[] array, int low, int high) { //changed to int
		if (high > low) {
			int partitionIndex = qsPartition2(array, low, high);
			quickSort2(array, low, partitionIndex-1);
			quickSort2(array, partitionIndex+1, high);
		}
	}
	
	//===========================================================
	
	//======================MERGESORT============================
	
	public static void merge(int[] left, int[] right, int[] S, int l, int r) {
	      
	      int i = 0, j = 0, k = 0;
	      while (j < l && k < r) {
	          if(left[j] < right[k]){
	              S[i++] = left[j++];
	          } else {
	              S[i++] = right[k++];
	          }
	      }
	      while (j < l) {
	          S[i++] = left[j++];
	      }
	      while (k < r) {
	        S[i++] = right[k++];
	      }
	  }

	  public static void mergeSort(int [] S, int n){
	      if (n > 1) {
	    	  int mid = n / 2;
	    	  int m = n - mid;
	    	  int [] left = new int[mid];
	    	  int [] right = new int[m];
	      
	    	  int k = 0;
	    	  for(int i = 0; i < n; ++i){
	    		  if(i<mid){
	    			  left[i] = S[i];
	    		  } else {
	    			  right[k] = S[i];
	    			  k = k+1;
	    		  }
	    	  }
	    	  mergeSort(left, mid);
	    	  mergeSort(right, m);
	    	  merge(left, right, S, mid, m);
	      }
	  }
	
	//===========================================================
	
	//======================MERGESORT 2==========================
	
	  public static int[] merge2(int arr[], int arr2[])
	    {
	        int i = 0;
	        int j = 0;
	        int k = 0;
	        int temp[] = new int[arr.length + arr2.length];

	        while(i < arr.length && j < arr2.length)
	        {
	            if(arr[i] < arr2[j])
	            {
	                temp[k++] = arr[i++];
	            }
	            else
	            {
	                temp[k++] = arr2[j++];
	            }
	        }

	        while(i<arr.length)
	        {
	            temp[k++] = arr[i++];
	        }

	        while(j<arr2.length)
	        {
	            temp[k++] = arr2[j++];
	        }

	        return temp;
	    }
	  
	//===========================================================
	
	/* PRINT ARRAY HELPER METHOD */
	public static void printArray(int[] array) { //changed to int
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[10];
		int[] array2 = new int[10];
		int[] array3 = new int[10];
		int[] array4 = new int[10];
		int[] array5 = new int[10];
		int[] array6 = new int[10];
		int[] array7 = new int[10];
		int[] array8 = new int[10];
		int[] array9 = new int[10];
		int[] array10 = new int[10];
		
		//==============POPULATE ARRAYS=====================
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			array[i] = (int) Math.floor(100*Math.random());
			array2[i] = (int) Math.floor(100*Math.random());
			array3[i] = (int) Math.floor(100*Math.random());
			array4[i] = (int) Math.floor(100*Math.random());
			array5[i] = (int) Math.floor(100*Math.random());
			array6[i] = (int) Math.floor(100*Math.random());
			array7[i] = (int) Math.floor(100*Math.random());
			array8[i] = (int) Math.floor(100*Math.random());
			array9[i] = (int) Math.floor(100*Math.random());
			array10[i] = (int) Math.floor(100*Math.random());
			list.insert(list, array[i]);
		}

		System.out.println("==================== LINKED LIST MERGESORT ====================");
		System.out.print("Unsorted List: ");
		LinkedList.printListNode(list.head);
		LinkedList.Node sortedList = mergeSortLL(list.head);
		System.out.print("Sorted List: ");
		LinkedList.printListNode(sortedList);

		System.out.println("==================== QUICKSORT ====================");
		System.out.print("Unsorted List: ");
		printArray(array);
		int n = array.length;
		quickSort(array, 0, n-1);
		System.out.print("Sorted List: ");
		printArray(array);

		System.out.println("==================== QUICKSORT 2 ====================");
		System.out.print("Unsorted List: ");
		printArray(array2);
		n = array2.length;
		quickSort2(array2, 0, n-1);
		System.out.print("Sorted List: ");
		printArray(array2);
		
		System.out.println("==================== MERGESORT ====================");
		System.out.print("Unsorted List: ");
		printArray(array3);
		n = array3.length;
		mergeSort(array3, n);
		System.out.print("Sorted list: ");
		printArray(array3);
		
		System.out.println("==================== MERGESORT 2 - HALF IMPLEMENTED ====================");
		int fullarray[] = {1, 21, 34, 55, 66, 2, 3, 4, 55, 67};
		int arr[] = {1, 21, 34, 55, 66};
		int arr2[] = {2, 3, 4, 55, 67};
		System.out.print("Unsorted List: ");
		printArray(fullarray);
		//printArray(array10);
		n = array10.length;
		int halfn = array10.length/2;
		array10 = merge2(arr, arr2);
		System.out.print("Sorted list: ");
		printArray(array10);
		
	}
}
