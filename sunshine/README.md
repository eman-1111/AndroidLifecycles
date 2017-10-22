# Sunshine  Codelab

This folder contains the source code for the Architecture Components codelab. 
In this codelab you'll use the different components to make a weather app called Sunshine that pulls data from a remote source, stores it locally, and displays it to the user.

### App is built to:

* Follow the principles in the [Guide to App Architecture](https://developer.android.com/topic/libraries/architecture/guide.html).
* Use the Lifecycle library, which includes [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html) and [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html).
* Use the [Room data persistence library](https://developer.android.com/topic/libraries/architecture/room.html).
* Pull data from a remote store, store it locally, and display it in a reactive UI to the user.

### Sunshine: Architecture

There will be two activities (MainActivity and DetailActivity) with their own ViewModels (MainActivityViewModel and DetailActivityViewModel) and associated LiveData. They will use a repository class (SunshineRepository), which will manage communications between a SQLite database and a network data source. The WeatherNetworkDataSource requests weather data from a mock weather server using two services (SunshineSyncIntentService and SunshineFirebaseJobService). The mock weather server returns randomized JSON data.

![Sunshine Architecture](https://codelabs.developers.google.com/codelabs/build-app-with-arch-components/img/a1289de09bf73c94.png)

