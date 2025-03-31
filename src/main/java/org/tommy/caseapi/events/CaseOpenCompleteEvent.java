package org.tommy.caseapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an event triggered when a case has been successfully opened,
 * and the reward has been determined. This event cannot be cancelled.
 *
 * @author Tommyyy
 * @version V1.0.0 (Class version)
 * @since   V1.0.0 (Project version)
 */
public class CaseOpenCompleteEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final String caseId;
    private final int rewardId;

    /**
     * Creates a new CaseOpenCompleteEvent.
     *
     * @param player   The player who opened the case.
     * @param caseId   The ID of the case that was opened.
     * @param rewardId The ID of the reward obtained from the case.
     */
    public CaseOpenCompleteEvent(Player player, String caseId, int rewardId) {
        this.player = player;
        this.caseId = caseId;
        this.rewardId = rewardId;
    }

    /**
     * Gets the player who opened the case.
     *
     * @return The player who opened the case.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets the ID of the case that was opened.
     *
     * @return The case ID.
     */
    public String getCaseId() {
        return this.caseId;
    }

    /**
     * Gets the reward ID that was obtained from the case.
     *
     * @return The reward ID.
     */
    public int getRewardId() {
        return this.rewardId;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Gets the static handler list for this event.
     *
     * @return The static handler list.
     */
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}