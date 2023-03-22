package coroutines
// 协程思维模型
// 其实，学习协程，相当于一次编程思维的升级。协程思维，它与我们常见的线程思维迥然不同，当我们能够用协程的思维来分析问题以后，线程当中某些棘手的问题在协程面前都会变成小菜一碟。因此，我们相当于多了一种解决问题的手段。



// 什么是协程
// 1. 可以理解为更轻量的线程，成千上万个协程可以同时运行在一个线程当中
// 2. 其实是运行在线程当中的轻量的 Task
// 3. 不会与特定的线程绑定，可以在不同的线程之间灵活切换
// 互相协作的程序

// implementation 'org.jetbrains.kotlinx:kotlinx=corotines-core:1.6.0'

// 协程思维模型
// 从包含关系上看，协程跟线程的关系，有点像线程和进程的关系。协程不可能脱离线程运行。所以协程可以理解为运行在线程当中更轻量的 Task。
// 协程虽然运行在线程之上，但是协程并不会和线程绑定，在某些情况下，协程是可以在不同线程之间切换的。

// fun main() = runBlocking(Dispatchers.IO) {
//     repeat(3) {
//         launch {
//             repeat(3) {
//                 println(Thread.currentThread().name)
//                 delay(100)
//             }
//         }
//     }

//     delay(5000L)
// }

/*
输出结果：
DefaultDispatcher-worker-3 @coroutine#2
DefaultDispatcher-worker-2 @coroutine#3
DefaultDispatcher-worker-4 @coroutine#4
DefaultDispatcher-worker-1 @coroutine#2 // 线程切换了
DefaultDispatcher-worker-4 @coroutine#4
DefaultDispatcher-worker-2 @coroutine#3
DefaultDispatcher-worker-2 @coroutine#2 // 线程切换了
DefaultDispatcher-worker-1 @coroutine#4
DefaultDispatcher-worker-4 @coroutine#3

*/

