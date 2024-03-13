package com.project.placementagency.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.placementagency.model.AppliedJobs;
import com.project.placementagency.model.Employer;
import com.project.placementagency.model.Job;
import com.project.placementagency.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findOneByEmailIgnoreCaseAndPassword(String email,String password);
	
//	@Modifying
//	@Query(value = "insert into user_jobs values(:uid,:jid)",nativeQuery = true)
//	void insertUser_Jobs(@Param("uid") int uid,@Param("jid") int jid);
	
//	@Modifying
	@Query("select u from User u")
	public List<User> selectUser();
	
	@Query("select j from Job j")
	public List<Job> selectJob();

	boolean existsByEmail(String email);

//	@Query("select e from Job j join j.employer e on j.employer.companyId=e.companyId where j.user.userId = ?1")
//	List<Employer> getEmployers(int uid);
//	
//	@Query("select j from Job j join j.employer e on j.employer.companyId=e.companyId where j.user.userId = ?1")
//	List<Job> getJobs(int uid);
	
	@Query("select e as employer,j as job,j.user.userId as uid from Job j join j.employer e on j.employer.companyId=e.companyId where j.user.userId = ?1")
	List<AppliedJobs> getAppliedJobs(int uid);

	@Query("select e as employer,j as job,j.user.userId as uid from Job j join j.employer e on j.employer.companyId=e.companyId")
	List<AppliedJobs> getAllJobs();
	
	@Query("select j.user from Job j where j.jobId = ?1")
	User isUserNull(int jid);
	
	@Modifying
	@Query("update Job j set j.user.userId = ?1 where j.jobId = ?2")
	void updateApply(int uid,int jid);
	
//	@Modifying
//	@Query(value = "SELECT * FROM user",nativeQuery = true)
//	public List<User> findAll();

	@Query("select e from Employer e where e.companyId = ?1")
	public Employer getEmployerById();
	
	@Query(value = "select * from user where first_name = 'Ashish'", nativeQuery = true)
	public List<User> allUser();
	
//	@Modifying
//	@Query(value = "insert into user (first_name,last_name,email,password) values ('dolly','teotia','dolly@gmail.com',4455)", nativeQuery = true)
//	public void update();
	
//	@Modifying
//	@Query("insert into User (1,2)")
//	public List<Job> mapUserJob();
}
