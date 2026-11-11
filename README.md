# pdd-testgen-sample

用來測試 PDD 測試生成功能（Epic-01）的小型 Java 專案。

- Java 17、Maven、JUnit 5，只依賴 Maven Central。
- `main`：`Calculator` 與它的測試 `CalculatorTest`。
- `feature/text-utils`：新增 `TextUtils`、為 `Calculator` 加上 `factorial` 與 `percentage`，**刻意不附測試**，
  對 `main` 開 PR 後讓 PDD 生成測試。

```bash
mvn test
```
