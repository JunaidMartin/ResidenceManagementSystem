package com.systemsmart.repository;

@Deprecated
public interface  IRepository <entityType, datatypeOfID> {
    entityType create (entityType t);
    entityType read (datatypeOfID id);
    entityType update (entityType t);
    boolean delete (datatypeOfID id);
}
