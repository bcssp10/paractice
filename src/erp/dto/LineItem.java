package erp.dto;

public class LineItem {

	public String itemId;
	public int qty;
	public double rate;

	public LineItem(String itemId, int qty, double rate) {
		this.itemId = itemId;
		this.qty = qty;
		this.rate = rate;
	}
	
}
