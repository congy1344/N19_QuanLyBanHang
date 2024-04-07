package entity;

public enum PTThanhToan {
	TIEN_MAT,
	ONLINE;

	private String ptThanhToan;
	
	private PTThanhToan() {
		this("");
	}
	
	private PTThanhToan(String ptThanhToan) {
		this.ptThanhToan = ptThanhToan;
	}
	
	public String getPtThanhToan() {
		return ptThanhToan;
	}
	
	@Override
	public String toString() {
		return ptThanhToan;
	}

}