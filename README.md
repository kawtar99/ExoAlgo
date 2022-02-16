# ExoAlgo
This repository is a collection of exercices intended to discover various sujbects related to POO, multhithreading, Java core, algorithmics.

*  *Multithreading*:
The source code related to multithreading is located in: `src\main\java\playingwiththread\`package.
  1. StaticSynchronizer class uses **synchronised** on static methods. Therefore, the treads are executed one after the other.
  2. StaticClassSynchronizer class also uses **synchronized** key word, but in a block and using StaticClassSynchronizer.class as the lock. The threads will also run one after the other.
  3. ThisSynchronizer class synchronizes an instance method. The keyword **synchronized** is applied to **this**, which is the current instance of the class.
  4. DifferentInstanceSynchronizer class aslo synchronises an instance method but runs threads on different instances of the class. The threads are executed simultaneously.
  5. StaticAndInstanceSynchronizer class synchronises both a static method and an instance method. Runs two threads with both methods. The threads are executed simultaneously because they are not blocking the same resources.
  6. ReentredLockSynchronizer classes also locks instance methods but using a **ReentrantLock** object and its methods **lock()** and **unlock()**
  7. WaterTankMonitor class simulates the filling and emptying of a **WaterTank** object. The class has an attribute WaterTank and a method fill() that fills the tank once it is empty and waits otherwise. Same goes to the emptying operation. The methods are implemented uning **wait()** and **notify()** 
