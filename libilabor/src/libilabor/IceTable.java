package libilabor;

import java.util.ArrayList;

public abstract class IceTable {

	private int snowHeight;
	private int capacity;
	private IceField iceField;
	private ArrayList<Player> playersOnTable;
	private ArrayList<PolarBear> animalsOnTable;
	private Construction construction;
	private Item frozenItem = null;
	private ArrayList<IceTable> neighbours;

	public IceTable() {

		animalsOnTable = new ArrayList<PolarBear>();
		playersOnTable = new ArrayList<Player>();
		neighbours = new ArrayList<IceTable>();

	}

	public ArrayList<Player> getPlayersOnTable() {
		return playersOnTable;
	}

	public void setPlayersOnTable(ArrayList<Player> playersOnTable) {
		this.playersOnTable = playersOnTable;
	}

	public ArrayList<PolarBear> getAnimalsOnTable() {
		return animalsOnTable;
	}

	public void setAnimalsOnTable(ArrayList<PolarBear> animalsOnTable) {
		this.animalsOnTable = animalsOnTable;
	}

	public int getSnowHeight() {
		return snowHeight;
	}

	public void setSnowHeight(int snowHeight) {
		this.snowHeight = snowHeight;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public IceField getIceField() {
		return iceField;
	}

	public void setIceField(IceField iceField) {
		this.iceField = iceField;
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	public Item getFrozenItem() {
		return frozenItem;
	}

	public void setFrozenItem(Item frozenItem) {
		this.frozenItem = frozenItem;
	}

	public ArrayList<IceTable> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<IceTable> neighbours) {
		this.neighbours = neighbours;
	}

	public void playerVisit(Player p) {

		this.playersOnTable.add(p);
		p.setTable(this);
	}

	public Item getItem() {
		return frozenItem;
	}

	public void setItem(Item it) {
		frozenItem = it;
	}

	public void blizzardComing() {
		if (playersOnTable != null && getConstruction() == null) {
			for (int i = 0; i < playersOnTable.size(); i++) {
				int newThp = (playersOnTable.get(i)).getThp() - 1;
				(playersOnTable.get(i)).setThp(newThp);
			}
		}

	}

	public int checkFlareGunPart() {

		int parts = 0;

		for (Character p : this.playersOnTable) {

			if (((Player) p).getInventory()[1] != null) {
				parts++;
			}
		}

		return parts;
	}

	public void removePlayer(Player character) {

		playersOnTable.remove(this.playersOnTable.indexOf(character));
	}

	public void removeAnimal(PolarBear character) {

		animalsOnTable.remove(this.animalsOnTable.indexOf(character));
	}

	public void writeOut() {
		// tabla resz
		System.out.println(this.getClass() == StableTable.class ? "ST"
				: this.getClass() == UnstableTable.class ? "US" : this.getClass() == Hole.class ? "H" : "" + "(");
		System.out.print(capacity + ", " + snowHeight + ", ");
		System.out.println(this.frozenItem.getId() == 0 ? "fg"
				: this.frozenItem.getId() == 1 ? "r"
						: this.frozenItem.getId() == 2 ? "sc"
								: this.frozenItem.getClass() == Shovel.class ? "s"
										: this.frozenItem.getClass() == WeakShovel.class ? "ws"
												: this.frozenItem.getId() == 4 ? "t" : "null" + ", ");
		//player resz
		if (playersOnTable.size() > 0) {
			for (Player player : playersOnTable) {
				// player class
				System.out.println(player.getClass() == Eskimo.class ? "es"
						: player.getClass() == Scientist.class ? "sc" : "" + "(");
				// player stats
				System.out.println(player.getName() + ", " + player.getThp() + ", " + player.getWork() + ", ");
				// player inventory
				for (Storable st : player.getInventory()) {
					System.out.println(st.getId() == 0 ? "fg"
							: st.getId() == 1 ? "r"
									: st.getId() == 2 ? "sc"
											: st.getClass() == Shovel.class ? "s"
													: st.getClass() == WeakShovel.class ? "ws"
															: st.getId() == 4 ? "t" : "" + ", ");
				}
				System.out.println(")");
			}
		} else {
			System.out.println("null" + ", ");
		}
		//szomszed resz
		System.out.println("(");
		for (IceTable it : neighbours) {
			System.out.println(/*ide kellenenek az indexek*/", ");
		}
		System.out.println(")");
	}

}
