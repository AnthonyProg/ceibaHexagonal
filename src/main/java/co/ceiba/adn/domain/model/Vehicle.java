package co.ceiba.adn.domain.model;

public class Vehicle {
	
	private long domainTypeId;
	private String domainType;	
	private String domainBrand;
	private String domainModel;	
	private int domainCubicCapacity;
	
	public Vehicle() {}
	
	public Vehicle(String domainType) {
		this.domainType = domainType;
	}
	
	public Vehicle(long domainTypeId , String domainType) {
		this.domainType = domainType;
		this.domainTypeId = domainTypeId;
	}
	
	

	public Vehicle(long domainTypeId, String domainType, String domainBrand, String domainModel,
			int domainCubicCapacity) {
		this.domainTypeId = domainTypeId;
		this.domainType = domainType;
		this.domainBrand = domainBrand;
		this.domainModel = domainModel;
		this.domainCubicCapacity = domainCubicCapacity;
	}

	public long getDomainTypeId() {
		return domainTypeId;
	}

	public String getDomainType() {
		return domainType;
	}

	public String getDomainBrand() {
		return domainBrand;
	}

	public String getDomainModel() {
		return domainModel;
	}

	public int getDomainCubicCapacity() {
		return domainCubicCapacity;
	}

	public void setDomainCubicCapacity(int domainCubicCapacity) {
		this.domainCubicCapacity = domainCubicCapacity;
	}	
}
