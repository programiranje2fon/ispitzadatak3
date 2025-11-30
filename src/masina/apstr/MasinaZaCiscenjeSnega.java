package masina.apstr;

import java.util.GregorianCalendar;

public abstract class MasinaZaCiscenjeSnega {
	
	private String markaIModel;
	private GregorianCalendar vremeServisa;
	
	public String getMarkaIModel() {
		return markaIModel;
	}
	
	public void setMarkaIModel(String markaIModel) {
		if (markaIModel==null || markaIModel.indexOf(' ')==-1)
			throw new RuntimeException("Marka i model ne smeju biti null i moraju sadrzati blanko znak");
			
		this.markaIModel = markaIModel;
	}
	
	public GregorianCalendar getVremeServisa() {
		return vremeServisa;
	}
	
	public void setVremeServisa(GregorianCalendar vremeServisa) {
		if (vremeServisa==null || !vremeServisa.after(new GregorianCalendar()))
			throw new RuntimeException("Vreme servisa ne sme biti null i mora se odnositi na buducnost");
		
		this.vremeServisa = vremeServisa;
	}

	public String toString() {
		return "MasinaZaCiscenjeSnega [markaIModel=" + markaIModel
				+ ", vremeServisa=" + vremeServisa + "]";
	}
	
	public abstract boolean servisiraj();
	

}