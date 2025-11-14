package entities;

import java.util.Objects;

public class AgreementItemRef {
	private String id;

	private String href;

	private String agreementItemId;

	private String name;

	private String baseType;

	private String schemaLocation;

	private String type;

	private String referredType;

	public AgreementItemRef() {
		
	}
	

	public AgreementItemRef(String id, String href, String agreementItemId, String name, String baseType,
			String schemaLocation, String type, String referredType) {
		this.id = id;
		this.href = href;
		this.agreementItemId = agreementItemId;
		this.name = name;
		this.baseType = baseType;
		this.schemaLocation = schemaLocation;
		this.type = type;
		this.referredType = referredType;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getAgreementItemId() {
		return agreementItemId;
	}

	public void setAgreementItemId(String agreementItemId) {
		this.agreementItemId = agreementItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReferredType() {
		return referredType;
	}

	public void setReferredType(String referredType) {
		this.referredType = referredType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agreementItemId, baseType, href, id, name, referredType, schemaLocation, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgreementItemRef other = (AgreementItemRef) obj;
		return Objects.equals(agreementItemId, other.agreementItemId) && Objects.equals(baseType, other.baseType)
				&& Objects.equals(href, other.href) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(referredType, other.referredType)
				&& Objects.equals(schemaLocation, other.schemaLocation) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "AgreementItemRef [id=" + id + ", href=" + href + ", agreementItemId=" + agreementItemId + ", name="
				+ name + ", baseType=" + baseType + ", schemaLocation=" + schemaLocation + ", type=" + type
				+ ", referredType=" + referredType + ", getId()=" + getId() + ", getHref()=" + getHref()
				+ ", getAgreementItemId()=" + getAgreementItemId() + ", getName()=" + getName() + ", getBaseType()="
				+ getBaseType() + ", getSchemaLocation()=" + getSchemaLocation() + ", getType()=" + getType()
				+ ", getReferredType()=" + getReferredType() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
	

}
