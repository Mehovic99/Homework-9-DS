package HW9;

//We need a node in order to successfully implement a binary search tree.
public class BNode<Key extends Comparable<Key>, Value> {
	
	   public Key key;             				
	   public Value value;            			
	   public BNode<Key, Value> left, right;    
	   public int size = 1;                		
	   
	   public BNode(Key key, Value value) {
		   this.key = key;
		   this.value = value;
	   }
	}