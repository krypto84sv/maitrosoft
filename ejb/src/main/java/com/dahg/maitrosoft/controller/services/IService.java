/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.services;

/**
 *
 * @author dahg
 * @param <T>
 */
public interface IService <T>{
    
    T getById(Object id);    
    void persist(T obj);    
    void merge(T obj);    
    void remove(T obj);
}
