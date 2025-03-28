import java.util.*;
public class QuickSort
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
		quickSort(a,0,a.length-1);
		System.out.println("\nAfter sorting:");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void quickSort(int[] a,int lb,int ub)
	{
		int left,right,pivot,temp;
                left=lb;
                right=ub;
                pivot=lb;
		while(left!=right){
                    while((a[right]>a[pivot])&&(left!=right))
                          right--;
                    if(left!=right){
                        temp=a[pivot];
                        a[pivot]=a[right];
                        a[right]=temp;
                        pivot=right;}
                  while((a[left]<a[pivot])&&(left!=right))
                          left++;
                  if(left!=right){
                        temp=a[left];
                        a[left]=a[pivot];
                        a[pivot]=temp;
                        pivot=left;}


	}
if(lb<pivot)
   quickSort(a,lb,pivot-1);
if(ub>pivot)
  quickSort(a,pivot+1,ub);
	}
}
