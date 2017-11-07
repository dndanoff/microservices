package eu.dreamix.team.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import eu.dreamix.team.model.joke.Joke;
import eu.dreamix.team.model.joke.Response;

public class MemberJokeClientFallback implements MemberJokeClient {

	private final static Logger LOGGER = LoggerFactory.getLogger(MemberJokeClientFallback.class);
	
    private final Throwable cause;

    public MemberJokeClientFallback(Throwable cause) {
      this.cause = cause;
    }

    @Override
    public ResponseEntity<Response> createJoke(String firstName, String lastName){
    	LOGGER.error("Calling fallback client because of an error.",cause);
    	Joke joke = new Joke();
    	joke.setId(-1);
    	joke.setJoke(String.format("%s %s can make all of the pushups.", firstName, lastName));
    	Response response = new Response();
    	response.setType("fallback");
    	response.setValue(joke);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
