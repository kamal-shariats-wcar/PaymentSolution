package com.mydigipay.paymentService.user.service;


import com.mydigipay.paymentService.base.service.IGenericService;
import com.mydigipay.paymentService.user.model.DebtCard;
import com.mydigipay.paymentService.user.web.viewModel.DebtCardVM;

import java.util.List;

public interface IDebtCardService extends IGenericService<DebtCard, Integer> {

  DebtCard update(DebtCardVM debtCardVM);

  List<DebtCard> findAll(Integer userId);
}
