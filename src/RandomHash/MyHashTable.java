package RandomHash;

import RandomHash.Node;

public class MyHashTable
{
	Node[] nodeArray;
	int hashType;
	int numKeys;
	int maxColl;
	
	MyHashTable(int type)
	{
		hashType = type;
		maxColl = 0;
		switch(type)
		{
			case 1:
				numKeys = 128;
				nodeArray = new Node[128];
				System.out.println("Hash table type 1, keys: " + numKeys);
				break;
				
			case 2:
				numKeys = 139;
				nodeArray = new Node[139];
				System.out.println("Hash table type 2, keys: " + numKeys);
				break;
				
			case 3:
				numKeys = 128;
				nodeArray = new Node[128];
				System.out.println("Hash table type 3, keys: " + numKeys);
				break;
		}
		
	}
	
	public int hash(int n)
	{
		int k = -1;
		
		switch(hashType)
		{
		case 1:
			k = h1(n);
			break;
			
		case 2:
			k = h2(n);
			break;
			
		case 3:
			k = h3(n);
			break;
		
		default:
			System.exit(-1);
			break;
		}
		
		if(nodeArray[k] == null)
		{
			nodeArray[k] = new Node(k, n);
			return 0;
		}
		else
		{
			Node node = new Node(k, n);
			Node presentNode = nodeArray[k];
			int chainLen = 1;
			
			while(!(presentNode.nextNode == null))
			{
				presentNode = presentNode.nextNode;
				chainLen++;
			}
			
			presentNode.nextNode = node;
			return chainLen;
		}

	}
	
	private int h1(int k)
	{
		k = k % 128;
		return k;
	}
	
	private int h2(int k)
	{
		k = k % 139;
		return k;
	}
	
	private int h3(int k)
	{
		k = (int)Math.floor(128 * (0.61803 * k % 1));
		return k;
	}
}

