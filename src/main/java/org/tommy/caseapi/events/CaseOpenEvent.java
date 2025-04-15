package org.tommy.caseapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an event triggered when a player starts opening a case.
 * This event can be cancelled to prevent the case from being opened.
 *
 * @author Tommyyy
 */
public class CaseOpenEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final String caseId;
    private boolean isCancelled;

    /**
     * Creates a new CaseOpenEvent.
     *
     * @param player The player who is opening the case.
     * @param caseId The ID of the case being opened.
     */
    public CaseOpenEvent(Player player, String caseId) {
        this.player = player;
        this.caseId = caseId;
        this.isCancelled = false;
    }

    /**
     * Gets the player who is opening the case.
     *
     * @return The player opening the case.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets the ID of the case being opened.
     *
     * @return The case ID.
     */
    public String getCaseId() {
        return this.caseId;
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
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }
}