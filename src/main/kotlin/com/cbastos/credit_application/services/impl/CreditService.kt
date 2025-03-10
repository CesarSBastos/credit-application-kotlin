package com.cbastos.credit_application.services.impl

import com.cbastos.credit_application.entities.Credit
import com.cbastos.credit_application.repositories.CreditRepository
import com.cbastos.credit_application.services.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(private val creditRepository: CreditRepository,
    private val customerService: CustomerService) : ICreditService{
    override fun save(credit: Credit): Credit {
        credit.apply { customer = customerService.findById(credit.customer?.id!!) }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId)
    }

    override fun findByCreditCode(customerId: Long,creditCode: UUID): Credit {
        val credit : Credit = this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Credit $creditCode not found")
        return  if(credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }

}