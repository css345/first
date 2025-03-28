import java.util.*;
public class MinMax {
	static class Result 
	{
		int max,min;
		public Result(int x,int y)
		{
			max = x;
			min = y;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no.of elements : ");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.print("Enter "+n+" elements : ");
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		Result r = findMinMax(a,0,n-1);
		System.out.println("Max = "+r.max);
		System.out.println("Min = "+r.min);
	}
	public static Result findMinMax(int[] a,int start,int end)
	{
		int max,min;
		if(start==end)
			return new Result(a[start],a[start]);
		else if(end-start==1)
		{
			if(a[start]<a[end])
				return new Result(a[end],a[start]);
			else
				return new Result(a[start],a[end]);
		}
		else
		{
			int mid = (start+end)/2;
			Result lr = findMinMax(a,start,mid);
			Result rr = findMinMax(a,mid+1,end);
			max = (lr.max>rr.max)?lr.max:rr.max;
			min = (lr.min<rr.min)?lr.min:rr.min;
			return new Result(max,min);
		}
	}
}
