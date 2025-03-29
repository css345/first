import java.util.*;
public class StrEdit
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s1 : ");
		String s1 = sc.next();
		System.out.print("Enter string s2 : ");
		String s2 = sc.next();
		int res = strEdit(s1,s2);
		System.out.println("Minimum no.of operations = "+res);
	}
	public static int strEdit(String s1,String s2)
	{
		int m = s1.length();
		int n = s2.length();
		int[][] table = new int[m+1][n+1];
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0)
					table[i][j] = j;
				else if(j==0)
					table[i][j] = i;
			}
		}
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
					table[i][j] = table[i-1][j-1];
				else
					table[i][j] = Math.min(Math.min(table[i-1][j],table[i][j-1]),table[i-1][j-1])+1;
			}
		}
		return table[m][n];
	}
}