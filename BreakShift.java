import java.util.*;
public class BreakShift
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the text : ");
		String str = sc.nextLine();
		int i=0;
		//char chr='';
		char[] ch = str.toCharArray();
		char[] ct = new char[ch.length];
		System.out.print("Cipher text : ");
		for(char chr:ch)
		{
			if(Character.isLowerCase(chr))
				chr = (char)((((int)chr-97+3)%26)+97);
			else if(Character.isUpperCase(chr))
				chr = (char)((((int)chr-65+3)%26)+65);
			else if(chr == ' ')
				chr = ' ';
			ct[i++] = chr;
		}
		System.out.println(ct);
		System.out.print("Plain text : ");
		char[] pt = new char[ch.length];
		i=0;
		for(char chr:ct)
		{
			if(Character.isLowerCase(chr))
				chr = (char)((((int)chr-97-3+26)%26)+97);
			else if(Character.isUpperCase(chr))
				chr = (char)((((int)chr-65-3+26)%26)+65);
			else if(chr == ' ')
				chr = ' ';
			pt[i++] = chr;
		}
		System.out.print(pt);
	}
}