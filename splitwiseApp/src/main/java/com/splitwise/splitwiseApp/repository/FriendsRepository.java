package com.splitwise.splitwiseApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.splitwise.splitwiseApp.entity.Friends;

public interface FriendsRepository extends JpaRepository<Friends, Long>{

	@Query(value="select e.spend as spend from friends e", nativeQuery=true)
	List<Friends> spend();
}
