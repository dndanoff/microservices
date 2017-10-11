package eu.dreamix.team.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER", schema = "team")
public class TeamMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "PHOTO_URL")
	private String photoUrl;
	@Column(name = "HIRE_DATE")
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