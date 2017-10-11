package eu.dreamix.gateway.client;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.dreamix.gateway.model.TeamMember;

@FeignClient("team-mservice")
public interface CompanyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/members", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<TeamMember>> readAllMembers();

}