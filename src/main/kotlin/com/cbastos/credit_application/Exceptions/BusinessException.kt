package com.cbastos.credit_application.Exceptions

import java.lang.RuntimeException

data class BusinessException(override val message: String?) : RuntimeException(message){
}