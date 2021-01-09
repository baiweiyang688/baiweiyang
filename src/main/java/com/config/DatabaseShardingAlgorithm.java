//package com.config;
//
//import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
//import com.google.common.collect.Range;
//import io.swagger.models.auth.In;
//
//import java.util.Collection;
//import java.util.LinkedHashSet;
//
///**
// * 分库策略类
// */
//public class DatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<String> {
//
//    @Override
//    public String doEqualSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
//        for (String each : databaseNames) {
//           String a = shardingValue.getValue();
//           int b = Integer.parseInt(a);
//          if(b > 10000){
//              if (each.endsWith(1 + "")){
//                  return each;
//              }else {
//                  if (each.endsWith(0 + "")){
//                      return each;
//                  }
//              }
//          }
//        }
//        throw new IllegalArgumentException();
//    }
//
//    @Override
//    public Collection<String> doInSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
//        Collection<String> result = new LinkedHashSet<>(databaseNames.size());
//        for (String value : shardingValue.getValues()) {
//            for (String tableName : databaseNames) {
//                if (tableName.endsWith(Long.valueOf(value) % 2 + "")) {
//                    result.add(tableName);
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public Collection<String> doBetweenSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
//        Collection<String> result = new LinkedHashSet<>(databaseNames.size());
//        Range<String> range = (Range<String>) shardingValue.getValueRange();
//        for (Long i = Long.valueOf(range.lowerEndpoint()); i <= Long.valueOf(range.upperEndpoint()); i++) {
//            for (String each : databaseNames) {
//                if (each.endsWith(i % 2 + "")) {
//                    result.add(each);
//                }
//            }
//        }
//        return result;
//    }
//
//}
