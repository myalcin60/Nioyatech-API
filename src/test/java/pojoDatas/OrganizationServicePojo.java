package pojoDatas;

import java.util.List;

public class OrganizationServicePojo{

		private String id;
		private String name;
		private int founder_id;
		private String created_at;
		private String updated_at;
		private int number_of_applications;
		private int number_of_files;
		private int number_of_users;
		private int number_of_groups;
		private List<GroupType> group_types;

		// Getter ve Setter metotları

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public  int getFounder_id() {
			return founder_id;
		}

		public void setFounder_id(int founder_id) {
			this.founder_id = founder_id;
		}

		public String getCreated_at() {
			return created_at;
		}

		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}

		public String getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(String updated_at) {
			this.updated_at = updated_at;
		}

		public int getNumber_of_applications() {
			return number_of_applications;
		}

		public void setNumber_of_applications(int number_of_applications) {
			this.number_of_applications = number_of_applications;
		}

		public int getNumber_of_files() {
			return number_of_files;
		}

		public void setNumber_of_files(int number_of_files) {
			this.number_of_files = number_of_files;
		}

		public int getNumber_of_users() {
			return number_of_users;
		}

		public void setNumber_of_users(int number_of_users) {
			this.number_of_users = number_of_users;
		}

		public int getNumber_of_groups() {
			return number_of_groups;
		}

		public void setNumber_of_groups(int number_of_groups) {
			this.number_of_groups = number_of_groups;
		}

		public List<GroupType> getGroup_types() {
			return group_types;
		}

		public void setGroup_types(List<GroupType> group_types) {
			this.group_types = group_types;
		}

		// Inner sınıfı
		public static class GroupType {
			private int id;
			private String name;
			private int number_of_groups;
			private int number_of_users;


			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public int getNumber_of_groups() {
				return number_of_groups;
			}

			public void setNumber_of_groups(int number_of_groups) {
				this.number_of_groups = number_of_groups;
			}

			public int getNumber_of_users() {
				return number_of_users;
			}

			public void setNumber_of_users(int number_of_users) {
				this.number_of_users = number_of_users;
			}
		}

	@Override
	public String toString() {
		return "OrganizationServicePojo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", founder_id=" + founder_id +
				", created_at='" + created_at + '\'' +
				", updated_at='" + updated_at + '\'' +
				", number_of_applications=" + number_of_applications +
				", number_of_files=" + number_of_files +
				", number_of_users=" + number_of_users +
				", number_of_groups=" + number_of_groups +
				", group_types=" + group_types +
				'}';
	}

}

