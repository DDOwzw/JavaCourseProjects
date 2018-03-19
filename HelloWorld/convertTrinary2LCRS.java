
public class convertTrinary2LCRS {

	public static <K> BinaryTreenode<K> convertTrinary2LCRS(TrinaryTreenode<K> triTreeRoot) {


		// if the tri is null, return null
		if(triTreeRoot == null)
			return null;
		// if the tri has one element
		else if(triTreeRoot.getLeft() == null){
			K key = triTreeRoot.getKey();
			BinaryTreenode<K> root = new BinaryTreenode<K>(key,null,null);
			return root;
		}
		// if the tri has 4 elements
		else if(triTreeRoot.getLeft().getLeft() == null){
			K key = triTreeRoot.getKey();
			BinaryTreenode<K> root = new BinaryTreenode<K>(key,null,null);
			root.setLeft(setChild(triTreeRoot));
			return root;
		}
		// if the tri has 13 elements
		else if(triTreeRoot.getLeft().getLeft().getLeft() == null){
			K key = triTreeRoot.getKey();
			BinaryTreenode<K> root = new BinaryTreenode<K>(key,null,null);
			root.setLeft(setChild(triTreeRoot));
			root.getLeft().setLeft(setChild(triTreeRoot.getLeft()));
			root.getLeft().getRight().setLeft(setChild(triTreeRoot.getMid()));
			root.getLeft().getRight().getRight().setLeft(setChild(triTreeRoot.getRight()));
			return root;
		}
		// recursive steps
		else{
			K key = triTreeRoot.getKey();
			BinaryTreenode<K> root = new BinaryTreenode<K>(key,null,null);
			root.setLeft(setChild(triTreeRoot));

			root.getLeft().setLeft(convertTrinary2LCRS(triTreeRoot.getLeft()));
			root.getLeft().getRight().setLeft(convertTrinary2LCRS(triTreeRoot.getMid()));
			root.getLeft().getRight().getRight().setLeft(convertTrinary2LCRS(triTreeRoot.getRight()));

			return root;
		}


	}




	private static <K> BinaryTreenode<K> setChild(TrinaryTreenode<K> triTreeRoot) {


		// create a new left child note in BinaryTreenode
		K key = triTreeRoot.getLeft().getKey();
		BinaryTreenode<K> leftC = new BinaryTreenode<K>(key, null, null);

		// create a new right child note in BinaryTreenode, which was the mid of the previous node
		key = triTreeRoot.getMid().getKey();
		BinaryTreenode<K> rightC = new BinaryTreenode<K>(key, null, null);

		// create a new right grandchild note in BinaryTreenode, which was the right of the previous node
		key = triTreeRoot.getRight().getKey();
		BinaryTreenode<K> rightGC = new BinaryTreenode<K>(key, null, null);


		// set right child of the leftC to be rightC
		leftC.setRight(rightC);

		// set right child of the rightC to be rightGC
		rightC.setRight(rightGC);

		return leftC;



	}

}

