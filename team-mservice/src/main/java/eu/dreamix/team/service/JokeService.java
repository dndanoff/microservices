package eu.dreamix.team.service;

import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import eu.dreamix.team.client.MemberJoke;
import eu.dreamix.team.model.TeamMember;
import eu.dreamix.team.model.joke.Joke;
import eu.dreamix.team.model.joke.Response;

@Service
public class JokeService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(JokeService.class);
	
	private final MemberJoke memberJoke;
	
	@Autowired
	public JokeService(MemberJoke memberJoke) {
		this.memberJoke = memberJoke;
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	public ResponseEntity<Joke> getMemberJoke(TeamMember member) {
		if(member == null) {
			throw new IllegalArgumentException("Member ID not found");
		}
		ResponseEntity<Response> response = memberJoke.createJoke(member.getFirstName(), member.getLastName());
		return new ResponseEntity<>(response.getBody().getValue(), HttpStatus.OK);
	}
	
	public ResponseEntity<Joke> fallback(TeamMember member, Throwable error) {
		return new ResponseEntity<>(new Joke(), HttpStatus.OK);
	}
}
