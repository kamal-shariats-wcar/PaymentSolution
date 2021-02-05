package com.mydigipay.paymentService.user.model;

import com.mydigipay.paymentService.base.model.Audit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Version;

import javax.persistence.*;

@Entity
@Table(name = "debt_card", indexes = {@Index(name = "card_number_index", columnList = "user_fk,card_number,deleted")})
@Getter
@Setter
@NoArgsConstructor
public class DebtCard extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    @Nationalized
    private String title;

    @Column(name = "card_number")
    private String cardNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk")
    private User user;

    @Column(nullable = false, name = "deleted")
    private Boolean deleted = false;

    @Column(nullable = false, name = "exp_date")
    private String expDate;
    
    @Version
    @JsonIgnore
    private Integer version;
}
