package edu.mum.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.mum.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	public Role findById(String id);
	public Role findByName(String name);

}
