package com.dev.simplecrudapp.repository;

import com.dev.simplecrudapp.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private String GET_ALL_USERS_QUERY = "select * from user";
    private String GET_USER_BY_ID_QUERY = "select * from user where id=?";
    private String REMOVE_USER_BY_ID_QUERY = "delete from user where id=?";
    private String ADD_USER_BY_ID_QUERY = "insert into user(name,surname) values(?,?)";
    private String UPDATE_USER_DATA_BY_ID_QUERY = "update user set name=2, surname=? where id=?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        return jdbcTemplate.query(GET_ALL_USERS_QUERY, BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getUserById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public void removeUserById(int id) {
        jdbcTemplate.update(REMOVE_USER_BY_ID_QUERY, id);
    }

    public void addNewUsers(List<User>users){
        users.forEach(user -> jdbcTemplate.update(ADD_USER_BY_ID_QUERY,user.getName(),user.getSurname()));
    }
    public void updateUserById(User user){
        jdbcTemplate.update(UPDATE_USER_DATA_BY_ID_QUERY,user.getName(),user.getSurname(),user.getId());
    }
}
