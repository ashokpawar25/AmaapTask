package com.birthday.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.birthday.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer>
{
	List<Friend> findAll();
}
