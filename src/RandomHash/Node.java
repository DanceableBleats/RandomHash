package RandomHash;


public class Node
{
	int k; //hash key value
	int n; //original random num value
	Node nextNode;
	
	Node(int key, int num)
	{
		k = key;
		n = num;
	}
}