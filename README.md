# 2048

基于java开发的2048app

暂时还没有想说的。。。

## 文件树目录

```shell
2048
├─ .git
├─ .gitignore
├─ .gradle
├─ .idea
├─ README.md
├─ app
│    ├─ .gitignore
│    ├─ build
│    ├─ build.gradle
│    ├─ proguard-rules.pro
│    └─ src
├─ build.gradle
├─ gradle
│    └─ wrapper
├─ gradle.properties
├─ gradlew
├─ gradlew.bat
├─ local.properties
└─ settings.gradle
```

`app/src/com/example/a2048`下的目录

```shell
main
├─ AndroidManifest.xml
├─ java
│    └─ com
│           └─ example
│                  └─ a2048
│                         ├─ MainActivity.java # 运行的主类
│                         ├─ app # 应用包
│                         │    ├─ Config.java # 配置
│                         │    └─ ConfigManger.java # 设置管理
│                         ├─ db # 数据库类
│                         │    ├─ CellPoint.java # 存每个Cell的点位（退出游戏后能重置）
│                         │    └─ GameDataBase.java # 游戏数据库
│                         ├─ util # 工具包
│                         │    └─ DensityUtil.java # 工具类（提供单位转化，获得设备的长宽等）
│                         └─ view # 视图
│                                ├─ Cell.java # 方格类
│                                └─ GameView.java # 游戏的主逻辑
└─ res
       ├─ drawable
       │    ├─ bg.jpg # 背景图片
       │    ├─ bg_cell.xml # cell的背景
       │    ├─ bg_score_panel.xml # 得分的背景
       │    ├─ button_select.xml # 按键变化
       │    ├─ ic_cheat_kick_starter.png
       │    └─ ic_launcher_background.xml
       ├─ drawable-v24
       │    └─ ic_launcher_foreground.xml
       ├─ layout
       │    └─ activity_main.xml # 页面UI
       ├─ menu
       │    └─ main.xml
       ├─ mipmap-anydpi-v26
       │    ├─ ic_launcher.xml
       │    └─ ic_launcher_round.xml
       ├─ mipmap-hdpi
       │    ├─ ic_launcher.webp
       │    └─ ic_launcher_round.webp
       ├─ mipmap-mdpi
       │    ├─ ic_launcher.webp
       │    └─ ic_launcher_round.webp
       ├─ mipmap-xhdpi
       │    ├─ ic_launcher.webp
       │    └─ ic_launcher_round.webp
       ├─ mipmap-xxhdpi
       │    ├─ ic_launcher.webp
       │    └─ ic_launcher_round.webp
       ├─ mipmap-xxxhdpi
       │    ├─ ic_launcher.webp
       │    └─ ic_launcher_round.webp
       ├─ values
       │    ├─ colors.xml # 颜色
       │    ├─ strings.xml # 名字的字符串
       │    └─ themes.xml
       └─ values-night
              └─ themes.xml
```

- [ ] 方格出现的动画（缩放）
- [ ] 移动时，滑块滑动的效果
- [ ] 更新当前得分与最高得分
- [ ] 游戏结束时的提示（失败or胜利）
- [ ] 重置游戏（click按键的事件）
- [ ] 更新UI
- [ ] 无限模式（不止到2048）
- [ ] ……想到再写
