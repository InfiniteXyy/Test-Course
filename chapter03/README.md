## Junit 进阶

#### Basic Assert Test 
in [`AssertTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertTest.java)
- assertTrue / assertFalse
- assertNull / assertNotNull
- assertEquals
- assertSame / assertNotSame


#### Assertion with assertThat
##### compare value matchers
in [`AssertThatCompareValueMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatCompareValueMatcher.java)
- equalTo
- not

##### compound value matchers
in [`AssertThatCompoundValueMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatCompoundValueMatcher.java)

- either
- both
- anyOf
- allOf

*注意：由于使用了泛型，必须保证所有 Matchers 的数据类型是一致的*

##### collection matcher
in [`AssertThatCollectionMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatCollectionMatcher.java)

- hasItem/hasItems

##### string matcher
in [`AssertThatStringMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatStringMatcher.java)

- startsWith
- endsWith
- containsString

##### custom matcher
matcher in [`LessThanOrEqual`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/LessThanOrEqual.java)

in [`AssertThatLessThanOrEqualCustomMatcher`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertThatLessThanOrEqualCustomMatcher.java)


### Executing Test in Order
in [`OrderedTests`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/OrderedTests.java)

- MethodSorters.DEFAULT 默认执行
- MethodSorters.NAME_ASCENDING 按照命名字典序
- MethodSorters.JVM 按照JVM的反射返回的顺序


### Applying Assumption
in [`Assumption`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/Assumption.java)

测试前置条件，若不满足就会忽略后面的测试

### Ignoring a Test
in [`AssertTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/AssertTest.java)

- `@Ignore` 来标记，不建议使用。尽量使用assume，增加可读性
- 但是比注释掉还是要便于跟踪

### Set Test Runner (using `@RunWith`)
in [`RunTestSuites`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/RunTestSuites.java)

- `@RunWith` 来设置TestRunner，可以才一次运行中执行
  - **一组**检查输入是否有效的测试方法
  - **一组** API 测试
- `@Suite.SuiteClasses`标注需要执行的测试类，测试类之间使用逗号 分开

### Set Test Runner (using `@RunWith`)
in [`RunTestSuites`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/main/RunTestSuites.java)

- `@RunWith` 来设置TestRunner，可以才一次运行中执行
  - **一组**检查输入是否有效的测试方法
  - **一组** API 测试
  
### Parameterized Test
use constructor in [`FactorialTest`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/course/FactorialTest.java)

use annotation [`FactorialTestTwo`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/course/FactorialTestTwo.java)

use JUnitParamsRunner [`FactorialTestThree`](https://github.com/InfiniteXyy/Test-Course-2018-autumn/blob/master/chapter03/src/test/java/course/FactorialTestThree.java)

- 避免重复的测试代码
- 提高测试代码的可维护性
- 提高测试效率

步骤
1. 制定参数化测试运行器
1. 定义测试数据集合
