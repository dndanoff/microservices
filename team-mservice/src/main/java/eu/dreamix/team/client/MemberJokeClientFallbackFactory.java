package eu.dreamix.team.client;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class MemberJokeClientFallbackFactory implements FallbackFactory<MemberJokeClient> {

	@Override
	public MemberJokeClient create(Throwable throwable) {
		return new MemberJokeClientFallback(throwable);
	}

}
