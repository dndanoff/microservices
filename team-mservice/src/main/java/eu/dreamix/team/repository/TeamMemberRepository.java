package eu.dreamix.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.dreamix.team.model.TeamMember;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long>{

}
