package com.molice.service;

/**
 * @author molice
 * @date 2019/4/10
 **/
@FunctionalInterface
public interface LoadCallback<T> {
    T load();
}
