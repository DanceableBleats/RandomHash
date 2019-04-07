package RandomHash;

import java.util.Random;
import java.util.ArrayList;
import java.lang.Integer;

public class RanomHash {

	public static void main(String[] args)  {
		Random rand = new Random();
		ArrayList<Integer> intList = new ArrayList<Integer>();

		while(intList.size() < 1000)
		{
			int x = rand.nextInt(Integer.MAX_VALUE);
			if (collisionSearch(x, intList))
			{
				//System.out.println("collision found: " + x);
			}
			else
			{
				intList.add(x);
			}
			//System.out.println(intList.size());
		}
		System.out.println("num of unique random ints generated: " + intList.size());
		
		MyHashTable table1 = new MyHashTable(1);
		MyHashTable table2 = new MyHashTable(2);
		MyHashTable table3 = new MyHashTable(3);
		
		int col1 = 0, col2 = 0, col3 = 0;
		for (int i = 0; i < 1000; i++)
		{
			int c1 = table1.hash(intList.get(i));
			if (c1 > col1) {col1 = c1;}
			
			int c2 = table2.hash(intList.get(i));
			if (c2 > col2) {col2 = c2;}
			
			int c3 = table3.hash(intList.get(i));
			if (c3 > col3) {col3 = c3;}
		}
		
		System.out.println("Collisions: h1(): " + col1 + " - h2(): " + col2 + " - h3(): " + col3);
		
	}//end MAIN
	
	public static boolean collisionSearch(int x, ArrayList<Integer> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == x)
			{
				return true;
			}
		}
		return false;
	}
		

}
		
		
