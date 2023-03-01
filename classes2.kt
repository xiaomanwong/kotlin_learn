

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
