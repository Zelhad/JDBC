package entities;

import java.util.Objects;

public class BillingAccountRef {

	private String id;
	private String baseType;
	private String referredType;
	private String schemaLocation;
	private String type;
	private String href;
	private String name;

	public BillingAccountRef() {
	}

	public BillingAccountRef(String id, String baseType, String referredType, String schemaLocation, String type,
			String href, String name) {
		this.id = id;
		this.baseType = baseType;
		this.referredType = referredType;
		this.schemaLocation = schemaLocation;
		this.type = type;
		this.href = href;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public String getReferredType() {
		return referredType;
	}

	public void setReferredType(String referredType) {
		this.referredType = referredType;
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

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseType, href, id, name, referredType, schemaLocation, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingAccountRef other = (BillingAccountRef) obj;
		return Objects.equals(baseType, other.baseType) && Objects.equals(href, other.href)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(referredType, other.referredType)
				&& Objects.equals(schemaLocation, other.schemaLocation) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "BillingAccountRef [id=" + id + ", baseType=" + baseType + ", referredType=" + referredType
				+ ", schemaLocation=" + schemaLocation + ", type=" + type + ", href=" + href + ", name=" + name + "]";
	}
}
