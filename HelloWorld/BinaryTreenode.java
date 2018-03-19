
public class BinaryTreenode<K>{

	private K key;
	private BinaryTreenode<K> leftChild;
	private BinaryTreenode<K> rightChild;

	public BinaryTreenode(){

	}



	public BinaryTreenode(K keyRef, BinaryTreenode<K> leftNodeRef, BinaryTreenode<K> rightNodeRef) { 
		key = keyRef;
		leftChild  = leftNodeRef;
		rightChild = rightNodeRef;
	}
	
	public K getKey() { return key; }
    public BinaryTreenode<K> getLeft()  { return leftChild;  }
    
    public BinaryTreenode<K> getRight() { return rightChild; }
	
	
	
	
	
	public void setLeft(BinaryTreenode<K> leftNodeRef)   { leftChild  = leftNodeRef;  }
	public void setRight(BinaryTreenode<K> rightNodeRef) { rightChild = rightNodeRef; }


}
