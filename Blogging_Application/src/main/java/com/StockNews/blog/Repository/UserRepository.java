package com.StockNews.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StockNews.blog.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
