package erp.entity;

import java.io.Serializable;

public class ItemStockKey implements Serializable {

	private static final long serialVersionUID = 6070883843768197457L;

	private String itemId;

	private String stockId;
	
	private double rate;

	public ItemStockKey(String stockId, String itemId, double rate) {
		this.stockId = stockId;
		this.itemId = itemId;
		this.rate = rate;
	}
	
	public ItemStockKey() {}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "itemId=" + itemId + ", stockId=" + stockId + ", rate=" + rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		ItemStockKey other = (ItemStockKey) obj;
		if (!itemId.equals(other.itemId))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		else if (!stockId.equals(other.stockId))
			return false;
		
		return true;
	}
	
	
	
}
