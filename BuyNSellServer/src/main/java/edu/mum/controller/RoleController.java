package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Role;
import edu.mum.service.RoleServiceImpl;

@RestController
@RequestMapping("/role")
public class RoleController implements IController<Role>{
	
	@Autowired
	private RoleServiceImpl rSer;

	@Override
    @PostMapping("/")
    public Role add(@RequestBody Role t) {
        // TODO Auto-generated method stub
        return rSer.add(t);
    }
	

	@Override
	public Role update(Role t, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role delete(Role t, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
