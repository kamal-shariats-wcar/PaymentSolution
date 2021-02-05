package com.mydigipay.paymentService.user.web.api;


import com.mydigipay.paymentService.user.model.DebtCard;
import com.mydigipay.paymentService.user.service.IDebtCardService;
import com.mydigipay.paymentService.user.web.validation.AddDebtCardValidationGroup;
import com.mydigipay.paymentService.user.web.validation.UpdateDebtCardValidationGroup;
import com.mydigipay.paymentService.user.web.viewModel.DebtCardVM;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user/debt-card")
@RequiredArgsConstructor
public class DebtCardController {

    private final IDebtCardService service;

    @PostMapping
    public DebtCard create(@RequestBody @Validated(AddDebtCardValidationGroup.class) DebtCardVM debtCardVM) {

        DebtCard debtCard = debtCardVM.toModel();
        service.save(debtCard);
        return debtCard;
    }

    @PutMapping
    public DebtCard update(@RequestBody @Validated(UpdateDebtCardValidationGroup.class) DebtCardVM debtCardVM) {
        return service.update(debtCardVM);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    @GetMapping("{userId}")
    public List<DebtCard> findAll(@PathVariable Integer userId) {
        return service.findAll(userId);
    }

}
