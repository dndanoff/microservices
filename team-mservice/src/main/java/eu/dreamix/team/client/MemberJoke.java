package eu.dreamix.team.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.dreamix.team.model.joke.Response;

@FeignClient(name="jokeClient", url="https://api.icndb.com/jokes")
public interface MemberJoke {
	
	@RequestMapping(method = RequestMethod.GET, value = "/random", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> createJoke(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName);
	
}
