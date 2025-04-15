# CaseAPI

CaseAPI is a specialized API designed exclusively for integrating with the CaseOpening plugin developed by me. It allows other plugins to interact with cases, track statistics and even more, but it requires [CaseOpening](https://github.com) to function properly.

## 🔧 Installation

### **Maven**
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.tommyyy-dev</groupId>
    <artifactId>CaseAPI</artifactId>
    <version>2.0.1</version>
    <scope>provided</scope>
</dependency>
```

### **Gradle (Kotlin DSL)**
```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.tommyyy-dev:CaseAPI:2.0.1")
}
```

## 🚀 Getting Started

### **1. Hook into CaseAPI**
Before using the API, you need to obtain an instance of `CaseAPI`. This can be done using the Bukkit Services Manager:

```java
private CaseAPI caseAPI;

@Override
public void onEnable() {
    RegisteredServiceProvider<CaseAPI> provider = getServer().getServicesManager().getRegistration(CaseAPI.class);
    if (provider != null) {
        caseAPI = provider.getProvider();
    }
}
```

### **2. Add the Plugin as a Dependency**
To ensure your plugin loads after CaseOpening, you need to declare it as a dependency in your plugin.yml:

```yaml
depend: [CaseOpening]
```

This allows you to safely access the CaseAPI during the onEnable() phase.

### **3. Opening a Case**
You can open a case for a player with or without removing it from them:

```java
boolean success = caseAPI.openCaseWithRemove(player, "example_case");
if (success) {
    player.sendMessage("You have successfully opened a case!");
}
```

### **4. Managing Cases**
You can add or remove cases from a player:

```java
caseAPI.addCases(player, "example_case", 5);
caseAPI.removeCases(player, "example_case", 2);
```

### **5. Listening to Case Events**
You can listen to CaseOpening events to trigger custom actions:

```java
@EventHandler
public void onCaseOpen(CaseOpenEvent event) {
    Player player = event.getPlayer();
    player.sendMessage("You are opening a case: " + event.getCaseId());
}

@EventHandler
public void onCaseReward(CaseOpenCompleteEvent event) {
    Player player = event.getPlayer();
    if (event.getCaseReward() instanceof MoneyCaseReward moneyCaseReward) {
        player.sendMessage("You have won: " + moneyCaseReward.getAmount());
    }
}
```

If you want to work with the reward or perform actions after the case has been opened and all calculations are complete, you should use the `CaseOpenCompleteEvent`. This event is triggered after all reward calculations have been finalized, ensuring that you are working with the correct result.

On the other hand, the `CaseOpenEvent` is only triggered at the beginning of the case opening process and should not be used for reward-related actions. Additionally, please note that the `CaseOpenCompleteEvent` is **not cancellable**, whereas the `CaseOpenEvent` is **cancellable**.

## 📜 API Overview

### **Main Methods**
| Method                                                              | Description                                                    |
|---------------------------------------------------------------------|----------------------------------------------------------------|
| `List<String> getCases()`                                           | Gets a list of all available case IDs.                         |
| `boolean caseExists(String caseId)`                                 | Checks if a case with the given ID exists.                     |
| `boolean openCaseWithoutRemove(Player player, String caseId)`       | Opens a case for a player without removing it from them.       |
| `boolean openCaseWithRemove(Player player, String caseId)`          | Opens a case for a player and removes it from them.            |
| `void setJewelry(OfflinePlayer player, int amount)`                 | Sets the amount of jewelry a player owns.                      |
| `void addJewelry(OfflinePlayer player, int amount)`                 | Adds a specific amount of jewelry to a player.                 |
| `void removeJewelry(OfflinePlayer player, int amount)`              | Removes a specific amount of jewelry from a player.            |
| `void setCases(OfflinePlayer player, String caseId, int amount)`    | Sets the amount of a specific case a player owns.              |
| `void addCases(OfflinePlayer player, String caseId, int amount)`    | Adds a specific number of cases to a player.                   |
| `void removeCases(OfflinePlayer player, String caseId, int amount)` | Removes a specific number of cases from a player.              |
| `int getJewelry(OfflinePlayer player)`                              | Retrieves the current amount of jewelry a player owns.         |
| `int getPlayerCases(OfflinePlayer player, String caseId)`           | Retrieves the number of a specific case a player owns.         |
| `int getTotalCasesOpened()`                                         | Retrieves the total number of cases opened globally.           |
| `int getTotalCasesOpenedByPlayer(OfflinePlayer player)`             | Retrieves the total number of cases opened by a specific player. |
| `void deletePlayerData(UUID uuid)`                                  | Deletes the player data for the specified UUID.                |

### **Events**
| Event | Description                                                                                  |
|--------|----------------------------------------------------------------------------------------------|
| `CaseOpenEvent` | Triggered when a player attempts to open a case. Can be cancelled.                           |
| `CaseOpenCompleteEvent` | Triggered when a case is successfully opened, providing the reward details.                  |
| `CaseRewardAnnounceEvent` | Triggered when a case reward is announced, allowing message customization. Can be cancelled. |
| `FailedCaseOpenEvent` | Triggered when a case opening attempt fails, providing the failure reason.                   |

## ❓ Need Help?
If you need assistance, feel free to open an issue on this repository or join our community [Discord](https://discord.com/invite/BKsZxh4D6W)!

## 🧠 Versioning Notice

Although this is the first official public release, the version starts at `2.0.0` due to earlier internal tags (`1.0.0` and `1.1.0`) which are now outdated and permanently cached by JitPack.

Please do **not** use version `1.0.0`, as it does not reflect the current state of the project and will lead to errors. The first stable version is `2.0.0`, and all future updates will follow semantic versioning starting from this version.