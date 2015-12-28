# CustomAnalyzerPlugin
按照书“Master Elasticsearch”第九章第三节写的自定义es分词器插件,实现按空格分词后将词反转。代码基本上都是照着书上写的，但因为es版本不同有一点点改动。es版本采用2.1.0

#### 如何将插件安装到elasticsearch

```java
  打包
  $ mvn clean package
  安装插件
  $ bin/plugin install file:///PATH-TO-CUSTOM-PLUGIN/target/releases/custom-plugin-1.0-SNAPSHOT.zip   
  启动elasticsearch,会看到加载插件的信息
  $ bin/elasticsearch
  可以用下面的命令删除插件
  $ bin/plugin remove custom-analysis
  
```

#### 验证

```java
  添加索引
  curl -XPOST 'localhost:9200/test/'
  Post浏览器输入如下地址
  GET localhost:9200/test/_analyze?analyzer=custom-analysis&text=test reverse
  输出结果
  {
  "tokens": [
    {
      "token": "tset",
      "start_offset": 0,
      "end_offset": 4,
      "type": "word",
      "position": 0
    },
    {
      "token": "esrever",
      "start_offset": 5,
      "end_offset": 12,
      "type": "word",
      "position": 1
    }
  ]
}
```
