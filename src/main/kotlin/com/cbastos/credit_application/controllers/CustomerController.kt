package com.cbastos.credit_application.controllers

import com.cbastos.credit_application.dtos.CustomerDto
import com.cbastos.credit_application.dtos.CustomerUpdateDto
import com.cbastos.credit_application.dtos.CustomerView
import com.cbastos.credit_application.entities.Customer
import com.cbastos.credit_application.services.impl.CustomerService
import jakarta.validation.Valid
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDto : CustomerDto) : ResponseEntity<String> {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
    return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.id} saved")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<CustomerView> {
        val customer : Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
  }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        this.customerService.delete(id)
    }

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody @Valid customerUpdateDto : CustomerUpdateDto) : ResponseEntity<CustomerView> {
        val customer : Customer = this.customerService.findById(id)
        val customerToUpdate : Customer = customerUpdateDto.toEntity(customer)
        val updatedCustomer : Customer= this.customerService.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(updatedCustomer))

    }
}