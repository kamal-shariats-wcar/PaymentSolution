package com.mydigipay.paymentService.user.repository;


import com.mydigipay.paymentService.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
