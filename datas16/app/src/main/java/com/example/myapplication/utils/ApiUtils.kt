package com.example.myapplication.utils

import com.example.myapplication.dao.ApiServicesDistrito
import com.example.myapplication.dao.ApiServicesDocente


class ApiUtils {
    companion object {
        val BASE_URL="http://192.168.1.101:8091"

        fun getAPIServiceDistrito(): ApiServicesDistrito {
            return RetrofitClient.getClient(BASE_URL).create(ApiServicesDistrito::class.java)
        }
        fun getAPIServiceDocente(): ApiServicesDocente {
            return RetrofitClient.getClient(BASE_URL).create(ApiServicesDocente::class.java)
        }
    }
}


