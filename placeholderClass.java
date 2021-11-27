package ultimate;

public class placeholderClass {
	private int placeholder;
	// placeholder is indicated by * on the board
	//placeholder = "*"
	public placeholderClass() {
		placeholder = 0;
	}
	//sets the placeholder
	public void setPlaceholder(int thing) {
		placeholder = thing;
	}
	
	//returns the placeholder
	public int getPlaceholder() {
		return placeholder;
	}
	//if it is not available, return placeholder
	public boolean available() {
		return (placeholder == 0);
	}
}
