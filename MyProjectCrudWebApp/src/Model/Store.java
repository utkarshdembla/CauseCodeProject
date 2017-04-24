package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
	@Column(unique=true)
	private String storeId;
	
	@Column
	private String storeName;
	
	@Column
	private String zipCode;
	
	@Column
	private int distance;
	
	public Store()
	{
		
	}
	
	public Store(String storeId,String storeName,String zipCode,int distance)
	{
		this.storeId=storeId;
		this.storeName=storeName;
		this.zipCode=zipCode;
		this.distance=distance;
	}
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}

