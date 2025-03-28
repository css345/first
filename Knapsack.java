import java.util.*;
public class Knapsack {
    static class Item {
        int weight;
        int profit;

        public Item(int w, int p) {
            weight = w;
            profit = p;
        }
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no.of items : ");
		int n = sc.nextInt();
		System.out.println("Enter items weights and profits (weight profit) : ");
		Item items[] = new Item[n];
		for(int i=0;i<n;i++)
		{
			items[i] = new Item(sc.nextInt(),sc.nextInt());
		}
		System.out.print("Enter size : ");
		int size = sc.nextInt();
        double tp = fractionalKnapsack(items, size);
        System.out.println("Total Profit: " + tp);  
    }

    public static double fractionalKnapsack(Item items[], int w) {
        double tprofit = 0.0;
        sortByProfitRatio(items);  

        for (int i = 0; i < items.length; i++) {
            Item x = items[i];
            if (w == 0)
                return tprofit;  
            else {
                if (x.weight <= w) {
                    tprofit += x.profit;  
                    w -= x.weight;  
                } else {
                    tprofit += (x.profit / (double) x.weight) * w; 
                    w = 0;  
                }
            }
        }
        return tprofit;
    }

    public static void sortByProfitRatio(Item items[]) {
        int i, j;
        Item temp;
        for (i = 0; i < items.length - 1; i++) {
            for (j = i + 1; j < items.length; j++) {
                double r1 = (double) items[i].profit / items[i].weight;
                double r2 = (double) items[j].profit / items[j].weight;  
                if (r1 < r2) {  
                    temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
    }
}