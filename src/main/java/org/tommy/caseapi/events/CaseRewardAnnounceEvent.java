package org.tommy.caseapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.tommy.caseapi.models.CaseReward;

/**
 * Represents an event triggered when a player receives a reward from opening a case.
 * This event is only triggered if the reward is announced in the chat for all players.
 * It allows modifying or cancelling the announcement of the reward.
 * This event can be cancelled.
 *
 * @author Tommyyy
 */
public class CaseRewardAnnounceEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final String caseId;
    private final CaseReward caseReward;
    private boolean isCancelled;
    private String announceMessage;

    /**
     * Constructs a new {@code CaseRewardAnnounceEvent} with the specified parameters.
     *
     * @param player The player who received the reward.
     * @param caseId The unique identifier of the case that was opened.
     * @param caseReward The reward received by the player.
     * @param announceMessage The announcement message associated with the reward.
     */
    public CaseRewardAnnounceEvent(Player player, String caseId, CaseReward caseReward, String announceMessage) {
        this.player = player;
        this.caseId = caseId;
        this.caseReward = caseReward;
        this.announceMessage = announceMessage;
        this.isCancelled = false;
    }

    /**
     * Gets the player who received the reward.
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
     * Gets the reward received by the player.
     *
     * @return The {@link CaseReward} instance.
     */
    public CaseReward getCaseReward() {
        return this.caseReward;
    }

    /**
     * Gets the announcement message for the reward.
     *
     * @return The current announcement message.
     */
    public String getAnnouncementMessage() {
        return this.announceMessage;
    }

    /**
     * Sets a new announcement message for the reward.
     *
     * @param announceMessage The new announcement message.
     */
    public void setAnnounceMessage(String announceMessage) {
        this.announceMessage = announceMessage;
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

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }
}