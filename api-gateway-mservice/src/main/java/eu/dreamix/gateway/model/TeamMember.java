package eu.dreamix.gateway.model;

import java.time.LocalDate;

public class TeamMember {
	
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private LocalDate hireDate;

	public TeamMember() {
		this(-1L, null, null, null, null, null);
	}

	public TeamMember(Long id, String email, String firstName, String lastName, String photoUrl, LocalDate hireDate) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photoUrl = photoUrl;
		this.hireDate = hireDate;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}
}