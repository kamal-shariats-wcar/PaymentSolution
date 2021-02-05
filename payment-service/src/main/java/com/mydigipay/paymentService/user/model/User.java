package com.mydigipay.paymentService.user.model;

import com.mydigipay.paymentService.base.model.Audit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User extends Audit implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, name = "name")
    @Nationalized
    private String name;

    @Column(length = 50, name = "last_name")
    @Nationalized
    private String lastName;


    @Column(name = "identity_number")
    private String identityNumber;

    private String number;

    public User(Integer id) {
        this.id = id;
    }


}
