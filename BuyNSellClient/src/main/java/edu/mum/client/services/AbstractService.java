package edu.mum.client.services;

import edu.mum.client.ReflectionUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Rabin Shrestha on 8/13/2017.
 */
public class AbstractService<T> {
    private RestTemplate restTemplate;
    public String baseUrl;

    private Class clazz;
    public AbstractService() {
        this.restTemplate = new RestTemplate();
        try {
            this.clazz = ReflectionUtil.getClazz(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public T post(T t, String param){
        String  url = baseUrl;
        if (param!=null)
            url=baseUrl+param;
        System.out.println("calling url :"+url);
        T obj = (T) restTemplate.postForObject(url, t, clazz, "");
        return obj;

    }
    public T update(T t, String param){
        String  url = baseUrl+"update/";
        if (param!=null)
            url=url+param;
        System.out.println("calling url :"+url);
        T obj = (T) restTemplate.postForObject(url, t, clazz, "");
        return obj;
    }

    public void put(T t, String param){
        String  url = baseUrl;
        if (param!=null)
            url=baseUrl+param;
         restTemplate.put(url, t, clazz, "");
        return ;
    }


    public T get(String param){
        String  url = baseUrl;
        if (param!=null)
            url=baseUrl+param;
        System.out.println("calling url :"+url);
        T obj = (T) restTemplate.getForObject(url, clazz, "");
        return obj;
    }

    public List<T> getList(String param){
        String  url = baseUrl;
        if (param!=null)
            url=baseUrl+param;
        System.out.println("calling url :"+url);
        ResponseEntity<List<T>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<T>>() {
                        });
        System.out.println("List:"+response.getBody());
        return response.getBody();
    }

    public void delete(String param){
        String  url = baseUrl;
        if (param!=null)
            url=baseUrl+param;
        System.out.println("url:"+url);

        restTemplate.delete(url);
    }



}