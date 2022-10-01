package com.sushobh.jtclib

interface JTCCustomDataHandler {
    fun handle(key : String) : JTCViewDataParser?
}