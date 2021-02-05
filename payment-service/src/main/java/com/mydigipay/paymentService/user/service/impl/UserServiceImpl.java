package com.mydigipay.paymentService.user.service.impl;


import com.mydigipay.paymentService.base.service.GenericServiceImpl;
import com.mydigipay.paymentService.user.model.User;
import com.mydigipay.paymentService.user.repository.UserRepository;
import com.mydigipay.paymentService.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements IUserService {

  private final UserRepository repository;

  @Override
  public JpaRepository<User, Integer> getRepositoryBean() {
    return repository;
  }
}
