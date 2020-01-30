package plugin.skill.magic.lunar;

import org.crandor.game.component.Component;
import org.crandor.game.content.skill.free.magic.MagicSpell;
import org.crandor.game.content.skill.free.magic.Runes;
import org.crandor.game.node.Node;
import org.crandor.game.node.entity.Entity;
import org.crandor.game.node.entity.combat.equipment.SpellType;
import org.crandor.game.node.entity.player.Player;
import org.crandor.game.node.entity.player.link.SpellBookManager.SpellBook;
import org.crandor.game.node.entity.player.link.TeleportManager.TeleportType;
import org.crandor.game.node.item.Item;
import org.crandor.game.world.map.Location;
import org.crandor.game.world.map.RegionManager;
import org.crandor.plugin.InitializablePlugin;
import org.crandor.plugin.Plugin;

/**
 * Represents the plugin to handle all teleport spells.
 * @author 'Vexia
 * @version 1.0
 */
@InitializablePlugin
public final class LunarTeleportPlugin extends MagicSpell {

	/**
	 * Represents the component used for group spells.
	 */
	private static final Component COMPONENT = new Component(326);

	/**
	 * Represents the location to teleport to.
	 */
	private Location location;

	/**
	 * Represents if it's a group teleport.
	 */
	private boolean group;

	/**
	 * Constructs a new {@code LunarTeleportPlugin} {@code Object}.
	 */
	public LunarTeleportPlugin() {
		/**
		 * empty.
		 */
	}

	/**
	 * Constructs a new {@code LunarTeleportPlugin} {@code Object}.
	 * @param level the level.
	 * @param experience the experience.
	 * @param animation the animation.
	 * @param items the items.
	 */
	public LunarTeleportPlugin(final int level, final double experience, final Location location, boolean group, final Item... items) {
		super(SpellBook.LUNAR, level, experience, null, null, null, items);
		this.location = location;
		this.group = group;
	}

	@Override
	public boolean cast(Entity entity, Node target) {
		final Player player = (Player) entity;
		if (player.getLocks().isTeleportLocked() || !meetsRequirements(player, true, false)) {
			return false;
		}
		player.getTeleporter().send(location.transform(0, 0, 0), getSpellId() == 16 ? TeleportType.HOME : TeleportType.LUNAR);
		if (!meetsRequirements(player, true, true)) {
			return false;
		}
		entity.setAttribute("teleport:items", super.runes);
		if (group) {
			String destination = "Moonclan Island";
			switch (getSpellId()) {
			case 34:
				destination = "Waterbirth Island";
				break;
			case 35:
				destination = "Barbarian outpost";
				break;
			case 36:
				destination = "Port Khazard";
				break;
			case 37:
				destination = "Fishing guild";
				break;
			case 38:
				destination = "Catherby";
				break;
			case 39:
				destination = "Ice plateau";
				break;
			}
			for (Player p : RegionManager.getLocalPlayers(player, 1)) {
				if (p == player) {
					continue;
				}
				if (!p.isActive() || p.getLocks().isTeleportLocked()) {
					player.getPacketDispatch().sendMessage("The other player is currently busy.");
					continue;
				}
				if (!p.getSettings().isAcceptAid()) {
					player.getPacketDispatch().sendMessage("The player is not accepting any aid.");
					continue;
				}
				visualize(entity, p);
				p.setAttribute("t-o_location", location);
				p.getPacketDispatch().sendString(player.getUsername(), 326, 1);
				p.getPacketDispatch().sendString(destination, 326, 3);
				p.getInterfaceManager().open(COMPONENT);
			}
		}
		return true;
	}

	@Override
	public Plugin<SpellType> newInstance(SpellType arg) throws Throwable {
		// home
		SpellBook.LUNAR.register(16, new LunarTeleportPlugin(0, 0, Location.create(2100, 3914, 0), false));
		// moonclan teleport
		SpellBook.LUNAR.register(20, new LunarTeleportPlugin(69, 0, Location.create(2111, 3916, 0), false));
		// moonclan group teleport
		SpellBook.LUNAR.register(33, new LunarTeleportPlugin(70, 0, Location.create(2111, 3916, 0), true));
		// ourina teleport
		SpellBook.LUNAR.register(31, new LunarTeleportPlugin(71, 0, Location.create(2469, 3247, 0), false));
		// waterbirth teleport
		SpellBook.LUNAR.register(24, new LunarTeleportPlugin(72, 0, Location.create(2527, 3739, 0), false));
		// waterbirth group teleport
		SpellBook.LUNAR.register(34, new LunarTeleportPlugin(73, 0, Location.create(2527, 3739, 0), true));
		// barbarian post teleport.
		SpellBook.LUNAR.register(0, new LunarTeleportPlugin(75, 0, Location.create(2544, 3572, 0), false));
		// barbarian group teleport
		SpellBook.LUNAR.register(35, new LunarTeleportPlugin(77, 0, Location.create(2544, 3572, 0), true));
		// khzard teleport
		SpellBook.LUNAR.register(18, new LunarTeleportPlugin(78, 0, Location.create(2656, 3157, 0), false));
		// khzard group teleport
		SpellBook.LUNAR.register(36, new LunarTeleportPlugin(79, 0, Location.create(2656, 3157, 0), true));
		// fishing guild teleport
		SpellBook.LUNAR.register(17, new LunarTeleportPlugin(85, 0, Location.create(2611, 3393, 0), false));
		// fishing guild group teleport
		SpellBook.LUNAR.register(37, new LunarTeleportPlugin(86, 0, Location.create(2611, 3393, 0), true));
		// catherby teleport
		SpellBook.LUNAR.register(21, new LunarTeleportPlugin(87, 0, Location.create(2804, 3433, 0), false));
		// catherby group teleport
		SpellBook.LUNAR.register(38, new LunarTeleportPlugin(88, 0, Location.create(2804, 3433, 0), true));
		// ice plateua teleport
		SpellBook.LUNAR.register(28, new LunarTeleportPlugin(89, 0, Location.create(2972, 3873, 0), false));
		// ice plateua group teleport
		SpellBook.LUNAR.register(39, new LunarTeleportPlugin(90, 0, Location.create(2972, 3873, 0), true));
		return this;
	}

}
