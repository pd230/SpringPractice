package com.example.SpringBasics.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBasics.model.UserHib;

public interface UserHibRepo extends JpaRepository<UserHib, Integer>{

}