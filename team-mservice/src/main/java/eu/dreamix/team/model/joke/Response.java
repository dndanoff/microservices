package eu.dreamix.team.model.joke;

import java.util.List;

public class Response {
	
	private String type;
	private Joke value;
	
	public Response() {
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Joke getValue() {
		return value;
	}
	public void setValue(Joke value) {
		this.value = value;
	}
	
	
}
