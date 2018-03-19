
public class NullListException extends Exception{
	public NullListException(String message) {
		super(message);
	}
	public NullListException(){
		super("List is null!");
	}
}
