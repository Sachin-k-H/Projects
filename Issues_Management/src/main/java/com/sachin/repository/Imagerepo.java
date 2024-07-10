package com.sachin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sachin.dto.Images;
import com.sachin.dto.RegisterDto;

@Repository
public interface Imagerepo extends JpaRepository<Images, Integer> {
	/*
	 * @Query("select u from Images u where u.userid=:userid") Optional<Images>
	 * getbyuserid(@Param("userid") int userid);
	 */
	@Query("UPDATE Images SET imagestatus = 'Inactive' WHERE userid=:userid")
        void update(@Param("userid") int userid);
	
	@Query("select u from Images u where u.userid=:userid")
	List<Images> getbyuserid(@Param("userid") int userid);
}
