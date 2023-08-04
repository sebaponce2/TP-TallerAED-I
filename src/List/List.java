package List;
public interface List {

	boolean insert(String value);
	
	boolean insert(String value, int pos);
	
	boolean delete(String value);
	
	Node searchElement(String value);
	
	Node modifyElementByConsole(String toModifyValue);
	
	void printElements();
}
