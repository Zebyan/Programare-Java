package org.example.lab9.configuraremasini;
import java.sql.*;
import org.springframework.jdbc.core.RowMapper;

public class MasinaMapper implements RowMapper {
    @Override
    public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Masina(rs.getString("nr_inmatriculare"), rs.getString("marca"), rs.getInt("an_fabricatie"), rs.getString("culoare"), rs.getInt("km"));
    }

}
