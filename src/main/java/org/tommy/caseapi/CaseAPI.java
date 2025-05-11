package org.tommy.caseapi;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.tommy.caseapi.utils.threading.BukkitFutureResult;

/**
 * The CaseAPI interface provides methods to interact with the case system.
 * It allows opening cases, managing players' jewelry and cases, and retrieving statistics.
 *
 * @author Tommyyy
 */
public interface CaseAPI {

    /**
     * Checks if a case with the given ID exists.
     *
     * @param caseId The ID of the case to check.
     * @return A {@link BukkitFutureResult} that completes with {@code true} if the case exists, {@code false} otherwise.
     */
    BukkitFutureResult<Boolean> caseExists(String caseId);

    /**
     * Opens a case for a player without removing it.
     *
     * @param player The player opening the case.
     * @param caseId The ID of the case to open.
     * @return A {@link BukkitFutureResult} that completes with {@code true} if the case was successfully opened, {@code false} otherwise.
     */
    BukkitFutureResult<Boolean> openCaseWithoutRemove(Player player, String caseId);

    /**
     * Opens a case for a player and removes one from them.
     *
     * @param player The player opening the case.
     * @param caseId The ID of the case to open.
     * @return A {@link BukkitFutureResult} that completes with {@code true} if the case was successfully opened, {@code false} otherwise.
     */
    BukkitFutureResult<Boolean> openCaseWithRemove(Player player, String caseId);

    /**
     * Sets the amount of jewelry a player has.
     *
     * @param player The player whose jewelry amount will be set.
     * @param amount The amount of jewelry to set.
     */
    void setJewelry(OfflinePlayer player, int amount);

    /**
     * Adds a specific amount of jewelry to the given player.
     *
     * @param player The player to receive the jewelry.
     * @param amount The amount of jewelry to add.
     */
    void addJewelry(OfflinePlayer player, int amount);

    /**
     * Removes a specific amount of jewelry from the given player.
     *
     * @param player The player whose jewelry will be removed.
     * @param amount The amount of jewelry to remove.
     */
    void removeJewelry(OfflinePlayer player, int amount);

    /**
     * Sets the amount of a specific case a player has.
     *
     * @param player The player whose cases will be set.
     * @param caseId The ID of the case to set.
     * @param amount The amount of cases to set.
     */
    void setCases(OfflinePlayer player, String caseId, int amount);

    /**
     * Adds a specified number of cases to a player.
     *
     * @param player The player receiving the cases.
     * @param caseId The ID of the case to add.
     * @param amount The number of cases to add.
     */
    void addCases(OfflinePlayer player, String caseId, int amount);

    /**
     * Removes a specified number of cases from a player.
     *
     * @param player The player losing the cases.
     * @param caseId The ID of the case to remove.
     * @param amount The number of cases to remove.
     */
    void removeCases(OfflinePlayer player, String caseId, int amount);

    /**
     * Retrieves the current amount of jewelry owned by the given player.
     *
     * @param player The player whose jewelry amount is requested.
     * @return The current amount of jewelry the player owns as a {@link BukkitFutureResult}.
     */
    BukkitFutureResult<Integer> getJewelry(OfflinePlayer player);

    /**
     * Gets the number of a specific case a player owns.
     *
     * @param player The player whose case count is retrieved.
     * @param caseId The ID of the case.
     * @return The number of cases the player owns as a {@link BukkitFutureResult}.
     */
    BukkitFutureResult<Integer> getPlayerCases(OfflinePlayer player, String caseId);

    /**
     * Gets the total number of cases opened globally.
     *
     * @return The total number of opened cases as a {@link BukkitFutureResult}.
     */
    BukkitFutureResult<Integer> getTotalCasesOpened();

    /**
     * Gets the total number of cases opened by a specific player.
     *
     * @param player The player whose case opening count is retrieved.
     * @return The total number of cases opened by the player as a {@link BukkitFutureResult}.
     */
    BukkitFutureResult<Integer> getTotalCasesOpenedByPlayer(OfflinePlayer player);
}
