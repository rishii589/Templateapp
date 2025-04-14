package com.example.demo.typehandler;

import com.example.demo.enums.TemplateType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

@MappedTypes(TemplateType.class)
public class TemplateTypeHandler extends BaseTypeHandler<TemplateType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TemplateType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getTypeId());
    }

    @Override
    public TemplateType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int typeId = rs.getInt(columnName);
        return getTemplateType(typeId);
    }

    @Override
    public TemplateType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int typeId = rs.getInt(columnIndex);
        return getTemplateType(typeId);
    }

    @Override
    public TemplateType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int typeId = cs.getInt(columnIndex);
        return getTemplateType(typeId);
    }

    private TemplateType getTemplateType(int typeId) {
        for (TemplateType type : TemplateType.values()) {
            if (type.getTypeId() == typeId) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid TemplateType typeId: " + typeId);
    }
}