package com.tree.gdhealth.mybatis.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**<p>커스텀 이넘타입을 작성시 중첩정적클래스로 손쉽게 타입핸들러를 구현이 가능한 추상클래스</p>
 * @apiNote 구현클래스의 위에 @MappedType(클래스.class)를 적어야하며, 마이바티스 설정 파일에 타입핸들러를 추가해야한다.
 * 내부클래스경로는 외부클래스$내부클래스 로 표현
 * @author 정인호
 *
 */
public abstract class CodeEnumTypeHandler<E extends CodeEnum> implements TypeHandler<CodeEnum> {
    private final E customEnum;

    public CodeEnumTypeHandler(E customEnum){
        this.customEnum = customEnum;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CodeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public CodeEnum getResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return customEnum.fromCode(code);
    }

    @Override
    public CodeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return customEnum.fromCode(code);
    }

    @Override
    public CodeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return customEnum.fromCode(code);
    }
}
