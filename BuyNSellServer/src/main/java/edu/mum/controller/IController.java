package edu.mum.controller;

import java.util.List;

/**
 * Created by Rabin Shrestha on 8/10/2017.
 */
public interface IController<T> {
    T add(T t);

    T update(T t, String id);

    T delete(T t, String id);

    List<T> getAll();

    T get(String id);
}
