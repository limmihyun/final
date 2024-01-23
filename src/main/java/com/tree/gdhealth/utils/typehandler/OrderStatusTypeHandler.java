package com.tree.gdhealth.utils.typehandler;

import com.tree.gdhealth.utils.enumtype.OrderStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 정인호
 * <p>Java enum <-> mybatis 을 활용하기 위한 타입핸들러 구현체
 * </p>
 */
@MappedTypes(OrderStatus.class)
public class OrderStatusTypeHandler implements TypeHandler<OrderStatus> {
    @Override
    public void setParameter(PreparedStatement ps, int i, OrderStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public OrderStatus getResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return OrderStatus.fromCode(code);
    }

    @Override
    public OrderStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return OrderStatus.fromCode(code);
    }

    @Override
    public OrderStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return OrderStatus.fromCode(code);
    }
}
