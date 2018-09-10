package erp.entity;

public class ItemStock implements Cloneable{

	private ItemStockKey id;

	private int qty;

	public ItemStockKey getId() {
		return id;
	}

	public void setId(ItemStockKey id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public ItemStock(String stockId, String itemId, double rate,int qty) {
		this.setId(new ItemStockKey(stockId, itemId, rate));
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "ItemStock ["+ id + ", qty=" + qty + "]";
	}
	
	@Override
    public ItemStock clone() {
        try {
            return (ItemStock) super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new RuntimeException("superclass messed up", ex);
        }
    }
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		ItemStock other = (ItemStock) obj;
		return id.equals(other.id);
	}

	public static final String SERIALIZED_NAME = Character.toLowerCase(ItemStock.class.getSimpleName().charAt(0))
			+ ItemStock.class.getSimpleName().substring(1);
}
