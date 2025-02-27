package com.cbastos.credit_application.services.impl

import com.cbastos.credit_application.entities.Customer
import com.cbastos.credit_application.repositories.CustomerRepository
import com.cbastos.credit_application.services.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {
    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }
    }
    override fun delete(id: Long) {
        this.customerRepository.deleteById(id)
    }
}