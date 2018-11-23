## Junit 进阶

### Basic Assert Test 
[`AssertTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertTest.java)
- assertTrue / assertFalse
- assertNull / assertNotNull
- assertEquals
- assertSame / assertNotSame




### Assertion with assertThat
#### compare value matchers
[`AssertThatCompareValueMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatCompareValueMatcher.java)
- equalTo
- not

#### compound value matchers
[`AssertThatCompoundValueMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatCompoundValueMatcher.java)

- either
- both
- anyOf
- allOf

*注意：由于使用了泛型，必须保证所有 Matchers 的数据类型是一致的*

#### collection matcher
[`AssertThatCollectionMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatCollectionMatcher.java)

- hasItem/hasItems

##### string matcher
[`AssertThatStringMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatStringMatcher.java)

- startsWith
- endsWith
- containsString

#### custom matcher
matcher [`LessThanOrEqual`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/LessThanOrEqual.java)

[`AssertThatLessThanOrEqualCustomMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatLessThanOrEqualCustomMatcher.java)




### Executing Test Order
[`OrderedTests`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/OrderedTests.java)

- MethodSorters.DEFAULT 默认执行
- MethodSorters.NAME_ASCENDING 按照命名字典序
- MethodSorters.JVM 按照JVM的反射返回的顺序




### Applying Assumption
[`Assumption`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/Assumption.java)

测试前置条件，若不满足就会忽略后面的测试



### Ignoring a Test
[`AssertTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertTest.java)

- `@Ignore` 来标记，不建议使用。尽量使用assume，增加可读性
- 但是比注释掉还是要便于跟踪



### Set Test Runner (using `@RunWith`)
[`RunTestSuites`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/RunTestSuites.java)

- `@RunWith` 来设置TestRunner，可以才一次运行中执行
  - **一组**检查输入是否有效的测试方法
  - **一组** API 测试
- `@Suite.SuiteClasses`标注需要执行的测试类，测试类之间使用逗号 分开



### Parameterized Test

**非常重要！**在工业界被称作自动化测试。

use constructor [`FactorialTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/course/FactorialTest.java)

use annotation [`FactorialTestTwo`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/course/FactorialTestTwo.java)

use JUnitParamsRunner [`FactorialTestThree`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/course/FactorialTestThree.java)

- 避免重复的测试代码
- 提高测试代码的可维护性
- 提高测试效率

步骤
1. 制定参数化测试运行器
1. 定义测试数据集合



### Handling Exception Flow


#### 经典测试
使用`try` -> `fail` -> `catch`，（若被测试代码没有抛出指定异常，则测试失败）

#### 使用@Test模式
`@Test` 的 **expected** 属性
[`ExceptHandlingTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/exceptions/ExceptHandlingTest.java)

#### 使用 `ExpectedException` 模式

不仅能测试异常的**种类**，还能测试异常的**信息**

[`ExpectedExceptionRuleTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/exceptions/ExpectedExceptionRuleTest.java)

注：expect除了支持 string 以外还支持 Matcher


#### 使用函数式接口模式 `@FunctionalInterface`
[`ExceptionTestUseFunctionalInterface`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/exceptions/ExceptionTestUseFunctionalInterface.java)

编写异常测试遵循简洁一致的代码结构以保证/提高代码的<u>可读性和可维护性</u> （三阶段arrange/act/assert）

利用Java8中提供的函数式接口@FunctionalInterface实现按照三阶段或四阶段模式。

#### 使用 `assertion` 模式

[`ExceptionTestUseAssertJ`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/exceptions/ExceptionTestUseAssertJ.java)

流式断言，一行代码处理多个断言。可以增加可读性。

- 检查是否抛出异常
- 抛出的异常是否为期望异常
- 抛出的异常信息是否为期望信息

注：此处的 `assertThat` 为 `assertJ` 中的方法



### JUnit Theories
[`MyTheories`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/theory/MyTheories.java)

[`ExternalTheoryTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/theory/ExternalTheoryTest.java)

一种特殊的JUnit的测试方法，实现参数化测试，支持将**测试数据与测试脚本隔离**。是**数据驱动**的测试

- @Theory:类似于 @Test，标注方法为 Theory
  - 会匹配所有参数与**类型一致**的 **DataPoint(s)** 数据，是**排列**问题。
- @DataPoint @DataPoints:类似于 @Parameter, 标注一个/多个可用于测试的数据 
- Theories:面向 Theory 的测试运行器，执行 Theory 需要使用该运行器且 Theory 运行器不支持运行 @Test 
- ParameterSupplier:向测试方法提供测试数据的抽象类，测试数据提供类应提供对其的具体实现。 
  - 只有一个方法需要实现 `getValueSources`
- @ParametersSuppliedBy:标注测试方法里参数使用的测试数据提供类 



### JUnit Rules

#### Timeout Rule
[`TimeoutRuleTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/rules/TimeoutRuleTest.java)

[`TimeoutTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/rules/TimeoutTest.java)

制定测试执行的时长

- 在每个测试方法前添加 @Test(timeout) 
- @Rule 标记全局**Timeout Rule**

#### ErrorCollector Rule

[`ErrorCollectorTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/rules/ErrorCollectorTest.java)

普通的测试在遇到测试失败后就会停止，collector会运行到最后，收集所有的测试。

#### Verifier Rule 

[`VerifierRuleTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/rules/VerifierRuleTest.java)

通过定义verify rule，在每个测试结束后对一些通用的部分进行测试。

其中 Verifier 类实例化后的方法可以自定义规则。

#### TestWatcher Rule

[`TestWatcherRuleTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/rules/TestWatcherRuleTest.java)

类似于生命周期钩子，可以收集执行测试过程中的相关信息。

#### TestName Rule

[`TestNameRuleTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/rules/TestNameRuleTest.java)

在测试方法内部获得测试的方法

#### ExternalResource Rule

[`ExternalResourceTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/rules/ExternalResourceTest.java)

在访问**外部资源**的时候，使用该rule，进行资源自我管理（建立链接和关闭链接）

例如：需要链接测试专用数据库时，需要连接数据库。



### JUnit Category

[`ExternalResourceTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/rules/ExternalResourceTest.java)


Categories 是一个JUnit测试运行器，是一类特殊的 Suite

它按照测试方法或者测试类进行分类

- 只执行在@IncludeCategory内指定的测试方法和测试类
- @ExcludeCategory排除指定的测试方法和测试类的执行



### JUnit 5

#### ParameterizedTest

[`FactorialTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/junit5/FactorialTest.java)

参数化测试

支持：

- @ValueSource(): 一个基本类型的数组
- EnumSource: 使用Enum常量作为数据源
- MethodSource: 使用方法作为数据源
- CsvSource / CsvFileSource: 使用逗号分隔符数据作为数据源
- ArgumentsSource: 使用自定义数据源类

#### RepeatedTest

重复执行同一个测试函数，通常用于增加负载。

#### TestFactory
[`DynamicTestJUnit5`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/junit5/DynamicTestJUnit5.java)

目前仍是试验性功能

可以在测试的过程中动态生成测试用例。

