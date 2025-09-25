package edu.ccrm.domain;

public interface Searchable<T> {
    boolean matches(T criteria);
}
