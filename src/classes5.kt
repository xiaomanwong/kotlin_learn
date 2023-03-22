/*
    object 关键字
        1. 匿名内部类
        2. 单例模式
        3. 伴生对象
    这三种语义本质上都是在定义一个类的同时还创建了对象
*/

/*
    object 匿名内部类
    
    image.setOnClickListener(object: View.OnClickListener {
        override fun onClick(v: View?) {
            gotoPreview()
        }
    })

    在 Kotlin 中，匿名内部类还有一个特殊之处，就是我们在使用 object 定义匿名内部类的时候，其实还可以在继承一个抽象类的同时，来实现多个接口。
    interface A {
        fun funA()
    }

    interface B {
        fun funB()
    }

    abstract class Man {
        abstract fun findMan()
    }

    fun main() {
        // 这个匿名内部类，在继承了Man类的同时，还实现了A、B两个接口
        val item = object : Man(), A, B{
            override fun funA() {
                // do something
            }
            override fun funB() {
                // do something
            }
            override fun findMan() {
                // do something
            }
        }
    }
*/

/*
    object 单例模式
    在 Kotlin 当中，要实现单例模式其实非常简单，我们直接用 object 修饰类即可：
    
    object UserManager {
        fun login() {}
    }

    缺点：
    1. 不支持懒加载
    2. 不支持传参构造单例
*/


/*
    object 伴生对象
    class Person{
        companion object InnerSigleton{
            fun foo(){}
        }
    }
*/

//  私有的构造函数，外部无法调用
//            ↓
class User private constructor(name: String) {
    companion object {
        @JvmStatic
        fun create(name: String): User? {
            // 统一检查，比如敏感词过滤
            return User(name)
        }
    }
}
/*
    4 种单例模式的写法
*/

/*
借助懒加载
object UserManager {
    // 对外暴露的 user
    val user by lazy { loadUser() }

    private fun loadUser(): User {
        // 从网络或者数据库加载数据
        return User.create("tom")
    }

    fun login() {}
}*/

/*
 Double Check
class UserManager private constructor(name: String) {
    companion object {
        @Volatile private var INSTANCE: UserManager? = null

        fun getInstance(name: String): UserManager =
            // 第一次判空
            INSTANCE?: synchronized(this) {
            // 第二次判空
                INSTANCE?:UserManager(name).also { INSTANCE = it }
            }
    }
}

// 使用
UserManager.getInstance("Tom")
*/

