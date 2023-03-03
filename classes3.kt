

// Kotlin 编译器都做了什么
// Java 和 Kotlin 本质上是在用同一种语言进行沟通。
// Kotlin 经过编译后，最终会变成 Java 字节码，并可以在 JVM 中运行。
/*
    如何研究 Kotlin 
    一： 研究 Kotlin 编译后的字节码
    二： Kotlin 转换为字节码后，再将字节码反编译成等价的 Java 代码。
        
        Tools -> Kotlin -> Show Kotlin Bytecode。

    我们可以用以下两个规律，来总结下 Kotlin 对基础类型的转换规则：
    > 只要基础类型的变量可能为空，那么这个变量就会被转换成 Java 的包装类型。
    > 反之，只要基础类型的变量不可能为空，那么这个变量就会被转换成 Java 的原始类型。
*/

/*

    接口语法的局限性
    类型推导，我们写 Kotlin 代码的时候省略的变量类型，最终被编译器补充回来了。
    原始类型，虽然 Kotlin 没有原始类型，但编译器会根据每一个变量的可空性将它们转换成“原始类型”或者“包装类型”。
    字符串模板，编译器最终会将它们转换成 Java 拼接的形式。when 表达式，编译器最终会将它们转换成类似 switch case 的语句。
    类默认 public，Kotlin 当中被我们省略掉 public，最终会被编译器补充。
    嵌套类默认 static，我们在 Kotlin 当中的嵌套类，默认会被添加 static 关键字，将其变成静态内部类，防止不必要的内存泄漏。
    数据类，Kotlin 当中简单的一行代码“data class Person(val name: String, val age: Int)”，编译器帮我们自动生成很多方法：getter()、setter()、equals()、hashCode()、toString()、componentN()、copy()。
*/