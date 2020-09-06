package com.systemsmart.service;

public interface IService <entityType, datatypeOfID, R> {
    entityType create (entityType t);
    entityType read (datatypeOfID id);
    entityType update (entityType t);
    boolean delete (datatypeOfID id);
}
