import java.util.List;

/**
 *  GroupHeirarchy consists of a list of attributes ordered from 
 *  highest in the heirarchy to the lowest
 * @author david
 *
 */
public class GroupHeirarchy {
	private List<String> attributes;
	
	public GroupHeirarchy(List<String> attributes) {
		setAttributes(attributes);
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}
	
	public List<String> getUpwardAttributes(String attribute) {
		return (List<String>)attributes.subList(
				0, 
				attributes.indexOf(attribute));
	}
	
	public List<String> getDownwardAttributes(String attribute) {
		return (List<String>)attributes.subList(
				attributes.indexOf(attribute) + 1, 
				attributes.size());
	}
}
