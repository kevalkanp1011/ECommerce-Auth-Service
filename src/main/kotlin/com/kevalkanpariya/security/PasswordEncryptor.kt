package com.kevalkanpariya.security

import io.ktor.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

private val SECRET_KEY = "4968110512"
private val ALGORITHM = "HmacSHA1"

private val HASH_KEY = hex(SECRET_KEY)
private val HMAC_KEY = SecretKeySpec(HASH_KEY, ALGORITHM)

fun String.hash(): String {
    val hmac = Mac.getInstance(ALGORITHM)
    hmac.init(HMAC_KEY)
    return hex(hmac.doFinal(this.toByteArray(Charsets.UTF_8)))
}