package mallpage;

import java.security.Timestamp;

public class ProductDto {
	private int midx, pmoney, psales, psmoney;
	private String pcode, pnm, pimg;
	private Timestamp pdate;
	
	public int getMidx() {
		return midx;
	}
	public void setMidx(int midx) {
		this.midx = midx;
	}
	public int getPmoney() {
		return pmoney;
	}
	public void setPmoney(int pmoney) {
		this.pmoney = pmoney;
	}
	public int getPsales() {
		return psales;
	}
	public void setPsales(int psales) {
		this.psales = psales;
	}
	public int getPsmoney() {
		return psmoney;
	}
	public void setPsmoney(int psmoney) {
		this.psmoney = psmoney;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPnm() {
		return pnm;
	}
	public void setPnm(String pnm) {
		this.pnm = pnm;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public Timestamp getPdate() {
		return pdate;
	}
	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}
}
