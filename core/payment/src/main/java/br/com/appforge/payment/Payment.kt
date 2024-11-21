package br.com.appforge.payment

object Payment {
    fun creditCard(){
        PaymentAPI.requestCreditCard()
    }

    fun pix(){
        PaymentAPI.getPixCode()
    }
}