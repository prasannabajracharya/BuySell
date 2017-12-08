package edu.mum.controller;

import edu.mum.dao.CatagoryRepository;
import edu.mum.domain.Catagory;
import edu.mum.domain.WishList;
import edu.mum.service.CatagoryServiceImpl;
import edu.mum.service.WishListServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yentran
 */
@CrossOrigin(origins = "http://localhost:9090/wishlist")
@RestController
@RequestMapping("/catagory")
public class CatagoryRestController implements IController<Catagory> {

    @Autowired
    private CatagoryRepository cRep;
    
    @Autowired
    private WishListServiceImpl wlService;
    
    @Autowired
    private CatagoryServiceImpl ctService;

    @Override
    @PostMapping("/")
    public Catagory add(@RequestBody Catagory t) {
        // TODO Auto-generated method stub
        return ctService.add(t);
    }
    
    @PostMapping("/addNLoad")
    public List<Catagory> addNLoad(@RequestBody Catagory t) {
        // TODO Auto-generated method stub
    		cRep.save(t);
        return cRep.findAll();
    }
    
    @GetMapping("/getWLByCatagory/{cataId}")
    public List<WishList> getWLByCata(@PathVariable("cataId") String cataId) {
        // TODO Auto-generated method stub
    	 	
    		Catagory c = ctService.get(cataId);
    		
        return ctService.getAllWishList(c);
    }
    
    @PostMapping("/addNLoadWishList/{cataId}")
    public List<WishList> add(@RequestBody WishList t, @PathVariable("cataId") String cataId) {
        // TODO Auto-generated method stub
    	 	
    		Catagory c = ctService.get(cataId);
    		List<WishList> wlList = c.getWishLists();
    		wlList.add(t);
    		
    		c.setWishLists(wlList);
    		
    		System.out.println("c: "+Arrays.toString(c.getWishLists().toArray()));
    		
    		wlService.add(t);
    		
    		ctService.update(c, cataId);
        return ctService.getAllWishList(c);
    }

    @Override
    @PutMapping("/update/{id}")
    public Catagory update(@RequestBody Catagory t, @PathVariable("id") String id) {
        // TODO Auto-generated method stub
        t.setId(id);
        return cRep.save(t);
    }

    @Override
    @DeleteMapping("/detele/{id}")
    public Catagory delete(@RequestBody Catagory t, @PathVariable("id") String id) {
        // TODO Auto-generated method stub
        cRep.deleteById(id);
        return t;
    }

    @Override
    @GetMapping("/all")
    public List<Catagory> getAll() {
        // TODO Auto-generated method stub
        return cRep.findAll();
    }

    @Override
    @GetMapping("/get/{id}")
    public Catagory get(@PathVariable("id") String id) {
        // TODO Auto-generated method stub
        return cRep.findById(id);
    }

}
