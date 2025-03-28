import java.util.*;
public class TwoWayMergeSort
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//int[] a = {7,1,4,5,3,2,6,8,9};
		System.out.print("Enter the size : ");
		int size = sc.nextInt();
		int[] a = new int[size];
		System.out.print("Enter elements : ");
		for(int i=0;i<size;i++)
			a[i] = sc.nextInt();
		System.out.println("Before Sorting");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		mergePass(a,0,a.length-1);
		System.out.println("\nAfter sorting:");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void mergePass(int[] a,int lb,int ub)
	{
		int mid;
		if(lb != ub)
		{
			mid = (lb+ub)/2;
			mergePass(a,lb,mid);
			mergePass(a,mid+1,ub);
			mergeSort(a,lb,mid,ub);
		}
	}
	public static void mergeSort(int[] a,int l,int m,int u)
	{
		int i,j,k;
		int temp[] = new int[50];
		i = l;
		j = m+1;
		k = l;
		while((i<=m) && (j<=u))
		{
			if(a[i]<a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		while(i<=m)
			temp[k++] = a[i++];
		while(j<=u)
			temp[k++] = a[j++];
		for(i=l;i<=u;i++)
			a[i] = temp[i];
	}
}
