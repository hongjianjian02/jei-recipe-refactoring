# JEI recipe refactoring

Minecraft 1.21.1 / NeoForge 21.1.265 / Java 21 / JEI 19.76.1.481 / EMI 1.1.24+1.21.1+neoforge。

将物品、附魔书与修复材料查询聚合为 6×4 滚动网格，读取当前服务器同步的附魔定义、标签与物品组件。

同一 jar 提供 JEI 与原生 EMI 的三个基础视图；EMI 可单独使用。两者同时安装时，EMI 接管本模组查询；没有 EMI 时使用 JEI。原生 EMI 动态查询仅启用整合包当前锁定的 `1.1.24+1.21.1+neoforge`。

当前版本为 `1.2.5-mc1.21.1`，整理共享查询模型、提示文本、最高等级筛选与 EMI 快照失效流程，保持既有查询与游戏规则。Java 21 环境下运行 `./gradlew clean build`（Windows 使用 `gradlew.bat`），成品为 `build/libs/jei_recipe_refactoring-1.2.5-mc1.21.1.jar`，不包含 JEI、EMI 或其他依赖。`-PwithoutJei`、`-PwithoutEmi` 可分别关闭开发运行依赖。1.2.5 已构建，39项自动测试全部通过，成品哈希与审计结果见验证记录。

- [迁移说明、构建与游戏验收](docs/migration-1.21.1.md)
- [附魔兼容清单与版本证据](docs/compatibility-1.21.1.md)
- [验证记录](docs/validation-1.21.1.md)
- [EMI 支持范围、版本证据与游戏验收](docs/emi-1.21.1.md)
- [1.2.0 EMI 重载故障与修复](docs/incident-emi-reload-1.2.0.md)
- [1.2.1 变更说明](docs/CHANGELOG-1.2.1.md)
- [1.2.2 EMI 等级角标修复](docs/CHANGELOG-1.2.2.md)
- [1.2.3 EMI 原生材料修补页替换](docs/CHANGELOG-1.2.3.md)
- [1.2.4 EMI 原生旧页隐藏与修复装备查询](docs/CHANGELOG-1.2.4.md)
- [1.2.5 代码职责与重复规则整理](docs/CHANGELOG-1.2.5.md)
- [代码结构与维护落点](docs/code-structure.md)

沿用的 1.2.4 行为：修复网格成功注册后隐藏精确识别的 EMI 原生材料修补、同装备合并和附魔旧页；未成功注册修复网格时保留原生页。不可附魔但可修复的装备也能通过物品 R/U 查看修复材料。重载或换服后，旧页面和槽位停止使用旧数据，并提示重新查询。

上一版 1.2.4 已构建，36项自动测试全部通过；1.2.3 的实例日志已确认加载、页面注册和 EMI 重载完成，历史记录继续保留。1.2.5 尚未安装或进行游戏内验收，原生旧页隐藏、旧页面失效保护与完整交互仍需核验；源码备份与可选联动边界见迁移说明和本轮变更说明。
