# learn
# java深入学习笔记（与C/C++的异同）
## CH1 语法及关键字
>**java中，boolean类型的长度由jvm决定，不能转化为其他基本类型。**  
>### 数组
>java数组可以直接定义，不指定大小，但是此时数组指向null，使用前需要指定大小，c/c++中定义数组时必须指定数组大小，指向数组的指针可以先指向null。
>数组length属性不能修改
## CH2 操作符
>按位操作符和移位操作符都只能作用于**整数**，非整数会被转化为整数，如（char、short、byte），浮点需手动转化为整形。boolean不可移位操作，不可取非（~）操作，boolean之间可以进行其他按位操作（作为1bit单位对待），boolean不可转化为整形。
>### 按位操作符  
><table>
>	<tr><th/><th>c/c++</th><th>java</th></tr>  
>	<tr><td><<</td><td>有（低位补0）</td><td>有（低位补0）</td></tr>  
>	<tr><td>>></td><td>有（高位正补0，负补1）</td><td>有（高位正补0，负补1）</td></tr>
>	<tr><td>>>></td><td>无</td><td>有（高位无论正负都补0）</td></tr>  
></table>
>无论c/c++还是java，移位操作的最小单位都是int类型。对于java，如果移动位数超过数据类型大小，计算的结果等同于  
>
>**被移位数/（位数%移位操作符的最基本位长度）**  
>**boolean类型，不能用于移位操作**  
## CH3 类、对象、接口、封装、继承、多态  
>通过newInstance()方法构造对象时，如果相关类未定义默认构造方法，不会报编译错误，
>但是会抛出异常，且不会创建相关对象。  
>每个类的编译码在任何static成员被访问时被加载（构造器是static方法，尽管static没
>有显示地写出来）
>### 类型转换
>java中boolean不能转化成任何基本数据类型
>### 上下转型
>c++只能向上转型，java可以转型
>### 接口（待续）
>只有public接口default接口，接口中的方法抽象方法，不能有函数体，接口中方法只有public或default属性。
>### 内部类
>静态内部类可以使用new关键字创建，而非静态内部类只能通过外部类的实例创建。  
>### 静态初始化  
>静态数据在第一次调用时初始化  
>包括：第一次创建该类的对象，第一次调用该静态类的静态方法，第一次使用该类，通过newInstance()方法创建对象。  
>不包括：第一次用该类定义对象（没有对定义的对象初始化）
>#### 显式静态初始化
>静态代码块和非静态代码块都不能添加访问属性限制（private，protected，public等）
>静态代码块和静态变量的初始化没有先后明确的先后顺序，按照java代码上下文的先后顺序依次执行。
>当当前类的静态初始化部分包含当前对象的实例创建时，会先创建该实例，实例创建之前会初始化
>其成员变量,然后调用构造方法，这期间不初始化静态变量和代码块，实例创建完成后继续执行静
>态变量和代码块的初始化。初始化静态变量和代码块的创建顺序保持不变。
>### 非静态代码块
>如果非静态代码块中包含当前类实例的创建，则会使程序陷入无限递归，进而导致栈溢出。
>如果非静态代码块在静态数据初始化之前调用（如上述情况），此时如果在非静态代码块访问静
>态数据，则静态数据会被先初始化（只初始化一次）。
>### 可变参数列表
>如果用数组代替可变参数列表，则不能在调用方法时直接传入多个参数，而应该定义一个包
>含参数的数组，可变参数列表定义的方法可以直接传入多个参数。
>当方法参数列表为可变参数列表时，在调用该方法时，如果只传递一个数组，则其中数组元
>素会被直接当成参数处理，否则这个数组会被当成参数处理。
>方法参数的可变参数列表部分可以不传参数（不用定义空数组）。
>可变参数列表定义的参数类型可以是基本数据类型。
>可变列表必须放在方法参数的最后。
>不能定义多个可变参数。
>调用可变参数列表方法不明确时会报编译错误，可以通过添加明确的参数解决。
>### 继承
>子类继承父类的同名成员变量，向上转型时，可以在访问权限允许的情况下访问父类变量，
>覆盖方法时，向上转型只能访问到子类覆盖的方法，在子类内部可以通过super调用父类的
>该方法。  
>c++和java构造函数调用之前会调用父类默认构造函数，如果父类默认构造函数不存在，则
>必须显示调用父类其他构造函数，否则会报编译错误。
>java子类重载父类方法，不会隐藏父类方法；同样的机制，c++会隐藏父类函数，在c++中
>子类对父类函数的这种机制称为重写（这是为了和c++多继承时对二义性的处理方式相统一）。
>### final
>早期java使用final声明方法时，编译器可以使方法内嵌到调用处，后来的JVM做了优化，不
>内嵌大方法，最后这种方式被抛弃，原因是这种效率问题应该由jvm处理，而非编译器。 
>private定义方法隐含了final的含义，因为private本身是不可被继承的，private fianl
>可以定义方法，编译器不会报错。  
>当类被定义为final时，其中的方法都隐式为fianl，可以为其中的方法声明为final，但是
>这没有任何意义。
>fianl定义静态变量时必须显示初始化（在静态初始化块或初始化块中引用都会报编译错误）   
>### 多态
>java父类引用调用子类继承的方法时，调用的子类的方法，而c++调用的是父类的方法。  
>c++通过虚函数实现多态，类通过基类指针调用子类相应的虚函数实现。  
>在JVM的支持下java支持动态绑定，而c++则没有这种机制。  
>在类的静态方法内部可以访问类实例的私有成员变量，子类向上转型也是如此，但是不能
>访问子类私有成员变量。
>java中private方法无法既不会被重载，也不会被覆盖，父类引用调用子类与private方法
>同名的方法是不可能的，只能调用自己的同名private方法。
>c++和java在实现多态时都不会覆盖内存中父类的方法，而是通过自己特定的机制实现多态，
>c++通过虚函数表实现，而java通过JVM的动态绑定实现。  
>对于成员变量，c++和java都不能实现多态，java对同名变量引用的确定在编译期完成。  
>java和c++静态方法都不支持多态。
## CH4 访问权限
>### 包管理
>static 用于类的声明类，接口以及枚举，static可以做静态引入，用于引用静态变量或静态方法。
>java 1.4版本之后就不再支持导入默认包中的类和接口。但是可以通过反射的方式实现创建默认包的类。
>包访问权限的public成员在包外可以通过反射的方式访问。
>无论main方法所在类是public还是包访问权限，main方法都能被调用。
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
