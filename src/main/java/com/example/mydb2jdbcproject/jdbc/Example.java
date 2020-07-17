package com.example.mydb2jdbcproject.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Example {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("test")
    public @ResponseBody ResponseEntity<String> example() {
        List<String> list = new ArrayList<>();
        list.add("Table data...");
        jdbcTemplate.query(
                "SELECT * FROM user", new Object[]{},
                (rs,rowNum) -> new User(rs.getLong("id"), rs.getString("name")))
                .forEach(thing -> list.add(thing.toString()));
        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
    }

}
