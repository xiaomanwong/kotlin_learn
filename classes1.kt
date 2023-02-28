fun main(args: Array<String>) {

    // 变量在
    // Java/C 当中，如果我们要声明变量，我们必须要声明它的类型，后面跟着变量的名称和对应的值，然后以分号结尾。就像这样：
    // 变量声明
    // 关键字， 变量名，变量类型，变量值
    var price: Int = 100
    // Kotlin 支持类型推导，大部分情况下，变量类型可以省略不写
    var price2 = 1200

    // var(Variable) 可变变量
    // val(value) 不可变变量， 等价于 Java 中的 final ,它的值在初始化以后就无法再次被修改
    println(price)

    // 基本类型
    // 包括我们常见的数字类型、布尔类型、字符类型，以及前面这些类型组成的数组。这些类型是我们经常会遇到的概念，因此我们把它统一归为“基础类型”。
    // 在 Java 里面，基础类型分为原始类型（Primitive Types）和包装类型（Wrapper Type）。比如，整型会有对应的 int 和
    // Integer，前者是原始类型，后者是包装类型。
    // Java 之所以要这样做，是因为原始类型的开销小、性能高，但它不是对象，无法很好地融入到面向对象的系统中。而包装类型的开销大、性能相对较差，但它是对象，可以很好地发挥面向对象的特性。在
    // JDK 源码当中，我们可以看到 Integer 作为包装类型，它是有成员变量以及成员方法的，这就是它作为对象的优势。
    // 然而，在 Kotlin 语言体系当中，是没有原始类型这个概念的。这也就意味着，在 Kotlin 里，一切都是对象。
    // https://static001.geekbang.org/resource/image/yy/3b/yyd95b04616943878351867c4d1e063b.jpg?wh=2000x1077
    // Double: 64bit, Float: 32bit, Long: 64bit, Int: 32bit, Short: 16bit, Char: 16bit, Byte: 8bit,
    // Boolean: 8bit
    // 可以发现，由于在 Kotlin 中，整型数字“1”被看作是对象了，所以我们可以调用它的成员方法 toDouble()，而这样的代码在 Java 中是无法实现的。
    val i: Double = 1.toDouble()

    // 空安全
    // Kotlin 中一切皆对象，那么对象就有可能空，
    // val i1: Double = null // 编译器会报错 ==>  error: null can not be a value of a non-null type Double
    // Kotlin 强制要求开发者在定义变量的时候，指定这个变量是否可能为 null。对于可能为 null 的变量，我们需要在声明的时候，在变量类型后面加一个问号“?”
    val i2: Double? = null

    // "可能为空" 的变量，无法直接赋值给 "不可为空的变量",反向赋值是可以的
    var i22: Double = 1.0
    var j: Double? = null

    if (j != null) {
        i22 = j // 编译通过
    }

    // 数字类型
    val int = 1 // 整数默认被推导为 Int 类型
    val long = 12345678L // Long 需要后缀 L
    val double = 13.15 // 小数默认推导为 Double
    val float = 13.41f // Float 需要使用 F 后缀
    val hexadecimal = 0xAF // 0x 代表十六进制面量
    val binary = 0b01010101 // 0b 代表二进制面量

    // 布尔类型
    // true 和 false。布尔类型支持逻辑操作
    // & 代表 与运算
    // | 代表 或运算
    // ! 代表 非运算
    // && 和 || 分别代表 短路逻辑运算
    val k = 1
    val m = 2
    val n = 3

    val isTrue = k < m && m < n

    // 字符 Char
    // Char 代表单个字符 比如'A'、'B'、'C'，字符应该用单引号括起来

    val c: Char = 'A'
    val i3: Int = c.code // 编译器报错

    // 字符串：String
    // 字符串（String），顾名思义，就是一连串的字符。和 Java 一样，Kotlin 中的字符串也是不可变的。在大部分情况下，我们会使用双引号来表示字符串的字面量，这一点跟 Java
    // 也是一样的。
    val s = "Hello Kotlin!"
    // Kotlin 还为我们提供了非常简洁的字符串模板
    val name = "Kotlin"
    print("Hello $name!")
    /*            ↑
        直接在字符串中访问变量
    */
    // 输出结果：
    // Hello Kotlin!

    val array = arrayOf("Java", "Kotlin")
    print("Hello ${array.get(1)}!")
    /*            ↑
        复杂的变量，使用${}
    */
    // 输出结果：
    // Hello Kotlin!

    // 原始字符串
    // 是用三个引号来表示的。它可以用于存放复杂的多行文本，并且它定义的时候是什么格式，最终打印也会是对应的格式。所以当我们需要复杂文本的时候，就不需要像 Java 那样写一堆的加号和换行符了。

    val originString = """
    当我们的字符串有复杂的格式时
    原始字符串非常的方便
    因为它可以做到所见即所得。 """
    print(originString)

    // 数组
    // 
}
