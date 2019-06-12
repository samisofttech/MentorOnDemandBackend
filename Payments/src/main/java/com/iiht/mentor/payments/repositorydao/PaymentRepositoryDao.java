package com.iiht.mentor.payments.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.mentor.payments.model.Payments;


@Repository
public interface PaymentRepositoryDao extends JpaRepository<Payments, Long>{

}
