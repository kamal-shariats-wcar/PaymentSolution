package com.mydigipay.paymentService.debtCardTransfer.constant;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum DebtCardTransferErrorType {
    error_boom_service_exception(0, "سرویس دهنده پاسخگو نیست لطفا مجددا تلاش کنید", "error.boom.service.exception"),
    error_service_forbidden(1, "درخواست سرویسی که اجازه اجرای آن را ندارید", "error.service.forbidden"),
    error_invalid_card_info(2, "اطلاعات کارت معتبر نیست", "error.invalid.card.info"),
    error_invalid_card(3, "کارت یا سپرده معتبر نیست", "error.invalid.card"),
    error_card_expire(4, "کارت منقضی و یا مسدود شده است", "error.card.expire"),
    error_card_user_forbidden(5, "کاربر یا دارنده کارت اجازه انجام عملیات ندارد", "error.card.user.forbidden"),
    error_internal_bank(6, "صادر کننده کارت پاسخگو نمی باشد لطفا تراکنش در زمان دیگر ارسال شود", "error.internal.bank"),
    error_parameter_invalid(7, "پارامتر یا پارامترهای ورودی به درستی وارد نشده است", "error.parameter.invalid"),
    error_card_number_mandatory(8, "شماره کارت الزامی است", "error.card.number.mandatory"),
    error_amount_more_than_limit(9, "مبلغ خرید بیشتر از سقف برداشت است", "error.amount.more.than.limit"),
    error_credit_not_enough(10, "موجودی کافی نیست", "error.credit.not.enough"),
    error_pay_amount_invalid(11, "مبلغ پرداختی معتبر نیست", "error.pay.amount.invalid"),
    error_transaction_id_invalid(12, "شناسه پرداخت نامعتبر است", "error.transaction.id.invalid"),
    error_card_producer_invalid(13, "صادرکننده کارت اشتباه است", "error.card.producer.invalid"),
    error_invalid_cvv2(14, "cvv2 اجباری است", "error.invalid.cvv2"),
    error_expDate_mandatory(15, "تاریخ انقضا اجباری است", "error.expDate.mandatory"),
    error_destination_card_number_mandatory(16, "شماره کارت مقصد الزامی است", "error.destination.card.number.mandatory"),
    error_destination_account_type_mandatory(17, "نوع سپرده مقصد اجباری است", "error.destination.account.type.mandatory"),
    error_bank_not_response(18, "بانک پاسخگو نمی باشد", "error.bank.not.response"),
    error_amount_limit_each_transaction(19, "حداکثر مبلغ قابل انتقال در هر تراکنش 10,000,000 ریال می باشد", "error.amount.limit.each.transaction"),
    error_pin_mandatory(20, "رمز کارت اجباری است", "error.pin.mandatory"),
    error_holder_transaction_id_duplicated(21, "شماره مرجع سرویس مشخصات کارت تکراری است", "error.holder.transaction.id.duplicated"),
    error_boom_service_unavailable(22, "سیستم بوم قادر به سرویس دهی به درخواست کاربر نیست", "error.boom.service.unavailable"),
    error_access_denied(23, "دسترسی این برنامه برای بانک درخواست شده برقرار نیست", "error.access.denied")
    ;

    private Integer id;
    private String message;
    private String key;

    DebtCardTransferErrorType(Integer id, String message, String key) {
        this.id = id;
        this.message = message;
        this.key = key;

    }

    public static DebtCardTransferErrorType getType(String key) {
        Optional<DebtCardTransferErrorType> typeOptional = Arrays.stream(DebtCardTransferErrorType.values())
                .filter(type -> type.key.equals(key)).findFirst();
        if (typeOptional.isEmpty()) {
            return null;
        } else return typeOptional.get();
    }
}
