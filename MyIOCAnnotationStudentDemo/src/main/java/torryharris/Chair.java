package torryharris;

import org.springframework.stereotype.Component;
@Component("chair")
public class Chair {
	private String colour;
	private String type;
	
						//Getters And Setters
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
						//toString
	@Override
	public String toString() {
		return "Chair [colour=" + colour + ", type=" + type + "]";
	}
	
	
	
}
