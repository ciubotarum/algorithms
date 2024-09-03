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


## Concurrent Map
- Interface that can be accessed safely by multi-threads

Internal Implementation and working of Concurrent Map
- Adding an element to concurrent hash map
    - Hashing and Determining Segment
    - Acquiring Lock
    - Insertion in Segment
    - Releasing Lock
- Fetching an element from concurrent hash map
    - Same steps

## Cyclic Barrier

- When a thread reaches the checkpoint it calls the await method on the 
Cyclic barrier
- The thread waits there until all the other threads are also reached the checkpoint

## Exchanger
- Synchronization point at which threads compare and swap elements in a 
concurrent environment
- 2 threads can call exchange method on the exchanger object
- is useful when 2 threads need to synchronize and exchange data before
proceed to their tasks 

## Copy On Write Array _(COWA)_

- Use when you have multiple threads trying to access and modify data
- When a thread want to read from the array it creates a snapshot of the array
- It does the same for the write operation
- When a change is complete that is considered the latest version of the array

## Locks
- locks provide a way to control access shared resources 
- ensures that only one thread access the resource at a given time

Synchronized Blocks VS Locks
- Synchronized Blocks use the `synchronized` keyword to ensure that only one 
thread can execute a particular section of code in a particular time
- Locks provide more control on locking mechanisms
- Interface Lock allow to manually acquire and release the locks
- Use Synchronized Blocks where performance is not that critical
- Use Locks for complex synchronization scenarios where flexibility are required

### Reentrant Lock
- an implementation of Lock Interface
- it allows a thread to acquire the same lock multiple times without 
blocking himself
- Important methods:
    - `getHoldCount()` - return an integer which is a number of times the
    current thread has acquired the lock
    - `tryLock()` - an approach when we request a thread to try a lock,
    the result is a boolean, tells if a thread was successfully acquired or not
    - `tryLock(timeout, timeUnit)` - ask a thread to acquire the lock and be 
    blocked for the given time duration, if the lock can't be acquired in the time
    period it returns false
    - `isHeldByCurrentThread()`
    - `getQueueLength()`
    - `newCondition()` 

### Read Write Lock
- a synchronization method which allows multiple threads to read but only one
to write
- used when is more likely to read than to write

### Deadlock
- it occurs when 2 or more threads a blocked forever, each waiting another to
release a resource they need to proceed
- how to handle:
    - write in console `jps -l` while the code is still running
    - get the process id and type `kill -Id process_id`

## Atomic Variables
- important tool in writing concurrent code
- support lock free thread safe operations on single variables
- Types of atomic variables:
  - AtomicInteger
  - AtomicBoolean
  - AtomicLong
- Basic operations:
  - `get()` - fetches the current value
  - `set()` - set some value
  - `compareAndSet(expected, update)` - sets the value to update value
  - `getAndIncrement()`/`incrementAndGet()`
  - `getAndDecrement()`/`decrementAndGet()`

## Semaphores
- is a synchronization mechanism used to control access to a shared resource in
concurrent programming
- `acquire()` - thread request a permit
- it provides a multi permits
- Methods of Permits
    - `tryAcquire()` - thread will try to acquire a permit, if there is no permit
    available it won't be blocked and try to do something else
    - `tryAcquire(timeout)` - the same but have timeout
    - `availablePermits()` - nr. of available permits within a given semaphore
    - `new Semaphore(count, fairness)`

## Mutex
- Is a short form of the word mutual exclusion
- It is a synchronization mechanism used to control access to a shared resource
- Ensures that only one thread is able to access a critical section of a shared
resource at a given time

## Fork Join
- a concurrency framework
- Fork Join can create subtasks of a task to simplify the problem  
- utilization of multi cores processors
- simplified parallelism
- Key Concepts:
    - Forking - process of breaking down tasks into smaller tasks
    - Joining - process of waiting a fork task to complete and combine the sol.
    - RecursiveTask - abstract class and used for teh task that return a result
    - Recursive Action - use for tasks that do not return any result
- Fork Join Pool
    - a specialized implementation of executor service 
    - Work stealing algorithm - manage and balance the work load among threads
    if a thread finished his tasks it can steal tasks from other threads
    - Parallelism 
    - Fork & Join Algorithm - a task can be split into smaller subtasks and 
    the results can be combined
    - Managing Fork Join Tasks - these tasks encapsulate the logic for 
    splitting the work and combining the results