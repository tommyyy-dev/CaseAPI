package org.tommy.caseapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is triggered when a case opening attempt fails.
 * It provides information about the player, the case ID, and the reason for failure.
 *
 * @author Tommyyy
 * @version V1.0.0 (Class version)
 * @since   V1.0.1 (Project version)
 */
public class FailedCaseOpenEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final String caseId;
    private final String failureReason;

    /**
     * Creates a new FailedCaseOpenEvent.
     *
     * @param player The player who attempted to open the case.
     * @param caseId The ID of the case that was attempted to be opened.
     * @param failureReason The reason why the case opening failed.
     */
    public FailedCaseOpenEvent(Player player, String caseId, String failureReason) {
        this.player = player;
        this.caseId = caseId;
        this.failureReason = failureReason;
    }

    /**
     * Gets the player who attempted to open the case.
     *
     * @return The player who attempted to open the case.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets the ID of the case that was attempted to be opened.
     *
     * @return The case ID.
     */
    public String getCaseId() {
        return this.caseId;
    }

    /**
     * Gets the reason why the case opening failed.
     *
     * @return The failure reason.
     */
    public String getFailureReason() {
        return this.failureReason;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Gets the static handler list for this event.
     *
     * @return The handler list.
     */
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}