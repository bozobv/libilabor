package libilabor;

import java.util.ArrayList;


public abstract class IceTable 
{
	/**A ho magassaga a tablan*/
	private int snowHeight;
	/**A tablan allhato jatekosok maximalis szama*/
	private int capacity;
	/**Az a jegmezo amin ez a jegtabla van*/
	private IceField iceField;
	/**A tablan allo jatekosok listaja*/
	private ArrayList<Player> playersOnTable;
	/**A tablan levo medvek listaja*/
	private ArrayList<PolarBear> animalsOnTable;
	/**A tablan levo epitmeny referenciaja*/
	private Construction construction=null;
	/**A tablaba fagyott targy referenciaja*/
	private Item frozenItem = null;
	/**A tabla szomszedos tablainak listaja*/
	private ArrayList<IceTable> neighbours;
	
	/**A table konstruktora inicalizalja a szukseges adattagokat*/
	public IceTable(){
		
		animalsOnTable = new ArrayList<PolarBear>();
		playersOnTable = new ArrayList<Player>();
		neighbours = new ArrayList<IceTable>();
		
	}
	/**Getter a playersOnTable adattagnak
	 * @return visszaadja a lista referenciajat
	 * */
	public ArrayList<Player> getPlayersOnTable() {
		return playersOnTable;
	}
	/**Setter a playersOnTable adattagnak
	 * @param a playersOnTable uj erteke
	 * */
	public void setPlayersOnTable(ArrayList<Player> playersOnTable) {
		this.playersOnTable = playersOnTable;
	}
	/**Getter a animalsOnTable adattagnak
	 * @return a lista referenciaja
	 * */
	public ArrayList<PolarBear> getAnimalsOnTable() {
		return animalsOnTable;
	}
	/**Setter a animalsOnTable adattagnak
	 * @param az animalsOnTable uj erteke
	 * */
	public void setAnimalsOnTable(ArrayList<PolarBear> animalsOnTable) {
		this.animalsOnTable = animalsOnTable;
	}
	/**Getter a snowHeight adattagnak
	 * @return a snowHeight referenciaja
	 * */
	public int getSnowHeight() {
		return snowHeight;
	}
	/**Setter a snowHeight adattagnak
	 * @param snowheight uj erteke
	 * */
	public void setSnowHeight(int snowHeight) {
		this.snowHeight = snowHeight;
	}
	/**Getter a capacity adattagnak
	 * @return a capacity referenciaja
	 * */
	public int getCapacity() {
		return capacity;
	}
	/**Setter a capacity adattagnak
	 * @param a capacity uj erteke
	 * */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**Getter a iceField adattagnak
	 * @return az iceField referenciaja
	 * */
	public IceField getIceField() {
		return iceField;
	}
	/**Setter a iceField adattagnak
	 * @param iceField uj erteke
	 * */
	public void setIceField(IceField iceField) {
		this.iceField = iceField;
	}
	/**Getter a construction adattagnak
	 * @return a construction referenciaja
	 * */
	public Construction getConstruction() {
		return construction;
	}
	/**Setter a construction adattagnak
	 * @param a construction uj erteke
	 * */
	public void setConstruction(Construction construction) {
		this.construction = construction;
	}
	/**Getter a forzenItem adattagnak
	 * @return a frozenItemReferenciaja
	 * */
	public Item getFrozenItem() {
		return frozenItem;
	}
	/**Setter a forzenItem adattagnak
	 * @param a frozenItem uj erteke
	 * */
	public void setFrozenItem(Item frozenItem) {
		this.frozenItem = frozenItem;
	}
	/**Getter a neighbours adattagnak
	 * @return a neighbours lista referenciaja
	 * */
	public ArrayList<IceTable> getNeighbours() {
		return neighbours;
	}
	/**Setter a neighbours adattagnak
	 * @param a neighbours lista uj erteke
	 * */
	public void setNeighbours(ArrayList<IceTable> neighbours) {
		this.neighbours = neighbours;
	}
	/**Ez a fuggveny felel a jatekos egyik tablarol a masikra valo leptesere
	 * @param az eppen a tablara lepo jatekos
	 * */
	public void playerVisit(Player p) {
		
		this.playersOnTable.add(p);
		p.setCurrentTable(this);
	}
	/**A hovihar kezelese az tablan*/
	public void blizzardComing() {
		if (playersOnTable != null && getConstruction() == null) {
			for (int i = 0; i < playersOnTable.size(); i++) {
				int newThp = (playersOnTable.get(i)).getThp() - 1;
				(playersOnTable.get(i)).setThp(newThp);
			}
		}
		
	
	}
	
	/**megvizsgalja hogy hany flareGunPart van a tablan*/
	public int checkFlareGunPart() {
		
		int parts = 0; 
		
		for(Character p: this.playersOnTable) {
			
			if(((Player) p).getInventory()[1] != null) {				
				parts++;
			}
		}
		
		return parts;
	}
	/**eltavlitja a parameterkent kapott jatekost a tablarol
	 * @param a torolni kivant jatekos
	 * */
	public void removePlayer(Player character) {
		
		playersOnTable.remove(this.playersOnTable.indexOf(character));
	}
	/**eltavolitja a paramterkent kapott medvet a tablarol
	 * @param a torolni kivant medve
	 * */
	public void removeAnimal(PolarBear character) {
		
		animalsOnTable.remove(this.animalsOnTable.indexOf(character));
	}
	/**ez tortenik ha medve lep ide*/
	public void attacked(){
		if(construction!=null&&playersOnTable.size()>0){
			construction.attacked(playersOnTable.get(0));
		}
	}
	/**kiiro fuggveny*/
	public abstract void writeOut();

}
