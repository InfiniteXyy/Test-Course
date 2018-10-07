# 码农酒店

## 需求

**“码农酒店”世界时钟系统特性**
作为一位酒店大堂服务人员，我想在大堂的城市时钟不准时，用设置自己手机时间的方法，自动统一调整这些城市时钟时间，来避免逐一根据时差调整这些时钟的繁琐工作。
**系统的具体特性包括：**

- REQ1: ”码农酒店”大堂里有 5 个时钟，分别显示北京、伦敦、莫斯科、悉尼和纽约的时间
- REQ2: 伦敦与 UTC 时间一致，北京比 UTC 时间早 8 小时，莫斯科比 UTC 时间早 4 小时，悉尼比 UTC 时间早 10 小时，纽约比 UTC 时间晚 5 小时
- REQ3: 将酒店大堂服务员的智能手机时间设置为北京时间
- REQ4: 若大堂墙壁上所有城市的时钟都或多或少有些走时不准，需要调整时间时，只需调准服务员手机的时间，那么墙上 5 个城市的时钟时间都能够相应地自动调整准确

## 静态分析报告

#### 工具

`sonarLint`

Intellij idea

#### 解决的问题

- Standard outputs should not be used directly to log anything

  - 使用 `util.logging.Logger` 代替 `System.out.println`
  - 将输出仅仅放在 `Main` 中，其它地方用 `return String`
    ![using_logger](https://raw.githubusercontent.com/infiniteXyy/Test-Course-Projects/master/chapter01/screenshots/using_logger.png)

- Generic exceptions should never be thrown
  - 考虑到可能会有手机未绑定到 `HotelSystem` 时调整时间的情况，需要抛出异常
  - 用继承实现自己的 `NotBindingException`
    ![using_exception](https://raw.githubusercontent.com/infiniteXyy/Test-Course-Projects/master/chapter01/screenshots/using_exception.png)

#### 截图

- **before**

![before lint](https://raw.githubusercontent.com/infiniteXyy/Test-Course-Projects/master/chapter01/screenshots/before_lint.png)

- **after**

![after lint](https://raw.githubusercontent.com/infiniteXyy/Test-Course-Projects/master/chapter01/screenshots/after_lint.png)

## 动态测试

- 测试系统初始化标准时间是否为 0
- 测试系统是否正确加入了 5 个城市的时钟
- 测试城市时钟是否会随酒店标准时间变化
- 测试手机是否能改变酒店时钟
  ![result](https://raw.githubusercontent.com/infiniteXyy/Test-Course-Projects/master/chapter01/screenshots/dynamic_test_result.png)
