//package com.systemsmart.repository.impl;
//
//
//
//import com.systemsmart.entity.Query;
//import com.systemsmart.repository.QueryRepository;
//import java.util.HashSet;
//import java.util.Set;
//
//public class QueryRepositoryImpl implements QueryRepository {
//
//    private static QueryRepository repository = null;
//    private Set<Query> queryDB;
//
//    private QueryRepositoryImpl() {
//        this.queryDB = new HashSet<>();
//    }
//
//    public static QueryRepository getRepository(){
//        if (repository == null) repository =  new QueryRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Query create(Query query) {
//        queryDB.add(query);
//        return query;
//    }
//
//    @Override
//    public Query read(String queryID) {
//        for (Query query: queryDB)
//            if(query.getQueryId().equalsIgnoreCase(queryID)) return query;
//
//        return null;
//    }
//
//    @Override
//    public Query update(Query query) {
//        boolean queryRemoved = delete(query.getQueryId());
//        if(queryRemoved){
//            queryDB.add(query);
//            return query;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String queryID) {
//        Query query = read(queryID);
//        if(query != null){
//            queryDB.remove(query);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public Set<Query> retrieve() {
//        return queryDB;
//    }
//}
//
//
