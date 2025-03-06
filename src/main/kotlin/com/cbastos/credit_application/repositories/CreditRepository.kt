package com.cbastos.credit_application.repositories

import com.cbastos.credit_application.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface CreditRepository : JpaRepository<Credit, Long> {

    fun findByCreditCode(creditCode: UUID): Credit?
<<<<<<< HEAD
    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID = ?1", nativeQuery = true)
=======
    @Query(value = "SELECT * FROM CREDIT WHERE CREDIT_ID = ?1", nativeQuery = true)
>>>>>>> 0b607edf493596a1dac6cfd627d186228eddfcd6
    fun findAllByCustomer(customerId: Long): List<Credit>
}