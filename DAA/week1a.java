import java.util.*;

class week1a
{
	static int comp=0;
	static int arr[];
	static void quicksort(int low,int high)
	{
		if(low<high)
		{
			comp++;
			int j=partition(low,high);
			quicksort(low,j-1);
			quicksort(j+1,high);
		}
	}
	static int partition(int low,int high)
	{
		int pivot=arr[low];
		int i=low,j=high;
		while(i<j)
		{
			comp++;
			while(i<high && arr[i]<=pivot)
			{
				comp+=2;
				i++;
			}
			while(j>low && arr[i]>=pivot)
			{
				comp+=2;
				j--;
			}
			if(i<j)
			{
				comp++;
				interchange(i,j);
			}
		}
		arr[low]=arr[j];
		arr[j]=pivot;
		return j;
	}
	static void interchange(int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String args[])
	{
		int n;
		Scanner s=new Scanner(System.in);
		System.out.print("enter n value:");
		n=s.nextInt();
		arr=new int[n];
		System.out.print("QuickSort:\n1.Best/Avg case\n2.Worst case:");
		int ch=s.nextInt();
		switch(ch)
		{
			case 1:
				Random r=new Random(3000);
				for(int i=0;i<n;i++)
					arr[i]=r.nextInt();
				break;
			case 2:
				for(int i=0;i<n;i++)
					arr[i]=i+1;
				break;
		}
		long start=System.nanoTime();
		quicksort(0,n-1);
		long end=System.nanoTime();
		System.out.println("Sorted array:");
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
		System.out.println("Time taken: "+(end-start)+"ns");
		System.out.println("Comparisons: "+comp);
	}
}

/*Output:
enter n value:10
QuickSort:
1.Best/Avg case
2.Worst case:1
Sorted array:
-426000662
-1089390459
-926162117
-1155264162
38037653
-1861260866
-1382105223
-1076964443
1492432317
1518298030
Time taken: 7624ns
Comparisons: 132 */
