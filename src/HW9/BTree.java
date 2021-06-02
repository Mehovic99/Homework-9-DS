package HW9;


//NOTE: This code was taken from the 'Laboratory week 12: Binary Search Tree' Github repository, made by the assistent
public class BTree<Key extends Comparable<Key>, Value> {
	
	private BNode<Key, Value> root;
	
	//Return a value associated with the key
	public Value get(Key key) {
		
		BNode<Key, Value> x = root;			
		
		while (x != null) {			
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {					
				x = x.left;
			} else if (cmp > 0) { 
				x = x.right;
			} else {				
				return x.value;
			}	
		}
		
		return null;					
	}
	
	//Total size of the tree returned as result
	public int size() {
		return size(root);			
	}
	
	//Same as the total size of the tree, only made private
	private int size(BNode<Key, Value> x) {	
		if (x == null) {							
			return 0;						
		}
		return x.size;								
	}
	
	//When given a key, add value under the key
	public void put(Key key, Value value) {
		root = put(root, key, value);							
	}
	
	//Same as the add value method, only changed to be private
	private BNode<Key, Value> put(BNode<Key, Value> x, Key key, Value value) {		
		if (x == null) {														
			return new BNode<Key, Value>(key, value);								
		}
		
		int cmp = key.compareTo(x.key);									
		if (cmp < 0) {															
			x.left = put(x.left, key, value);						
		} else if (cmp > 0) {									
			x.right = put(x.right, key, value);							
		} else {													
			x.value = value;											
		}
		
		x.size = 1 + size(x.left) + size(x.right);						
		return x;												
	}
	
	//Find the minimum
	public Key findMin() {  
	   return findMin(root).key; 					
	}	
	 
	private BNode<Key, Value> findMin(BNode<Key, Value> x) {
	   if (x.left == null) {									
		   return x;											
	   }
	   return findMin(x.left);										
	}
	
	//Find the max
	public Key findMax() {  
		return findMax(root).key; 			
	}
	
	private BNode<Key, Value> findMax(BNode<Key, Value> x) {
		if (x.right == null) {								
			return x;							
		}
		return findMax(x.right);						
	}
	
	//Ranking the key given 
	public int rank(Key key) {						
		return rank(root, key);								
	}	
	
	private int rank(BNode<Key, Value> x, Key key) {
		if (x == null) {								
			return 0;										
		}
		
		int cmp = key.compareTo(x.key);						
		if (cmp < 0) {								
			return rank(x.left, key);					
		} else if (cmp > 0) {						
			return 1 + size(x.left) + rank(x.right, key);
		} else {									
			return size(x.left);				
		}
	}
	
	//Delete the minimum key
	public void deleteMin() {
		root = deleteMin(root);									
	}
	
	private BNode<Key, Value> deleteMin(BNode<Key, Value> x) {
		if (x.left == null) {							
			return x.right;							
		}
		
		x.left = deleteMin(x.left);						
		x.size = 1 + size(x.left) + size(x.right);		
		
		return x;							
	}
	
	//Delete specified key
	public void delete(Key key) {
		root = delete(root, key);								
	}
	
	private BNode<Key, Value> delete(BNode<Key, Value> x, Key key) {
		if (x == null) {									
			return null;											
		}
		
		int cmp = key.compareTo(x.key);							
		if (cmp < 0) {													
			x.left = delete(x.left, key);								
		} else if (cmp > 0) {										
			x.right = delete(x.right, key);								
		} else {												
			if (x.right == null) {			
				return x.left;								
			}
			if (x.left == null) {						
				return x.right;									
			}			
			BNode<Key, Value> t = x;					
			x = findMin(t.right);							
			x.right = deleteMin(t.right);			
			x.left = t.left;						
		}
		x.size = 1 + size(x.left) + size(x.right);					
		return x;														
	}

}