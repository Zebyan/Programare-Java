package org.example.lab9.configuraremasini;

import java.util.*;
//import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MasinaJDBC {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Masina masina) {
        String sql = "INSERT INTO masini VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql,masina.getNr_inmatriculare(),masina.getMarca(),masina.getAn_fabricatie(),masina.getCuloare(),masina.getKm());
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM masini WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

    public Masina findById(String id) {
        String sql = "SELECT * FROM masini WHERE id = ?";
        return (Masina) jdbcTemplate.queryForObject(sql,new MasinaMapper(),id);
    }

    public List<Masina>findAll(){
        String sql = "select * from masini";
        return jdbcTemplate.query(sql,new MasinaMapper());
    }



}
