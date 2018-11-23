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