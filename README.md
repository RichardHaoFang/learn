# learn
# java深入学习笔记（与C/C++的异同）
## CH1 语法及关键字
>**java中，boolean类型的长度由jvm决定，不能转化为其他基本类型。**  
>java数组可以直接定义，不指定大小，但是此时数组指向null，使用前需要指定大小，c/c++中定义数组时必须指定数组大小，指向数组的指针可以先指向null。
## CH2 操作符
>按位操作符和移位操作符都只能作用于**整数**，非整数会被转化为整数，如（char、short、byte），浮点需手动转化为整形。boolean不可移位操作，不可取非（~）操作，boolean之间可以进行其他按位操作（作为1bit单位对待），boolean不可转化为整形。
>### 按位操作符  
>
><table>
>	<tr><th/><th>c/c++</th><th>java</th></tr>  
>	<tr><td><<</td><td>有（低位补0）</td><td>有（低位补0）</td></tr>  
>	<tr><td>>></td><td>有（高位正补0，负补1）</td><td>有（高位正补0，负补1）</td></tr>
>	<tr><td>>>></td><td>无</td><td>有（高位无论正负都补0）</td></tr>  
></table>
>无论c/c++还是java，移位操作的最小单位都是int类型。对于java，如果移动位数超过数据类型大小，计算的结果等同于：  
>**被移位数/（位数%移位操作符的最基本位长度）**。  
>**boolean类型，不能用于移位操作**。
## CH3 类、对象、接口、封装、继承、多态  
>### 类型转换
>java中boolean不能转化成任何基本数据类型
>### 上下转型
>c++只能向上转型，java可以转型
>### 接口（待续）
>只有public接口default接口，接口中的方法抽象方法，不能有函数体，接口中方法只有public或default属性。
>### 内部类
>静态内部类可以使用new关键字创建，而非静态内部类只能通过外部类的实例创建。
>静态数据在第一次调用时初始化  
包括：第一次创建该类的对象，第一次调用该静态类的静态方法  
不包括：第一次用该类定义对象（没有对定义的对象初始化）
## CH4 访问权限
## CH5 调试技巧
## CH6 JVM和内存管理
>### JVM
>JVM（java虚拟机），java应用通过main方法启动，每一个main方法启动后，就会启动一个java虚拟机。同时产生5线程：  
>其中main是主线程
>### java内存模型
>### 堆栈内存
>对于像c语言那样的面向过程的语言，要求所变量都在一个块的开头定义，以便编译器在创建这个块的时候，可以为那些变量分配空间。而在java和c++中，则可在整个块的范围内分散变量声明，在真正需要的地方才加以定义，这样便可形成更自然的编程风格，也更易理解。（《java编程思想第四版》）
## CH7 异常处理
>throws用于方法上的抛出异常声明，throw用于方法体内的异常抛出。
## CH8 多线程
>### volicate与synchronized（待续）
>volicate用于声明变量，synchronized用于声明代码块。
>对于volicate声明的变量，各个线程都有一个内存同步副本，而synchornized加锁的变量只有一个实例。
## CH9 IO
## CH10 注解
## CH11 GUI
