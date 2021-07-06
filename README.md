# RainRouter

#### 介绍
路由学习

#### 软件架构
router 路由api Java 可以不用动可以自定义
router-plugin 路由任务，主要用于build 插入数据
router-api 路由api kotlin 版本 有问题

#### 安装教程

通过router-plugin 的build.gradle 文件的uploadArchives任务生成release仓库
项目根目录配置release地址 引入 插件地址  classpath 'com.example.rain.router_plugin:router:1.0.0'
app 的 build.gradle 引入  id 'router'
router 的build.gradle 利用maven 在 release仓库下router-1.0.0.jar 然后复制到需要路由的目录

有待解决 直接在本地路径引入jar



#### 使用说明
@Route(path = "/app/main")
class MainActivity : AppCompatActivity() {
}
ARouter.getInstance().build("/app/login")
                .withString("title", "Rain")
                .navigation(this, 1) { _, resultCode, data ->
                    findViewById.text = data?.getStringExtra("name") ?: ""
                }

#### 参与贡献




#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
