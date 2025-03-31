package org.tommy.caseapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a player receives a reward from opening a case.
 * Allows modifying or cancelling the announcement of the reward.
 *
 * @author Tommyyy
 * @version V1.0.0 (Class version)
 * @since   V1.0.1 (Project version)
 */
public class CaseRewardAnnounceEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final String caseId;
    private final int rewardId;
    private boolean isCancelled;
    private String announceMessage;

    /**
     * Constructs a new CaseRewardAnnounceEvent.
     *
     * @param player The player who received the reward.
     * @param caseId The ID of the case that was opened.
     * @param rewardId The ID of the reward received.
     * @param announceMessage The announcement message for the reward.
     */
    public CaseRewardAnnounceEvent(Player player, String caseId, int rewardId, String announceMessage) {
        this.player = player;
        this.caseId = caseId;
        this.rewardId = rewardId;
        this.announceMessage = announceMessage;
        this.isCancelled = false;
    }

    /**
     * Gets the player who received the reward.
     *
     * @return The player.
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
     * Gets the ID of the reward received.
     *
     * @return The reward ID.
     */
    public int getRewardId() {
        return this.rewardId;
    }

    /**
     * Gets the announcement message for the reward.
     *
     * @return The announcement message.
     */
    public String getAnnounceMessage() {
        return this.announceMessage;
    }

    /**
     * Sets the announcement message for the reward.
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
     * @return The static handler list.
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