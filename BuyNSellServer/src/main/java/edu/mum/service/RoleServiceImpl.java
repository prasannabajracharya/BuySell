package edu.mum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.RoleRepository;
import edu.mum.domain.Role;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleRepository rRep;
	
	@Override
	public Role add(Role t) {
		// TODO Auto-generated method stub
		return rRep.save(t);
	}

	@Override
	public Role update(Role t, String id) {
		// TODO Auto-generated method stub
		t.setId(id);
		return rRep.save(t);
	}

	@Override
	public Role delete(Role t) {
		// TODO Auto-generated method stub
		rRep.delete(t);
		return t;
	}

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return rRep.findAll();
	}

	@Override
	public Role get(String id) {
		// TODO Auto-generated method stub
		return rRep.findById(id);
	}

}
