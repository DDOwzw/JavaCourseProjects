
public class TrinaryTreenode<K> {
	// *** fields ***
    private K key;
    private TrinaryTreenode<K> leftChild;
    private TrinaryTreenode<K> midChild;
    private TrinaryTreenode<K> rightChild;
    
    
    
    
    
    public TrinaryTreenode(){
    	
    }

    // *** methods ***
    public K getKey() { return key; }
    public TrinaryTreenode<K> getLeft()  { return leftChild;  }
    public TrinaryTreenode<K> getMid()   { return midChild;   }
    public TrinaryTreenode<K> getRight() { return rightChild; }
}
