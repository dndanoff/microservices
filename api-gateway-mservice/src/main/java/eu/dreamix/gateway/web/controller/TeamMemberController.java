package eu.dreamix.gateway.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import eu.dreamix.gateway.client.CompanyClient;
import eu.dreamix.gateway.model.TeamMember;

@RestController
@RequestMapping(value = "/members")
public class TeamMemberController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TeamMemberController.class);

	private final CompanyClient companyClient;

	@Autowired
	public TeamMemberController(CompanyClient companyClient) {
		this.companyClient = companyClient;
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<String>> getAllMembers() {
		LOGGER.debug("Received request to display all team members e-mails.");
		return new ResponseEntity<>(companyClient.readAllMembers().getBody().stream().map(TeamMember::getEmail)
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	public ResponseEntity<Collection<String>> fallback() {
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
	}
}
