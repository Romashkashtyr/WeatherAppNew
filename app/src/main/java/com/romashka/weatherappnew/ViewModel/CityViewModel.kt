package com.romashka.weatherappnew.ViewModel

import androidx.lifecycle.ViewModel
import com.romashka.weatherappnew.Repository.CityRepository
import com.romashka.weatherappnew.Server.ApiClient
import com.romashka.weatherappnew.Server.ApiServices

class CityViewModel(val repository: CityRepository): ViewModel() {
    constructor():this(CityRepository(ApiClient().getClient().create(ApiServices::class.java)))



    fun loadCity(q: String, limit: Int) =
        repository.getCities(q,limit)

}