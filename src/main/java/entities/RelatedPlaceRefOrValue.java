package entities;

import java.util.Objects;

public class RelatedPlaceRefOrValue {
	private String id;
	private String href;
	private String name;
	private String role;
	private String base_type;
	private String schema_location;
	private String type;
	private String referred_type;

	public RelatedPlaceRefOrValue() {
	}

	public RelatedPlaceRefOrValue(String id, String href, String name, String role, String base_type,
			String schema_location, String type, String referred_type) {
		this.id = id;
		this.href = href;
		this.name = name;
		this.role = role;
		this.base_type = base_type;
		this.schema_location = schema_location;
		this.type = type;
		this.referred_type = referred_type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBase_type() {
		return base_type;
	}

	public void setBase_type(String base_type) {
		this.base_type = base_type;
	}

	public String getSchema_location() {
		return schema_location;
	}

	public void setSchema_location(String schema_location) {
		this.schema_location = schema_location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReferred_type() {
		return referred_type;
	}

	public void setReferred_type(String referred_type) {
		this.referred_type = referred_type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(base_type, href, id, name, referred_type, role, schema_location, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelatedPlaceRefOrValue other = (RelatedPlaceRefOrValue) obj;
		return Objects.equals(base_type, other.base_type) && Objects.equals(href, other.href)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(referred_type, other.referred_type) && Objects.equals(role, other.role)
				&& Objects.equals(schema_location, other.schema_location) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "RelatedPlaceRefOrValue [id=" + id + ", href=" + href + ", name=" + name + ", role=" + role
				+ ", base_type=" + base_type + ", schema_location=" + schema_location + ", type=" + type
				+ ", referred_type=" + referred_type + "]";
	}
	

}
