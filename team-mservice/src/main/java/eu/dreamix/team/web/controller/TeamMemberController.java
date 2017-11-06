package eu.dreamix.team.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.dreamix.team.model.TeamMember;
import eu.dreamix.team.model.joke.Joke;
import eu.dreamix.team.repository.TeamMemberRepository;
import eu.dreamix.team.service.JokeService;

@RestController
@RequestMapping(value = "/members")
public class TeamMemberController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TeamMemberController.class);
	
	private final TeamMemberRepository memberRepository;
	private final JokeService jokeService;
	
	@Autowired
	public TeamMemberController(TeamMemberRepository memberRepository, JokeService jokeService) {
		this.memberRepository = memberRepository;
		this.jokeService = jokeService;
	}

	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TeamMember>> getAllMembers() {
		LOGGER.debug("Received request to display all team members.");
		return new ResponseEntity<>(memberRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}/joke", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Joke> getMemberJoke(@PathVariable("id") Long id) {
		LOGGER.debug("Received request to display member joke.");
		TeamMember member = memberRepository.findOne(id);
		return jokeService.getMemberJoke(member);
	}
}
