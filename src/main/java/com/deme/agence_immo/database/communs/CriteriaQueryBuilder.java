package com.deme.agence_immo.database.communs;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CriteriaQueryBuilder {
    private Boolean isFirst = true;

    public String buildQuery(String collumn, QueryOperator operator, Integer value){
        if (value == null) return "";
        return buildQuery(collumn, operator, value.toString());
    }

    public String buildQuery(String collumn, QueryOperator operator, String value){
        if (value == null) return "";
        StringBuilder sqlBuilder = new StringBuilder();
        if(isFirst) {
            sqlBuilder.append("WHERE ");
            isFirst = Boolean.FALSE;
        } else {
            sqlBuilder.append(" AND ");
        }
        sqlBuilder.append(collumn + " " + getOperatorString(operator, value));
        return sqlBuilder.toString();
    }

    public String buildQueryWithArray(String collumn, List<String> values){
        if (values == null) return "";
        StringBuilder sqlBuilder = new StringBuilder();
        if(isFirst) {
            sqlBuilder.append("WHERE ");
            isFirst = Boolean.FALSE;
        } else {
            sqlBuilder.append(" AND ");
        }
        sqlBuilder.append(collumn + " IN (");
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()){
            sqlBuilder.append("'"+iterator.next()+"'");
            if (iterator.hasNext()) {
                sqlBuilder.append(",");
            }
        }
        sqlBuilder.append(")");
        return sqlBuilder.toString();
    }

    private static String getOperatorString (QueryOperator operator, String value){
        switch (operator){
            case EQUAL: return "=" + " '" + value + "'";
            case SUPERIOR: return ">=" + " '" + value + "'";
            case INFERIOR: return "<=" + " '" + value + "'";
            case LIKE: return "LIKE" + " %" + value + "%";
            default: return null;
        }
    }
}
