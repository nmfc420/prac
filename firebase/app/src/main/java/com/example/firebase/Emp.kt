package com.example.firebase

class Emp {
    private var ename: String? = null
    private var phone: String? = null

    fun getename(): String? {
        return ename
    }
    fun setename(e: String?) {
        this.ename = e
    }
    fun getPhone(): String? {
        return phone
    }
    fun setPhone(p: String?) {
        this.phone = p
    }
}