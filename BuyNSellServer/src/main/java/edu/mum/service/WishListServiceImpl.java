package edu.mum.service;

import edu.mum.dao.WishListRepository;
import edu.mum.domain.Catagory;
import edu.mum.domain.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yentran
 */
@Service
public class WishListServiceImpl implements IWishListService {
    @Autowired
    private WishListRepository wlRep;

    @Override
    public WishList add(WishList t) {
        // TODO Auto-generated method stub
        return wlRep.save(t);
    }

    @Override
    public WishList update(WishList t, String id) {
        // TODO Auto-generated method stub
        t.setId(id);
        return wlRep.save(t);
    }

    @Override
    public WishList delete(WishList t) {
        // TODO Auto-generated method stub
        wlRep.delete(t);
        return t;
    }

    @Override
    public List<WishList> getAll() {
        // TODO Auto-generated method stub
        return wlRep.findAll();
    }

    @Override
    public WishList get(String id) {
        // TODO Auto-generated method stub
        return wlRep.findById(id);
    }

    @Override
    public void delete(String wl_id) {
        // TODO Auto-generated method stub
        wlRep.delete(wl_id);
    }
    
}
