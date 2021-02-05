package com.mydigipay.paymentService.debtCardTransfer.model;


import com.mydigipay.paymentService.base.model.Audit;
import com.mydigipay.paymentService.user.model.DebtCard;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Version;

import javax.persistence.*;

@Entity
@Table(name = "debt_card_transfer_record",
        indexes = {@Index(name = "created_date_index", columnList = "created_date")})
@Getter
@Setter
@NoArgsConstructor
public class DebtCardTransferRecord extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debt_card_fk", nullable = false)
    private DebtCard debtCard;
    @Column(name = "destination_card_number", nullable = false)
    private String destinationCardNumber;
    @Column(name = "amount", nullable = false)
    private Long amount;
    @Column(name = "successful", nullable = false)
    private Boolean successful = false;
    @Version
    @JsonIgnore
    private Integer version;

    public DebtCardTransferRecord(DebtCard debtCard, String destinationCardNumber, Long amount, Boolean successful) {
        this.debtCard = debtCard;
        this.destinationCardNumber = destinationCardNumber;
        this.amount = amount;
        this.successful = successful;
    }
}
