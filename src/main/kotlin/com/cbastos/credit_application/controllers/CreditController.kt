package com.cbastos.credit_application.controllers

import com.cbastos.credit_application.dtos.CreditDto
import com.cbastos.credit_application.dtos.CreditView
import com.cbastos.credit_application.dtos.CreditViewList
import com.cbastos.credit_application.entities.Credit
import com.cbastos.credit_application.services.impl.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto : CreditDto) : ResponseEntity<String>{
        val credit : Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - customer ${credit.customer?.firstName} saved")

    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId : Long) : ResponseEntity<List<CreditViewList>>{
        val creditVierList : List<CreditViewList> = this.creditService.findAllByCustomer(customerId).stream().map { credit : Credit -> CreditViewList(credit) }.collect(
            Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditVierList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId : Long,
            @PathVariable creditCode : UUID) : ResponseEntity<CreditView> {
        val credit : Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}