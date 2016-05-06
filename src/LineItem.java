import java.util.HashMap;

public class LineItem {
	private double value;
	private HashMap<String, String> attributes;
	
	public LineItem(double value, HashMap<String, String> attributes) {
		this.setValue(value);
		this.setAttributes(attributes);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
}
