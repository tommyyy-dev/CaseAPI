# CaseAPI

CaseAPI is a specialized API designed exclusively for integrating with the CaseOpening plugin developed by me. It allows other plugins to interact with cases, track statistics and even more, but it requires [PLUGIN](https://google.com) to function properly.

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
    <version>1.2.0</version>
    <scope>provided</scope>
</dependency>
```

### **Gradle (Kotlin DSL)**
```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.tommyyy-dev:CaseAPI:1.2.0")
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
| Method | Description |
|--------|-------------|
| `List<String> getCases()` | Returns a list of all available cases. |
| `boolean caseExists(String caseId)` | Checks if a case with the given ID exists. |
| `boolean openCaseWithRemove(Player player, String caseId)` | Opens a case and removes it from the player. |
| `boolean openCaseWithoutRemove(Player player, String caseId)` | Opens a case without removing it from the player. |
| `boolean addCases(OfflinePlayer player, String caseId, int amount)` | Adds cases to the player. |
| `boolean removeCases(OfflinePlayer player, String caseId, int amount)` | Removes cases from the player. |
| `int getPlayerCases(OfflinePlayer player, String caseId)` | Gets the number of a specific case the player owns. |
| `int getTotalCasesOpened()` | Gets the total number of cases opened globally. |
| `int getTotalCasesOpenedByPlayer(Player player)` | Gets the total number of cases opened by a specific player. |

### **Events**
| Event | Description                                                                                  |
|--------|----------------------------------------------------------------------------------------------|
| `CaseOpenEvent` | Triggered when a player attempts to open a case. Can be cancelled.                           |
| `CaseOpenCompleteEvent` | Triggered when a case is successfully opened, providing the reward details.                  |
| `CaseRewardAnnounceEvent` | Triggered when a case reward is announced, allowing message customization. Can be cancelled. |
| `FailedCaseOpenEvent` | Triggered when a case opening attempt fails, providing the failure reason.                   |

## ❓ Need Help?
If you need assistance, feel free to open an issue on this repository or join our community Discord!
