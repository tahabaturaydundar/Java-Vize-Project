package paket;

import java.io.Serializable;

public class Otomobil implements Serializable { 

	private String plaka, marka, t?r, vitest?r?, yakitt?r?, renk;
	private int modelyili;
	
	// yap?land?r?c? metod olusturdum! 
	public Otomobil(String plaka, String marka, String t?r, String vitest?r?, String yakitt?r?, String renk,
			int modelyili) {
		super();
		this.plaka = plaka;
		this.marka = marka;
		this.t?r = t?r;
		this.vitest?r? = vitest?r?;
		this.yakitt?r? = yakitt?r?;
		this.renk = renk;
		this.modelyili = modelyili;
	}

	// Her bir ?zelli?e d??ar?dan eri?ebilmek i?in getter-setter;
	
	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getT?r() {
		return t?r;
	}

	public void setT?r(String t?r) {
		this.t?r = t?r;
	}

	public String getVitest?r?() {
		return vitest?r?;
	}

	public void setVitest?r?(String vitest?r?) {
		this.vitest?r? = vitest?r?;
	}

	public String getYakitt?r?() {
		return yakitt?r?;
	}

	public void setYakitt?r?(String yakitt?r?) {
		this.yakitt?r? = yakitt?r?;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public int getModelyili() {
		return modelyili;
	}

	public void setModelyili(int modelyili) {
		this.modelyili = modelyili;
	}
	
	
	
	
	
	
	
}
