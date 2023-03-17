

// import javax.swing.text.View// 高阶函数

// // 高阶函数，是 Kotlin 函数式编程的基石，是各种框架的关键元素。理解高阶函数，有助于理解 携程的 launch async 函数就会轻松一些，阅读携程的源代码也会不那么吃力；

// Type        不使用高阶函数           使用高阶函数
// 定义方      需要额外定义接口        不需要额外定义接口
// 调用方         代码繁琐              代码简洁、清晰
// 性能            差           借助 inline 的情况，性能极高

// *  函数类型
// 就是函数的类型，在 Kotlin 中函数是一等公民。

// (Int, Int): Float 就是函数 add 的类型
// fun add(a: Int, b: Int): Float{ return (a + b).toFloat()}

// 将函数的 “参数类型”和“返回值类型”抽离出来后，就得到了函数类型。（Int, Int): Float 就代表了参数类型是两个 Int，返回值类型是 Float 的函数类型

// ** 高阶函数是将函数用作参数或返回值的函数。**

// fun setOnClickListener(l: (View) -> Unit){ ... }
// 换句话说，当一个函数的参数或者是返回值，他们当中有一个是函数的情况下，那么这个函数就是高阶函数。

// Lambda
// Lambda 表达式作为函数参数的，就可以理解 Lambda 是函数的简写
// fun onClick(v: View):Unit {}
// setOnClickListener(::onClick)
// // 用 Lambda 表达式来替代函数的引用
// setOnClickListener({v: View -> ...})

// SAM 转换
// SAM 是 Single Abstract Method 缩写，意思是只有一个抽象方法的类或者接口。在 Kotlin 和 Java8 里，SAM 代表着只有一个抽象方法的接口。只要符合要求，编译器就能进行 SAM 转换。
// 必须是接口，且抽象方法只能有一个

// Lambda 引发的 8 种写法
// 第一种。
// image.setOnClickListener(object: View.OnClickListener {
//     override fun onClick(v: View){
//         .....
//     }
// })

// 第二种
// image.setOnClickListener(View.OnClickListener{ v: View ->
//         ...
// })

// 第三种
// image.setOnClickListener({ v: View ->
//     。。。
// })

// 第四种
// image.setOnClickListener({ v->
//     ...
// })

// 第五种
// image.setOnClickListener({ it->
//     ...
// })

// 第六种
// image.setOnClickListener({
//     ...
// })

// 第七种

// image.setOnClickListener (){ it->
//     ...
// }

// 第八种 
// image.setOnClickListener{ 
//     ...
// }