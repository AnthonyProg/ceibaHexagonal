package co.ceiba.adn.domain.model;

public class Vehicle {
	
	private long domainTypeId;
	private String domainType;	
	private String domainBrand;
	private String domainModel;	
	private String domainCubicCapacity;
	
	public Vehicle() {}
	
	public Vehicle(String domainType) {
		this.domainType = domainType;
	}
	
	

	public Vehicle(long domainTypeId, String domainType, String domainBrand, String domainModel,
			String domainCubicCapacity) {
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

	public String getDomainCubicCapacity() {
		return domainCubicCapacity;
	}	
	
	
}
