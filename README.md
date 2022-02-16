# ExoAlgo
This repository is a collection of exercices intended to discover various sujbects related to POO, multhithreading, Java core, algorithmics.

*  *Multithreading*:
The source code related to multithreading is located in: `src\main\java\playingwiththread\`package.
  1. **StaticSynchronizer** class uses **synchronised** on static methods. Therefore, the treads are executed one after the other.
  2. **StaticClassSynchronizer** class also uses **synchronized** key word, but in a block and using StaticClassSynchronizer.class as the lock. The threads will also run one after the other.
  3. **ThisSynchronizer** class synchronizes an instance method. The keyword **synchronized** is applied to **this**, which is the current instance of the class.
  4. **DifferentInstanceSynchronizer** class aslo synchronises an instance method but runs threads on different instances of the class. The threads are executed simultaneously.
  5. **StaticAndInstanceSynchronizer** class synchronises both a static method and an instance method. Runs two threads with both methods. The threads are executed simultaneously because they are not blocking the same resources.
  6. **ReentredLockSynchronizer** classes also locks instance methods but using a **ReentrantLock** object and its methods **lock()** and **unlock()**
  7. **WaterTankMonitor** class simulates the filling and emptying of a **WaterTank** object. The class has an attribute WaterTank and a method fill() that fills the tank once it is empty and waits otherwise. Same goes to the emptying operation. The methods are implemented uning **wait()** and **notify()** 
  8. **ThreadWithCallableFuture** class executes a thread with a **FutureTask** objects in order to get the result of the execution. As a thread only accepts an object of type **Runnable**, a FutureTask is provided with a **Callable** object to store the result.
  9. **RunnableWithResult** class simulates the behavior of the previous class by implementing **Runnable** interface, adding a **result Object** to store the result of the method run(), and implementing a method **get()** to retrieve to result one the thread finishes.
  10. **CountDownLatchExample** class is an example of CountDownLatch use case. Four Worker threads are executing, and the main thread is waiting for them to finish using a CountDownLatch Object.
  11. **CyclicBarrierExample** class is an example of CyclicBarrier use case. In this class, three threads are instanciated: one parent thread and two child threads that will execute subtasks. The **CyclicBarrier** object detects when all the threads have arrived to the barrier and allows computation of the final outputin the parent thread.
  12. **ProducerConsumerExample** this class simulates a Producer/Consumer pattern. A producer thread will write elements in a LinkedList when it is empty and a consumer thread will read elements from the list when it is not empty. The producer should not write when the list is full and the consumer should not read when the list is empty.
