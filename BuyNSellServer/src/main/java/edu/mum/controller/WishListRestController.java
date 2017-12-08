package edu.mum.controller;

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
@RestController
@RequestMapping("/wishlist")
public class WishListRestController implements IController<WishList> {
    @Autowired
    private WishListServiceImpl wlService;
    
    @Autowired
    private CatagoryServiceImpl ctService;

    @Override
    @PostMapping("/add")
    public WishList add(@RequestBody WishList t) {
        // TODO Auto-generated method stub
        return wlService.add(t);
    }
    
//    @PostMapping("/addNLoadByCatagory/{cataId}")
//    public List<WishList> add(@RequestBody WishList t, @PathVariable("cataId") String cataId) {
//        // TODO Auto-generated method stub
//    	 	
//    		Catagory c = ctService.get(cataId);
//    		List<WishList> wlList = c.getWishLists();
//    		wlList.add(t);
//    		
//    		c.setWishLists(wlList);
//    		
//    		System.out.println("c: "+Arrays.toString(c.getWishLists().toArray()));
//    		
//    		wlService.add(t);
//    		
//    		ctService.update(c, cataId);
//        return ctService.getAllWishList(c);
//    }
    
    @PostMapping("/addNLoad")
    public List<WishList> addNew(@RequestBody WishList t){
    		wlService.add(t);
    		return wlService.getAll();
    }

    @Override
    @PutMapping("/update/{id}")
    public WishList update(@RequestBody WishList t, @PathVariable("id") String id) {
        // TODO Auto-generated method stub
        t.setId(id);
        return wlService.update(t, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public WishList delete(@RequestBody WishList t, @RequestParam String id) {
        // TODO Auto-generated method stub
        wlService.delete(id);
        return t;
    }
    
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")String id) {
        // TODO Auto-generated method stub
        wlService.delete(id);
    }

    @Override
    @GetMapping("/all")
    public List<WishList> getAll() {
        // TODO Auto-generated method stub
        return wlService.getAll();
    }
    @Override
    @GetMapping("/get/{id}")
    public WishList get(@PathVariable("id") String id) {			
        // TODO Auto-generated method stub
    		return wlService.get(id);
    }

    @PostMapping("/getByCatagory/{cata}")
    public List<WishList> getWLByCata(@RequestBody WishList t, @PathVariable("cata") Catagory cata){
    		return ctService.getAllWishList(cata);
    }
}
