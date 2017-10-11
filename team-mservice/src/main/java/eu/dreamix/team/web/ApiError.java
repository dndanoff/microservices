package eu.dreamix.team.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
	private String message;
	private List<String> errors;

	public ApiError(HttpStatus status, String message, List<String> errors) {
		this.errors = new ArrayList<>();
		this.status = status;
		this.message = message;
		if(errors != null) {
			this.errors.addAll(errors);
		}
	}

	public ApiError(HttpStatus status, String message, String error) {
		this.errors = new ArrayList<>();
		this.status = status;
		this.message = message;
		this.errors.add(error);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getErrors() {
		return new ArrayList<>(errors);
	}
}
