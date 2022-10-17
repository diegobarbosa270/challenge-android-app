package com.dob.desafioapp.application

import com.dob.desafioapp.data.database.AppDataBase
import com.dob.desafioapp.data.repository.HomeRepository
import com.dob.desafioapp.data.repository.IHomeRepository
import com.dob.desafioapp.data.request.ICardApi
import com.dob.desafioapp.network.RequestServiceApi
import com.dob.desafioapp.domain.usecase.HomeUseCase
import com.dob.desafioapp.presentation.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val singleModuleHome = module {
    single {
        RequestServiceApi.getInstanceRetrofit("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
            .create(ICardApi::class.java)
    }
}

val roomModule = module {
    factory { AppDataBase.getIntanceDatabase(androidApplication()) }
    factory { get<AppDataBase>().cardDAO }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}

val useCaseModule = module {
    factory { HomeUseCase(get()) }
}

val repositoryModule = module {
    factory<IHomeRepository> { HomeRepository(get(), get()) }
}