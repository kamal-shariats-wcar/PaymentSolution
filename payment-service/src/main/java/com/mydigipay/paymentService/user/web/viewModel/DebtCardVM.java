package com.mydigipay.paymentService.user.web.viewModel;


import com.mydigipay.paymentService.annotation.Length;
import com.mydigipay.paymentService.user.model.DebtCard;
import com.mydigipay.paymentService.user.model.User;
import com.mydigipay.paymentService.user.web.validation.AddDebtCardValidationGroup;
import com.mydigipay.paymentService.user.web.validation.UpdateDebtCardValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class DebtCardVM {

    @NotNull(groups = UpdateDebtCardValidationGroup.class)
    @Null(groups = AddDebtCardValidationGroup.class)
    private Integer id;
    @NotEmpty(groups = {UpdateDebtCardValidationGroup.class, AddDebtCardValidationGroup.class})
    @Size(min = 3, max = 40, groups = {UpdateDebtCardValidationGroup.class, AddDebtCardValidationGroup.class})
    private String title;
    @Length(groups = AddDebtCardValidationGroup.class, min = 16, max = 16)
    @Pattern(regexp = "[0-9]+", groups = {AddDebtCardValidationGroup.class})
    @NotEmpty(groups = { AddDebtCardValidationGroup.class})
    @Null(groups = UpdateDebtCardValidationGroup.class)
    private String cardNumber;

    @Length(groups = {UpdateDebtCardValidationGroup.class, AddDebtCardValidationGroup.class}, min = 4, max = 4)
    @NotEmpty(groups = {UpdateDebtCardValidationGroup.class, AddDebtCardValidationGroup.class})
    @Pattern(regexp = "[0-9]+", groups = {UpdateDebtCardValidationGroup.class, AddDebtCardValidationGroup.class})
    private String expDate;

    private Integer userId;

    public DebtCard toModel() {
        DebtCard debtCard = new DebtCard();
        debtCard.setCardNumber(this.cardNumber);
        debtCard.setExpDate(this.expDate);
        debtCard.setTitle(this.title);
        debtCard.setDeleted(false);
        debtCard.setUser(new User(this.userId));
        return debtCard;
    }


}
