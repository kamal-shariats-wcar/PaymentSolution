package com.mydigipay.paymentService.user.repository;

import com.mydigipay.paymentService.user.model.DebtCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DebtCardRepository extends JpaRepository<DebtCard, Integer> {

    @Modifying
    @Query("update DebtCard set title=?2 , expDate=?3 ,deleted=false where id=?1")
    void updateTitleAndExpDateAndSetDeletedFalse(Integer id, String title, String expDate);

    @Modifying
    @Query("update DebtCard set deleted=true where id=?1")
    void logicalDelete(Integer id);

    List<DebtCard> findAllByUser_IdAndDeletedIsFalse(Integer userId);
    List<DebtCard> findAllByUser_Id(Integer userId);

    Boolean existsByUser_IdAndCardNumber(Integer userId, String cardNumber);
    Optional<DebtCard> findByUser_IdAndCardNumber(Integer userId, String cardNumber);
}
