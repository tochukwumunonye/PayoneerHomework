# PayoneerHomework  ![Android Build](https://github.com/mayokunthefirst/CardInfoFinder/workflows/Android%20Build/badge.svg) [![BCH compliance](https://bettercodehub.com/edge/badge/mayokunthefirst/CardInfoFinder?branch=master)](https://bettercodehub.com/)

PayoneerHomeWork is an Android application that uses an retrofit to fetch data from a web through an API and displays the data as a list.


![Screenshot_20210908-145256](https://user-images.githubusercontent.com/61085272/132524972-d0708872-6e3f-4c5d-ac16-1dc4bbd3b063.png)
![Screenshot_20210908-145313](https://user-images.githubusercontent.com/61085272/132524982-90d9c046-cc8e-44b1-a489-2b688c2a8e37.png)
![Screenshot_20210908-145401](https://user-images.githubusercontent.com/61085272/132525002-d6575e14-61dd-4cdb-8031-f8cd0ef8bd02.png)



## Project Characteristics

This project makes use of the following tools and solutions:

* 100% [Java](https://www.java.com/en/)
* Modern architecture (Clean Architecture, Model-View-ViewModel)
* [Android Jetpack](https://developer.android.com/jetpack)
* A single-activity architecture ( using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage Fragment operations.)
* [Pagination](https://developer.android.com/jetpack/androidx/releases/paging)
* Dependency Injection
* Material design


## Tech Stack


Minimum API level is set to 22, so the presented approach is suitable for over 92.3% of devices running Android as at the time of writing this. 

* Tech-stack
  
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android/) - dependency injection
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Testing](https://developer.android.com/training/testing/set-up-project) - Unit and Instrumented test
    * [Jetpack](https://developer.android.com/jetpack)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - deal with whole in-app navigation
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
       
    * [and more...](https://github.com/tochukwumunonye/CardInfoFinder/blob/master/buildSrc/src/main/kotlin/Dependencies.kt)
* Architecture
    * Clean Architecture (at module level)
    * MVVM (presentation layer)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)
    
* Gradle
    * [DaggerHilt](https://developer.android.com/training/dependency-injection/hilt-android)
    * Plugins ([SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args))
    
    
## Architecture
Clean Architecture is the "core architecture" of this application. The main purpose of this approach is to achieve a separation of concerns which Clean architecture helps with and in
making the code loosely coupled. This approach results in a more testable and flexible code. This approach divides the project in 3 modules: **presentation, data and domain**.

<p align="center"><a><img src="https://github.com/mayokunthefirst/CardInfoFinder/blob/master/media/clean-arch.png" width="700"></a></p>

* **Presentation**: Layer with the Android Framework, the MVVM pattern and the DI module. Depends on domain to access the use cases and on DI, to inject dependencies. This is the layer closest 
to what the user sees on the screen. 
    - **MVVM**: The Model View ViewModel pattern helps with the separation of concerns, dividing the user interface with the logic behind. It combines very well with Android Architecture Components like LiveData and DataBinding.
* **Domain**: This is also known as viewModel. It is the core layer of the application with the business logic. It contains the use cases, in charge of calling the correct repository or data member.The domain layer is independent of any other layers. 
* **Data**: Layer with the responsibility of managing the application data and exposes these data sources as repositories to the domain layer. Typical responsibilities of this layer is to retrieve data from the internet and optionally cache this data locally.

### Dependency Injection with DaggerHilt
Dependency injection is closely related to two SOLID concepts: dependency inversion, which states that high level modules should not depend on low level modules, 
both should depend on abstractions; and single responsibility principle, 
which states that every class or module is responsible for just a single piece of functionality. This application makes use of DaggerHilt as a DI library.
    
