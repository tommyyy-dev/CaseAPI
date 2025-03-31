package org.tommy.caseapi;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * The CaseAPI interface provides methods to interact with the case system.
 * It allows opening cases, managing player inventories, and retrieving statistics.
 *
 * @author Tommyyy
 * @version V1.0.0 (Class version)
 * @since   V1.0.0 (Project version)
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
     * @return True if the case exists, false otherwise.
     */
    boolean caseExists(String caseId);

    /**
     * Opens a case for a player without removing it from their inventory.
     *
     * @param player The player opening the case.
     * @param caseId The ID of the case to open.
     * @return True if the case was successfully opened, false otherwise.
     */
    boolean openCaseWithoutRemove(Player player, String caseId);

    /**
     * Opens a case for a player and removes it from their inventory.
     *
     * @param player The player opening the case.
     * @param caseId The ID of the case to open.
     * @return True if the case was successfully opened, false otherwise.
     */
    boolean openCaseWithRemove(Player player, String caseId);

    /**
     * Adds a specified number of cases to a player's inventory.
     *
     * @param player The player receiving the cases.
     * @param caseId The ID of the case to add.
     * @param amount The number of cases to add.
     * @return True if the cases were successfully added, false otherwise.
     */
    boolean addCases(OfflinePlayer player, String caseId, int amount);

    /**
     * Removes a specified number of cases from a player's inventory.
     *
     * @param player The player losing the cases.
     * @param caseId The ID of the case to remove.
     * @param amount The number of cases to remove.
     * @return True if the cases were successfully removed, false otherwise.
     */
    boolean removeCases(OfflinePlayer player, String caseId, int amount);

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
    int getTotalCasesOpenedByPlayer(Player player);
}