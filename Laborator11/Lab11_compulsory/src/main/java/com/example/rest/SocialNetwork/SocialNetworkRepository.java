package com.example.rest.SocialNetwork;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocialNetworkRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
    default Optional<Person> findByName(String name){
        return findByName(name);
    }
}
