package eu.dreamix.auth.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class PrincipleController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PrincipleController.class);

	@RequestMapping(method = RequestMethod.GET)
	public Principal user(Principal user) {
		LOGGER.info("AS /user has been called. User info: {}", user.toString());
		return user;
	}
}
