package com.romashka.weatherappnew.Repository

import com.romashka.weatherappnew.Server.ApiServices

class CityRepository(val api: ApiServices) {
    fun getCities(q: String, limit: Int) =
        api.getCitiesList(q,limit, "1f8c76634fbcb6d96791da5e044c13ae")
}