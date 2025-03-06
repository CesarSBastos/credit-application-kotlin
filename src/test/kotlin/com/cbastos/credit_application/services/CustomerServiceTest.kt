package com.cbastos.credit_application.services


import com.cbastos.credit_application.entities.Address
import com.cbastos.credit_application.entities.Customer
import com.cbastos.credit_application.repositories.CustomerRepository
import com.cbastos.credit_application.services.impl.CustomerService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal

@ActiveProfiles("test")
@ExtendWith(MockitoExtension::class)
class CustomerServiceTest {
    @Mock lateinit var customerRepository: CustomerRepository
    @InjectMocks lateinit var customerService: CustomerService

    @Test
    fun `should create a customer`(){
        //given
        val fakeCustomer: Customer = buildCustomer()
        //when
        val actual : Customer = customerService.save(fakeCustomer)
        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
    }

    private fun buildCustomer(
        firstName: String = "John",
        lastName: String = "Doe",
        cpf: String = "12345678900",
        email: String = "teste@gmail.com",
        password: String = "123456",
        zipCode: String = "12345678",
        street: String = "Rua 1",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
        id: Long = 1L
    ) = Customer(
        firstName = firstName,
        lastName = lastName,
        cpf = cpf,
        email = email,
        password = password,
        address = Address(
            zipCode = zipCode,
            street = street
        ),
        income = income,
        id = id,
    )
}