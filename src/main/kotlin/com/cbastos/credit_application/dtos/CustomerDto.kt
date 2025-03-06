package com.cbastos.credit_application.dtos

import com.cbastos.credit_application.entities.Address
import com.cbastos.credit_application.entities.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "First name is required")
    val firstName : String,
    @field:NotEmpty(message = "Last name is required")
    val lastName : String,
    @field:CPF(message = "CPF is required")
    val cpf : String,
    @field:NotNull(message = "Income is required")
    val income : BigDecimal,
    @field:Email(message = "Email is required")
    val email : String,
    @field:NotEmpty(message = "Password is required")
    val password : String,
    @field:NotEmpty(message = "Zip code is required")
    val zipCode : String,
    @field:NotEmpty(message = "Street is required")
    val street : String
) {
    fun toEntity() : Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
