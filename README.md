# CustomAnalyzerPlugin
按照书“Master Elasticsearch”第九章第三节写的自定义es分词器插件,实现按空格分词后将词反转。代码基本上都是照着书上写的。

#### 如何将插件安装到elasticsearch

```
  打包
  $ mvn clean package
  安装插件
  $ bin/plugin --url file:///PATH-TO-CUSTOM-PLUGIN/target/releases/custom-plugin-1.0-SNAPSHOT.zip --install custom-plugin
  启动elasticsearch,会看到加载插件的信息
  $ in/elasticsearch -f
  
```

#### 验证

```java
  添加索引
  curl -XPOST 'localhost:9200/test/'
  使用插件
  curl -XGET 'localhost:9200/ymy/_analyze' -d '{analyzer:talos-analyzer,"text":"this is a test"}'
  输出结果
  {"tokens":[{"token":"siht\"","start_offset":0,"end_offset":5,"type":"word","position":1},{"token":"\"thsi","start_offset":6,"end_offset":8,"type":"word","position":2},{"token":"ishta","start_offset":9,"end_offset":10,"type":"word","position":3},{"token":"\"tset","start_offset":11,"end_offset":16,"type":"word","position":4}]}
```
