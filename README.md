# 青春校园
## 项目介绍:
以运动爱好为主题的大学生校园交友平台。
#### 后端：https://github.com/BITzga/campus_java
#### Web端：https://github.com/BITzga/campus
#### Android端：https://github.com/zsybh1/hobbyfriends
用户通过Web端/App发布运动邀请信息，其他用户参与邀请、线下参与活动达到交友的目的
具有类似朋友圈的“校友圈“功能
![img.png](introduction_img/img.png)

## 使用技术:

使用Spring Boot、SpringBoot MVC完成Restful API开发<br />
使用Spring Data MongoDB完成用户信息、活动邀请、校友圈帖子的存取<br />
使用手写的LRU Cache完成热点帖子/邀请的缓存<br />
使用Vue、Vuex、Router、axios、Element-UI完成Web前端开发<br />
使用JWT+Spring的Interceptor对特定访问路径下未登录的用户进行拦截
## 功能演示：
### Web端:
广场界面，显示运动邀请<br />
![img_2.png](introduction_img/img_2.png)<br />
校友圈界面，分享生活<br />
![img_1.png](introduction_img/img_1.png)<br />
支持二级评论、点赞<br />
![img_3.png](introduction_img/img_3.png)<br />
### 安卓端：
邀请详情界面，用户加入邀请后，可在“我“界面看到已加入邀请<br />
![img_5.png](introduction_img/img_5.png)<br />
其他功能演示<br />
![img_4.png](introduction_img/img_4.png)<br />


