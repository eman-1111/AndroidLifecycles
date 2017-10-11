Android lifecycle-aware components codelab
===========================================

This sample showcases the following Architecture Components:

* [ViewModels](https://developer.android.com/reference/android/arch/lifecycle/ViewModel.html) - provides a way to create and retrieve objects that are bound to a specific lifecycle. 
A ViewModel typically stores the state of a view's data and communicates with other components,
such as data repositories or the domain layer which handles business logic.
To read an introductory guide to this topic, see [ViewModels](https://developer.android.com/topic/libraries/architecture/viewmodel.html)
* [LifecycleOwner](https://developer.android.com/reference/android/arch/lifecycle/LifecycleOwner.html) / [LifecycleRegistryOwner](https://developer.android.com/reference/android/arch/lifecycle/LifecycleRegistryOwner.html) - 
both LifecycleOwner and LifecycleRegistryOwner are interfaces that are implemented in the LifecycleActivity and LifecycleFragment classes. 
You can subscribe other components to owner objects which implement these interfaces, 
to observe changes to the lifecycle of the owner. To read an introductory guide to this topic, see [Handling Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle.html) .
* [LiveData](https://developer.android.com/reference/android/arch/lifecycle/LiveData.html) - allows you to observe changes to data across multiple components of your app without creating explicit,
 rigid dependency paths between them. LiveData respects the complex lifecycles of your app components, including activities,
 fragments, services, or any LifecycleOwner defined in your app. 
 LiveData manages observer subscriptions by pausing subscriptions to stopped LifecycleOwner objects,
 and cancelling subscriptions to LifecycleOwner objects that are finished. To read an introductory guide to this topic, see [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html).


## Features

 in this codelab, you implement examples of each of the components described above.
 You begin with a sample app and add code through a series of steps, integrating the various architecture components as you progress.








