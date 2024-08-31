# Multithreading

Definition:
- The ability of CPU to perform different tasks concurrently

## Process
- An instance of program execution
- when enter an application is a process

## Thread
- Lightweight process
- A unit of execution within a given program
- A single process may contain multiple threads
- Each thread in the process shares the memory and resources

**Lifecycle**
- **New State** - every thread is in this state till is called start()
- **Active State** - every thread is in this state after we call start()
  It has 2 states:
    * runnable
    * running
- **Blocked State** - every thread is in state when it's waiting for some thread to finish
- **Terminated** - every thread is in this state after it's done doing it's required task

## Implementing Runnable vs Extending Thread class

- Which approach is better?
    - If we extend Thread then we can't extend any other class (big disadvantage)
    - Implement Runnable approach there is no restriction to extension af class

## .join() operation in Java
- when create and start other threads, they run concurrently with the mai thread
  unless instructed otherwise. No thread waits for other thread
- the main thread could be any thread which created the thread on which .join()
  is being called
- The parent thread waits for the completion of the child thread and then 
  continues with its execution

## Daemon and User Threads
- Based on surface of execution there is 2 types of threads:
    * Daemon Threads
    * User Threads
- The main thread is the last thread to finish the execution
- Daemon threads are helper threads running in the background with low priority
- Daemon threads are terminated by the JVM after all threads are terminated
- User threads are allowed to terminate once they are done,
  however the daemon threads are shutdown by JVM once all threads are done 

## Thread priority
- Thread scheduler decides the priority of multiple threads 
- threads have their priorities and the higher priority thread runs first
- 1 priority is MIN_PRIORITY
- 10 priority is MAX_PRIORITY
- 5 priority is AVERAGE_PRIORITY
- Threads with the same priority gets executed in FIFO manner
- The threads scheduler stores the threads in a queue

## Thread Pool
- Software design pattern for achieving concurrency of execution in a program

## Executor Service
- simplifies running tasks in asynchronous mode
- automatically provides a pool of threads and API for assigning tasks to it
- The following line of code will create a thread pool with 10 threads:
- `ExecutorService executor = Executors.newFixedThreadPool(10);`

Types of `ExecutorService`:
- SingleThreadExecutor
- FixedThreadPoolExecutor
- CachedThreadPool
- ScheduledExecutor

## Concurrent Collections

- Collections are not thread safe
- To make them thread safe:
    - Use `Collections.synchronize()` method
    - Use the concurrent collections which are synchronized

Types:
### Countdown Latch
- synchronization utility that allows one or more threads to wait until
    a set of operations which is being performed in another thread completes
- controlling the flow of executing concurrent programs
- coordination among multiple threads
- thread synchronization in a single thread context
- 
### Blocking Queue
- data structure which allows multiple threads to safely put items to the 
    queue and take items off the queue
- if a thread try to take an item from a queue which is empty it will be
paused of block until an item becomes available
- if a thread try to add an item to a full queue it will be blocked until the
place becomes available
- follow FIFO
- It's a parent of 2 interfaces
    - BlockingQueue
    - TransferQueue

Implementations of Blocking Queue:
- `ArrayBlockingQueue`
- `LinkedBlockingQueue`
- `PriorityBlokingQueue`
- `DelayQueue`
- `SynchronousQueue`

Blocking Queue Operations
- `put(E e)`
    - adds the specified method e to te queue if the space is available
    - if the queue is full it is blocked until the space become available
- `take()`
    - removes the head of the queue
- `offer(E e)`
    - adds the specified element to the queue if there are space
    - returns false or true if the operation was successful
- `poll()`
    - retrieves the element of the head of the queue
    - returns null if the queue is empty
    - does not block the queue
- `peek()`
    - retrieves but does not remove the head of the queue