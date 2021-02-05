package com.mydigipay.paymentService.user.service.impl;


import com.mydigipay.paymentService.base.service.GenericServiceImpl;
import com.mydigipay.paymentService.user.model.DebtCard;
import com.mydigipay.paymentService.user.model.User;
import com.mydigipay.paymentService.user.repository.DebtCardRepository;
import com.mydigipay.paymentService.user.service.IDebtCardService;
import com.mydigipay.paymentService.user.web.viewModel.DebtCardVM;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Log4j2
public class DebtCardServiceImpl extends GenericServiceImpl<DebtCard, Integer> implements IDebtCardService {

  private final DebtCardRepository repository;

  @Override
  public JpaRepository<DebtCard, Integer> getRepositoryBean() {
    return repository;
  }

  @Override
  @Transactional
  public void save(DebtCard debtCard) {
    Integer userId = 1;
    if (repository.existsByUser_IdAndCardNumber(userId, debtCard.getCardNumber())) {
      Optional<DebtCard> optionalDebtCard = repository.findByUser_IdAndCardNumber(userId, debtCard.getCardNumber());
      if (optionalDebtCard.isEmpty()) {
        log.error("debt card not found");
        throw new RuntimeException(); // TODO: 1/17/2021  
      } else
        repository.updateTitleAndExpDateAndSetDeletedFalse(optionalDebtCard.get().getId(), debtCard.getTitle(), debtCard.getExpDate());
    } else {
      try {
        debtCard.setUser(new User(userId));
        super.save(debtCard);
      } catch (Exception e) {
        log.error(e.getMessage());
        throw new RuntimeException(); // TODO: 1/17/2021  
      }
    }
  }

  @Override
  @Transactional
  public DebtCard update(DebtCardVM debtCardVM) {

    DebtCard debtCard = find(debtCardVM.getId()).get();
    try {
      repository.updateTitleAndExpDateAndSetDeletedFalse(debtCard.getId(), debtCardVM.getTitle(), debtCardVM.getExpDate());
      debtCard.setTitle(debtCardVM.getTitle());
      debtCard.setExpDate(debtCardVM.getExpDate());
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new RuntimeException(); // TODO: 1/17/2021  
    }
    return debtCard;


  }

  @Override
  public List<DebtCard> findAll(Integer userId) {
    return repository.findAllByUser_IdAndDeletedIsFalse(userId);
  }

  @Override
  public Optional<DebtCard> find(Integer integer) {
    Optional<DebtCard> optionalDebtCard = super.find(integer);

    if (optionalDebtCard.isEmpty()) {
      throw new RuntimeException("error.debt.card.not.found");
    }

    if (!optionalDebtCard.get().getUser().getId().equals(1)) { //todo 1
      throw new RuntimeException();
    }

    if (optionalDebtCard.get().getDeleted().equals(Boolean.TRUE)) {
      throw new RuntimeException();
    }
    return optionalDebtCard;
  }

  @Override
  public void delete(Integer id) {

    DebtCard debtCard = find(id).get();
    try {
      repository.logicalDelete(debtCard.getId());
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new RuntimeException();
    }
  }


}
