package org.tommy.caseapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.tommy.caseapi.models.CaseReward;

/**
 * Represents an event triggered when a case has been successfully opened,
 * and the reward has been determined. This event cannot be cancelled.
 *
 * @author Tommyyy
 */
public class CaseOpenCompleteEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final String caseId;
    private final CaseReward caseReward;

    /**
     * Constructs a new {@code CaseOpenCompleteEvent} with the specified parameters.
     *
     * @param player The player who opened the case.
     * @param caseId The unique identifier of the case that was opened.
     * @param caseReward The reward obtained from the case.
     */
    public CaseOpenCompleteEvent(Player player, String caseId, CaseReward caseReward) {
        this.player = player;
        this.caseId = caseId;
        this.caseReward = caseReward;
    }

    /**
     * Gets the player who opened the case.
     *
     * @return The player instance.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets the unique identifier of the case that was opened.
     *
     * @return The case ID.
     */
    public String getCaseId() {
        return this.caseId;
    }

    /**
     * Gets the reward obtained from the case.
     *
     * @return The {@link CaseReward} instance.
     */
    public CaseReward getCaseReward() {
        return this.caseReward;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Gets the static handler list for this event.
     *
     * @return The static {@link HandlerList}.
     */
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}