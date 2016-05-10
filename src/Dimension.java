import java.util.ArrayList;
import java.util.List;

public class Dimension {
	private String name;
	private List<GroupHeirarchy> heirarchies;
	
	public Dimension(String name, List<GroupHeirarchy> heirarchies) {
		this.name = name;
		this.heirarchies = heirarchies;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<GroupHeirarchy> getHeirarchies() {
		return heirarchies;
	}
	
	public List<String> getUpwardAttributes(String attribute) {
		List<String> upward = new ArrayList<String>();
		for (GroupHeirarchy h : heirarchies) {
			ArrayList<String> higher = (ArrayList<String>)h.getAttributes().subList(
					0, 
					h.getAttributes().indexOf(attribute));
			for (String s : higher) {
				if (!upward.contains(s)) {
					upward.add(s);
				}
			}
		}
		return upward;
	}
	
	public List<String> getDownwardAttributes(String attribute) {
		List<String> downward = new ArrayList<String>();
		for (GroupHeirarchy h : heirarchies) {
			ArrayList<String> lower = (ArrayList<String>)h.getAttributes().subList(
					h.getAttributes().indexOf(attribute),
					h.getAttributes().size());
			for (String s : lower) {
				if (!downward.contains(s)) {
					downward.add(s);
				}
			}
		}
		return downward;
	}
	
	public void setHeirarchies(List<GroupHeirarchy> heirarchies) {
		this.heirarchies = heirarchies;
	}
}
