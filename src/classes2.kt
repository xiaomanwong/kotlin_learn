

// 面向对象
// 类，接口，集成，嵌套，数据类，密封类

// 类，对某种事物的抽象模型
class Person(val name: String, var age: Int)

// val 修饰，意味着初始化以后将无法修改。只有 get 没有 set
// var 修饰，意味着可以被随意修改，既有 get 也有 set

// 默认情况下， Kotlin 定义的类，都是 public，编译器会帮我们生成 "构造函数"，对于类中的属性， Kotlin 编译器也会根据实际情况，自动生成 get 和 set。

// 自定义属性 get
class Person1(val name: String, var age: Int) {
    val isAudlt
        get() = age >= 18
}

// 自定义属性 setter
// 有的时候，我们不希望属性的 set 方法在外部访问，那么我们可以给 set 方法加上可见性修饰符，比如这里，我们可以给 set 方法加上 private，
class Person2(val name: String) {
    var age: Int = 0
        set(value: Int) {
            log(value)
            field = value
        }

    fun log(value: Any) {
        println(value)
    }
}

// 抽象类与继承
// Kotlin 抽象类的定义和 Java 几乎一致，在关键字 class  和 fun 前面追加 abstract 关键字。这样一来如果创建实例类，就必须使用匿名内部类的方式， 或者使用其子类来创建变量。这样就需要继承了
abstract class Person3(val name:String) {
    abstract fun walk()
}

// Kotlin 的继承使用 : 来表示
// 重写的方法，使用 override 关键字
// 除了抽象类以外，正常的类默认是不允许继承，承载的，编译成 Java 后，会有 final  进行修饰，因此如果想被继承 需要将类标记为 open。
// open 修饰的普通类，内部的方法和属性，默认也是不允许重写的，同样需要用 open 修饰
class Boy(name:String): Person3 (name){
    override fun walk(){

    }
}

open class Person4(){
    val canWalk:Boolean = false
    open fun walk(){}
}
class Boy2: Person4(){

    override fun walk(){}
}

// 接口和实现
// 与 Java 类似
interface Behavior {
    val canWalk:Boolean
        get() = canWalk
    fun walk(){
        //..
    }
}

class Person5: Behavior {
    override val canWalk:Boolean
        get() = true
}


// 嵌套
// Java 当中常见的嵌套类分为两种： 非静态内部类、静态内部类。
class A{
    class B{

    }
}
// 默认情况下  Kotlin 的内部嵌套类为静态的，无法直接访问外部类的成员和方法， 那么如果想定义一个普通的内部类，则在前面加上 inner 关键字
// 因此普通类，才会持有外部类的引用 
class A1 {
    inner class B {

    }
}

// 数据类
// 用于存放数据的类。 data 关键字
// 数据类编译器会默认自动生成一些有用的方法， equals、hashCode、toString、 componentN、copy
data class Person6(val name:String, val age:Int){}


val tom = Person6("Tom", 18)
val jack = Person6("Jack", 19)

println(tom.equals(jack)) // 输出：false
println(tom.hashCode())   // 输出：对应的hash code
println(tom.toString())   // 输出：Person(name=Tom, age=18)

val (name, age) = tom     // name=Tom, age=18
println("name is $name, age is $age .")

val mike = tom.copy(name = "Mike")
println(mike)             // 输出：Person(name=Mike, age=18)

//这里你需要注意的是最后的四行代码。
// “val (name, age) = tom”这行代码，其实是使用了数据类的解构声明。这种方式，可以让我们快速通过数据类来创建一连串的变量。
// 另外，就是 copy 方法。数据类为我们默认实现了 copy 方法，可以让我们非常方便地在创建一份拷贝的同时，修改某个属性。

// 密封类
// Kotlin 当中的密封类，常常用来表示某种受到限制的继承结构。这样说起来可能有点抽象，让我们换个说法：密封类，是更强大的枚举类。
// 首先，让我们看看枚举类是什么。


enum class Human {
    MAN, WOMAN
}

fun isMan(data: Human) = when(data) {
    Human.MAN -> true
    Human.WOMAN -> false
    // 这里不需要else分支，编译器自动推导出逻辑已完备
}

//我们通过 enum 就可以定义枚举类，所谓枚举，就是一组有限的数量的值。比如，人分为男人和女人。这样的分类是有限的，所以我们可以枚举出每一种情况。我们在 when 表达式当中使用枚举时，编译器甚至可以自动帮我们推导出逻辑是否完备。这是枚举的优势。
// 想要定义密封类，我们需要使用 sealed 关键字，它的中文含义也代表着“密封”。在 Android 开发当中，我们会经常使用密封类对数据进行封装。比如我们可以来看一个代码例子：


sealed class Result<out R> {
    data class Success<out T>(val data: T, val message: String = "") : Result<T>()

    data class Error(val exception: Exception) : Result<Nothing>()

    data class Loading(val time: Long = System.currentTimeMillis()) : Result<Nothing>()
}

/*

这个密封类，我们是专门用于封装网络请求结果的。
可以看到，在 Result 类当中，分别有三个数据类，分别是 Success、Error、Loading。我们将一个网络请求结果也分为了三大类，分别代表请求成功、请求失败、请求中。
这样，当网络请求有结果以后，我们的 UI 展示逻辑就会变得非常简单，也就是非常直白的三个逻辑分支：成功、失败、进行中。我们将其与 Kotlin 协程当中的 when 表达式相结合，就能很好地处理 UI 展示逻辑：如果是 Loading，我们就展示进度条；如果是 Success，我们就展示成功的数据；如果是 Error，我们就展示错误提示框。

fun display(data: Result) = when(data) {
    is Result.Success -> displaySuccessUI(data)
    is Result.Error -> showErrorMsg(data)
    is Result.Loading -> showLoading()
}
 */

 // 小结在这节课当中，我们学习了面向对象常见的概念，包括类、继承、接口、实现、枚举，还有 Kotlin 独有的数据类、密封类。同时也进一步领略到了 Kotlin 语法在一些细节的良苦用心。比如说：
 // Kotlin 的类，默认是 public 的。
 // Kotlin 的类继承语法、接口实现语法，是完全一样的。
 // Kotlin 当中的类默认是对继承封闭的，类当中的成员和方法，默认也是无法被重写的。这样的设计就很好地避免了继承被滥用。
 // Kotlin 接口可以有成员属性，还可以有默认实现。Kotlin 的嵌套类默认是静态的，这种设计可以防止我们无意中出现内存泄漏问题。
 // Kotlin 独特的数据类，在语法简洁的同时，还给我们提供了丰富的功能。
 // 密封类，作为枚举和对象的结合体，帮助我们很好地设计数据模型，支持 when 表达式完备性。