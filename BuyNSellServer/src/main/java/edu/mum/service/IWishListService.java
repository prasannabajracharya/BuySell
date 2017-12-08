package edu.mum.service;

import edu.mum.domain.WishList;

/**
 * Created by yentran
 */
public interface IWishListService extends IService<WishList> {
    public void delete(String Id);
}
