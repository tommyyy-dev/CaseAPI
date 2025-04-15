package org.tommy.caseapi;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

/**
 * The CaseAPI interface provides methods to interact with the case system.
 * It allows opening cases, managing players' jewelry and cases, and retrieving statistics.
 *
 * @author Tommyyy
 */
public interface CaseAPI {

    /**
     * Gets a list of all available case IDs.
     *
     * @return A list of case IDs.
     */
    List<String> getCases();

    /**
     * Checks if a case with the given ID exists.
     *
     * @param caseId The ID of the case to check.
     * @return {@code true} if the case exists, {@code false} otherwise.
     */
    boolean caseExists(String caseId);

    /**
     * Opens a case for a player without removing it from them.
     *
     * @param player The player opening the case.
     * @param caseId The ID of the case to open.
     * @return {@code true} if the case was successfully opened, {@code false} otherwise.
     */
    boolean openCaseWithoutRemove(Player player, String caseId);

    /**
     * Opens a case for a player and removes it from them.
     *
     * @param player The player opening the case.
     * @param caseId The ID of the case to open.
     * @return {@code true} if the case was successfully opened, {@code false} otherwise.
     */
    boolean openCaseWithRemove(Player player, String caseId);

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
     * Deletes all the player data.
     * This includes removing the player's statistics, jewelry, and case ownership.
     *
     * @param uuid The UUID of the player whose data is to be deleted.
     */
    void deletePlayerData(UUID uuid);

    /**
     * Retrieves the current amount of jewelry owned by the given player.
     *
     * @param player The player whose jewelry amount is requested.
     * @return The current amount of jewelry the player owns.
     */
    int getJewelry(OfflinePlayer player);

    /**
     * Gets the number of a specific case a player owns.
     *
     * @param player The player whose case count is retrieved.
     * @param caseId The ID of the case.
     * @return The number of cases the player owns.
     */
    int getPlayerCases(OfflinePlayer player, String caseId);

    /**
     * Gets the total number of cases opened globally.
     *
     * @return The total number of opened cases.
     */
    int getTotalCasesOpened();

    /**
     * Gets the total number of cases opened by a specific player.
     *
     * @param player The player whose case opening count is retrieved.
     * @return The total number of cases opened by the player.
     */
    int getTotalCasesOpenedByPlayer(OfflinePlayer player);
}